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
tdolby@IBM-PF3K066L:~/github.com/ace-bdd-cucumber-maven$ git clone -b maven git@github.com:tdolby-at-uk-ibm-com/ace-bdd-cucumber.git .
Cloning into '.'...
remote: Enumerating objects: 461, done.
remote: Counting objects: 100% (119/119), done.
remote: Compressing objects: 100% (92/92), done.
remote: Total 461 (delta 37), reused 60 (delta 9), pack-reused 342
Receiving objects: 100% (461/461), 7.84 MiB | 14.47 MiB/s, done.
Resolving deltas: 100% (180/180), done.
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
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 1 source file to /home/tdolby/github.com/ace-bdd-cucumber-maven/FridayApplication_Test/classes
[INFO] /home/tdolby/github.com/ace-bdd-cucumber-maven/FridayApplication_Test/src/main/java/bdd/cucumber/RunCucumberTest.java: /home/tdolby/github.com/ace-bdd-cucumber-maven/FridayApplication_Test/src/main/java/bdd/cucumber/RunCucumberTest.java uses or overrides a deprecated API.
[INFO] /home/tdolby/github.com/ace-bdd-cucumber-maven/FridayApplication_Test/src/main/java/bdd/cucumber/RunCucumberTest.java: Recompile with -Xlint:deprecation for details.
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
[INFO] Building jar: /home/tdolby/github.com/ace-bdd-cucumber-maven/FridayApplication_Test/FridayApplication_Test-maven.jar
[INFO]
[INFO] --- maven-dependency-plugin:3.3.0:copy-dependencies (copy-dependencies) @ FridayApplication_Test ---
[INFO] Copying apiguardian-api-1.1.0.jar to /home/tdolby/github.com/ace-bdd-cucumber-maven/FridayApplication_Test/apiguardian-api-1.1.0.jar
[INFO] Copying cucumber-junit-7.9.0.jar to /home/tdolby/github.com/ace-bdd-cucumber-maven/FridayApplication_Test/cucumber-junit-7.9.0.jar
[INFO] Copying cucumber-core-7.9.0.jar to /home/tdolby/github.com/ace-bdd-cucumber-maven/FridayApplication_Test/cucumber-core-7.9.0.jar
[INFO] Copying cucumber-gherkin-7.9.0.jar to /home/tdolby/github.com/ace-bdd-cucumber-maven/FridayApplication_Test/cucumber-gherkin-7.9.0.jar
[INFO] Copying cucumber-gherkin-messages-7.9.0.jar to /home/tdolby/github.com/ace-bdd-cucumber-maven/FridayApplication_Test/cucumber-gherkin-messages-7.9.0.jar
[INFO] Copying gherkin-24.1.0.jar to /home/tdolby/github.com/ace-bdd-cucumber-maven/FridayApplication_Test/gherkin-24.1.0.jar
[INFO] Copying messages-19.1.4.jar to /home/tdolby/github.com/ace-bdd-cucumber-maven/FridayApplication_Test/messages-19.1.4.jar
[INFO] Copying tag-expressions-4.1.0.jar to /home/tdolby/github.com/ace-bdd-cucumber-maven/FridayApplication_Test/tag-expressions-4.1.0.jar
[INFO] Copying cucumber-expressions-16.0.0.jar to /home/tdolby/github.com/ace-bdd-cucumber-maven/FridayApplication_Test/cucumber-expressions-16.0.0.jar
[INFO] Copying datatable-7.9.0.jar to /home/tdolby/github.com/ace-bdd-cucumber-maven/FridayApplication_Test/datatable-7.9.0.jar
[INFO] Copying cucumber-plugin-7.9.0.jar to /home/tdolby/github.com/ace-bdd-cucumber-maven/FridayApplication_Test/cucumber-plugin-7.9.0.jar
[INFO] Copying docstring-7.9.0.jar to /home/tdolby/github.com/ace-bdd-cucumber-maven/FridayApplication_Test/docstring-7.9.0.jar
[INFO] Copying html-formatter-20.1.0.jar to /home/tdolby/github.com/ace-bdd-cucumber-maven/FridayApplication_Test/html-formatter-20.1.0.jar
[INFO] Copying ci-environment-9.1.0.jar to /home/tdolby/github.com/ace-bdd-cucumber-maven/FridayApplication_Test/ci-environment-9.1.0.jar
[INFO] Copying cucumber-java-7.9.0.jar to /home/tdolby/github.com/ace-bdd-cucumber-maven/FridayApplication_Test/cucumber-java-7.9.0.jar
[INFO] Copying cucumber-junit-platform-engine-7.9.0.jar to /home/tdolby/github.com/ace-bdd-cucumber-maven/FridayApplication_Test/cucumber-junit-platform-engine-7.9.0.jar
[INFO] Copying opentest4j-1.2.0.jar to /home/tdolby/github.com/ace-bdd-cucumber-maven/FridayApplication_Test/opentest4j-1.2.0.jar
[INFO]
[INFO] --- exec-maven-plugin:3.0.0:exec (create-work-dir) @ FridayApplication_Test ---
mqsicreateworkdir: Copying sample server.config.yaml to work directory
1 file(s) copied.
Successful command completion.
[INFO]
[INFO] --- exec-maven-plugin:3.0.0:exec (populate-work-dir) @ FridayApplication_Test ---
BIP15233I: Generating BAR file '/tmp/ibmint_deploy_generated_2022112916-23-13.bar' for deploy.
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
2022-11-29 10:23:15.115470: BIP1990I: Integration server 'bdd-test-work-dir' starting initialization; version '12.0.7.0' (64-bit)
2022-11-29 10:23:15.119308: BIP9905I: Initializing resource managers.
2022-11-29 10:23:16.379293: BIP9906I: Reading deployed resources.
2022-11-29 10:23:16.388460: BIP9907I: Initializing deployed resources.
2022-11-29 10:23:16.389532: BIP2155I: About to 'Initialize' the deployed resource 'FridayApplication' of type 'Application'.
2022-11-29 10:23:16.400553: BIP2155I: About to 'Initialize' the deployed resource 'FridayApplication_Test' of type 'TestProjectType'.
2022-11-29 10:23:16.562105: BIP2155I: About to 'Start' the deployed resource 'FridayApplication' of type 'Application'.
2022-11-29 10:23:16.562523: BIP9910I: Running tests in test project 'FridayApplication_Test'.
2022-11-29 10:23:18.386      1 STARTING TEST:Sunday isn't Friday
2022-11-29 10:23:18.427      1 FINISHED TEST:Sunday isn't Friday SUCCESSFUL
2022-11-29 10:23:18.427      1 STARTING TEST:Friday is Friday
2022-11-29 10:23:18.433      1 FINISHED TEST:Friday is Friday SUCCESSFUL
2022-11-29 10:23:18.438      1
TEST RESULTS:

TOTALS:
  PASSED    :2
  FAILED    :0
  ABORTED   :0
  TIME(secs):0.099
2022-11-29 10:23:18.439044: BIP9911I: Running tests in test project 'FridayApplication_Test' completed successfully.
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary:
[INFO]
[INFO] FridayApplication_top 1.0 .......................... SUCCESS [  0.011 s]
[INFO] FridayApplication 0.0.1-SNAPSHOT ................... SUCCESS [  1.197 s]
[INFO] FridayApplication_Test 0.0.1-SNAPSHOT .............. SUCCESS [  6.808 s]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  8.118 s
[INFO] Finished at: 2022-11-29T10:23:18-06:00
[INFO] ------------------------------------------------------------------------
```
