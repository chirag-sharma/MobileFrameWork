package com.actions;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.reporting.CaptureScreenshot;

//import com.utilities.FWLogger;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;


public class DefaultActions {
	public static final Logger logger = LogManager.getLogger(DefaultActions.class);
	TouchAction touch= null;
	/*
	 * Method Name: selectDropDown
	 * function: to select an element in a drop down on a Mobile App
	 * Parameters: AppiumDriver, MobileElement element, String country
	 * Return: Boolean true/ false
	 */
	public void selectDropDown(ExtentTest test, AndroidDriver<MobileElement> driver, MobileElement element, String text) throws IOException {
		try {
			element.click();
			driver.findElementByAndroidUIAutomator
			("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))");
			driver.findElement(By.xpath("//*[@text='"+text+"']")).click();
			logger.info(text+" selected in drop down");
			test.log(Status.PASS, text+" selected in drop down");
		}
		catch(Exception e) {
			logger.error("Exception Occured: "+e.getMessage());
			test.log(Status.ERROR, "Exception Occured: "+e.getMessage()).addScreenCaptureFromPath(CaptureScreenshot.func_captureScreenshot(driver));
		}
	}
	
	public void inputText(ExtentTest test, MobileElement element, String text) {
		try {
			element.sendKeys(text);
			logger.info(text+" entered in Mobile TextBox "+element);
			test.log(Status.PASS, text+" entered in Mobile TextBox "+element);
		}
		catch(Exception e) {
			logger.error("Exception Occured: "+e.getMessage());
			test.log(Status.ERROR, "Exception Occured: "+e.getMessage());
		}
	}
	
	public void clickRadioBtn(ExtentTest test, MobileElement element) {
		try {
			element.click();
			logger.info("Click performed on Radio Button "+element );
			test.log(Status.PASS, "Click performed on Radio Button "+element );
		}
		catch(Exception e) {
			logger.error("Exception Occured: "+e.getMessage());
			test.log(Status.ERROR, "Exception Occured: "+e.getMessage());
		}
	}
	
	public void clickBtn(ExtentTest test, MobileElement element) {
		try {
			element.click();
			logger.info("Click on Button "+element);
			test.log(Status.PASS, "Click on Button "+element );
		}
		catch(Exception e) {
			logger.error("Exception Occured: "+e.getMessage());
			test.log(Status.ERROR, "Exception Occured: "+e.getMessage());
		}
	}
	
	public void clickElement(ExtentTest test, MobileElement element) {
		try {
			element.click();
			logger.info("Click on Element "+element);
			test.log(Status.PASS, "Click on Element "+element );
		}
		catch(Exception e) {
			logger.error("Exception Occured: "+e.getMessage());
			test.log(Status.ERROR, "Exception Occured: "+e.getMessage());
		}
	}
	
	public void waitImplicit(ExtentTest test, AndroidDriver<MobileElement> driver, Integer waitTime) {
		try {
			driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
			logger.info("Performed Implicit Wait "+waitTime);
			test.log(Status.PASS, "Performed Implicit Wait "+waitTime );
		}
		catch(Exception e) {
			logger.error("Exception Occured: "+e.getMessage());
			test.log(Status.ERROR, "Exception Occured: "+e.getMessage());
		}
		
	}
	
	public void waitExplicit(ExtentTest test, AndroidDriver<MobileElement> driver, MobileElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			logger.info("Waiting for element to be clickable");
			test.log(Status.PASS, "Waiting for element to be clickable");
		}
		catch(Exception e) {
			logger.error("Exception Occured: "+e.getMessage());
			test.log(Status.ERROR, "Exception Occured: "+e.getMessage());
		}
	}
	
	public Boolean verifyElement(AndroidDriver<MobileElement> driver,ExtentTest test, MobileElement element, String text) {
		try {
			Thread.sleep(5000);
			String str = element.getAttribute("text");
			if(str.equals(text)) {
				logger.info("Validation successfully!!!");
				test.log(Status.PASS, "Validation successfully!!!");
				return true;
			}
			else {
				logger.error("Validation Failure");
				test.log(Status.FAIL, "Validation Failure").addScreenCaptureFromPath(CaptureScreenshot.func_captureScreenshot(driver));
				return false;
			}
				
		}
		catch(Exception e) {
			logger.error("Exception Occured: "+e.getMessage());
			test.log(Status.ERROR, "Exception Occured: "+e.getMessage());
			return false;
	
		}
	}
	
	public void scrollElement(ExtentTest test, AndroidDriver<MobileElement> driver, String text) {
		try {
			//element.click();
			driver.findElementByAndroidUIAutomator
			("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))");
			//driver.findElement(By.xpath("//*[@text='"+text+"']")).click();x
			logger.info("Scrolling to the given text: "+text );
			test.log(Status.PASS, "Scrolling to the given text: "+text);
		}
		catch(Exception e) {
			logger.error("Exception Occured: "+e.getMessage());
			test.log(Status.ERROR, "Exception Occured: "+e.getMessage());
		}
	}
	
	public Integer getSize(ExtentTest test, List<MobileElement> element) {
		try {
			logger.info("Returing size of given collection "+element);
			test.log(Status.PASS, "Returing size of given collection "+element);
			return element.size();
		}
		catch(Exception e) {
			logger.error("Exception Occured: "+e.getMessage());
			test.log(Status.ERROR, "Exception Occured: "+e.getMessage());
			return element.size();
		}
	}
	
	public void clickCheckBox(ExtentTest test, MobileElement element) {
		try {
			element.click();
			logger.info("Click on Element "+element);
			test.log(Status.PASS, "Click on Element "+element);
		}
		catch(Exception e) {
			logger.error("Exception Occured: "+e.getMessage());
			test.log(Status.ERROR, "Exception Occured: "+e.getMessage());
			//return element.size();
		}
	}
	
	public void tapButton(ExtentTest test, AndroidDriver<MobileElement> driver, MobileElement element) {
		try {
			touch = new TouchAction(driver);
			touch.tap(tapOptions().withElement(element(element))).perform();
			logger.info("Tap performed on Button "+element);
			test.log(Status.PASS, "Tap performed on Button "+element);
		}
		catch(Exception e) {
			logger.error("Exception Occured: "+e.getMessage());
			test.log(Status.ERROR, "Exception Occured: "+e.getMessage());
		}
	}
	
	public void longPressButton(ExtentTest test, AndroidDriver<MobileElement>driver, MobileElement element) {
		try {
			touch = new TouchAction(driver);
			touch.longPress(longPressOptions().withElement(element(element)).withDuration(ofSeconds(2))).release().perform();
			logger.info("Long Press performed on button "+element);
			test.log(Status.PASS, "Long Press performed on Button "+element);
			
		}
		catch(Exception e) {
			logger.error("Exception Occured: "+e.getMessage());
			test.log(Status.ERROR, "Exception Occured: "+e.getMessage());
		}
	}
	
	public void pressKey(ExtentTest test, MobileElement element, String key)
	{
		try {
			if(key.equalsIgnoreCase("enter")) {
				element.sendKeys(Keys.ENTER);
				logger.info("Pressed "+key+" key");
				test.log(Status.PASS, "Pressed "+key+" key");
			}
		}
		catch(Exception e) {
			logger.error("Exception Occured: "+e.getMessage());
			test.log(Status.ERROR, "Exception Occured: "+e.getMessage());
		}
		
	}
	
	public void switchContext(ExtentTest test, AndroidDriver<MobileElement> driver) {
		try {
			String context = driver.getContext();
			Set<String> multiContext = driver.getContextHandles();
			for(String switchCon: multiContext) {
				if(switchCon.equalsIgnoreCase(context)) {
					driver.context(switchCon);
					logger.info("Switched to given context "+switchCon);
					test.log(Status.PASS, "Switched to given context "+switchCon);
				}
			}
		}
		catch(Exception e) {
			logger.error("Exception Occured: "+e.getMessage());
			test.log(Status.ERROR, "Exception Occured: "+e.getMessage());
		}
	}
}
