package iosdemo;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.gson.Gson;

import HelperComponents.makeDir;
import io.github.bonigarcia.wdm.WebDriverManager;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class Zelenium_test {

	//private static final String Fileutils = null;
	ExtentReports extent;
	WebDriver driver;
	TestResult testResult;
	private static Logger logger = LogManager.getLogger(Log4jDemo.class);
	long startTime;

	@BeforeSuite
	public void setUp() throws IOException {
		testResult = new TestResult();
		testResult.setName("Marygold_automation");
		startTime=System.currentTimeMillis();
		testResult.setStartTime(getTime());
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
		long endTime = System.currentTimeMillis() - startTime;
		testResult.setExecutionTime(String.format("(%d)s", endTime/1000));
		testResult.setEndTime(getTime());
		Gson gson =new Gson();
		String json = gson.toJson(testResult);

		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, json);
		Request request = new Request.Builder()
				.url("https://mgold.services/reports/api/v1/test-logs")
				.post(body)
				// .addHeader("cache-control", "no-cache")
				// .addHeader("postman-token", "e11ce033-931a-0419-4903-ab860261a91a")
				.build();

		Response response = client.newCall(request).execute();
		logger.info(" TestResult : {}",json);
	}
	@Test

	public void readExcelandexecute() throws IOException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("chrome");
		capabilities.setCapability("name", "Marygold&Co");
		capabilities.setCapability("build", "1.0.10");
		capabilities.setCapability("recordVideo", true);

		RemoteWebDriver driver = new RemoteWebDriver(
				URI.create("http://" + "naveenautomation" +":" +"Zalenium2020" + "@"+ "35.238.247.78" +"/wd/hub").toURL(),
				capabilities
				);
		driver.manage().window().maximize();

		//Faker faker = new Faker();
		ExtentTest test = extent.createTest("Marygold&Co").assignAuthor("Remigius L").assignCategory("Ad-hoc testing").assignDevice("Chrome");
		setAuthorCategoryAndBrowser(testResult,"Remigius L","Ad-hoc testing","Chrome");
		test.pass("Testing Started successfully.");
		logger.info("Testing Started successfully.");
		frameTestCase(testResult,"Testing Started successfully.",true);

		try {

			FileInputStream file = new FileInputStream(new File("/Users/smartpoint/Testing/Automation_testing/Appium/selenium/TestDatas/Marygold&Co_web.xlsx"));
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
					for (int j = 0; j < column; j++) {
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
						System.out.println("id :" +LocatorType );
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
						logger.info(Keyword+" " + TestData +" URL navigated successfully.");
						frameTestCase(testResult,String.format("%s %s  URL navigated successfully. ", Keyword,TestData),true);
						break;
					case "click":
						driver.findElement(By.xpath(LocatorValue)).click(); 
						test.pass(Keyword +"  xpath  "+LocatorValue+"  Click action Performed");
						logger.info(Keyword +"  xpath  "+LocatorValue+"  Click action Performed");
						frameTestCase(testResult,String.format("%s xpath %s  Click action Performed. ", Keyword,LocatorValue),true);
						break;
					case "sendKeys":	
						driver.findElement(By.xpath(LocatorValue)).clear();	
						driver.findElement(By.xpath(LocatorValue)).sendKeys(TestData);
						test.pass(Keyword +"  xpath  "+ LocatorValue+ TestData +"  Sendkey action Performed");
						logger.info(Keyword +"  xpath  "+ LocatorValue+ TestData +"  Sendkey action Performed");
						frameTestCase(testResult,String.format("%s xpath %s %s  Sendkey action Performed. ", Keyword,LocatorValue,TestData),true);
						break;
					case "clear":	
						driver.findElement(By.xpath(LocatorValue)).clear();   
						test.pass(Keyword +"  xpath  "+LocatorValue+ TestData +"  Clear action Performed");
						logger.info(Keyword +"  xpath  "+LocatorValue+ TestData +"  Clear action Performed");
						frameTestCase(testResult,String.format("%s xpath %s %s  Clear action Performed. ", Keyword,LocatorValue,TestData),true);
						break;
					case"select":
						new Select(driver.findElement(By.xpath(LocatorValue))).selectByVisibleText(TestData);
						test.pass(Keyword +"  xpath  "+LocatorValue+ TestData +"  SelectByVisibleText action Performed");
						logger.info(Keyword +"  xpath  "+LocatorValue+ TestData +"  SelectByVisibleText action Performed");
						frameTestCase(testResult,String.format("%s xpath %s %s  SelectByVisibleText action Performed. ", Keyword,LocatorValue,TestData),true);
						break;
					case "keys":	
						driver.findElement(By.xpath(LocatorValue)).sendKeys(Keys.TAB);   
						test.pass(Keyword +"  xpath  "+LocatorValue+ TestData +"  Keyboard key action Performed");							
						logger.info(Keyword +"  xpath  "+LocatorValue+ TestData +"  Keyboard key action Performed");
						frameTestCase(testResult,String.format("%s xpath %s %s  Keyboard key action Performed. ", Keyword,LocatorValue,TestData),true);
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
			logger.error("OOPS!, something went wrong:" +e);
			test.fail("OOPS!, something went wrong:" +e);
			test.fail("Screenshot"+ test.addScreenCaptureFromPath("/Users/smartpoint/Testing/Automation_testing/Appium/iosdemo/Reports/22-09-2021/Screenshots/image.png"));
			frameTestCaseWithevidence(testResult, "OOPS!, something went wrong:" +e, false, "Screenshot"+"/Users/smartpoint/Testing/Automation_testing/Appium/iosdemo/Reports/22-09-2021/Screenshots/image.png");
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

	public void frameTestCase(TestResult testResult,String details,boolean isPassed) {
		testResult.getTestcases().add(new TestCases((isPassed)?1:0, getTime(),details));
	}

	public void frameTestCaseWithevidence(TestResult testResult,String details,boolean isPassed,String screenShotPath) {
		testResult.getTestcases().add(new TestCases((isPassed)?1:0,getTime() ,details,screenShotPath));
	}

	private void setAuthorCategoryAndBrowser(TestResult result,String author,String category,String browser) {
		result.getAuthors().add(author);
		result.getCategories().add(category);
		result.getBrowsers().add(browser);
	}

	private String getTime() {
		return LocalDateTime.now().toString();
	}
}
