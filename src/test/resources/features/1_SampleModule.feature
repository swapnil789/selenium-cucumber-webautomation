Feature: Module to test

Scenario Outline: Test scenario for module
Given User is on Login page
When User enters "<Username>" and "<Password>" and click on Login button
Then User validate Home sceen appears
Examples:
|Username|Password|
|admin|admin|