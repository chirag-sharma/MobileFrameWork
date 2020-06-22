package com.test;

import org.testng.annotations.Test;

import com.pages.ProductPage;

public class VerifyProductPage extends Base {
	
	@Test
	public void verifyProductPageTest() throws InterruptedException {
		Thread.sleep(3000);
		reporter.generateReport("verifyProductPageTest");
		reporter.logs("pass", "Nice- verifyProductPageTest");
		ProductPage prodPage = new ProductPage(mDriver);
		prodPage.verifyProductPage("Products");
	}

}
