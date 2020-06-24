package com.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.pages.HomePage;
import com.pages.ProductPage;

public class VerifyProductPage extends Base {
	
	@Test
	public void verifyProductPageTest() throws InterruptedException, IOException {
		Thread.sleep(3000);
		ExtentTest test=reporter.generateReport("verifyProductPageTest");
		HomePage homePage  = new HomePage(mDriver, test);
		homePage.selectCountry("Cook Islands");
		homePage.inputName("I still long for her");
		homePage.selectGender("Female");
		homePage.clickShopBtn();
		ProductPage prodPage = new ProductPage(mDriver,test);
		prodPage.verifyProductPage("Products");
	}

}
