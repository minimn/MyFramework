package com.automation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrangeLoginPage2 {

 WebDriver driver;
	
 @FindBy (xpath="//input[@id='txtUsername']")
 WebElement username;
 
 @FindBy (id ="txtPassword")
 WebElement password;
 
 @FindBy (xpath="//input[@id='btnLogin']")
 WebElement Loginbtn;
  
  public OrangeLoginPage2(WebDriver driver)
  {
	 this.driver=driver; 
  }
  
  public void logintoapplication(String user,String pwd)
  {
	username.sendKeys(user);
	password.sendKeys(pwd);
	Loginbtn.click();
  }
  	
}
	
