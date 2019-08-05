package com.automation.managers;

import org.openqa.selenium.WebDriver;

import com.automation.pageobjects.SampleLoginPage;

/**
 * @author Swapnil Khute
 *
 */
public class PageObjectManager {

	private WebDriver driver;

	private SampleLoginPage sampleloginPage;
    
	public PageObjectManager(WebDriver driver) {

		this.driver = driver;
	}

	public SampleLoginPage getSampleLoginPage() {

		return (sampleloginPage == null) ? sampleloginPage = new SampleLoginPage(driver) : sampleloginPage;

	}
}