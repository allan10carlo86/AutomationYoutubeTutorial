package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.LoggerClass;

import junit.framework.Assert;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws IOException {
		
		LoggerClass.startTestCase(this.getClass().getName());
		
		LoginPage loginPage = new LoginPage(driver);
		LoggerClass.info("Logged to URL " + super.baseURL);
		
		loginPage.setUserName(super.username);
		LoggerClass.info("Username Entered");
		loginPage.setPassword(super.password);
		LoggerClass.info("Password Entered");
		loginPage.clickSubmit();
		
		
		boolean getTitleSame = driver.getTitle().contains("Guru99 Bank Manager HomePage");
		if(getTitleSame) {
			Assert.assertTrue(true);
			LoggerClass.info("Good Title");
		} else {
			LoggerClass.error("Bad Title");
			captureScreen(driver, this.getClass().getName());
			Assert.assertTrue(false);
		}
		
		LoggerClass.endTestCase(this.getClass().getName());

	}

}
