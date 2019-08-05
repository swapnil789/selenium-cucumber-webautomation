**************************************************************************************************
**************************************************************************************************
## Selenium Cucumber Test Framework
**************************************************************************************************
**************************************************************************************************

seleniumcucumber webapp generic testframework
Release - v0.1.0

**************************************************************************************************
**************************************************************************************************

## Steps to get you set up and running:
1.  Install jdk1.8.0_172 , setup environment variable of JAVA_HOME = "C:\Program Files\Java\jdk1.8.0_172"
2.  Download Eclipse Mars Enterprise Edition
3.  Import the clone project in selected workspace

## The following structure with corresponding folder and file names is to be maintained and followed:

seleniumcucumber_webapp_testframework | | | |
----- | ----- | ----- | ----- | -----
src/main/java |	----- | com.sk.Managers | ---- |
----- | ----- | ------------ | PageObjectManager.java |
----- | ----- | ------------ | FileReaderManager.java |
----- | ----- | ------------ | WebDriverManager.java |
----- |	----- |	com.sk.pageobjects | ----- |
----- |	----- |	--------------- | SampleLoginPage.java |
----- | ----- | com.sk.cucumber | --- |
----- | ----- | -------- | TestContext.java |		<!-- Pico-Container managing WebdriverManager and pageObjectManager -->
----- | ----- |	com.sk.dataProvider | ---- |
----- | ----- |	------------ | ConfigFileReader.java |
----- | ----- | enums | ---- |
----- | ----- | ----- | DriverType.java |
----- | ----- | ----- | EnvironmentType.java |
----- | ----- |	com.sk.helperutils | ---- |
----- | ----- |	------------ | HelperUtility.java |
----- | ----- |	com.sk.waitutility | ---- |
----- | ----- |	------------ | WaitUtility.java |
----- | ----- |	com.sk.locators | ---- |
----- | ----- |	------------ | SampleElements.java |
src/test/java | ---- | com.sk.runners | ---- |
----- | ----- | ----------- | TestRunner.java |
----- | ----- | com.sk.stepdefinitions | ---- |
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
