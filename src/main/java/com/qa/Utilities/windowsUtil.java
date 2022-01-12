package com.qa.Utilities;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qa.testbase.TestBase;
public class windowsUtil extends TestBase{
	
	public windowsUtil() {
		super();
	}
	
	public static void switchToParentWindow() {
		String parentID = driver.getWindowHandle();
		driver.switchTo().window(parentID);
	}
	
	public static void switchToDifferentWindow() {
		Set<String> windowsID = driver.getWindowHandles();
		Iterator<String> iWindowsID=windowsID.iterator();
		while(iWindowsID.hasNext()) {
			String childWindow = iWindowsID.next();
			if (!childWindow.equalsIgnoreCase(driver.getWindowHandle())) {
				driver.switchTo().window(childWindow);
			}
		}
 	}
}
