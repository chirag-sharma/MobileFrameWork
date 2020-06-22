package com.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.actions.DefaultActions;

//import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {
	
	public static final Logger logger = LogManager.getLogger(HomePage.class);
	AndroidDriver<MobileElement> driver;
	DefaultActions dActions = new DefaultActions();
	
	public HomePage(AndroidDriver<MobileElement> driver){
		this.driver =driver;
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
	
	public void selectCountry(String country) {
			dActions.selectDropDown(driver, countryDD, country);
			logger.info("Drop Down: Country Selected "+country);
	}
	
	public void inputName(String inputName) {
		dActions.inputText(name, inputName);
		logger.info("Input Text "+inputName);
	}
	
	public void selectGender(String Gender) {
		if(Gender.equalsIgnoreCase("male"))
			dActions.clickRadioBtn(male);
		else
			dActions.clickRadioBtn(female);
		
		logger.info("Radio Button Clicked "+Gender);
	}
	
	public void clickShopBtn() {
		dActions.clickBtn(shopBtn);
		logger.info("Click button "+shopBtn);
	}
	
	public void verifyHomePage(String strText) {
		Boolean result = dActions.verifyElement(homePageTitle,strText);
		if(result==true)
			logger.info(" Valdiation Passed "+homePageTitle+" is equal to "+strText);
		else
			logger.info(" Valdiation Passed "+homePageTitle+" is not equal to "+strText);
	}
}
