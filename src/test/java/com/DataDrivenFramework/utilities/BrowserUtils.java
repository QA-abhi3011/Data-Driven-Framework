package com.DataDrivenFramework.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;



import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtils {
	// Factory method to initialize browser
	
	public static void initBrowser() {
		
		// Read browser name from config.properties
		String browser = ConfigReader.getBrowser();
		
		// Read headless mode flag from config
		boolean headless = Boolean.parseBoolean(ConfigReader.getProperty("headless"));
		
		// Read incognito/private mode flag from config
		boolean incognito = Boolean.parseBoolean(ConfigReader.getProperty("incognito"));
		
		 // WebDriver reference (parent interface)
		WebDriver driver;
		
		switch(browser.toLowerCase()) {
			
			case "chrome":
				// Automatically download and setup ChromeDriver				
				WebDriverManager.chromedriver().setup();
				
				// Chrome-specific options
                ChromeOptions chromeOptions = new ChromeOptions();
				
				// Enable headless mode if configured
				if(headless) {
					chromeOptions.addArguments("--headless=new");
				}
				
				// Enable incognito mode if configured
				if(incognito) {
					chromeOptions.addArguments("--incognito");
				}
				
				// Launch Chrome browser
				driver = new ChromeDriver(chromeOptions);
				break;
				
			case "edge":
				WebDriverManager.edgedriver().setup();
				
				// Edge-specific options
                EdgeOptions edgeOptions = new EdgeOptions();

                // Enable headless mode if configured
                if (headless) {
                    edgeOptions.addArguments("--headless=new");
                }

                // Enable InPrivate mode if configured
                if (incognito) {
                    edgeOptions.addArguments("--inprivate");
                }

				driver = new EdgeDriver(edgeOptions);
				break;
				
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				
				  // Firefox-specific options
                FirefoxOptions firefoxOptions = new FirefoxOptions();

                // Enable headless mode if configured
                if (headless) {
                    firefoxOptions.addArguments("--headless");
                }

                // Enable private browsing if configured
                if (incognito) {
                    firefoxOptions.addArguments("-private");
                }
                
				driver = new FirefoxDriver(firefoxOptions);
				break;
				
            default:
                throw new IllegalArgumentException(
                        "Invalid browser name: " + browser);	
		}
		
		if(!headless) driver.manage().window().maximize();
		
		// Store WebDriver in ThreadLocal for thread-safe access
        DriverFactory.setDriver(driver);
	}
}
