package com.automation.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.automation.cucumber.TestContext;
import com.automation.pageobjects.SampleLoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author Swapnil Khute
 *
 */

public class SampleLoginPageStep {

	WebDriver driver;
	TestContext testContext;
	SampleLoginPage loginPage;

	public SampleLoginPageStep(TestContext context) {
		testContext = context;
		loginPage = testContext.getPageObjectManager().getSampleLoginPage();
	}

	@Given("^User is on Login page$")
	public void userIsOnLoginPage() {
		loginPage.navigateToLoginPage();
	}

	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\" and click on Login button$")
	public void userEntersAndAndClickOnLoginButton(String uname, String pwd) {
		loginPage.enterUserName(uname);
		loginPage.enterPassword(pwd);
		loginPage.clickOnLoginBtn();
	}

	@Then("^User validate Home sceen appears$")
	public void userValidateHomeSceenAppears() {
		
	}
}
