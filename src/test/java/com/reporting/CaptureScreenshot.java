package com.reporting;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenshot {
	
	public static String func_captureScreenshot(WebDriver driver) {
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		File opfile = scrShot.getScreenshotAs(OutputType.FILE);
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("d MMM yyyy H.mm.ss.SSS");
		String date= sdf.format(cal.getTimeInMillis());
		String dest = System.getProperty("user.dir")+"/reports/screenshots/"+date+".png";
		File destfile = new File(dest);
		
		try {
			FileUtils.copyFile(opfile, destfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return dest;
	}
}
