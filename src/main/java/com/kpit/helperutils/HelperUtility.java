package com.kpit.helperutils;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * @author Swapnil Khute
 *
 */
public class HelperUtility {

	WebDriver driver;
	private static HelperUtility helperUtil;
	
	//This method will create the object of HelperUtil class
	public static HelperUtility getInstance(WebDriver driver){
			return (helperUtil == null) ? helperUtil = new HelperUtility(driver) : helperUtil;
	}
	
	//This method can be used to explicitly kill HelperUtil object allocation
	public static void clean(){
		helperUtil = null;
	}
	
	//This method will initialize the HelperUtil with driver
	private HelperUtility(WebDriver driver){
		this.driver = driver;
	}

	// JavascriptExecutor's
	
	public void jsClickEvent(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	public void jsScrollIntoView(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	
	public void clickElement(WebElement element) {
		element.click();
	}
	
	public void typeKeys(WebElement element,String text){
		element.sendKeys(text);
	}
	
	public void clearText(WebElement element){
		element.clear();
	}
	
	public void doubleClick(WebElement element){
		Actions actions = new Actions(driver);
		actions.doubleClick().perform();
	}
	
	public void rightClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}
	
	public void hoverElement(WebElement element){
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
	}
}
