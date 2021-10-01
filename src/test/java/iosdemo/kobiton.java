package iosdemo;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class kobiton {
	@Test
	public void kobiton_auto() {

		String kobitonServerUrl = "https://RemigiusRemi:25015a2d-924f-4017-ad5e-017dbc1a328b@api.kobiton.com/wd/hub";

		DesiredCapabilities capabilities = new DesiredCapabilities();
		// The generated session will be visible to you only. 
		capabilities.setCapability("sessionName", "Automation test session");
		capabilities.setCapability("sessionDescription", "");
		capabilities.setCapability("deviceOrientation", "portrait");
		capabilities.setCapability("captureScreenshots", true);
		// The maximum size of application is 500MB
		// By default, HTTP requests from testing library are expired
		// in 2 minutes while the app copying and installation may
		// take up-to 30 minutes. Therefore, you need to extend the HTTP
		// request timeout duration in your testing library so that
		// it doesn't interrupt while the device is being initialized.
		capabilities.setCapability("app", "/Users/smartpoint/Library/Developer/Xcode/DerivedData/mg-dxmklyqggsyhnibjfwdilitvtjjx/Build/Products/Debug-iphonesimulator/mg.app");

		capabilities.setCapability("deviceGroup", "KOBITON");
		// For deviceName, platformVersion Kobiton supports wildcard
		// character *, with 3 formats: *text, text* and *text*
		// If there is no *, Kobiton will match the exact text provided
		capabilities.setCapability("deviceName", "iPhone 8");
		capabilities.setCapability("platformVersion", "14.6");
		capabilities.setCapability("platformName", "iOS"); 
	}
}
