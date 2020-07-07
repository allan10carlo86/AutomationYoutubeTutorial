package com.inetbanking.testCases;

import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.LoggerClass;

import junit.framework.Assert;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() {
		
		
	
		
		LoggerClass.startTestCase(this.getClass().getName());
		
		LoginPage loginPage = new LoginPage(driver);
		LoggerClass.info("Logged to URL " + super.baseURL);
		
		loginPage.setUserName(super.username);
		LoggerClass.info("Username Entered");
		loginPage.setPassword(super.password);
		LoggerClass.info("Password Entered");
		loginPage.clickSubmit();
		
		if(driver.getTitle().contains("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			LoggerClass.info("Good Title");
		} else {
			LoggerClass.error("Bad Title");
			Assert.assertTrue(false);
		}
		
		LoggerClass.endTestCase(this.getClass().getName());

	}

}
