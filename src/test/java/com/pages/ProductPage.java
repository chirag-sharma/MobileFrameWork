package com.pages;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import com.actions.DefaultActions;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.reporting.CaptureScreenshot;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductPage {
	
	public static final Logger logger = LogManager.getLogger(ProductPage.class);
	AndroidDriver<MobileElement> driver;
	DefaultActions dActions = new DefaultActions();
	ExtentTest test;
	public ProductPage(AndroidDriver<MobileElement> driver, ExtentTest test){
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/toolbar_title")
	public MobileElement productPageTitle;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productName")
	public MobileElement productName;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productAddCart")
	public MobileElement productAddCart;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	public MobileElement cartBtn;
	
	/*
	 * Common Functions, that we can do on
	 * ProductPage
	 */
	public void addProductToCart(String strText) {
		dActions.scrollElement(test, driver, strText);
		int count=  driver.findElementsById("com.androidsample.generalstore:id/productName").size();
		for(int i=0;i<count;i++) {
			String text=driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();
			
			if(text.contains(strText)) {
				driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
				logger.info("Adding product to cart");
				test.log(Status.INFO, "Adding product to cart");
				
			}
		}	
	}
	
	public void clickCartBtn() {
		dActions.clickBtn(test, cartBtn);
		logger.info("Click on Button "+cartBtn);
	}
	
	public void verifyProductPage(String strText) throws IOException {
		Boolean result = dActions.verifyElement(driver,test, productPageTitle,strText);
		if(result==true) {
			logger.info(" Valdiation Passed "+productPageTitle+" is equal to "+strText);
			test.log(Status.PASS, " Valdiation Passed "+productPageTitle+" is equal to "+strText);
		}
		else {
			logger.info(" Valdiation Failed "+productPageTitle+" is not equal to "+strText);
			test.log(Status.FAIL, " Valdiation Failed "+productPageTitle+" is not equal to "+strText).addScreenCaptureFromPath(CaptureScreenshot.func_captureScreenshot(driver));
		}
	}
}
