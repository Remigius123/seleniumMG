package iosdemo;
import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Log;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.github.javafaker.Faker;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
public class ReadInvoices {

	private static final String NAME = "/Users/smartpoint/Documents/TestData.xlsx";


	public static void main(String[] args) {
		ExtentReport log = new ExtentReport();

		try {
			log.logger.log(Status.INFO, "Automstion Testing Started");

			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("platformName", "iOS");
			caps.setCapability("deviceName", "iPhone 8 Plus");
			caps.setCapability("platformVersion", "14.5");
			//caps.setCapability(CapabilityType.BROWSER_NAME, "safari");
			caps.setCapability("app", "/Users/smartpoint/Library/Developer/Xcode/DerivedData/MaryGold-fupudusfwfwafjffpptqcloogtpq/Build/Products/Debug-iphonesimulator/MaryGold.app");


			URL url = new URL("http://127.0.0.1:4723/wd/hub");




			IOSDriver driver = new IOSDriver(url, caps);

			System.out.println("Started successfully.");
			Faker faker = new Faker();

			FileInputStream file = new FileInputStream(new File(NAME));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			int testcasescount = workbook.getNumberOfSheets();
			System.out.println("Total test cases :" + testcasescount);
			System.out.println("" + testcasescount);


			for (int testcase = 0; testcase < testcasescount; testcase++) {

				XSSFSheet worksheet = workbook.getSheetAt(testcase);
				System.out.println("worksheet Number " + testcase + ":" + worksheet.getSheetName());
				int row = worksheet.getLastRowNum();
				int column = worksheet.getRow(1).getLastCellNum();

				for (int i = 1; i <= row; i++) {

					LinkedList < String > Testexecution = new LinkedList < > ();

					//System.out.println('Row value :"+i+"It has first cell value as : "+worksheet.getRow(i).getCell(0));
					for (int j = 0; j < column; j++) {
						//System.out.println("Column index :"+j);
						Cell Criteria = worksheet.getRow(i).getCell(j);

						Criteria.setCellType(CellType.STRING);
						Testexecution.add(Criteria.getStringCellValue());
					}
					System.out.println("List :" + Testexecution);


					String TCID = Testexecution.get(0);
					String TestSteps = Testexecution.get(1);
					String Keyword = Testexecution.get(2).toString();
					String LocatorType = Testexecution.get(3).toString();
					String LocatorValue = Testexecution.get(4).toString().replace("\\", "");
					String TestData = Testexecution.get(5);



					switch (Keyword) {
					case "navigateTo": //t.navigateTo( url )

						break;
					case "click":
						driver.findElement(By.xpath(LocatorValue)).click();
						log.logger.log(Status.PASS, Keyword+ "  xpath  "+LocatorValue+"  Click action Performed");
						break;
					case "sendKeys":
						driver.findElement(By.xpath(LocatorValue)).sendKeys(TestData);  
						log.logger.log(Status.PASS, Keyword+ "  xpath  "+LocatorValue+ TestData+"  Sendkey action performed");
						break;

					default:
						return;


					}
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block                                                                                                                                                                                                                                                                              
						e.printStackTrace();
					}

				}

			}


		} catch (Exception e) {

			e.printStackTrace();
			log.logger.log(Status.FAIL, "OOPS! something went wrong : " +e);
		}
		log.extent.flush();

	}
}