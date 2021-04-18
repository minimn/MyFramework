package com.automation.TestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.Pages.OrangeLoginPage;

public class VerifyOrangeLogin {

@Test
public void VerifyValidLogin()
{
	System.setProperty("webdriver.chrome.driver", "C:\\Mini\\89\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	
	OrangeLoginPage login=new OrangeLoginPage(driver);
	login.logintoapplication("Admin","admin123");
	Assert.assertTrue(driver.findElement(By.linkText("Welcome Paul")).isDisplayed());
	driver.close();
	
}
}
