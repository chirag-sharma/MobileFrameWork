package com.pages;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.actions.DefaultActions;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.reporting.CaptureScreenshot;

//import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {
	
	public static final Logger logger = LogManager.getLogger(HomePage.class);
	AndroidDriver<MobileElement> driver;
	DefaultActions dActions = new DefaultActions();
	ExtentTest test = null;
	
	public HomePage(AndroidDriver<MobileElement> driver, ExtentTest test){
		this.driver =driver;
		this.test=test;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/toolbar_title")
	MobileElement homePageTitle;
	
	@AndroidFindBy(id="android:id/text1")
	MobileElement countryDD;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	MobileElement name; 	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
	MobileElement male;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	MobileElement female;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	MobileElement shopBtn;
	
	public void selectCountry(String country) throws IOException {
			dActions.selectDropDown(test,driver, countryDD, country);
			logger.info("Drop Down: Country Selected "+country);
	}
	
	public void inputName(String inputName) {
		dActions.inputText(test,name, inputName);
		logger.info("Input Text "+inputName);
	}
	
	public void selectGender(String Gender) {
		if(Gender.equalsIgnoreCase("male"))
			dActions.clickRadioBtn(test, male);
		else
			dActions.clickRadioBtn(test, female);
		
		logger.info("Radio Button Clicked "+Gender);
	
	}
	
	public void clickShopBtn() {
		dActions.clickBtn(test, shopBtn);
		logger.info("Click button "+shopBtn);
	}
	
	public void verifyHomePage(String strText) throws IOException {
		Boolean result = dActions.verifyElement(driver,test, homePageTitle,strText);
		if(result==true) {
			logger.info(" Valdiation Passed "+homePageTitle+" is equal to "+strText);
			test.log(Status.PASS, "Valdiation Passed "+homePageTitle+" is equal to "+strText);
		}
		else {
			logger.info(" Valdiation Failed "+homePageTitle+" is not equal to "+strText);
			test.log(Status.FAIL, "Valdiation Failed "+homePageTitle+" is equal to "+strText).addScreenCaptureFromPath(CaptureScreenshot.func_captureScreenshot(driver));
		}
			
	}
}
