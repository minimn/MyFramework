package com.automation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}

	@FindBy(id="user_login") WebElement username;
	@FindBy(name="pwd") WebElement password;
	@FindBy(xpath="//input[@id='wp-submit']") WebElement loginbutton;
	
	
	public void loginToWordPress(String Appusername,String AppPassword)
	{
		username.sendKeys(Appusername);
		password.sendKeys(AppPassword);
		loginbutton.click();
		
	}
	
}

