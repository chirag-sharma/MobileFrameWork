package com.test;

import org.testng.annotations.Test;

import com.pages.HomePage;

public class VerifyHomePage extends Base{
	
	@Test
	public void verifyHomePageTest() throws InterruptedException {
		Thread.sleep(5000);
		reporter.generateReport("verifyHomePageTest");
		reporter.logs("pass", "Nice- verifyHomePageTest");
		HomePage homePage = new HomePage(mDriver);
		homePage.verifyHomePage("General Store");
	}

}
