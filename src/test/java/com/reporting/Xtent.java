package com.reporting;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentAventReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.ExtentKlovReporter;
//import com.aventstack.extentreports.reporter.ExtentLoggerReporter;

public class Xtent {
	
	public ExtentReports extent;
	//static ExtentKlovReporter Klov;
	public ExtentTest test;
	public ExtentHtmlReporter Html;

	
	public void initiateReport() {
	
		Html = new ExtentHtmlReporter("./reports/TestReport.html");
		Html.loadXMLConfig("./src/test/resources/html-config.xml");
		Html.setAppendExisting(true);
		
		extent = new ExtentReports();		
		extent.attachReporter(Html);
	}
	
	public ExtentTest generateReport(String testName) {
		return extent.createTest(testName);
	}
	
	public void logInfo(ExtentTest test,String description) {
		test.log(Status.INFO, description);
	}
	
	public void logPass(ExtentTest test,String description) {
		test.log(Status.PASS, description);
	}
	
	public void logError(ExtentTest test, WebDriver driver, String description) {
		try {
				test.log(Status.ERROR, description).addScreenCaptureFromPath(CaptureScreenshot.func_captureScreenshot(driver));
			}
		catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
	public void createHTMLReport() {
		extent.flush();
	}

}

