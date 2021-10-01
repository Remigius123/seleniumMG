package iosdemo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BaseTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void steUp(String browserName) throws MalformedURLException {
		System.out.println("Browser name is :" +browserName);
		
		MutableCapabilities sauceOpts = new MutableCapabilities();
		sauceOpts.setCapability("build", "Java-W3C-Examples");
		sauceOpts.setCapability("seleniumVersion", "3.141.59");
		sauceOpts.setCapability("username", "RemigiusImmanuel");
		sauceOpts.setCapability("accesskey", "bb1d1130-ba7b-4a95-aae9-409dc31c4fee");
		sauceOpts.setCapability("tags", "w3c-chrome-test");
		
		
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("sauce:options", sauceOpts);
		cap.setCapability("browserVersion", "latest");
		cap.setCapability("plateformName", "windows 10");
		
		
		if(browserName.equals("chrome")) {
			//WebDriverManager.chromedriver().setup();
			cap.setCapability(browserName, false);
			
			
			
		}
		//https://RemigiusImmanuel:bb1d1130-ba7b-4a95-aae9-409dc31c4fee@ondemand.apac-southeast-1.saucelabs.com/wd/hub
		driver = new RemoteWebDriver(new URL("http://@ondemand.apac-southeast-1.saucelabs.com/wd/hub"),cap);
		
		
		
	}
	@AfterMethod(alwaysRun = true)
	public void teardown() {
		driver.quit();
		
	}
	

}
