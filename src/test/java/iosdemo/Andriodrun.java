package iosdemo;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.github.javafaker.Faker;

import io.appium.java_client.AppiumDriver;

public class Andriodrun {
	//private static final String Fileutils = null;
	ExtentReports extent;
	WebDriver driver;

	@BeforeSuite
	public void setUp() throws IOException {
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("./Reports/Spark123.html");
		//spark.loadXMLConfig(new File("extentconfig.xml"));
		extent.attachReporter(spark);

		//this.logger = this.extent.createTest("StaticTestReport");
		System.out.println("0");


	}
	@AfterSuite
	public void tearTown() throws IOException {
		extent.flush();
		Desktop.getDesktop().browse(new File("./Reports/Spark123.html").toURI());
	}
	@Test

	public void readExcelandexecute() throws IOException {
		ExtentTest test = extent.createTest("Android_Marygold&Co").assignAuthor("Remigius L").assignCategory("Ad-hoc testing").assignDevice("iPhone 8 Plus");

		//test.pass("Test Finished");
		//test.fail("Failed");
		try {
			DesiredCapabilities caps = new DesiredCapabilities();
			//caps.setCapability("platformName", "Android");
			//caps.setCapability("platformVersion", "11");
			//caps.setCapability("deviceName", "Pixel_2_API_30");
			//caps.setCapability("platformVersion", "11");
			//caps.setCapability("app", "/Users/smartpoint/Downloads/47.apk");
			//caps.setCapability("appPackage", "com.marygoldandco.marygoldandco");
			//caps.setCapability("appActivity", "com.marygoldandco.marygoldandco.MainActivity");
			//caps.setCapability("automationName", "UiAutomator2");
			
			caps.setCapability("platformName", "Android");
			caps.setCapability("udid", "15afaf370806");
			caps.setCapability("app", "/Users/smartpoint/Downloads/47.apk");
			caps.setCapability("appPackage", "com.marygoldandco.marygoldandco");
			caps.setCapability("appActivity", "com.marygoldandco.marygoldandco.MainActivity");
			caps.setCapability("automationName", "UiAutomator2");
			caps.setCapability("platformVersion", "10");
			caps.setCapability("ensureWebviewsHavePages", true);
			

			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			//URL remoteUrl = new URL ("http://" + "naveenautomation" +  ":" + "Zalenium2020" + "@" + "35.192.74.183" + "/wd/hub");

			//IOSDriver driver = new IOSDriver(url, caps);
			AppiumDriver driver = new AppiumDriver (url, caps);

			System.out.println("Started successfully.");
			Faker faker = new Faker();

			FileInputStream file = new FileInputStream(new File("/Users/smartpoint/Documents/TestData.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			int testcasescount = workbook.getNumberOfSheets();
			//System.out.println("Total test cases :" + testcasescount);
			//System.out.println("" + testcasescount);


			for (int testcase = 0; testcase < testcasescount; testcase++) {

				XSSFSheet worksheet = workbook.getSheetAt(testcase);
				//System.out.println("worksheet Number " + testcase + ":" + worksheet.getSheetName());
				int row = worksheet.getLastRowNum();
				int column = worksheet.getRow(1).getLastCellNum();

				for (int i = 1; i <= row; i++) {

					LinkedList < String > Testexecution = new LinkedList <String > ();

					//System.out.println('Row value :"+i+"It has first cell value as : "+worksheet.getRow(i).getCell(0));
					for (int j = 0; j < column; j++) {
						//System.out.println("Column index :"+j);
						Cell Criteria = worksheet.getRow(i).getCell(j);
						System.out.println("Criteria :"+Criteria);
						Criteria.setCellType(CellType.STRING);
						Testexecution.add(Criteria.getStringCellValue());
					}
					System.out.println("List :" + Testexecution);

					String TCID = Testexecution.get(0);
					String TestSteps = Testexecution.get(1);
					String Keyword = Testexecution.get(2).toString();
					String LocatorType = Testexecution.get(3).toString();
					String LocatorValue = Testexecution.get(4).toString();
					String TestData = Testexecution.get(5).toString();
					System.out.println(LocatorValue);
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					switch (LocatorType) {
					case"xpath":
						LocatorType = Testexecution.get(3).toString();
						break;
					case"id":
						LocatorType = Testexecution.get(3).toString();
						break;	
					case"className":
						LocatorType = Testexecution.get(3).toString();
						break;
					case"cssSelector":
						LocatorType = Testexecution.get(3).toString();
						break;

					}
					switch (Keyword) {
					case "navigateTo": //t.navigateTo( url )
						driver.get(TestData);
						test.pass("Test started");

						break;
					case "click":
						driver.findElement(By.xpath(LocatorValue)).click();
						test.pass(Keyword +"  xpath  "+LocatorValue+"  Click action Performed");
						break;
					case "sendKeys":	
						driver.findElement(By.linkText(LocatorValue)).clear();	
						driver.findElement(By.xpath(LocatorValue)).sendKeys(TestData);
						driver.getKeyboard().pressKey(Keys.TAB);
						test.pass(Keyword +"  xpath  "+LocatorValue+ TestData +"  Sendkey action Performed");
						break;
					case "clear":	
						driver.findElement(By.xpath(LocatorValue)).clear();   
						test.pass(Keyword +"  xpath  "+LocatorValue+ TestData +"  Clear action Performed");
						break;
					case "keys":	
						driver.findElement(By.xpath(LocatorValue)).sendKeys(Keys.TAB);   
						test.pass(Keyword +"  xpath  "+LocatorValue+ TestData +"  Keyboard key action Performed");
						break;
					default:
						return;
					}
					Thread.sleep(2500);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			test.fail("OOPS!, something went wrong:" +e);
			test.fail("OOPS!",MediaEntityBuilder.createScreenCaptureFromPath(getScreenshotPath()).build());
		}	
	}
	public String getScreenshotPath() throws IOException {
		//System.out.println("Testme");
		File source = ((TakesScreenshot)this.driver).getScreenshotAs(OutputType.FILE);
		String path= System.getProperty("user.dir")+"/Screenshots/image.png";
		FileUtils.copyFile(source, new File(path));
		return path;
	}
}

