package bdd.cucumber;

import static com.ibm.integration.test.v1.Matchers.nodeCallCountIs;
import static com.ibm.integration.test.v1.Matchers.terminalPropagateCountIs;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.InputStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.platform.suite.api.IncludeEngines;

import com.ibm.integration.test.v1.NodeSpy;
import com.ibm.integration.test.v1.SpyObjectReference;
import com.ibm.integration.test.v1.TestMessageAssembly;
import com.ibm.integration.test.v1.TestSetup;
import com.ibm.integration.test.v1.exception.TestException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@IncludeEngines("cucumber")
public class RunCucumberTest 
{
	// Should probably be using message assemblies instead of strings . . . 
	static String messageAssemblyName;
	static String returnResult;
	
	@Given("today is Sunday")
	public void today_is_sunday() {
		messageAssemblyName = "Sunday";
	}
	@When("I ask whether it's Friday yet")
	public void i_ask_whether_it_s_friday_yet() throws TestException 
	{

		// Define the SpyObjectReference
		SpyObjectReference nodeReference = new SpyObjectReference().application("FridayApplication")
				.messageFlow("MainFlow").node("Compute");

		// Initialise a NodeSpy
		NodeSpy nodeSpy = new NodeSpy(nodeReference);

		// Declare a new TestMessageAssembly object for the message being sent into the node
		TestMessageAssembly inputMessageAssembly = new TestMessageAssembly();

		// Create a Message Assembly from the input data file
		try {
			String messageAssemblyPath = "/"+messageAssemblyName+".mxml";
			InputStream messageStream = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(messageAssemblyPath);
			if (messageStream == null) {
				throw new TestException("Unable to locate message assembly file: " + messageAssemblyPath);
			}
			inputMessageAssembly.buildFromRecordedMessageAssembly(messageStream);
		} catch (Exception ex) {
			throw new TestException("Failed to load input message", ex);
		}

		// Call the message flow node with the Message Assembly
		nodeSpy.evaluate(inputMessageAssembly, true, "in");

		// Assert the number of times that the node is called
		assertThat(nodeSpy, nodeCallCountIs(1));

		// Assert the terminal propagate count for the message
		assertThat(nodeSpy, terminalPropagateCountIs("out", 1));

        /* Compare Output Message 1 at output terminal out */
        TestMessageAssembly actualMessageAssembly = nodeSpy.propagatedMessageAssembly("out", 1);

        returnResult = actualMessageAssembly.messagePath("JSON.Data.result").getStringValue();	
	}
	@Then("I should be told {string}")
	public void i_should_be_told(String string) 
	{
		assertEquals(string, returnResult);
	}

	@AfterEach
	public void cleanupTest() throws TestException {
		// Ensure any mocks created by a test are cleared after the test runs 
		// Note that this makes it hard to share message assemblies between steps
		TestSetup.restoreAllMocks();
	}

}
