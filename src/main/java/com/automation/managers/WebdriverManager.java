package com.automation.managers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.automation.enums.DriverType;
import com.automation.enums.EnvironmentType;

/**
 * @author Swapnil Khute
 *
 */

public class WebdriverManager {
	private static WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	private static final String FIREFOX_DRIVER_PROPERTY = "webdriver.gecko.driver";
	private static final String IE_DRIVER_PROPERTY = "webdriver.ie.driver";
 
	public WebdriverManager() {
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
	}
	
	public WebDriver getDriver() {
		if(driver == null) driver = createDriver();
		return driver;
	}
 
	private WebDriver createDriver() {
		   switch (environmentType) {	    
	        case LOCAL : driver = createLocalDriver();
	        	break;
	        case REMOTE : driver = createRemoteDriver();
	        	break;
		   }
		   return driver;
	}
 
	private WebDriver createRemoteDriver() {
		//Below code is the partial implementation of Selenium Grid
		/*try{
		String pathToDriver = "D:\\Drivers\\chromedriver\\win32\\2.46\\chromedriver.exe";
		String node = "http://selenium.diagnostics.kpit.com:4444/wd/hub";
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--allow-file-access-from-files");
	    option.addArguments("user-data-dir="+pathToDriver);
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		capability.setCapability(ChromeOptions.CAPABILITY, option);
		capability.setBrowserName("chrome");
		capability.setPlatform(Platform.WIN10);
		driver = new RemoteWebDriver(new URL(node),capability);
		}catch(Exception e){
			e.printStackTrace();
		}
		return driver;*/
		throw new RuntimeException("RemoteWebDriver is not yet implemented");
	}
	
	private WebDriver createLocalDriver() {
        switch (driverType) {	    
        case FIREFOX :
        	System.setProperty(FIREFOX_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPath());
        	driver = new FirefoxDriver();
	    	break;
        case CHROME : 
        	System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPath());  //Old implementation of WebDriver, can be used in future if new implementation fails
        	driver = new ChromeDriver();
    		break;
        case INTERNETEXPLORER : 
        	System.setProperty(IE_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPath());        	
        	driver = new InternetExplorerDriver();
    		break;
        }
 
        if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
		return driver;
	}	
 
	public void closeDriver() {
		driver.close();
		driver.quit();
	}

}
