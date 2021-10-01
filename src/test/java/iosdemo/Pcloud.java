package iosdemo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Pcloud {
	AppiumDriverLocalService service;
	AppiumDriver<WebElement> driver;

	@Test
	public void test1() throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("pCloudy_Username", "remigiusimmanuel.loorthusamy@smartpoint.in");
		capabilities.setCapability("pCloudy_ApiKey", "j3hvr7tqf8wx45gspghv5wzc");
		capabilities.setCapability("pCloudy_DurationInMinutes", 10);
		capabilities.setCapability("newCommandTimeout", 600);
		capabilities.setCapability("launchTimeout", 90000);
		capabilities.setCapability("pCloudy_DeviceFullName", "GOOGLE_PixelXL_Android_10.0.0_53dda");
		capabilities.setCapability("platformVersion", "10.0.0");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("automationName", "uiautomator2");
		capabilities.setCapability("pCloudy_ApplicationName", "pCloudy_Appium_Demo.apk");
		capabilities.setCapability("appPackage", "com.pcloudy.appiumdemo");
		capabilities.setCapability("appActivity", "com.ba.mobile.LaunchActivity");
		capabilities.setCapability("pCloudy_WildNet", "false");
		capabilities.setCapability("pCloudy_EnableVideo", "true");
		capabilities.setCapability("pCloudy_EnablePerformanceData", "true");
		capabilities.setCapability("pCloudy_EnableDeviceLogs", "true");

		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("https://device.pcloudy.com/appiumcloud/wd/hub"), capabilities);
		//http://" + "naveenautomation" +":" +"j3hvr7tqf8wx45gspghv5wzc" + "@"+ "35.192.74.183" +"/wd/hub
		//https://" + "remigiusimmanuel.loorthusamy@smartpoint.in" +":" +"j3hvr7tqf8wx45gspghv5wzc" + "@"+ "device.pcloudy.com/appiumcloud" +"/wd/hub
		//AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("https://device.pcloudy.com/appiumcloud/wd/hub"), capabilities);
		//RemoteWebDriver driver = new RemoteWebDriver(
		// URI.create("https://device.pcloudy.com/appiumcloud/wd/hub").toURL(),
		// capabilities
		//);
		System.out.println("Started..");

		driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.pcloudy.appiumdemo:id/accept']")).click(); 

		//Click on Flight button
		driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.pcloudy.appiumdemo:id/flightButton']")).click();

		//Select from location
		driver.findElement(By.xpath("//android.widget.Spinner[@resource-id='com.pcloudy.appiumdemo:id/spinnerfrom']")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Bangalore, India (BLR)']")).click();

		//Select to location
		driver.findElement(By.xpath("//android.widget.Spinner[@resource-id='com.pcloudy.appiumdemo:id/spinnerto']")).click();

		driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='Pune, India (PNQ)']")).click();


		//Select one way trip
		driver.findElement(By.xpath("//android.widget.RadioButton[@resource-id='com.pcloudy.appiumdemo:id/singleTrip']")).click();


		//Select departure time
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.pcloudy.appiumdemo:id/txtdepart']")).click();

		driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1' and @text='OK']")).click();


		//Click on search flights button
		driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.pcloudy.appiumdemo:id/searchFlights']")).click();

		driver.quit();
	}
}
