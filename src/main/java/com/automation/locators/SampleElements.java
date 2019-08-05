package com.automation.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Swapnil Khute
 *
 */
public class SampleElements {
	
	WebDriver driver;
	
	public SampleElements(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	/*====================== Common Elements ===================================*/
	@FindBy(how = How.XPATH, using = "//INPUT[@id='nameInput']")
	public WebElement CDS_Id;

	@FindBy(how = How.XPATH, using = "//INPUT[@id='passwordInput']")
	public WebElement CDS_Password;

	/*==================== Elements From Screen 1 ==============================*/
	@FindBy(how = How.XPATH, using = "//button[@id='logInButton']")
	public WebElement Login_Button;

	@FindBy(how = How.XPATH, using = "(//BUTTON[@_ngcontent-c1=''])[1]")
	public WebElement Logged_UserName;
}
