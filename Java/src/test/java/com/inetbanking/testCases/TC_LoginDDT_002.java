package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.LoggerClass;
import com.inetbanking.utilities.XLUtils;

import junit.framework.Assert;

public class TC_LoginDDT_002  extends BaseClass {
	
	@Test(dataProvider="loginData")
	public void loginDDT(String user, String pwd) {
		LoginPage lgnPage = new LoginPage(driver);
		lgnPage.setUserName(user);
		LoggerClass.info("Username is provided");
		lgnPage.setPassword(pwd);
		LoggerClass.info("Username is provided");
		lgnPage.clickSubmit();
		
		if(isAlertPresent()) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			LoggerClass.warn("Login Failed");
			
		} else {
			Assert.assertTrue(true);
			lgnPage.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			LoggerClass.info("Login Passed");
		}
	}
	
	/**
	 * User Defined method that 
	 * @return returns a boolean to determine if alert is present (true) / or not present (false)
	 */
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e ) {
			return false;
		}
	}
	
	@DataProvider(name="loginData")
	public String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/inetbanking/testData/loginData.xlsx" ;
		
		int rowNumber = XLUtils.getRowCount(path, "Sheet1");
		int colCount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		System.out.println("rowNumber " + rowNumber);
		System.out.println("colCount " + colCount);
		
		String loginData[][] = new String[rowNumber][colCount];
		
		for(int i=1; i<=rowNumber; i++) {
			for(int j=0; j<colCount; j++) {
				loginData[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		
		return loginData;
	}

}
