package com.DataDrivenFramework.utilities;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
	
	 // ThreadLocal ensures one WebDriver per thread
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	//Set WebDriver for current thread
	public static void setDriver(WebDriver webDriver) {
		driver.set(webDriver);
	}
	
	// Get WebDriver for current thread
	public static WebDriver getDriver() {
		return driver.get();
	}
	
   // Remove WebDriver instance
   public static void unload() {
       driver.remove();
   }

}
