package iosdemo;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;

import HelperComponents.makeDir;
public class automationWeb {
	//private static final String Fileutils = null;
	ExtentReports extent;
	WebDriver driver;

	@BeforeSuite
	public void setUp() throws IOException {
		makeDir.makeDirectory();
		Date now = new Date();
		//dd-MM-yy HH:mm:ss
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyy");
		String time = dateFormat.format(now);
		File dir = new File("./Reports/"+time);
		dir.mkdir();
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(dir+"/extentReport.html");
		//spark.loadXMLConfig(new File("extentconfig.xml"));
		extent.attachReporter(spark);

	}
	@AfterSuite
	public void tearTown() throws IOException {
		Date now = new Date();
		//dd-MM-yy HH:mm:ss
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyy");
		String time = dateFormat.format(now);
		File dir = new File("./Reports/"+time);
		dir.mkdir();
		extent.flush();
		Desktop.getDesktop().browse(new File(dir+"/extentReport.html").toURI());
	}
	@Test

	public void readExcelandexecute() throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Faker faker = new Faker();
		ExtentTest test = extent.createTest("Marygold_automation").assignAuthor("Remigius L").assignCategory("Ad-hoc testing").assignDevice("Chrome");
		test.pass("Testing Started successfully.");
		try {


			FileInputStream file = new FileInputStream(new File("/Users/smartpoint/Desktop/Marygold&Co_web.xlsx"));
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
					//System.out.println("Remigius test");
					LinkedList < String > Testexecution = new LinkedList < > ();

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
					case"name":
						LocatorType = Testexecution.get(3).toString();
						break;							
					}							

					switch (Keyword) {						
					case "navigateTo":
						driver.get(TestData);		
						test.pass(Keyword+" " + TestData +" URL navigated successfully.");
						break;
					case "click":
						driver.findElement(By.xpath(LocatorValue)).click();
						test.pass(Keyword +"  xpath  "+LocatorValue+"  Click action Performed");
						break;
					case "sendKeys":	
						driver.findElement(By.xpath(LocatorValue)).clear();	
						driver.findElement(By.xpath(LocatorValue)).sendKeys(TestData);
						test.pass(Keyword +"  xpath  "+ LocatorValue+ TestData +"  Sendkey action Performed");
						break;
					case "clear":	
						driver.findElement(By.xpath(LocatorValue)).clear();   
						test.pass(Keyword +"  xpath  "+LocatorValue+ TestData +"  Clear action Performed");
						break;
					case"select":
						new Select(driver.findElement(By.xpath(LocatorValue))).selectByVisibleText(TestData);
						test.pass(Keyword +"  xpath  "+LocatorValue+ TestData +"  SelectByVisibleText action Performed");
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
			Date now = new Date();
			//dd-MM-yy HH:mm:ss
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyy");
			String time = dateFormat.format(now);
			File dir = new File("./Reports/"+time);
			dir.mkdir();
			//Capturing the screenshot
			File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(f, new File(dir+"/Screenshots/image.png"));
			e.printStackTrace();
			test.fail("OOPS!, something went wrong:" +e);
			test.fail("Screenshot"+ test.addScreenCaptureFromPath("/Users/smartpoint/Testing/Automation_testing/Appium/iosdemo/Reports/13-09-2021/Screenshots/image.png"));
			//test.addScreenCaptureFromPath(dir+"/Screenshots/image.png");
			//test.fail("OOPS!",MediaEntityBuilder.createScreenCaptureFromPath(getScreenshotPath()).build());		
			driver.quit();
			driver.close();
		}	
	}
	public String getScreenshotPath() throws IOException {

		Date now = new Date();
		//dd-MM-yy HH:mm:ss
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyy");
		String time = dateFormat.format(now);
		File dir = new File("./Reports/"+time);
		dir.mkdir();
		File source = ((TakesScreenshot)this.driver).getScreenshotAs(OutputType.FILE);
		String path= System.getProperty(dir+"/Screenshots/image.png");
		System.out.println("Testme"+ path);
		FileUtils.copyFile(source, new File(path));
		return path;
	}
}
