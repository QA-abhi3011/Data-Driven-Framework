package com.DataDrivenFramework.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

	public static String captureScreenshot(String testName) {
		
		//Get WebDriver from ThreadLocal
		WebDriver driver = DriverFactory.getDriver();
		
		//Create timestamp
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss\"").format(new Date());
		
		//Screenshot Folder Path
		String screenshotDir = System.getProperty("user.dir") + "/screenshots/";
		
		//Full Screenshot Path
		String fullScreenshotPath = screenshotDir + testName + "_" + timestamp + ".png";
		
		try {
			//capturing screenshot
			
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(src, new File(fullScreenshotPath));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return fullScreenshotPath;
	}
}
