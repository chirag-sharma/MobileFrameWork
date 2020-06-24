package com.test;


import org.testng.annotations.Test;

import com.pages.CartPage;
import com.pages.HomePage;
import com.pages.ProductPage;

public class AddSingleProduct extends Base{
	
	@Test
	public void addSingleProductTest() throws InterruptedException {
		HomePage homePage  = new HomePage(mDriver);
		reporter.generateReport("addSingleProductTest");
		//reporter.logs("pass", "Nice- addSingleProductTest");
		homePage.verifyHomePage("General Store");
		homePage.selectCountry("Cook Islands");
		Thread.sleep(5000);
		homePage.inputName("I still long for her");
		homePage.selectGender("Female");
		homePage.clickShopBtn();
		
		ProductPage prodPage = new ProductPage(mDriver);
		prodPage.verifyProductPage("Products");
		prodPage.addProductToCart("Jordan Lift Off");
		prodPage.addProductToCart("Air Jordan 4 Retro");
		prodPage.clickCartBtn();
		
		CartPage cartPage = new CartPage(mDriver);
		cartPage.verifyCartPage("Cart");
		cartPage.getTotalAmount();
		cartPage.getTotalProductAmount();
		cartPage.verifyTotalAmount();
		
	}

}
