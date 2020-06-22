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
	public ExtentTest logger;
	public ExtentHtmlReporter Html;

	
	public void intiateReport(String suiteName) {
	
		Html = new ExtentHtmlReporter("./report/TestReport.html");
		Html.loadXMLConfig("./Configuration/html-config.xml");
		Html.setAppendExisting(true);
		
		extent = new ExtentReports();		
		extent.attachReporter(Html);

	}
	
	public ExtentTest generateReport(String testName) {
		logger= extent.createTest(testName);
		return logger;
	}
	
	public void logs(WebDriver driver, String status, String description, String stepNum) {
		try {
			if(status.equalsIgnoreCase("info")) {
				logger.log(Status.INFO, description);
			}
			else if (status.equalsIgnoreCase("pass")) {
				logger.log(Status.PASS, description);
			}
			else if(status.equalsIgnoreCase("fail")) {
				logger.log(Status.FAIL, description).addScreenCaptureFromPath(CaptureScreenshot.func_captureScreenshot(driver, stepNum));
			}
		}
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
	//I thought of writing a function for logger, but I think that'd be an overhead, we can directly call the logger at
	//test steps. I believe that'd be a proper thing to do. (a better option). if not worked, we can always search
	//other options.
	
	//Chirag
	public void createHTMLReport() {
		extent.flush();
	}

}

