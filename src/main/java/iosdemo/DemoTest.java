package iosdemo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoTest {
	
	private RemoteWebDriver driver;

	@BeforeTest
	public void openDriver() throws MalformedURLException {
		final ChromeOptions browser = new ChromeOptions();
		browser.setCapability("moon:options", new HashMap<String, Object>(){
		{
			put("sessionTimeout", "3m");
			put("enableVNC", true);
			put("enableVideo", true);
			put("mobileDevice", new HashMap<String, Object>(){
				{
				put("deviceName", "Apple iPhone 11");
				put("enableVideo", true);
				}
			});
			
		}
		});
		driver = new RemoteWebDriver(new URL(
				"http://34.132.189.67:4444/wd/hub"), browser);
	}
	
	
	@Test
	public void browserTest() throws InterruptedException {
		String baseUrl = "http://demo.guru99.com/test/newtours/";
		Thread.sleep(8000);
		String expectedTitle = "Welcome: Mercury Tours";
		Thread.sleep(8000);
		String actualTitle = "";

		// launch Fire fox and direct it to the Base URL
		driver.get(baseUrl);
		driver.manage().window().fullscreen();
		driver.findElement(By.xpath("//a[contains(text(),'SIGN-ON')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'REGISTER')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'SUPPORT')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'CONTACT')]")).click();
		Thread.sleep(2000);
		driver.get(baseUrl);
		Thread.sleep(2000);
		//driver.findElement(By.xpath("/html[1]/body[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[4]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[2]/td[3]/form[1]/table[1]/tbody[1]/tr[4]/td[1]/table[1]/tbody[1]/tr[4]/td[2]/div[1]/input[1]")).click();
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[4]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[2]/td[3]/form[1]/table[1]/tbody[1]/tr[4]/td[1]/table[1]/tbody[1]/tr[2]/td[2]/input[1]")).sendKeys("demo user");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[4]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[2]/td[3]/form[1]/table[1]/tbody[1]/tr[4]/td[1]/table[1]/tbody[1]/tr[3]/td[2]/input[1]")).sendKeys("demo user");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[4]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[2]/td[3]/form[1]/table[1]/tbody[1]/tr[4]/td[1]/table[1]/tbody[1]/tr[4]/td[2]/div[1]/input[1]")).click();
		Thread.sleep(2000);
	}
}
