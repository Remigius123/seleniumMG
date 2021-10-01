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

public class BrowserStack_iOS {
    @Test
    public void test1() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        
        capabilities.setPlatform(Platform.MAC);
        capabilities.setBrowserName("iPhone");
        capabilities.setCapability("device", "iPhone 8 Plus");
        capabilities.setCapability("os_version", "12");
        capabilities.setCapability("browserstack.debug", true);
        //capabilities.setCapability("browser", "chrome");
      
        capabilities.setCapability("realMobile", "true");
        capabilities.setCapability("name", "BrowserStack_Cloud");
        capabilities.setCapability("build", "/Users/smartpoint/Library/Developer/Xcode/DerivedData/MaryGold-fupudusfwfwafjffpptqcloogtpq/Build/Products/Debug-iphonesimulator/MaryGold.app");
        capabilities.setCapability("timeZone", "Asia/Shanghai");
        
        String className = this.getClass().getName();
        String an = className + Thread.currentThread().getStackTrace()[1].getMethodName();
    
        

 
        RemoteWebDriver driver = new RemoteWebDriver(
                URI.create("http://" + "remigius_rHFcPp" +":" +"teCPim8xJxSNGr3oTD1E" + "@"+ "hub-cloud.browserstack.com" +"/wd/hub").toURL(),
                capabilities
        );
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
