package iosdemo;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.ios.IOSDriver;

public class webAutomation {

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
	public void steup() throws MalformedURLException, InterruptedException {
		ExtentTest test = extent.createTest("Marygold&CO web portal").assignAuthor("Remigius L").assignCategory("Ad-hoc testing").assignDevice("iPhone 8 Plus");

		// declaration and instantiation of objects/variables
		//System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		//comment the above 2 lines and uncomment below 2 lines to use Chrome
		//DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities.setBrowserName("chrome");
		//capabilities.setVersion("80.0");
		//capabilities.setCapability("enableVNC", true);
		//capabilities.setCapability("enableVideo", true);
		//capabilities.setCapability("name", "Demo_test");


		//RemoteWebDriver driver = new RemoteWebDriver(
		//URI.create("http://34.101.249.149:4444/wd/hub").toURL(), 
		//capabilities
		//);
		//Selenoid 
		//URL url = new URL("http://35.243.196.53:4444/wd/hub");

		//Selenoid+Moon
		//URL url = new URL("http://34.132.189.67:4444/wd/hub");
		test.info("Automation script test successfully started");

		//RemoteWebDriver driver = new RemoteWebDriver (url, capabilities);
		System.setProperty("webdriver.chrome.driver","/Users/smartpoint/Softwares/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
		//Test 3: Send a check
				Thread.sleep(2000);driver.get("https://marygold-pay-anyone.uc.r.appspot.com/payment?pid=d1ca1a52-c149-4d1d-9b0a-db874e896ec1");test.pass("URL navigated successfully");
				Thread.sleep(2000);driver.findElement(By.id("ngb-nav-2")).click();test.pass("Button clicked successfully");
				Thread.sleep(2000);driver.findElement(By.linkText("Accept Payment")).click();test.pass("Button clicked successfully");
				Thread.sleep(2000);driver.findElement(By.xpath("//div[@id='ngb-nav-2-panel']/app-exach/div/div[2]/form/div/div/div[2]/div/label/i")).click();test.pass("Button clicked successfully");
				Thread.sleep(2000);driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='SECS'])[1]/following::span[2]")).click();test.pass("Button clicked successfully");
				Thread.sleep(2000);driver.findElement(By.xpath("//div[@id='ngb-nav-2-panel']/app-exach/div/div[2]/form/div/div/div[3]/div/label/i")).click();test.pass("Button clicked successfully");
				Thread.sleep(2000);driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='SECS'])[1]/following::span[2]")).click();test.pass("Button clicked successfully");
				Thread.sleep(2000);driver.findElement(By.name("receiverAccountName")).click();test.pass("Button clicked successfully");
				Thread.sleep(2000);driver.findElement(By.name("receiverAccountName")).clear();test.pass("Values cleared successfully");
				Thread.sleep(2000);driver.findElement(By.name("receiverAccountName")).sendKeys("Dinesh");test.pass("Values sent successfully");
				Thread.sleep(2000);driver.findElement(By.name("receiverAccountType")).click();test.pass("Button clicked successfully");
				Thread.sleep(2000);new Select(driver.findElement(By.name("receiverAccountType"))).selectByVisibleText("Checking");test.pass("Value selected successfully");
				Thread.sleep(2000);driver.findElement(By.name("receiverAccountType")).click();test.pass("Button clicked successfully");
				Thread.sleep(2000);new Select(driver.findElement(By.name("receiverAccountType"))).selectByVisibleText("Savings");test.pass("Value selected successfully");
				Thread.sleep(2000);driver.findElement(By.name("receiverAccountType")).click();test.pass("Button clicked successfully");
				Thread.sleep(2000);new Select(driver.findElement(By.name("receiverAccountType"))).selectByVisibleText("Select");test.pass("Value selected successfully");
				Thread.sleep(2000);driver.findElement(By.name("receiverAccountType")).click();test.pass("Button clicked successfully");
				Thread.sleep(2000);new Select(driver.findElement(By.name("receiverAccountType"))).selectByVisibleText("Checking");test.pass("Value selected successfully");
				Thread.sleep(2000);driver.findElement(By.name("receiverRoutingNo")).click();test.pass("Button clicked successfully");
				Thread.sleep(2000);driver.findElement(By.name("receiverRoutingNo")).clear();test.pass("Text cleared successfully");
				Thread.sleep(2000);driver.findElement(By.name("receiverRoutingNo")).sendKeys("0983472930");test.pass("values sent successfully");
				Thread.sleep(2000);driver.findElement(By.name("receiverAccountId")).click();test.pass("Button clicked successfully");
				Thread.sleep(2000);driver.findElement(By.name("receiverAccountId")).clear();test.pass("Values cleared successfully");
				Thread.sleep(2000);driver.findElement(By.name("receiverAccountId")).sendKeys("20203369412");test.pass("Values sent successfully");
				Thread.sleep(2000);driver.findElement(By.linkText("Accept Payment")).click();test.pass("Button clicked successfully");
				Thread.sleep(2000);driver.findElement(By.name("receiverAccountId")).click();test.pass("Button clicked successfully");
				Thread.sleep(2000);driver.findElement(By.name("receiverAccountType")).click();test.pass("Button clicked successfully");
				Thread.sleep(2000);new Select(driver.findElement(By.name("receiverAccountType"))).selectByVisibleText("Select");test.pass("Value selected successfully");
				Thread.sleep(2000);driver.findElement(By.linkText("Accept Payment")).click();test.pass("Button clicked successfully");
				Thread.sleep(2000);driver.findElement(By.name("receiverAccountType")).click();test.pass("Button clicked successfully");
				Thread.sleep(2000);new Select(driver.findElement(By.name("receiverAccountType"))).selectByVisibleText("Checking");test.pass("Value selected successfully");
				Thread.sleep(2000);driver.findElement(By.name("receiverAccountId")).click();test.pass("Button clicked successfully");
				Thread.sleep(2000);driver.findElement(By.name("receiverAccountId")).clear();test.pass("Values cleared successfully");
				Thread.sleep(2000);driver.findElement(By.name("receiverAccountId")).sendKeys("2020336941");test.pass("values sent successfully");
				Thread.sleep(2000);driver.findElement(By.linkText("Accept Payment")).click();test.pass("Button clicked successfully");
				Thread.sleep(2000);driver.findElement(By.name("receiverRoutingNo")).click();test.pass("Button clicked successfully");
				Thread.sleep(2000);driver.findElement(By.name("receiverRoutingNo")).clear();test.pass("Values cleared successfully");
				Thread.sleep(2000);driver.findElement(By.name("receiverRoutingNo")).sendKeys("098347293");test.pass("Values sent successfully");
				Thread.sleep(2000);driver.findElement(By.id("ngb-nav-3")).click();test.pass("Button clicked successfully");
				Thread.sleep(2000);driver.findElement(By.linkText("Accept Payment")).click();test.pass("Button clicked successfully");

		
		//Test 1: SendToYourBank
		driver.get("https://marygold-pay-anyone.uc.r.appspot.com/payment?pid=d1ca1a52-c149-4d1d-9b0a-db874e896ec1");
		Thread.sleep(2000);driver.findElement(By.id("ngb-nav-1")).click();test.pass("Button clicked successfully");
		Thread.sleep(2000);driver.findElement(By.linkText("Accept Payment")).click();test.pass("Button clicked successfully");
		Thread.sleep(2000);driver.findElement(By.name("receiverAccountName")).click();test.pass("Button clicked successfully");
		Thread.sleep(2000);driver.findElement(By.xpath("//div[@id='ngb-nav-1-panel']/app-ach/div/div/form/div/div/div[2]/div/label/i")).click();test.pass("Button clicked successfully");
		Thread.sleep(2000);driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='SECS'])[1]/following::span[2]")).click();test.pass("Button clicked successfully");
		Thread.sleep(2000);driver.findElement(By.xpath("//div[@id='ngb-nav-1-panel']/app-ach/div/div/form/div/div/div[3]/div/label/i")).click();test.pass("Button clicked successfully");
		Thread.sleep(2000);driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='SECS'])[1]/following::span[2]")).click();test.pass("Button clicked successfully");
		Thread.sleep(2000);driver.findElement(By.name("receiverAccountName")).click();test.pass("Button clicked successfully");
		Thread.sleep(2000);driver.findElement(By.name("receiverAccountName")).clear();test.pass("Text cleared successfully");
		Thread.sleep(2000);driver.findElement(By.name("receiverAccountName")).sendKeys("Remigius L");test.pass("Values sent successfully");
		Thread.sleep(2000);driver.findElement(By.name("receiverAccountType")).click();test.pass("Button clicked successfully");
		Thread.sleep(2000);new Select(driver.findElement(By.name("receiverAccountType"))).selectByVisibleText("Checking");test.pass("Value selected successfully");
		Thread.sleep(2000);driver.findElement(By.name("receiverAccountType")).click();test.pass("Button clicked successfully");
		Thread.sleep(2000);new Select(driver.findElement(By.name("receiverAccountType"))).selectByVisibleText("Savings");test.pass("Value selected successfully");
		Thread.sleep(2000);driver.findElement(By.name("receiverAccountType")).click();test.pass("Button clicked successfully");
		Thread.sleep(2000);new Select(driver.findElement(By.name("receiverAccountType"))).selectByVisibleText("Select");test.pass("Values selected successfully");
		Thread.sleep(2000);driver.findElement(By.name("receiverAccountType")).click();test.pass("Button clicked successfully");
		Thread.sleep(2000);new Select(driver.findElement(By.name("receiverAccountType"))).selectByVisibleText("Checking");test.pass("Value selected successfully");
		Thread.sleep(2000);driver.findElement(By.name("receiverRoutingNo")).click();test.pass("Button clicked successfully");
		Thread.sleep(2000);driver.findElement(By.name("receiverRoutingNo")).clear();test.pass("Text cleared successfully");
		Thread.sleep(2000);driver.findElement(By.name("receiverRoutingNo")).sendKeys("8093428403");test.pass("Values sent successfully");
		Thread.sleep(2000);driver.findElement(By.name("receiverAccountId")).click();test.pass("Button clicked successfully");
		Thread.sleep(2000);driver.findElement(By.name("receiverAccountId")).clear();test.pass("Text cleared successfully");
		Thread.sleep(2000);driver.findElement(By.name("receiverAccountId")).sendKeys("20203369412");test.pass("Values sent successfully");
		Thread.sleep(2000);driver.findElement(By.linkText("Accept Payment")).click();test.pass("Button clicked successfully");
		Thread.sleep(2000);driver.findElement(By.name("receiverAccountId")).click();test.pass("Button clicked successfully");
		Thread.sleep(2000);driver.findElement(By.name("receiverAccountId")).clear();test.pass("Values cleared successfully");
		Thread.sleep(2000);driver.findElement(By.name("receiverAccountId")).sendKeys("2020336941");test.pass("Value sent successfully");
		Thread.sleep(2000);driver.findElement(By.linkText("Accept Payment")).click();test.pass("Button clicked successfully");
		Thread.sleep(2000);driver.findElement(By.name("receiverAccountId")).click();test.pass("Button clicked successfully");
		Thread.sleep(2000);driver.findElement(By.name("receiverRoutingNo")).click();test.pass("Button clicked successfully");
		Thread.sleep(2000);driver.findElement(By.name("receiverRoutingNo")).clear();test.pass("Values cleared successfully");
		Thread.sleep(2000);driver.findElement(By.name("receiverRoutingNo")).sendKeys("809342840");test.pass("Text sent successfully");
		Thread.sleep(2000);driver.findElement(By.id("ngb-nav-2")).click();

		//Test 2: SendToYourBankFast
		Thread.sleep(2000);driver.get("https://marygold-pay-anyone.uc.r.appspot.com/payment?pid=d1ca1a52-c149-4d1d-9b0a-db874e896ec1");test.pass("URL navigated successfully");
		Thread.sleep(2000);driver.findElement(By.id("ngb-nav-2")).click();test.pass("Button clicked successfully");
		Thread.sleep(2000);driver.findElement(By.linkText("Accept Payment")).click();test.pass("Button clicked successfully");
		Thread.sleep(2000);driver.findElement(By.xpath("//div[@id='ngb-nav-2-panel']/app-exach/div/div[2]/form/div/div/div[2]/div/label/i")).click();test.pass("Button clicked successfully");
		Thread.sleep(2000);driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='SECS'])[1]/following::span[2]")).click();test.pass("Button clicked successfully");
		Thread.sleep(2000);driver.findElement(By.xpath("//div[@id='ngb-nav-2-panel']/app-exach/div/div[2]/form/div/div/div[3]/div/label/i")).click();test.pass("Button clicked successfully");
		Thread.sleep(2000);driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='SECS'])[1]/following::span[2]")).click();test.pass("Button clicked successfully");
		Thread.sleep(2000);driver.findElement(By.name("receiverAccountName")).click();test.pass("Button clicked successfully");
		Thread.sleep(2000);driver.findElement(By.name("receiverAccountName")).clear();test.pass("Text cleared successfully");
		Thread.sleep(2000);driver.findElement(By.name("receiverAccountName")).sendKeys("Dinesh");test.pass("Text sent successfully");
		Thread.sleep(2000);driver.findElement(By.name("receiverAccountType")).click();test.pass("Button clicked successfully");
		Thread.sleep(2000);new Select(driver.findElement(By.name("receiverAccountType"))).selectByVisibleText("Checking");
		driver.findElement(By.name("receiverAccountType")).click();test.pass("Button clicked successfully");
		Thread.sleep(2000);new Select(driver.findElement(By.name("receiverAccountType"))).selectByVisibleText("Savings");test.pass("Value selected successfully");
		Thread.sleep(2000);driver.findElement(By.name("receiverAccountType")).click();test.pass("Button clicked successfully");
		Thread.sleep(2000);new Select(driver.findElement(By.name("receiverAccountType"))).selectByVisibleText("Select");test.pass("Value selected successfully");
		Thread.sleep(2000);driver.findElement(By.name("receiverAccountType")).click();test.pass("Button clicked successfully");
		Thread.sleep(2000);new Select(driver.findElement(By.name("receiverAccountType"))).selectByVisibleText("Checking");test.pass("Value selected successfully");
		Thread.sleep(2000);driver.findElement(By.name("receiverRoutingNo")).click();test.pass("Button clicked successfully");
		Thread.sleep(2000);driver.findElement(By.name("receiverRoutingNo")).clear();test.pass("Text cleared successfully");
		Thread.sleep(2000);driver.findElement(By.name("receiverRoutingNo")).sendKeys("0983472930");test.pass("Text sent successfully");
		Thread.sleep(2000);driver.findElement(By.name("receiverAccountId")).click();test.pass("Button clicked successfully");
		Thread.sleep(2000);driver.findElement(By.name("receiverAccountId")).clear();test.pass("Values cleared successfully");
		Thread.sleep(2000);driver.findElement(By.name("receiverAccountId")).sendKeys("20203369412");test.pass("Text sent successfully");
		Thread.sleep(2000);driver.findElement(By.linkText("Accept Payment")).click();test.pass("Button clicked successfully");
		Thread.sleep(2000);driver.findElement(By.name("receiverAccountId")).click();test.pass("Button clicked successfully");
		Thread.sleep(2000);driver.findElement(By.name("receiverAccountType")).click();test.pass("Button clicked successfully");
		Thread.sleep(2000);new Select(driver.findElement(By.name("receiverAccountType"))).selectByVisibleText("Select");test.pass("Value selected successfully");
		Thread.sleep(2000);driver.findElement(By.linkText("Accept Payment")).click();test.pass("Button clicked successfully");
		Thread.sleep(2000);driver.findElement(By.name("receiverAccountType")).click();test.pass("Button clicked successfully");
		Thread.sleep(2000);new Select(driver.findElement(By.name("receiverAccountType"))).selectByVisibleText("Checking");test.pass("Value selected successfully");
		Thread.sleep(2000);driver.findElement(By.name("receiverAccountId")).click();test.pass("Button clicked successfully");
		Thread.sleep(2000);driver.findElement(By.name("receiverAccountId")).clear();test.pass("Values cleared successfully");
		Thread.sleep(2000);driver.findElement(By.name("receiverAccountId")).sendKeys("2020336941");test.pass("Values sent successfully");
		Thread.sleep(2000);driver.findElement(By.linkText("Accept Payment")).click();test.pass("Button clicked successfully");
		Thread.sleep(2000);driver.findElement(By.name("receiverRoutingNo")).click();test.pass("Button clicked successfully");
		Thread.sleep(2000);driver.findElement(By.name("receiverRoutingNo")).clear();test.pass("Values cleared successfully");
		Thread.sleep(2000);driver.findElement(By.name("receiverRoutingNo")).sendKeys("098347293");test.pass("Values sent successfully");
		Thread.sleep(2000);driver.findElement(By.id("ngb-nav-3")).click();test.pass("Button clicked successfully");
		Thread.sleep(2000);driver.findElement(By.linkText("Accept Payment")).click();test.pass("Button clicked successfully");

		
		String baseUrl = "http://demo.guru99.com/test/newtours/";
		Thread.sleep(8000);
		test.pass("Navigated successfully");
		String expectedTitle = "Welcome: Mercury Tours";
		Thread.sleep(8000);
		String actualTitle = "";

		// launch Fire fox and direct it to the Base URL
		driver.get(baseUrl);
		driver.manage().window().fullscreen();
		driver.findElement(By.xpath("//a[contains(text(),'SIGN-ON')]")).click();
		test.pass("Button clicked successfully");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'REGISTER')]")).click();
		test.pass("Button clicked successfully");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'SUPPORT')]")).click();
		test.pass("Button clicked successfully");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'CONTACT')]")).click();
		test.pass("Button clicked successfully");
		Thread.sleep(2000);
		driver.get(baseUrl);
		Thread.sleep(2000);
		//driver.findElement(By.xpath("/html[1]/body[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[4]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[2]/td[3]/form[1]/table[1]/tbody[1]/tr[4]/td[1]/table[1]/tbody[1]/tr[4]/td[2]/div[1]/input[1]")).click();
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[4]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[2]/td[3]/form[1]/table[1]/tbody[1]/tr[4]/td[1]/table[1]/tbody[1]/tr[2]/td[2]/input[1]")).sendKeys("demo user");
		test.pass("Sendkey performed successfully");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[4]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[2]/td[3]/form[1]/table[1]/tbody[1]/tr[4]/td[1]/table[1]/tbody[1]/tr[3]/td[2]/input[1]")).sendKeys("demo user");
		test.pass("Sendkey performed successfully");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[4]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[2]/td[3]/form[1]/table[1]/tbody[1]/tr[4]/td[1]/table[1]/tbody[1]/tr[4]/td[2]/div[1]/input[1]")).click();
		test.pass("Sendkey performed successfully");
		Thread.sleep(2000);
		// get the actual value of the title
		actualTitle = driver.getTitle();

		/*
		 * compare the actual title of the page with the expected one and print
		 * the result as "Passed" or "Failed"
		 */
		if (actualTitle.contentEquals(expectedTitle)){
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed");
		}

		//close Fire fox
		driver.close();
		test.info("Automation script test successfully completed");

	}

}
