package com.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import com.actions.DefaultActions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WebPage {
	
	public static final Logger logger = LogManager.getLogger(WebPage.class);
	AndroidDriver<MobileElement> driver;
	DefaultActions dAction = new DefaultActions();
	
	public WebPage(AndroidDriver<MobileElement> driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//*[@name='q']")
	public MobileElement googleSearchBox;
	
	public void inputSearchtext(String strText) {
		dAction.inputText(googleSearchBox, strText);
		dAction.pressKey(googleSearchBox,"Enter");
		logger.info("Entered "+strText+" in google homepage and pressed Enter");
	}
	
	public void switchContext() {
		dAction.switchContext(driver);
		logger.info("Switching Context");
	}

}
