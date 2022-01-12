package com.qa.Utilities;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.testbase.TestBase;

public class waitUtil extends TestBase {
	
	public waitUtil() {
		super();
	}
	
	public static void waitUntilpageloads() {
		until_fluentWait(driver,(d)->
		{
			boolean pageLoads = (boolean)((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
			if (!pageLoads) System.out.println("page still loads");
			return pageLoads;
		}, Long.valueOf(prop.getProperty("explicitWaitTime")));
	}
	
	public static void waitUntilJQueryloads() {
		until_webDriverWait(driver,(d)->
		{
			boolean pageLoads = (boolean)((JavascriptExecutor)driver).executeScript("return jQuery.active ==0");
			if (!pageLoads) System.out.println("page still loads");
			return pageLoads;
		}, Long.valueOf(prop.getProperty("explicitWaitTime")));
	}
	
	public static void until_webDriverWait(WebDriver driver, Function<WebDriver,Boolean> waitCondition, long timeOut) {
		WebDriverWait wdw = new WebDriverWait(driver,timeOut);
		try {
			wdw.until(waitCondition);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static boolean until_fluentWait(WebDriver driver, Function<WebDriver,Boolean> waitcondition,long timeout) {
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
		.withTimeout(Duration.ofSeconds(timeout))
		.pollingEvery(Duration.ofSeconds(2))
		.ignoring(NoSuchElementException.class);
		return fwait.until(waitcondition);
	}
	
}