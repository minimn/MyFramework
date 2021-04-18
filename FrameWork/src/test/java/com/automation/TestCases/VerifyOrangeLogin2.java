package com.automation.TestCases;

import org.openqa.selenium.By;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import org.testng.annotations.Test;

import com.automation.Pages.BaseClass1;
import com.automation.Pages.OrangeLoginPage2;
import com.automation.Utility.Helper;


public class VerifyOrangeLogin2 extends BaseClass1 {
	
//login to Orange HCM
@Test
public void VerifyValidLogin()
   {
	
	logger=report.createTest("Login to OrangeHCM");
      OrangeLoginPage2 login=PageFactory.initElements(driver, OrangeLoginPage2.class);
      logger.info("Application Started");
      login.logintoapplication(excel.getStringData("Login", 0, 0),excel.getStringData("Login", 0, 1));
      Assert.assertTrue(driver.findElement(By.partialLinkText("Welcome")).isDisplayed());
      logger.pass("Login Successful");
      
    }


}
