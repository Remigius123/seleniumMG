package iosdemo;

import java.net.MalformedURLException;
import java.net.URI;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class BrowserStack {
    @Test
    public void test1() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        
        capabilities.setCapability("os", "Windows");
        capabilities.setCapability("os_version", "8");
        capabilities.setCapability("browser", "chrome");
        capabilities.setCapability("browser_version", "92.0");
        capabilities.setCapability("name", "BrowserStack_Cloud");
        capabilities.setCapability("build", "1.0.10");
        capabilities.setCapability("timeZone", "Asia/Shanghai");
        
        String className = this.getClass().getName();
        String an = className + Thread.currentThread().getStackTrace()[1].getMethodName();
    
        

 
        RemoteWebDriver driver = new RemoteWebDriver(
                URI.create("http://" + "remigius_rHFcPp" +":" +"teCPim8xJxSNGr3oTD1E" + "@"+ "hub-cloud.browserstack.com" +"/wd/hub").toURL(),
                capabilities
        );
        driver.manage().window().maximize();
        driver.get("http://www.google.com");
        System.out.println(driver.getTitle());
        driver.getWindowHandle();
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Zelenium", Keys.ENTER);
        driver.get("http://www.google.com");
        System.out.println(driver.getTitle());
        driver.getWindowHandle();
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Zelenium", Keys.ENTER);
        driver.get("http://www.google.com");
        System.out.println(driver.getTitle());
        driver.getWindowHandle();
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Zelenium", Keys.ENTER);
        //driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Selenoid", Keys.ENTER);
        //driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("Selenium", Keys.ENTER);
        //Thread.sleep(20000);
        driver.quit();
    }
}
