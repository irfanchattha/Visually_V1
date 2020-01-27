package com.Visual.ly.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateQuotePage {

WebDriver ldriver;
	
	public CreateQuotePage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id="start-a-scoping-brief")
	@CacheLookup
	WebElement btnStartQuote;
	
	@FindBy(name="projectTitle")
	@CacheLookup
	WebElement txtProjectTitle;
	
	@FindBy(name="email")
	@CacheLookup
	WebElement txtEmailID;
	
	public void enterEmail(String email)
	{
		txtEmailID.sendKeys(email);
	}
	
	
	@FindBy(name="projectType")
	@CacheLookup
	WebElement selectProject;
	
	public void selectProjectType(String projType)
	{
		Select ptype=new Select(selectProject);
		ptype.selectByVisibleText(projType);
	}
	
	
	
	@FindBy(name="currency")
	@CacheLookup
	WebElement selectCurrency;
	
	public void selectCurrencyType(String curncy)
	{
		Select ptype=new Select(selectCurrency);
		ptype.selectByVisibleText(curncy);
	}
	
	
	
	@FindBy(name="expirationPeriodDuration")
	@CacheLookup
	WebElement selectQuoteExpiry;
	
	public void selectExpiry(String expiry)
	{
		Select ptype=new Select(selectQuoteExpiry);
		ptype.selectByVisibleText(expiry);
	}
	
	
	
	@FindBy(name="invoiceType")
	@CacheLookup
	WebElement selectInvoiceType;
	
	public void selectInvoiceType(String invoice)
	{
		Select ptype=new Select(selectInvoiceType);
		ptype.selectByVisibleText(invoice);
	}
	
	
	
	@FindBy(name="salesPerson")
	@CacheLookup
	WebElement selectSalesPerson;
	
	public void selectSalesPerson(String saleperson)
	{
		Select ptype=new Select(selectSalesPerson);
		ptype.selectByVisibleText(saleperson);
	}
	
	
	@FindBy(name="company")
	@CacheLookup
	WebElement selectCompany;
	
	public void selectCompany(String company)
	{
		Select ptype=new Select(selectCompany);
		ptype.selectByVisibleText(company);
	}
	
	
	
	@FindBy(id="testProject")
	@CacheLookup
	WebElement inputTestProject;
	
	public void checkTestProject()
	{
		inputTestProject.click();
		
	}
	

	@FindBy(className="submit")
	@CacheLookup
	WebElement btnCreateQuote1;
	
	public void btnCreateQuote()
	{
		btnCreateQuote1.click();
		
	}
	

	@FindBy(id="project-type")
	@CacheLookup
	WebElement selectProjectType;
	
	public void selectPProjectType(String pptype)
	{
		Select ptype=new Select(selectProjectType);
		ptype.selectByVisibleText(pptype);
	}
	

	@FindBy(id="project-subtier")
	@CacheLookup
	WebElement selectProSubTier;
	
	public void selectSubTier(String stier)
	{
		Select ptype=new Select(selectProSubTier);
		ptype.selectByVisibleText(stier);
	}
	
	@FindBy(id="project-default")
	@CacheLookup
	WebElement selectDefDeliverable;
	
	public void selectDefaultDeliverable(String defdeliver)
	{
		Select ptype=new Select(selectDefDeliverable);
		ptype.selectByVisibleText(defdeliver);
	}
	

	@FindBy(name="customNotes")
	@CacheLookup
	WebElement textAreaComments;

	public void setComments(String comments)
	{
		textAreaComments.sendKeys(comments);
	}
	
	
	@FindBy(className="submit")
	@CacheLookup
	WebElement btnCreateQuote2;
	
	public void btnCreateQuote2()
	{
		btnCreateQuote2.click();
	}
	
	
	@FindBy(className="onlyCC")
	@CacheLookup
	WebElement inputOnlyCC;
	
	public void clickCC()
	{
		inputOnlyCC.click();
	}
	
	
	@FindBy(className="submit")
	@CacheLookup
	WebElement btnCreateQuote3;
	
	
	@FindBy(id="release-quote")
	@CacheLookup
	WebElement btnReleaseQuote;

	public void btnReleaseQuotation()
	{
		btnReleaseQuote.click();
	}
	
	
	public void startQuotBtnClick()
	{
		btnStartQuote.click();
		System.out.println("Create Quote button clicked");
		
	}
	
	public void setProjectTitle(String ptitle)
	{
		txtProjectTitle.sendKeys(ptitle);
	}
	
	
}
