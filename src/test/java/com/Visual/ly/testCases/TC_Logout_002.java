package com.Visual.ly.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Visual.ly.pageObjects.LoginPage;
import com.Visual.ly.pageObjects.LogoutPage;

public class TC_Logout_002 extends BaseClass{

	@Test
	public void logOut() throws IOException, InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
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

		
		LogoutPage lo=new LogoutPage(driver);
		
		Thread.sleep(5000);
		lo.VisuallyLogoClick(driver);
		logger.info("Marketplace Home Screen opened");
		logger.info(driver.getTitle());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		lo.mainMenuClick();
		logger.info("Main menue Clicked");
		logger.info(driver.getTitle());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		lo.Logout();
		logger.info("Logout Clicked");
		
		
		logger.info(driver.getTitle());
		Assert.assertTrue(true);
		//if(driver.getTitle()=="")
		
	}



}
