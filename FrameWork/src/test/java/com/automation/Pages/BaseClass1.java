package com.automation.Pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.automation.Utility.BrowserFactory2;
import com.automation.Utility.ConfigDataProvider;
import com.automation.Utility.ExcelDataProvider;
import com.automation.Utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass1 {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite()
	{
		excel = new ExcelDataProvider();
		config=new ConfigDataProvider();
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/OrangeHCM "+Helper.getCurrentDateTime()+".html"));
		report =new ExtentReports();
		report.attachReporter(extent);
	}
	
	@BeforeClass
	public void SetUp()
		{
			 driver=BrowserFactory2.StartBrowser(config.getBrowser(), config.getStaggingUrl());
		}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

	@AfterMethod
	public void tearDownMethod(ITestResult result)
	{
		if(result.getStatus()==ITestResult.SUCCESS) {
			Helper.CaptureScreenshot(driver);
			 try {
				logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenshot(driver)).build());
			} catch (Exception e) {
				System.out.println("Unable to attach screenshot" +e.getMessage());
			}
	}else if(result.getStatus()==ITestResult.FAILURE)
	{
		Helper.CaptureScreenshot(driver);
	}
		report.flush();
	}
}
