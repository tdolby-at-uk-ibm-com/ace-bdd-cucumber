# FridayApplication

Simple example using ACE with Cucumber BDD, building on the ideas (and initial feature) 
from https://cucumber.io/docs/guides/10-minute-tutorial/ using a very simple flow to 
implement the requirements:

![Flow overview](bdd-flow.png)

## Usage 

Import into the ACE v12 toolkit, and run the test project. This should cause the cucumber BDD tests to run 
and pass (checked on Windows and Linux).

Can also be run from the command line:
```
tdolby@IBM-PF3K066L:~/github.com/ace-bdd-cucumber-maven$ mvn verify
[INFO] Scanning for projects...
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Build Order:
[INFO]
[INFO] FridayApplication_top                                              [pom]
[INFO] FridayApplication                                                  [jar]
[INFO] FridayApplication_Test                                             [jar]
[INFO]
[INFO] --------------< FridayApplication:FridayApplication_top >---------------
[INFO] Building FridayApplication_top 1.0                                 [1/3]
[INFO] --------------------------------[ pom ]---------------------------------
[INFO]
[INFO] ----------------< FridayApplication:FridayApplication >-----------------
[INFO] Building FridayApplication 0.0.1-SNAPSHOT                          [2/3]
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- exec-maven-plugin:3.0.0:exec (default) @ FridayApplication ---
Successfully added file 'MainFlow.msgflow' to the BAR file.
Successfully added file 'application.descriptor' to the BAR file.
Successfully added file 'MainFlow_Compute.esql' to the BAR file.
Successfully added file 'pom.xml' to the BAR file.
Application file 'FridayApplication.appzip' successfully added to the BAR file.
BIP1845I: Command completed successfully.
[INFO]
[INFO] --------------< FridayApplication:FridayApplication_Test >--------------
[INFO] Building FridayApplication_Test 0.0.1-SNAPSHOT                     [3/3]
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ FridayApplication_Test ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 4 resources
[INFO]
[INFO] --- maven-compiler-plugin:3.8.0:compile (default-compile) @ FridayApplication_Test ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ FridayApplication_Test ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /home/tdolby/github.com/ace-bdd-cucumber-maven/FridayApplication_Test/src/test/resources
[INFO]
[INFO] --- maven-compiler-plugin:3.8.0:testCompile (default-testCompile) @ FridayApplication_Test ---
[INFO] No sources to compile
[INFO]
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ FridayApplication_Test ---
[INFO] No tests to run.
[INFO]
[INFO] --- maven-jar-plugin:3.2.2:jar (default-jar) @ FridayApplication_Test ---
[INFO]
[INFO] --- maven-dependency-plugin:3.3.0:copy-dependencies (copy-dependencies) @ FridayApplication_Test ---
[INFO] org.apiguardian:apiguardian-api:jar:1.1.0 already exists in destination.
[INFO] io.cucumber:cucumber-junit:jar:7.9.0 already exists in destination.
[INFO] io.cucumber:cucumber-core:jar:7.9.0 already exists in destination.
[INFO] io.cucumber:cucumber-gherkin:jar:7.9.0 already exists in destination.
[INFO] io.cucumber:cucumber-gherkin-messages:jar:7.9.0 already exists in destination.
[INFO] io.cucumber:gherkin:jar:24.1.0 already exists in destination.
[INFO] io.cucumber:messages:jar:19.1.4 already exists in destination.
[INFO] io.cucumber:tag-expressions:jar:4.1.0 already exists in destination.
[INFO] io.cucumber:cucumber-expressions:jar:16.0.0 already exists in destination.
[INFO] io.cucumber:datatable:jar:7.9.0 already exists in destination.
[INFO] io.cucumber:cucumber-plugin:jar:7.9.0 already exists in destination.
[INFO] io.cucumber:docstring:jar:7.9.0 already exists in destination.
[INFO] io.cucumber:html-formatter:jar:20.1.0 already exists in destination.
[INFO] io.cucumber:ci-environment:jar:9.1.0 already exists in destination.
[INFO] io.cucumber:cucumber-java:jar:7.9.0 already exists in destination.
[INFO] io.cucumber:cucumber-junit-platform-engine:jar:7.9.0 already exists in destination.
[INFO] org.opentest4j:opentest4j:jar:1.2.0 already exists in destination.
[INFO]
[INFO] --- exec-maven-plugin:3.0.0:exec (create-work-dir) @ FridayApplication_Test ---
mqsicreateworkdir: Copying sample server.config.yaml to work directory
1 file(s) copied.
Successful command completion.
[INFO]
[INFO] --- exec-maven-plugin:3.0.0:exec (populate-work-dir) @ FridayApplication_Test ---
BIP15233I: Generating BAR file '/tmp/ibmint_deploy_generated_2022112916-20-56.bar' for deploy.
BIP1859I: Successfully added file 'MainFlow.msgflow' to the BAR file.
BIP1859I: Successfully added file 'application.descriptor' to the BAR file.
BIP1859I: Successfully added file 'MainFlow_Compute.esql' to the BAR file.
BIP1859I: Successfully added file 'pom.xml' to the BAR file.
BIP1853I: Application file 'FridayApplication.appzip' successfully added to the BAR file.
BIP1859I: Successfully added file 'cucumber-core-7.9.0.jar' to the BAR file.
BIP1859I: Successfully added file 'cucumber-gherkin-messages-7.9.0.jar' to the BAR file.
BIP1859I: Successfully added file 'is_it_friday_yet.feature' to the BAR file.
BIP1859I: Successfully added file 'junit-platform.properties' to the BAR file.
BIP1859I: Successfully added file 'Tuesday.mxml' to the BAR file.
BIP1859I: Successfully added file 'Sunday.mxml' to the BAR file.
BIP1859I: Successfully added file 'apiguardian-api-1.1.0.jar' to the BAR file.
BIP1859I: Successfully added file 'gherkin-24.1.0.jar' to the BAR file.
BIP1859I: Successfully added file 'cucumber-junit-platform-engine-7.9.0.jar' to the BAR file.
BIP1859I: Successfully added file 'docstring-7.9.0.jar' to the BAR file.
BIP1859I: Successfully added file 'testproject.descriptor' to the BAR file.
BIP1859I: Successfully added file 'FridayApplication_Test-maven.jar' to the BAR file.
BIP1859I: Successfully added file 'cucumber-expressions-16.0.0.jar' to the BAR file.
BIP1859I: Successfully added file 'cucumber-junit-7.9.0.jar' to the BAR file.
BIP1859I: Successfully added file 'cucumber-plugin-7.9.0.jar' to the BAR file.
BIP1859I: Successfully added file 'tag-expressions-4.1.0.jar' to the BAR file.
BIP1859I: Successfully added file 'cucumber-java-7.9.0.jar' to the BAR file.
BIP1859I: Successfully added file 'ci-environment-9.1.0.jar' to the BAR file.
BIP1859I: Successfully added file 'datatable-7.9.0.jar' to the BAR file.
BIP1859I: Successfully added file 'opentest4j-1.2.0.jar' to the BAR file.
BIP1859I: Successfully added file 'html-formatter-20.1.0.jar' to the BAR file.
BIP1859I: Successfully added file 'cucumber-gherkin-7.9.0.jar' to the BAR file.
BIP1859I: Successfully added file 'messages-19.1.4.jar' to the BAR file.
BIP8148I: Unpacking BAR file...
BIP8071I: Successful command completion.
[INFO]
[INFO] --- exec-maven-plugin:3.0.0:exec (run-cucumber-test) @ FridayApplication_Test ---
2022-11-29 10:20:58.073156: BIP1990I: Integration server 'bdd-test-work-dir' starting initialization; version '12.0.7.0' (64-bit)
2022-11-29 10:20:58.078432: BIP9905I: Initializing resource managers.
2022-11-29 10:20:59.276268: BIP9906I: Reading deployed resources.
2022-11-29 10:20:59.285080: BIP9907I: Initializing deployed resources.
2022-11-29 10:20:59.286056: BIP2155I: About to 'Initialize' the deployed resource 'FridayApplication' of type 'Application'.
2022-11-29 10:20:59.295588: BIP2155I: About to 'Initialize' the deployed resource 'FridayApplication_Test' of type 'TestProjectType'.
2022-11-29 10:20:59.445224: BIP2155I: About to 'Start' the deployed resource 'FridayApplication' of type 'Application'.
2022-11-29 10:20:59.445608: BIP9910I: Running tests in test project 'FridayApplication_Test'.
2022-11-29 10:21:01.217      1 STARTING TEST:Sunday isn't Friday
2022-11-29 10:21:01.257      1 FINISHED TEST:Sunday isn't Friday SUCCESSFUL
2022-11-29 10:21:01.257      1 STARTING TEST:Friday is Friday
2022-11-29 10:21:01.262      1 FINISHED TEST:Friday is Friday SUCCESSFUL
2022-11-29 10:21:01.267      1
TEST RESULTS:

TOTALS:
  PASSED    :2
  FAILED    :0
  ABORTED   :0
  TIME(secs):0.099
2022-11-29 10:21:01.268237: BIP9911I: Running tests in test project 'FridayApplication_Test' completed successfully.
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary:
[INFO]
[INFO] FridayApplication_top 1.0 .......................... SUCCESS [  0.011 s]
[INFO] FridayApplication 0.0.1-SNAPSHOT ................... SUCCESS [  1.199 s]
[INFO] FridayApplication_Test 0.0.1-SNAPSHOT .............. SUCCESS [  6.152 s]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  7.466 s
[INFO] Finished at: 2022-11-29T10:21:01-06:00
[INFO] ------------------------------------------------------------------------
```
