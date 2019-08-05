package com.kpit.waitutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Swapnil Khute
 *
 */

public class WaitUtil {

	WebDriver driver;
	private static WaitUtil waitUtil;
	
	//This method will create the object of WaitUtil class
	public static WaitUtil getInstance(WebDriver driver) {
		return (waitUtil == null) ? waitUtil = new WaitUtil(driver) : waitUtil;
	}
	
	//This method can be used to explicitly kill WaitUtil object allocation
	public static void clean() {
		waitUtil = null;
	}

	//This method will initialize the WaitUtil with driver
	private WaitUtil(WebDriver driver){
		this.driver = driver;
	}
	
	public void waitForElementVisibility(WebElement element, int timeoutinsecond){
		WebDriverWait wait = new WebDriverWait(driver, timeoutinsecond);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementToBeClickable(WebElement element, int timeoutinsecond){
		WebDriverWait wait = new WebDriverWait(driver, timeoutinsecond);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForSpinnerToBeDisable(String locator, int timeoutinsecond){
		WebDriverWait wait = new WebDriverWait(driver, timeoutinsecond);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(locator)));
	}
}
