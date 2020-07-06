package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver_in) {
		this.driver = driver_in;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(name="uid")
	public WebElement txtuserName;
	
	@FindBy(name="password")
	public WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	public WebElement btnLogin;
	
	public void setUserName(String userName) {
		txtuserName.sendKeys(userName);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		btnLogin.click();
	}
}
