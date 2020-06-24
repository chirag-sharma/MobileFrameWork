package com.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.actions.DefaultActions;
import com.factory.DriverFactory;
import com.reporting.ExtFWReport;
import com.reporting.Xtent;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;





public class Base {
	
	public AndroidDriver<MobileElement> mDriver= null;
	public DefaultActions dAction= null; //logging ke baad ye set karna hai
	public static final Logger logger = LogManager.getLogger(Base.class); 
	public AppiumDriverLocalService service;
	Xtent reporter = new Xtent();
	/*
	 * 
	 * c=c  change all verification to assert
	 */
	@BeforeTest
	public void setUp() {
		//service=AppiumDriverLocalService.buildDefaultService();
		logger.info("------------------------------ Starting Appium Server ------------------------------");
		//service.start();
		mDriver = new DriverFactory().getDriver();
		reporter.initiateReport();
		
	}
	
	@AfterTest
	public void tearDown() {
		logger.info("------------------------------ Closing Drive instance ------------------------------");
		reporter.createHTMLReport();
		mDriver.closeApp();
		
		
	}

}
