package com.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.pages.HomePage;
import com.pages.ProductPage;

public class InputCustomerDetails extends Base {
	
	@Test
	public void inputCustomerDetailsTest() throws IOException {
		ExtentTest test=reporter.generateReport("inputCustomerDetailsTest");
		HomePage homePage  = new HomePage(mDriver, test);
		homePage.selectCountry("Cook Islands");
		homePage.inputName("I still long for her");
		homePage.selectGender("Female");
		homePage.clickShopBtn();
		ProductPage prodPage = new ProductPage(mDriver,test);
		prodPage.verifyProductPage("Products");
	}

}
