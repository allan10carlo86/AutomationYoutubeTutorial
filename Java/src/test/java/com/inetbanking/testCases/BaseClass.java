package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.LoggerClass;
import com.inetbanking.utilities.ReadConfig;

public class BaseClass {

	public String baseURL;
	public String username;
	public String password;
	public String chromePath;
	public String firefoxPath;
	public String log4jXMLPath;
	public static ReadConfig readConfig;
	public static WebDriver driver;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String browserToRun) {
		System.out.println(System.getProperty("user.dir"));
		setConfigVariables();

		DOMConfigurator.configure(this.log4jXMLPath);

		System.out.println("Browser: " + browserToRun);
		if (browserToRun.equals("chrome")) {

			System.out.println(this.chromePath);
			System.setProperty("webdriver.chrome.driver", this.chromePath);
			LoggerClass.info("Driver is Chrome");
			driver = new ChromeDriver();

		} else if (browserToRun.contentEquals("firefox")) {
			System.out.println(this.firefoxPath);
			System.setProperty("webdriver.gecko.driver", this.firefoxPath);
			LoggerClass.info("Driver is firefox");
			driver = new FirefoxDriver();
		}

		driver.get(this.baseURL);
	}

	@AfterClass
	public void teadDown() {
		driver.quit();
	}

	public void setConfigVariables() {
		readConfig = new ReadConfig();
		this.baseURL = readConfig.getApplicationURL();
		this.username = readConfig.getUsername();
		this.password = readConfig.getPassword();
		this.chromePath = readConfig.getChromeDriverPath();
		this.firefoxPath = readConfig.getFirefoxDriverPath();
		this.log4jXMLPath = readConfig.getLog4jXMLPath();

	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp

		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + "-" + timeStamp + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");

	}

}
