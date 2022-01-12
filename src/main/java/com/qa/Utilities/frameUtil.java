package com.qa.Utilities;

import org.openqa.selenium.WebElement;

import com.qa.testbase.TestBase;

public class frameUtil extends TestBase{
	public frameUtil() {
		super();
	}
	
	public static void switchToFrameByID(int index) {
		driver.switchTo().frame(index);
	}
	
	public static void switchToFrameByName(String frameName) {
		driver.switchTo().frame(frameName);
	}
	
	public static void switchToFrameByWebElement(WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public static void focusToDefaultContent() {
		driver.switchTo().defaultContent();
	}
}
