package com.DataDrivenFramework.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	private static Properties prop;

	// Load config file once
	static {
		
		prop = new Properties();
		String env = System.getProperty("env");
		if (env == null) {
			env = "QA";
		}

		try {
			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/Config-" + env + ".properties");
			
			String path = System.getProperty("user.dir")
			        + "/src/test/resources/Config-" + env + ".properties";

			System.out.println("Loading config from: " + path);
			
			prop.load(file);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Generic method to get any config value
	public static String getProperty(String key) {
		return prop.getProperty(key);
	}

	// Get browser from command line, otherwise use config file
	public static String getBrowser() {

		String browser = System.getProperty("browser");

		if (browser != null && !browser.isBlank()) {
			return browser;
		}

		return prop.getProperty("browser");
	}

}
