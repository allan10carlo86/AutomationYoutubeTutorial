package com.inetbanking.testCases;


import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	public String baseURL = "http://demo.guru99.com/v4";
	public String username = "mngr271043";
	public String password = "nAbumEp";
	public static WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		System.out.println(System.getProperty("user.dir"));
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		driver = new ChromeDriver();
		// logger = Logger.getLogger("Java");
		// BasicConfigurator.configure();
		// PropertyConfigurator.configure("log4j.properties");
		DOMConfigurator.configure("log4j.xml");
	}
	
	@AfterClass
	public void teadDown() {
		driver.quit();
	}
	
	
	
	

}
