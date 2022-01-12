package com.qa.pages;

import java.io.IOException;
import java.security.Key;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testbase.TestBase;

public class LoginPage extends TestBase{
		
	@FindBy (id ="login-form:email1")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy (id ="login-form:password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy (id ="login-form:login")
	@CacheLookup
	WebElement btnLogin;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitle() {
		System.out.println(driver.getTitle());
		return driver.getTitle();		
	}
	
	public void login() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		txtUserName.click();
		js.executeScript("arguments[0].value='"+prop.getProperty("username")+"';", txtUserName);
		txtPassword.click();
		js.executeScript("arguments[0].value='"+prop.getProperty("password")+"';", txtPassword);
		btnLogin.click();
		Thread.sleep(5000);
	}
}
