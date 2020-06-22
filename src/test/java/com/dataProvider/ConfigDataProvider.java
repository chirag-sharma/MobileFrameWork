package com.dataProvider;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import com.actions.DefaultActions;


public class ConfigDataProvider {
	public static final Logger logger = LogManager.getLogger(ConfigDataProvider.class);
	Properties pro;
	public ConfigDataProvider(){
		try {
			File file = new File("./src/test/resources/config.Properties");
			FileInputStream  fis = new FileInputStream(file);
			pro= new Properties();
			pro.load(fis);
		}
		catch(Exception e) {
			logger.error(e.getMessage());
		}
		
	}

	public String getProperty(String key) {
		String value = pro.getProperty(key);
		logger.info("Returning value of given key: "+key+" value: "+value);
		return value;
		
	}

}
