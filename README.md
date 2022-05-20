# ace-bdd-cucumber
Example using ACE with Cucumber BDD

Building on the ideas (and initial feature) from https://cucumber.io/docs/guides/10-minute-tutorial/ using a
very simple flow to implement the requirements:

![Flow overview](FridayApplication/bdd-flow.png)

## Usage 

Import into the ACE v12 toolkit, and run the test project. This should cause the cucumber BDD tests to run 
and pass (checked on Windows and Linux).

## Overview

ACE test projects assume the use of JUnit, but can be told to run Cucumber tests by specifying the
correct JUnit engine using a standard annotation of `@IncludeEngines("cucumber")` to tell the runtime
which engine to use.

The Cucumber feature description in [is_it_friday_yet.feature](FridayApplication_Test/src/main/resources/bdd/cucumber/is_it_friday_yet.feature) matches the
tutorial, and is picked up the Cucmber engine automatically. 
The tests in [RunCucumberTest.java](FridayApplication_Test/src/main/java/bdd/cucumber/RunCucumberTest.java) use standard 
JUnit and ACE testing constructus to implement the various steps, making sure the actual application code in 
[MainFlow_Compute.esql](FridayApplication/MainFlow_Compute.esql) works as expected.


![BDD overview](FridayApplication/bdd-overview.png)


## Next steps

Use Maven instead of copying JARs around.

More scenarios?
