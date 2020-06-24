package com.test;


import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.pages.CartPage;
import com.pages.HomePage;
import com.pages.ProductPage;

public class AddSingleProduct extends Base{
	
	@Test
	public void addSingleProductTest() throws InterruptedException, IOException {
		
		ExtentTest test=reporter.generateReport("addSingleProductTest");
		
		HomePage homePage  = new HomePage(mDriver,test);
		homePage.verifyHomePage("General Store");
		homePage.selectCountry("Cook Islands");
		Thread.sleep(5000);
		homePage.inputName("I still long for her");
		homePage.selectGender("Female");
		homePage.clickShopBtn();
		
		ProductPage prodPage = new ProductPage(mDriver,test);
		prodPage.verifyProductPage("Products");
		prodPage.addProductToCart("Jordan Lift Off");
		prodPage.addProductToCart("Air Jordan 4 Retro");
		prodPage.clickCartBtn();
		
		CartPage cartPage = new CartPage(mDriver,test);
		cartPage.verifyCartPage("Cart");
		cartPage.getTotalAmount();
		cartPage.getTotalProductAmount();
		cartPage.verifyTotalAmount();
		
	}

}
