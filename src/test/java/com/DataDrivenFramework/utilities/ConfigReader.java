package com.DataDrivenFramework.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	private static Properties prop;
	
	//Load config file once
	static {
		try {
			FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/Config.properties");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	// Generic method to get any config value
		protected static String getProperty(String key) {
			return prop.getProperty(key);
		}

}
