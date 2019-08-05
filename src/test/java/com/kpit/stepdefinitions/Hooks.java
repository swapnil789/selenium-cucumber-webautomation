package com.kpit.stepdefinitions;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import com.kpit.cucumber.TestContext;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before; 

/**
 * @author Swapnil Khute
 *
 */

public class Hooks {

	TestContext testContext;

	public Hooks(TestContext context) {
		testContext = context;
	}

	@Before
	public void beforeScenario(Scenario scenario) {
		Reporter.assignAuthor("KPIT Technologies");
	}

	@After
	public void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll("[^a-zA-Z0-9() ,]", "_");
			try {
				// This takes a screenshot from the driver at save it to the specified location
				File sourcePath = ((TakesScreenshot) testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.FILE);
				// Building up the destination path for the screenshot to save
				File destinationPath = new File(System.getProperty("user.dir") + "\\target\\cucumber-reports\\screenshots\\");
				//Create directory of destination path if not exists
				if(!destinationPath.exists()){
					destinationPath.mkdirs();
				}
				File screenshotFile = new File(destinationPath.getAbsolutePath()+"\\"+screenshotName+".png");
				// Copy taken screenshot from source location to destination location
				Files.copy(sourcePath, screenshotFile);
				// This attach the specified screenshot to the test
				Reporter.addScreenCaptureFromPath(screenshotFile.toString());
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
