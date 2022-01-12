package com.qa.pagetests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.LoginPage;
import com.qa.testbase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class Login extends TestBase{
	LoginPage loginpage;
	
	public Login() {
		super();		
	}

	@BeforeMethod
	public void setup() throws IOException {
		browserInitialization();
		loginpage=new LoginPage();
	}
	
	@Test (priority=1, enabled=true)
	public void verifyTitleOfLoginPage() throws InterruptedException {
		logger = extent.startTest("verifyTitleOfLoginPage");
		String title = loginpage.verifyTitle();
		Assert.assertEquals("InsuranceWeb: Home", title);
		logger.log(LogStatus.PASS, "Test Case is Passed");
	}
	
	@Test (priority=0, enabled =true)
	public void login() throws InterruptedException {
		logger = extent.startTest("login");
		loginpage.login();
	}
	
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}
}
