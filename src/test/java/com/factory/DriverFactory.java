package com.factory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.dataProvider.ConfigDataProvider;
import com.dataProvider.XMLParser;

//import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.AndroidDriver;


public class DriverFactory {
	
	public static final Logger logger = LogManager.getLogger(DriverFactory.class);
	ConfigDataProvider configuration = new ConfigDataProvider();	
	AndroidDriver<MobileElement> driver = null;
	
	public AndroidDriver<MobileElement> getDriver() {
		//use testng parameter to pass and select mobile, abhi ke liye hard code
		
		/*
		 * Reading XMl File for available device information and
		 * fetching the required device's information from the generated HashMap
		 */
		XMLParser configParser = XMLParser.getInstance();
		Map<String, String> capabilitites = configParser.getConfigMap().get("local_browser-device_OnePlus");  // .get("local_browser-device_OnePlus");
		//String[] metaDetails = configParser.getConfigMetaDataMap().get("local_browser-device_OnePlus");
		
		/*
		 * Iterating through the map and setting capabilities for device configuration
		 */
		DesiredCapabilities caps = new DesiredCapabilities();
		if (!capabilitites.isEmpty()) {
			for (Iterator<String> it = capabilitites.keySet().iterator(); it.hasNext();) {
				String key = it.next();
				caps.setCapability(key, capabilitites.get(key));
				logger.info("Setting Capabilities: "+key+" value: "+capabilitites.get(key));
			}
		}
		
		String ip = configuration.getProperty("APPIUM_IP");
		String port = configuration.getProperty("APPIUM_PORT");
		URL url =null;
		try {
			url = new URL("http://" + ip + ":" + port + "/wd/hub/" );
		} catch (MalformedURLException e) {
			logger.error(e.getMessage());
		}
		
		driver= new AndroidDriver<MobileElement>(url, caps);
		return driver;
		
	}

}
