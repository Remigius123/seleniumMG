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

public class FirstiOSTest {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		firstTest();

	}
	@Test
	public static void firstTest() throws MalformedURLException {

		DesiredCapabilities caps  = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 8 Plus");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.5");
		//caps.setCapability("platformName", "iOS");
		//caps.setCapability("deviceName", "iPhone");
		//caps.setCapability("platformVersion", "14.7.1");
		//caps.setCapability(CapabilityType.BROWSER_NAME, "safari");
		caps.setCapability("app", "/Users/smartpoint/Library/Developer/Xcode/DerivedData/mg-dxmklyqggsyhnibjfwdilitvtjjx/Build/Products/Debug-iphonesimulator/mg.app");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");


		IOSDriver driver = new IOSDriver(url, caps);

		System.out.println("Started successfully.");
		Faker faker = new Faker(); 


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
		driver.findElement(By.xpath("(//XCUIElementTypeOther[@name=' Daniel'])[3]")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("(//XCUIElementTypeOther[@name='$ USD'])[2]/XCUIElementTypeOther/XCUIElementTypeTextField")).clear();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("(//XCUIElementTypeOther[@name='$ USD'])[2]/XCUIElementTypeOther/XCUIElementTypeTextField")).sendKeys("20");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("(//XCUIElementTypeOther[@name='Pay now'])[2]")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Required validation Completed successfully.");



		//Passing Name
		driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"MaryGold\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[1]")).sendKeys(faker.name().fullName());
		System.out.println("Name validated successfully.");


		//Date picker selection                                                                                                                                                                                                                                                                                            

		driver.findElement(By.xpath("//XCUIElementTypeApplication[@name='MaryGold']/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[2]")).click();                                            
		try {                                                                                                                                                                                                                                                                                                               
			Thread.sleep(2000);                                                                                                                                                                                                                                                                                             
		} catch (InterruptedException e) {                                                                                                                                                                                                                                                                                  
			// TODO Auto-generated catch block                                                                                                                                                                                                                                                                              
			e.printStackTrace();                                                                                                                                                                                                                                                                                            
		}                                                                                                                                                                                                                                                                                                                  //Passing Phone Nr 
		driver.findElement(By.xpath("//XCUIElementTypeButton[@name='Done']")).click();   
		System.out.println("Date of birth validated successfully.");


		//Passing Phone number
		driver.findElement(By.xpath("//XCUIElementTypeApplication[@name='MaryGold']/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[3]")).click();
		driver.findElement(By.xpath("//XCUIElementTypeApplication[@name='MaryGold']/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[3]")).sendKeys("9750415799");        
		System.out.println("Phone number validated successfully.");

		//Passing email-address
		//driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"MaryGold\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[3]]")).click(); 
		driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"MaryGold\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[4]")).sendKeys(faker.internet().emailAddress());
		System.out.println("Email validated successfully.");



		//Passing Creditcard type
		driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Gold\"]")).click();
		driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Silver\"]")).click();
		driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Platinum\"]")).click();
		System.out.println("Crditcard validated successfully.");

		//Features Opted
		driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"National\"]")).click();
		driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"International\"]")).click();
		driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"EMV chip\"]")).click();
		System.out.println("Featues Opted validated successfully.");


		driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Save\"]")).click();

		// driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"MaryGold\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")).click();
		driver.findElement(By.xpath("//XCUIElementTypeButton[@name='View']")).click();

		//driver.findElement(By.xpath("//XCUIElementTypeApplication[@name='MaryGold']/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='User Info']")).click();

		driver.quit();




		System.out.println("Completed successfully.");


	}

}

