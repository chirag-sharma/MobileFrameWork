package com.test;

import org.testng.annotations.Test;

import com.pages.CartPage;
import com.pages.HomePage;
import com.pages.ProductPage;

public class AddMultiProduct extends Base {
	
	@Test
	public void addMultiProductPage() {
		
		HomePage homePage  = new HomePage(mDriver);
		reporter.generateReport("addMultiProductPage");
		reporter.logs("pass", "Nice- addMultiProductPage");
		homePage.verifyHomePage("General Store");
		homePage.selectCountry("Cook Islands");
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
