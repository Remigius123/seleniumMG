package iosdemo;


import org.aspectj.lang.annotation.After;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class AndroidRemoteApkTest {

	private RemoteWebDriver driver;

	@BeforeSuite
	public void openDriver() throws Exception {

		final DesiredCapabilities device = new DesiredCapabilities();
		device.setCapability("browserName", "android");
		device.setCapability("browserVersion", "8.1");
		device.setCapability("acceptInsecureCerts", "true");
		device.setCapability("app", "/Users/smartpoint/Downloads/com.androbaby.game2048_2.1-15_minAPI15(nodpi)_apkmirror.com.apk"); 
		//APK from https://www.apkmirror.com/apk/androbaby/2048/2048-2-1-release/2048-2-1-android-apk-download/download/
		//device.setCapability("appPackage", "com.androbaby.game2048");
		//device.setCapability("appActivity", "com.androbaby.game2048.MainActivity");
		device.setCapability("enableVNC", true);
		device.setCapability("enableVideo", true);
		device.setCapability("enableLog", true);
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver (url, device);
		// driver = new RemoteWebDriver(new URL(
		//    "http://35.202.12.85:4444/wd/hub" //Replace with correct host and port
		// ), device);
		System.out.println("started successfully");
	}

	@Test
	public void browserTest() throws Exception {
		try {
			driver.findElement(By.xpath("//*[@text=\"Start Game\"]")).click();
			driver.findElement(By.xpath("//*[@text=\"Start Game\"]")).click();
			driver.findElement(By.xpath("//*[@text=\"Start Game\"]")).click();
			driver.findElement(By.xpath("//*[@text=\"Start Game\"]")).click();
			driver.findElement(By.xpath("//*[@text=\"Start Game\"]")).click();
			System.out.println("success");
		} finally {
			takeScreenshot(driver);
		}
	}

	private void takeScreenshot(RemoteWebDriver driver2) {
		// TODO Auto-generated method stub

	}

	@AfterSuite
	public void closeDriver(){
		if (driver != null){
			driver.quit();
			driver = null;
			System.out.println("success");
		}
	}
}