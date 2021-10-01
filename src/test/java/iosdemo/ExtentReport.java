package iosdemo;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	public ExtentTest logger;
	public ExtentReports extent;
	public ExtentReport (){
		ExtentSparkReporter reporter = new ExtentSparkReporter("./Reports/index.html");
		this.extent = new ExtentReports();
		this.extent.attachReporter(reporter);
		this.extent.setSystemInfo("os", "macos");
		this.logger = this.extent.createTest("StaticTestReport")
				.assignAuthor("Remigius L")
				.assignCategory("Ad-hoc testing")
				.assignDevice("iPhone 8 Plus");
		reporter.config().setDocumentTitle("ExtentReporter");
		reporter.config().setReportName("Automation_testreport");



	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub


	}

	@Test
	public void extentRepo(String action)
	{
		System.out.println("success");




		//logger.log(Status.INFO, "Login to smartpoint");
		//logger.log(Status.PASS, "Navigate to smartpoint_dashboard");
		//logger.log(Status.PASS, "Navigate to smartpoint_title verified");



		this.logger.log(Status.PASS, action);
		this.logger.log(Status.FAIL, action);
		this.extent.flush();


	}

}
