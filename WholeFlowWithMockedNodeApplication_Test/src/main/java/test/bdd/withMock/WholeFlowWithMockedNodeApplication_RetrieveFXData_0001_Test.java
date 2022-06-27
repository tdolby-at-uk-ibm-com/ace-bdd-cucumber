package test.bdd.withMock;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.IncludeEngines;

import com.ibm.integration.test.v1.NodeSpy;
import com.ibm.integration.test.v1.NodeStub;
import com.ibm.integration.test.v1.SpyObjectReference;
import com.ibm.integration.test.v1.TestMessageAssembly;
import com.ibm.integration.test.v1.TestSetup;
import com.ibm.integration.test.v1.exception.TestException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.ibm.integration.test.v1.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.InputStream;
import java.time.Instant;

//Run the cucumber tests
@IncludeEngines("cucumber")
public class WholeFlowWithMockedNodeApplication_RetrieveFXData_0001_Test {

	/*
	 * WholeFlowWithMockedNodeApplication_RetrieveFXData_SetUpRequest_0001_Test
	 * Test generated by IBM App Connect Enterprise Toolkit 12.0.5.0 on Jun 27, 2022 12:02:40 PM
	 */

	@AfterEach
	public void cleanupTest() throws TestException {
		// Ensure any mocks created by a test are cleared after the test runs 
		TestSetup.restoreAllMocks();
	}
	
	// This is used for the reply so we can perform checks in the "Then" method.
	// Note that this could cause trouble if not cleaned up and multiple tests
	// are run from the same class.
	static TestMessageAssembly replyMessageAssembly;

	// Declare a new TestMessageAssembly object for the message being sent into the node
	static TestMessageAssembly inputMessageAssembly;
	
	// Set up for the blank body test by doing nothing
	@Given("a blank body and no service for USD to GBP")
	public void a_blank_body_and_no_service_for_USD_to_GBP() throws TestException
	{
	    inputMessageAssembly = new TestMessageAssembly();
		// Add Local Environment to Message Assembly for HTTP; equivalent to
		// 
		// curl 'http://localhost:7800/retrieveFXData?from=GBP&to=USD'
		// 
		inputMessageAssembly.localEnvironmentPath("HTTP.Input.QueryString.from").setValue("GBP");
		inputMessageAssembly.localEnvironmentPath("HTTP.Input.QueryString.to").setValue("USD");
	}


	@When("I ask if the results are correct")
	public void i_ask_if_the_results_are_correct() throws TestException 
	{
		SpyObjectReference nodeToBeMockedRef = new SpyObjectReference().application("WholeFlowWithMockedNodeApplication")
				.messageFlow("RetrieveFXData").node("HTTP Request");

		// Define the SpyObjectReference objects
		SpyObjectReference httpInputObjRef = new SpyObjectReference().application("WholeFlowWithMockedNodeApplication")
				.messageFlow("RetrieveFXData").node("HTTP Input");
		SpyObjectReference httpReplyObjRef = new SpyObjectReference().application("WholeFlowWithMockedNodeApplication")
				.messageFlow("RetrieveFXData").node("HTTP Reply");

		// Initialise NodeSpy objects
		NodeSpy httpInputSpy = new NodeSpy(httpInputObjRef);
		NodeSpy httpReplySpy = new NodeSpy(httpReplyObjRef);
		
		
		// Initialize the service stub to avoid needing an API key for unit testing
		NodeStub serviceStub = new NodeStub(nodeToBeMockedRef);
		
		// Create a Message Assembly and load it with the recorded result
		TestMessageAssembly serviceResultMessageAssembly = new TestMessageAssembly();
		try {
			String messageAssemblyPath = "/RetrieveFXData_HTTPResponseForMocking.mxml";
			InputStream messageStream = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(messageAssemblyPath);
			if (messageStream == null) {
				throw new TestException("Unable to locate message assembly file: " + messageAssemblyPath);
			}
			serviceResultMessageAssembly.buildFromRecordedMessageAssembly(messageStream);
		} catch (Exception ex) {
			fail("Failed to load input message: " + ex.getMessage());
		}

		// Program the stub to return this dummy result instead of calling the service
		serviceStub.onCall().propagatesMessage("in", "out", serviceResultMessageAssembly);
		
		// Configure the "in" terminal on the HTTP Reply node not to propagate.
		// If we don't do this, then the reply node will throw exceptions when it  
		// realises we haven't actually used the HTTP transport.
		httpReplySpy.setStopAtInputTerminal("in");

		// Now call propagate on the "out" terminal of the HTTP Input node.
		// This takes the place of an actual HTTP message: we simple hand the node
		// the message assembly and tell it to propagate that as if it came from an
		// actual client. This line is where the flow is actually run.
		httpInputSpy.propagate(inputMessageAssembly, "out");
		
		// Validate the results from the flow execution
        // We will now pick up the message that is propagated into the "HttpReply" node and validate it
		replyMessageAssembly = httpReplySpy.receivedMessageAssembly("in", 1);
	}
	


	@Then("the results should validate successfully")
	public void the_results_should_validate_successfully() throws TestException 
	{
		TestMessageAssembly expectedMessageAssembly = new TestMessageAssembly();
		try {
			String messageAssemblyPath = "/RetrieveFXData_ExpectedReply.mxml";
			InputStream messageStream = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(messageAssemblyPath);
			if (messageStream == null) {
				throw new TestException("Unable to locate message assembly file: " + messageAssemblyPath);
			}
			expectedMessageAssembly.buildFromRecordedMessageAssembly(messageStream);
		} catch (Exception ex) {
			throw new TestException("Failed to load input message", ex);
		}

		// Assert that the actual message assembly matches the expected message assembly
	    assertThat(replyMessageAssembly, equalsMessage(expectedMessageAssembly).
	    		ignoreTimeStamps().
	    		ignorePath("/Properties/ReplyProtocol", false). // Seems to be UNKNOWN instead of SOAP-HTTP
	    		ignorePath("/JSON/Data/timestamp", false));     // We'll check this ourselves as it changes every time
	    
	    // Make sure we did set the timestamp to an integer
		assertThat(replyMessageAssembly, hasMessageTreeElement("JSON.Data.timestamp").isInteger());
		// And that the value is within a couple of seconds of the current time 
		assertTrue(replyMessageAssembly.messagePath("JSON.Data.timestamp").getLongValue() >= (Instant.now().getEpochSecond() - 1));
	}
}
