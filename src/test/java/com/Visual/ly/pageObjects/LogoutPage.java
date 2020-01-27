package com.Visual.ly.pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

	WebDriver ldriver;
	
	public LogoutPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	//Follwing is non market place logo
	@FindBy(xpath="//a[@id='logo']")
	@CacheLookup
	WebElement imgVisualyLogo;
	
	//This is Visually logo under marketplace
	@FindBy(xpath="//*[@id='logo']")
	@CacheLookup
	WebElement imgVisualyLogoMarketplace;
	
	@FindBy(xpath="//*[@id='main-menu-content']/div[2]/div[1]/p")
	@CacheLookup
	WebElement menuMain;
	
	@FindBy(linkText="Logout")
	@CacheLookup
	WebElement menuItemLogout;
	
	@FindBy(linkText="LOG IN")
	@CacheLookup
	WebElement menuLogin;
	
	public void VisuallyLogoClick(WebDriver rdriver)
	{
		System.out.println("Visually logo function activated");
		
		String currentURL;
		currentURL=rdriver.getCurrentUrl();
		if(currentURL.contains("marketplace"))
		{
			imgVisualyLogoMarketplace.click();
		}
		else
		{
			
			imgVisualyLogo.click();	
		}
		
		//ldriver.findElement(By.xpath("//a[@id='logo']")).click();
		System.out.println("Logo clicked");
		
	}
	
	public void mainMenuClick()
	{
		menuMain.click();
	}
	
	public void Logout()
	{
		menuItemLogout.click();
	}
	
	public void btnLoginClick()
	{
		menuLogin.click();
	}

	
	
	public void LogoutUser(WebDriver rdriver) throws InterruptedException
	{
		
		VisuallyLogoClick(rdriver);
		mainMenuClick();
		Logout();
		Thread.sleep(5000);
		btnLoginClick();
	}
	
}
