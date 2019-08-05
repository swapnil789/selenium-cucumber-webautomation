package com.automation.cucumber;

import com.automation.managers.PageObjectManager;
import com.automation.managers.WebdriverManager;

/**
 * @author Swapnil Khute
 *
 */
public class TestContext {

	 private WebdriverManager webDriverManager;
	 private PageObjectManager pageObjectManager;
	 
	 public TestContext(){
	 webDriverManager = new WebdriverManager();
	 pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
	 }
	 
	 public WebdriverManager getWebDriverManager() {
	 return webDriverManager;
	 }
	 
	 public PageObjectManager getPageObjectManager() {
	 return pageObjectManager;
	 }
	 
}
