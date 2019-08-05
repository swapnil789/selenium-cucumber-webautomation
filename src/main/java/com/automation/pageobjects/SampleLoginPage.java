package com.automation.pageobjects;

import org.openqa.selenium.WebDriver;

import com.automation.helperutils.HelperUtility;
import com.automation.locators.SampleElements;
import com.automation.managers.FileReaderManager;
import com.automation.waitutility.WaitUtil;

/**
 * @author Swapnil Khute
 *
 */

public class SampleLoginPage extends SampleElements {

	WebDriver driver;
	WaitUtil waitUtil;
	HelperUtility helperUtil;

	public SampleLoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		waitUtil = WaitUtil.getInstance(driver);
		helperUtil = HelperUtility.getInstance(driver);
	}

	// Test Data
	String groupOwnerCDSId = "test_jlr_owner";
	String groupOwnerCDSPwd = "Test@123";
	String spinnerlocator = "spinner";        // Locator of spinner

	public void navigateToLoginPage() {

		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}

	public void enterUserName(String Username) {
		waitUtil.waitForElementVisibility(CDS_Id, 10);
		CDS_Id.sendKeys(Username);
	}
	
	public void enterPassword(String Password){
		CDS_Password.sendKeys(Password);
	}
	
	public void clickOnLoginBtn(){
		helperUtil.jsClickEvent(Login_Button);
	}
}
