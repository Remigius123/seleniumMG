package iosdemo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BrowserStackSample {
    @Test
    public void test1() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        
        // Set URL of the application under test
        capabilities.setCapability("app", "/Users/smartpoint/Downloads/com.androbaby.game2048_2.1-15_minAPI15(nodpi)_apkmirror.com.apk");
        
        // Specify device and os_version for testing
        capabilities.setCapability("device", "iPhone 8 Plus");
        capabilities.setCapability("os_version", "12");
          
        // Set other BrowserStack capabilities
        capabilities.setCapability("project", "First Java Project");
        capabilities.setCapability("build", "Java iOS");
        capabilities.setCapability("name", "first_test");
        
        String className = this.getClass().getName();
        String an = className + Thread.currentThread().getStackTrace()[1].getMethodName();
    
        

 
        //RemoteWebDriver driver = new RemoteWebDriver(
             //   URI.create("http://" + "remigius_rHFcPp" +":" +"teCPim8xJxSNGr3oTD1E" + "@"+ "hub-cloud.browserstack.com" +"/wd/hub").toURL(),
              //  capabilities
        //);
        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
          AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
              new URL("http://" + "remigius_rHFcPp" +":" +"teCPim8xJxSNGr3oTD1E" + "@"+ "hub-cloud.browserstack.com" +"/wd/hub"), capabilities);
          

        //driver.manage().window().maximize();
        driver.get("http://www.google.com");
        System.out.println(driver.getTitle());
        driver.getWindowHandle();
        //driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Zelenium", Keys.ENTER);
        driver.get("https://www.saucedemo.com/inventory.html");
        System.out.println(driver.getTitle());
        driver.getWindowHandle();
        //driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Zelenium", Keys.ENTER);
        driver.get("https://www.npmjs.com/package/keyword_driven");
        System.out.println(driver.getTitle());
        driver.getWindowHandle();
        //driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Zelenium", Keys.ENTER);
        //driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Selenoid", Keys.ENTER);
        //driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Selenium", Keys.ENTER);
        //Thread.sleep(20000);
        driver.quit();
    }
}
