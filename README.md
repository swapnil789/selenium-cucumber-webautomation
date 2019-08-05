**************************************************************************************************
**************************************************************************************************
## KPIT Technologies
**************************************************************************************************
**************************************************************************************************

seleniumcucumber webapp generic testframework
Release - v0.1.0
(C) 2018 KPIT Technologies Limited. All Rights Reserved.

**************************************************************************************************
**************************************************************************************************

## Steps to get you set up and running:
1.  Install jdk1.8.0_172 , setup environment variable of JAVA_HOME = "C:\Program Files\Java\jdk1.8.0_172"
2.  Download Eclipse Mars Enterprise Edition
3.  Clone the repository using command "http://git.diagnostics.kpit.com/scm/en/selenium_cucumber_test_framework.git"
4.  Import the clone project in selected workspace

## The following structure with corresponding folder and file names is to be maintained and followed:

seleniumcucumber_webapp_testframework | | | |
----- | ----- | ----- | ----- | -----
src/main/java |	----- | com.kpit.Managers | ---- |
----- | ----- | ------------ | PageObjectManager.java |
----- | ----- | ------------ | FileReaderManager.java |
----- | ----- | ------------ | WebDriverManager.java |
----- |	----- |	com.kpit.pageobjects | ----- |
----- |	----- |	--------------- | SampleLoginPage.java |
----- | ----- | com.kpit.cucumber | --- |
----- | ----- | -------- | TestContext.java |		<!-- Pico-Container managing WebdriverManager and pageObjectManager -->
----- | ----- |	com.kpit.dataProvider | ---- |
----- | ----- |	------------ | ConfigFileReader.java |
----- | ----- | enums | ---- |
----- | ----- | ----- | DriverType.java |
----- | ----- | ----- | EnvironmentType.java |
----- | ----- |	com.kpit.helperutils | ---- |
----- | ----- |	------------ | HelperUtility.java |
----- | ----- |	com.kpit.waitutility | ---- |
----- | ----- |	------------ | WaitUtility.java |
----- | ----- |	com.kpit.locators | ---- |
----- | ----- |	------------ | SampleElements.java |
src/test/java | ---- | com.kpit.runners | ---- |
----- | ----- | ----------- | TestRunner.java |
----- | ----- | com.kpit.stepdefinitions | ---- |
----- | ----- | ------------------- | SampleLoginPageStep.java |
src/test/resources | ---- | features | ---- |
---- | ---- | ---- | SampleModule1.feature |
Configs | ---- | ---- | ---- |
---- | Configuration.properties | ---- | ---- |
---- | extent-config.xml | ---- | ---- |

## Key Concerns for writing Feature file
* One Feature file may have multiple scenarios
* One Scenario should cover only one test case

## Dont's -

* Avoid using Thread.sleep()
* Avoid hardcode values, instead use parameterization

## Report
1. Mention Build version in Test Runner class
2. Mention Suite name in Test Runner class
