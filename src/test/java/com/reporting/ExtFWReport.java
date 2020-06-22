package com.reporting;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtFWReport {
	
	//public ExtentSparkReporter sparkReport;
	public ExtentReports extent;
	public ExtentTest test;
	
	//@SuppressWarnings("deprecation")
	public void configureReporter() {
	//	sparkReport = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/TestAutomationAventReport.html");
		//sparkReport.loadConfig(System.getProperty("user.dir")+"/src/test/resources/avent-config.xml");
		extent = new ExtentReports();
		//extent.attachReporter(sparkReport);
	}
	
	public void generateReport(String testName) {
		test = extent.createTest(testName);
	}
	
	public void logs(String status, String description) {
		try{
			if(status.equalsIgnoreCase("pass")) {
				test.log(Status.PASS, description);
			}
			else if(status.equalsIgnoreCase("info")) {
				test.log(Status.INFO, description);
			}
			else if(status.equalsIgnoreCase("fail")) {
				test.log(Status.FAIL, description);
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void createHTMLReport() {
		extent.flush();
	}

}
