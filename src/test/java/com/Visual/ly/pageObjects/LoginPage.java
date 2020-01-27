package com.Visual.ly.pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
		
	@FindBy(name="name")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="pass")
	@CacheLookup
	WebElement txtUserPass;
	
	
	@FindBy(id="edit-submit")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(className="accept-button")
	@CacheLookup
	WebElement btnPopup;
	
	//ffDriver.findElement(By.className("accept-button")).click();
	
	public void popupBtnClick()
	{
		btnPopup.click();
	}
	
	
	public void setUserName(String uname)
	{
		txtUserName.sendKeys(uname);
	}
	
	public void setPassword(String pass)
	{
		txtUserPass.sendKeys(pass);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
	
	
}
