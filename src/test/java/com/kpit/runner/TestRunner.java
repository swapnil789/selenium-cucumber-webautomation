package com.kpit.runner;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import com.kpit.cucumber.TestContext;
import com.kpit.managers.FileReaderManager;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * @author Swapnil Khute
 *
 */

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src/test/resources/features"},
		glue={"com.kpit.stepdefinitions"},
		//tags={"@Home"}, // this is used when we have multiple tests in a feature file. If one test then no need to mention this annotation
		plugin={"com.cucumber.listener.ExtentCucumberFormatter:"}
		//,dryRun=true // To test if the all the gherkin methods declared and defined or not.It will give an update if any issues there before running the actual test
		//monochrome=true // To get better logs at console
		)

public class TestRunner {
	
	@BeforeClass()
	public static void setup() {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
		extentProperties.setReportPath("target/cucumber-reports/" + "Automation_Report_" + timeStamp + ".html");
		extentProperties.setProjectName("KPIT");
	}
	
	@AfterClass
	public static void writeExtentReport() throws InterruptedException {
	 TestContext context = new TestContext();
	 Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
	 Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
     Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
     Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
     Reporter.setSystemInfo("Selenium", "3.7.0");
     Reporter.setSystemInfo("Maven", "3.5.2");
     Reporter.setSystemInfo("Java Version", "1.8.0_151");
     Reporter.setSystemInfo("Build Version", "Version 1.0.0");
     Reporter.setSystemInfo("Suite Name", "Sanity");
     context.getWebDriverManager().closeDriver();       //Close web driver
     }
}
