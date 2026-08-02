package com.DataDrivenFramework.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import com.DataDrivenFramework.utilities.BrowserUtils;
import com.DataDrivenFramework.utilities.ConfigReader;
import com.DataDrivenFramework.utilities.DriverFactory;




public class BaseClass {
	
    // Executes before every @Test method
    @BeforeMethod
    public void setup() {

        // Initialize the browser based on the configuration
        BrowserUtils.initBrowser();

        // Navigate to the application URL from Config.properties
        DriverFactory.getDriver().get(ConfigReader.getProperty("baseUrl"));
        
    }

    // Executes after every @Test method
    @AfterMethod
    public void tearDown() {

        // Close all browser windows and end the WebDriver session
        DriverFactory.getDriver().quit();

        // Remove the current thread's WebDriver instance from ThreadLocal
        DriverFactory.unload();
    }

}
