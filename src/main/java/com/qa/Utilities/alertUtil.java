package com.qa.Utilities;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.testbase.TestBase;

public class alertUtil extends TestBase {
	public alertUtil() {
		super();
	}
	
	public static void acceptAlert() {
		WebDriverWait wdw = new WebDriverWait(driver, Long.valueOf(prop.getProperty("alertTimeOut")));
		wdw.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}
	
	public static void dismissAlert() {
		WebDriverWait wdw = new WebDriverWait(driver, Long.valueOf(prop.getProperty("alertTimeOut")));
		wdw.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().dismiss();
	}
	
	public static String getAlertText() {
		WebDriverWait wdw = new WebDriverWait(driver, Long.valueOf(prop.getProperty("alertTimeOut")));
		wdw.until(ExpectedConditions.alertIsPresent());
		return driver.switchTo().alert().getText();
	}
}