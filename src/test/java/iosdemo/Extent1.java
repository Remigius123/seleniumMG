package iosdemo;

import java.net.MalformedURLException;
import java.net.URL;


import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.ios.IOSDriver;

public class Extent1 {

	static ExtentTest test;
	static ExtentReports report;
	@BeforeClass
	public static void startTest()
	{
		System.out.println("success");
		//ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/extentreport1.html");
		ExtentReports extent = new ExtentReports();
		//extent.attachReporter(reporter);
		ExtentTest logger = extent.createTest("StaticTestReport");
		logger.log(Status.PASS, "success");
	}
	@Test
	public void extentReportsDemo() throws MalformedURLException
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "iOS");
		caps.setCapability("deviceName", "iPhone 8 Plus");
		caps.setCapability("platformVersion", "14.5");
		caps.setCapability(CapabilityType.BROWSER_NAME, "safari");
		//caps.setCapability("app", "/Users/smartpoint/Library/Developer/Xcode/DerivedData/MaryGold-fupudusfwfwafjffpptqcloogtpq/Build/Products/Debug-iphonesimulator/MaryGold.app");


		URL url = new URL("http://127.0.0.1:4723/wd/hub");




		IOSDriver driver = new IOSDriver(url, caps);

		System.out.println("Started 1 successfully.");


		test.log(Status.PASS, "Navigated to the specified URL");
		System.out.println("Started 2 successfully.");


		test.log(Status.FAIL, "Test Failed");
		System.out.println("Started 3 successfully.");
		test.log(Status.FAIL, "Test Failed");
		System.out.println("Started 4 successfully.");

	}

	@AfterClass
	public static void endTest()
	{
		//report.removeTest(test);
		report.flush();
		System.out.println("Completed successfully.");
	}

}

