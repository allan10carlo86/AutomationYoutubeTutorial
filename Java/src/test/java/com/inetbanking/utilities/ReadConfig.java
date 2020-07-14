package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties prop;

	public ReadConfig() {
		File src = new File("./configuration/config.properties");

		try {
			FileInputStream fls = new FileInputStream(src);
			prop = new Properties();
			prop.load(fls);
			
			
		} catch (Exception e) {
			LoggerClass.error("Exception is " + e.getMessage());

		}
	}

	public String getApplicationURL() {
		return prop.getProperty("baseURL");
	}

	public String getUsername() {
		return prop.getProperty("username");
	}

	public String getPassword() {
		return prop.getProperty("password");
	}

	public String getChromeDriverPath() {
		return prop.getProperty("chromepath");
	}

	public String getFirefoxDriverPath() {
		return prop.getProperty("firefoxpath");
	}
	
	public String getLog4jXMLPath() {
		return prop.getProperty("log4jXMLPath");
	}
	
	public String getChromePathWindows() {
		return prop.getProperty("chromepathWindows");
	}
	
	public String getFirefoxPathWindows() {
		return prop.getProperty("firefoxpathWindows");
	}
}
