package iosdemo;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class iPhone7 {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		firstTest();

	}
	@Test
	public static void firstTest() throws MalformedURLException {

		DesiredCapabilities caps  = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 7");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.7.1");
		caps.setCapability("automationName", "XCuiTest");
		caps.setCapability("udid", "0d00f1084c3d1be999a1f6eed324f9e12b655fa7");
		caps.setCapability("bundleId", "org.reactjs.native.example.mg");
		caps.setCapability("xcodeOrgId", "C275G6AACT");
		caps.setCapability("xcodeSigningId", "iPhone Developer");
		///Users/smartpoint/Downloads/mg_newipa/mg.ipa
		caps.setCapability("app", "/Users/smartpoint/Library/Developer/Xcode/DerivedData/mg-cvlyrczmthgmszcksescecbhtuyy/Build/Products/Debug-iphoneos/mg.app");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		IOSDriver driver = new IOSDriver(url, caps);

		System.out.println("Started successfully.");
		Faker faker = new Faker(); 

		//Permissions for device access
		driver.findElement(By.xpath("//XCUIElementTypeButton[@name='OK']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//Required validation checks in the form
		driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Pay Anyone']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.xpath("//XCUIElementTypeButton[@name='OK']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.xpath("(//XCUIElementTypeOther[@name=' Jio Office'])[3]")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("(//XCUIElementTypeOther[@name='Back'])[2]")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		driver.quit();




		System.out.println("Completed successfully.");


	}

}

