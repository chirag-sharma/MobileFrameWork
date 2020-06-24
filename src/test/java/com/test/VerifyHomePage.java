package com.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.pages.HomePage;

public class VerifyHomePage extends Base{
	
	@Test
	public void verifyHomePageTest() throws InterruptedException, IOException {
		Thread.sleep(5000);
		ExtentTest test=reporter.generateReport("verifyHomePageTest");
		HomePage homePage = new HomePage(mDriver, test);
		homePage.verifyHomePage("General Store");
	}

}
