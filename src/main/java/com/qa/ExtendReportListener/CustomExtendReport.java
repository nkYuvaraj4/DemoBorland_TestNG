package com.qa.ExtendReportListener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CustomExtendReport implements IReporter{
//	public WebDriver driver;
	public ExtentReports extent;
	public ExtentTest logger;

	@BeforeTest
	public void setExtent(){
		System.out.println("setExtent --------- setExtent");
		//ExtentReports(String filePath,Boolean replaceExisting)
		//filepath - path of the file, in .htm or .html format - path where your report needs to generate.
		//replaceExisting - Setting to overwrite (TRUE) the existing file or append to it
		//True (default): the file will be replaced with brand new markup, and all existing data will be lost. Use this option to create a brand new report
		//False: existing data will remain, new tests will be appended to the existing report. If the the supplied path does not exist, a new file will be created.
		extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/CustomExtentReport.html", true);
		//extent.addSystemInfo("Environment","Environment Name")
		extent
            .addSystemInfo("Host Name", "Automation Practice")
            .addSystemInfo("Environment", "QA")
            .addSystemInfo("User Name", "Yuvaraj N");
            //loading the external xml file (i.e., extent-config.xml) which was placed under the base directory
            //You could find the xml file below. Create xml file in your project and copy past the code mentioned below
            //extent.loadConfig(new File("E:\\Yuvaraj Learning\\Eclipse\\DemoBorland_TestNG\\extent-config.xml"));
            extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	}
	
	@AfterTest
	public void endReport(){
		extent.flush();
		extent.close();
	}
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);		
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		// TODO Auto-generated method stub
		
	}
}
