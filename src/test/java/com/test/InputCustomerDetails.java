package com.test;

import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.ProductPage;

public class InputCustomerDetails extends Base {
	
	@Test
	public void inputCustomerDetailsTest() {
		reporter.generateReport("inputCustomerDetailsTest");
		reporter.logs("pass", "Nice- inputCustomerDetailsTest");
		HomePage homePage  = new HomePage(mDriver);
		homePage.selectCountry("Cook Islands");
		homePage.inputName("I still long for her");
		homePage.selectGender("Female");
		homePage.clickShopBtn();
		ProductPage prodPage = new ProductPage(mDriver);
		prodPage.verifyProductPage("Products");
	}

}
