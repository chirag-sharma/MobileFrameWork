package com.pages;

import java.util.List;
//import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import com.actions.DefaultActions;
//import com.factory.DriverFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.MobileElement;

public class CartPage {
	
	public static final Logger logger = LogManager.getLogger(CartPage.class);
	AndroidDriver<MobileElement> driver;
	DefaultActions dActions = new DefaultActions();
	//public Logger logs = LogManager.getLogger(this);
	
	public CartPage(AndroidDriver<MobileElement> driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/toolbar_title")
	public MobileElement cartPageTitle;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	public List<MobileElement> productsPrice;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	public MobileElement totalAmount;
	
	@AndroidFindBy(className ="android.widget.CheckBox")
	public MobileElement checkBox;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
	public MobileElement termsBtn;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	public MobileElement proceedBtn;
	
	@AndroidFindBy(id="android:id/button1")
	public MobileElement closeTerm;
	/*
	 * Common Funtion on Cart Page
	 */
	Double sum=0.0d, totalAmt=0.0d;
	
	public void getTotalProductAmount() {
		dActions.waitImplicit(driver, 5);
		Integer prodCount = dActions.getSize(productsPrice);
		for(Integer j=0;j<prodCount;j++) {
			String priceText=productsPrice.get(j).getAttribute("name");
			priceText=priceText.substring(1);
			Double amount = Double.parseDouble(priceText);
			sum=sum+amount;	
			logger.info("Total Products Amounts "+sum);
		}
	}
	
	public void getTotalAmount() {
		String totalPrice=totalAmount.getAttribute("name");
		totalPrice=totalPrice.substring(1);
		totalAmt = Double.parseDouble(totalPrice);
		logger.info("Total Amount "+totalAmt);
	}
	
	public void verifyTotalAmount() {
		if(sum.compareTo(totalAmt)==0) {
			logger.info("Validation Successful: "
					+ "Final Amount("+totalAmt+") is equal to Sum of cost price("+sum+") of each product");
		}
		else
			logger.error("Validation Unsuccessful: Final "
					+ "Amount("+totalAmt+") is not equal to Sum of cost price("+sum+")of each product");
			
	}
	
	public void clickChkBox() {
		dActions.clickCheckBox(checkBox);
		logger.info("Checkbox Clicked");
	}
	
	public void tapProceedBtn() {
		dActions.tapButton(driver,proceedBtn);
		logger.info("tap Button Clicked");
	}
	
	public void longPressTerms() {
		dActions.longPressButton(driver, termsBtn);
		logger.info("Long Press Button Clicked");
	}
	
	public void closeTerms() {
		dActions.clickElement(termsBtn);
		logger.info("Close Terms Button Clicked");
	}
	
	public void switchContext() {
		dActions.switchContext(driver);
		logger.info("Context Switched");
	}
	
	public void verifyCartPage(String strText) {
		Boolean result = dActions.verifyElement(cartPageTitle,strText);
		if(result==true)
			logger.info(" Valdiation Passed "+cartPageTitle+" is equal to "+strText);
		else
			logger.info(" Valdiation Passed "+cartPageTitle+" is not equal to "+strText);
	}

}
