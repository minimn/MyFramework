package com.automation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeLoginPage {

 WebDriver driver;
	
  By username=By.xpath("//input[@id='txtUsername']");
  By password=By.cssSelector("#txtPassword");
  By Loginbtn=By.xpath("//input[@id='btnLogin']");
  
  public OrangeLoginPage(WebDriver driver)
  {
	 this.driver=driver; 
  }
  
  public void logintoapplication(String user,String pwd)
  {
	 driver.findElement(username).sendKeys(user);
	 driver.findElement(password).sendKeys(pwd);
	 driver.findElement(Loginbtn).click();
  }
  	
}
	
