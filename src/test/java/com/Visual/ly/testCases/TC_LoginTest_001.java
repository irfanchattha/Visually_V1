package com.Visual.ly.testCases;

import java.io.IOException;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.Visual.ly.pageObjects.LoginPage;
import com.Visual.ly.pageObjects.LogoutPage;



public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void loginTest() throws IOException, InterruptedException
	{
		
		
		LoginPage lp=new LoginPage(driver);
		captureScreen(driver,"loginTest_Popup");
		lp.popupBtnClick();
		logger.info("Popup closed");
		lp.setUserName(username);
		logger.info("UserID Entered");
		lp.setPassword(password);
		logger.info("Password Entered");
				
		lp.clickLogin();
		logger.info("Login button clicked");
		
		if(driver.getTitle().equals("Visual.ly Marketplace"))
		{
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		}else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login Test Failed");
		}
		
		//Log out user
		LogoutPage objLogout=new LogoutPage(driver);
		objLogout.LogoutUser(driver);
		
		
	}
}
