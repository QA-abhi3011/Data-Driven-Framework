package com.DataDrivenFramework.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	private static Properties prop;
	
	
	//Load config file once
	static {
		String env = System.getProperty("env");

		if (env == null) {
		    env = "QA";
		}
		
	
		try {		
			FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/Config-"+ env+".properties");
			prop = new Properties();
			prop.load(file);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	// Generic method to get any config value
		public static String getProperty(String key) {
			return prop.getProperty(key);
		}

}
