# ace-bdd-cucumber
Examples using ACE with Cucumber BDD

This repo is currently aimed at advanced users; more detailed instructions needed for general usage.

## Overview

ACE test projects assume the use of JUnit, but can be told to run Cucumber tests by specifying the
correct JUnit engine using a standard annotation of `@IncludeEngines("cucumber")` to tell the runtime
which engine to use.

The Cucumber feature description in [is_it_friday_yet.feature](FridayApplication_Test/src/main/resources/bdd/cucumber/is_it_friday_yet.feature) matches the
tutorial, and is picked up the Cucumber engine automatically. 
The tests in [RunCucumberTest.java](FridayApplication_Test/src/main/java/bdd/cucumber/RunCucumberTest.java) use standard 
JUnit and ACE testing constructs to implement the various steps, making sure the actual application code in 
[MainFlow_Compute.esql](FridayApplication/MainFlow_Compute.esql) works as expected.

![BDD overview](FridayApplication/bdd-overview.png)


## Usage 

Import this repo the ACE v12 toolkit using the built-in egit client (switch to the "git" perspective), and 
run the test projects. This should cause the cucumber BDD tests to run and pass (checked on Windows and Linux).

The projects are as follows:

- The simplest application demo is [FridayApplication](FridayApplication/README.md), showing the use of Cucumber with a single node.
- The BDD tests for FridayApplication are in [FridayApplication_Test](FridayApplication_Test/README.md)
- BDD testing of a whole flow with multiple nodes is shown using the [WholeFlowApplication](WholeFlowApplication/README.md) project
- The BDD tests for WholeFlowApplication are in [WholeFlowApplication_Test](WholeFlowApplication_Test/README.md)
- BDD testing with a service stubbed out is shown using the [WholeFlowWithMockedNodeApplication](WholeFlowWithMockedNodeApplication/README.md) project
- The BDD tests with mocking of one node are in the [WholeFlowWithMockedNodeApplication_Test](WholeFlowWithMockedNodeApplication_Test/README.md) project
- TDD testing of one node is also possible [WholeFlowWithMockedNodeApplication_TDD](WholeFlowWithMockedNodeApplication_TDD/README.md)

## Next steps

Use Maven instead of copying JARs around.

More scenarios?
