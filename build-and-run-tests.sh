#!/bin/bash

# Assumes a shell with the ACE profile already loaded, and will create
# directories in /tmp for the repo and work directory.

# Print commands to the screen
set -x

# Exit on any error
set -e

mkdir -p /tmp/bdd
rm -rf /tmp/bdd/*

cd /tmp/bdd

git clone https://github.com/tdolby-at-uk-ibm-com/ace-bdd-cucumber

# Patch the .classpath to work around a known issue with mqsicreatebar and test projects
sed -i 's/<\/classpath>/        <classpathentry kind="lib" path="\/opt\/ace-12.0.5.0\/common\/classes\/IntegrationTest.jar"\/>\n        <classpathentry kind="lib" path="\/opt\/ace-12.0.5.0\/common\/classes\/hamcrest-2.2.jar"\/>\n<\/classpath>/g' /tmp/bdd/ace-bdd-cucumber/FridayApplication_Test/.classpath /tmp/bdd/ace-bdd-cucumber/WholeFlowApplication_Test/.classpath /tmp/bdd/ace-bdd-cucumber/WholeFlowWithMockedNodeApplication_TDD/.classpath /tmp/bdd/ace-bdd-cucumber/WholeFlowWithMockedNodeApplication_Test/.classpath

echo ""
echo "================ Building FridayApplication tests"
echo ""
mqsicreatebar -data /tmp/bdd/ace-bdd-cucumber -b /tmp/bdd/FridayApplication-tests.bar -a FridayApplication_Test -p FridayApplication
mqsicreatebar -data /tmp/bdd/ace-bdd-cucumber -b /tmp/bdd/FridayApplication.bar -a FridayApplication

echo ""
echo "================ Running FridayApplication tests"
echo ""
rm -rf /tmp/bdd/FridayApplication-work-dir
mqsicreateworkdir /tmp/bdd/FridayApplication-work-dir
mqsibar -c -w /tmp/bdd/FridayApplication-work-dir -a FridayApplication.bar
mqsibar -c -w /tmp/bdd/FridayApplication-work-dir -a FridayApplication-tests.bar
IntegrationServer -w /tmp/bdd/FridayApplication-work-dir --no-nodejs --start-msgflows no --test-project FridayApplication_Test

echo ""
echo "================ Building WholeFlowApplication tests"
echo ""
mqsicreatebar -data /tmp/bdd/ace-bdd-cucumber -b /tmp/bdd/WholeFlowApplication-tests.bar -a WholeFlowApplication_Test -p WholeFlowApplication
mqsicreatebar -data /tmp/bdd/ace-bdd-cucumber -b /tmp/bdd/WholeFlowApplication.bar -a WholeFlowApplication

echo ""
echo "================ Running WholeFlowApplication tests"
echo ""r
rm -rf /tmp/bdd/WholeFlowApplication-work-dir
mqsicreateworkdir /tmp/bdd/WholeFlowApplication-work-dir
mqsibar -c -w /tmp/bdd/WholeFlowApplication-work-dir -a WholeFlowApplication.bar
mqsibar -c -w /tmp/bdd/WholeFlowApplication-work-dir -a WholeFlowApplication-tests.bar
IntegrationServer -w /tmp/bdd/WholeFlowApplication-work-dir --no-nodejs --start-msgflows no --test-project WholeFlowApplication_Test

echo ""
echo "================ Building WholeFlowWithMockedNodeApplication tests"
echo ""
mqsicreatebar -data /tmp/bdd/ace-bdd-cucumber -b /tmp/bdd/WholeFlowWithMockedNodeApplication-tests.bar -a WholeFlowWithMockedNodeApplication_Test -p WholeFlowWithMockedNodeApplication
mqsicreatebar -data /tmp/bdd/ace-bdd-cucumber -b /tmp/bdd/WholeFlowWithMockedNodeApplication-TDD-tests.bar -a WholeFlowWithMockedNodeApplication_TDD -p WholeFlowWithMockedNodeApplication
mqsicreatebar -data /tmp/bdd/ace-bdd-cucumber -b /tmp/bdd/WholeFlowWithMockedNodeApplication.bar -a WholeFlowWithMockedNodeApplication

echo ""
echo "================ Running WholeFlowWithMockedNodeApplication tests"
echo ""
rm -rf /tmp/bdd/WholeFlowWithMockedNodeApplication-work-dir
mqsicreateworkdir /tmp/bdd/WholeFlowWithMockedNodeApplication-work-dir
mqsibar -c -w /tmp/bdd/WholeFlowWithMockedNodeApplication-work-dir -a WholeFlowWithMockedNodeApplication.bar
# Could run a separate TDD test work directory if there was a danger of interference
mqsibar -c -w /tmp/bdd/WholeFlowWithMockedNodeApplication-work-dir -a WholeFlowWithMockedNodeApplication-TDD-tests.bar
mqsibar -c -w /tmp/bdd/WholeFlowWithMockedNodeApplication-work-dir -a WholeFlowWithMockedNodeApplication-tests.bar
IntegrationServer -w /tmp/bdd/WholeFlowWithMockedNodeApplication-work-dir --no-nodejs --start-msgflows no --test-project WholeFlowWithMockedNodeApplication_TDD
IntegrationServer -w /tmp/bdd/WholeFlowWithMockedNodeApplication-work-dir --no-nodejs --start-msgflows no --test-project WholeFlowWithMockedNodeApplication_Test
