package com.automation.Utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	//Screenshot, alerts,frame,windows, sync issues, javascript executor
	public static String CaptureScreenshot(WebDriver driver) {
	
		
     File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
     String ScreenshotPath=System.getProperty("user.dir")+"/Screenshots/OrangeHCM"+getCurrentDateTime()+".png";
     try {
		FileHandler.copy(src, new File(ScreenshotPath));
		
	} catch (Exception e) {
		System.out.println("Unable to capture Screenshot" + e.getMessage());
	}
     		System.out.println("Sreenshot Captured");
     		return ScreenshotPath;
	}
	
	
public static String getCurrentDateTime()
{
	DateFormat format=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
	Date CurrentDate = new Date();
	
	return format.format(CurrentDate);
	
}
	

}
