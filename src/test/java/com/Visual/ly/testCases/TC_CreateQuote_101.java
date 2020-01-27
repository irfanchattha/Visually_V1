package com.Visual.ly.testCases;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Visual.ly.pageObjects.CreateQuotePage;
import com.Visual.ly.pageObjects.LoginPage;
import com.Visual.ly.pageObjects.LogoutPage;
import com.Visual.ly.utilities.XLUtils;

public class TC_CreateQuote_101 extends BaseClass{
	Boolean isPresent=false;
	@Test(dataProvider="projectData")
	public void createQuote(String PType, String PST, String PSD ) throws IOException, InterruptedException
	{
	
		System.out.println("Starting Test");
		//Checking if popup is there, first time popup will be there but next time it won't be there
		if(isPresent==false)
		{
		isPresent = driver.findElements(By.className("accept-button")).size() > 0;
		driver.findElement(By.className("accept-button")).click();
		}
		
		
		System.out.println("Trying to Enter user name");
		LoginPage lp=new LoginPage(driver);		
		System.out.println("Trying to enter user id");
		lp.setUserName(adminuser);
		logger.info("Admin ID Entered");
		lp.setPassword(adminpass);
		logger.info("Admin Password Entered");
		lp.clickLogin();
		logger.info("Login button clicked");
		
		
		
		driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/ul/li[6]/a")).click();
		logger.info("Menu Clicked");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Admin")).click();
		logger.info("Admin menu clicked");
		driver.findElement(By.linkText("Quotes")).click();
		logger.info("Quote Screen Opened");
		
		CreateQuotePage cqp=new CreateQuotePage(driver);
		cqp.startQuotBtnClick();
		logger.info("Create Quote Screen opened");
		
		LocalDate date=LocalDate.now();
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		
		cqp.setProjectTitle(PType + " Regression:" + date.format(formatter));
		logger.info("Project Title Entered");
		
		cqp.enterEmail("chattha.irfan@gmail.com");
		logger.info("Client email entered");
		
		cqp.selectProjectType(PType);
		logger.info("Project type selected");
		
		cqp.selectCurrencyType("USD - US Dollar");
		logger.info("Currency Selected");
		
		cqp.selectExpiry("Quote Expiration Days: 30");
		logger.info("Quote Expiry selected");
		
		// Scrolling page down by 300 pixels
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,400)");
			
		cqp.selectInvoiceType("Marketplace Invoice");
		logger.info("Invoice Type selected");
		
		cqp.selectSalesPerson("Sales Test");	
		logger.info("Sales person selected");
		
		cqp.selectCompany("Irfan Test");
		logger.info("Workspace Selected");
		
		cqp.checkTestProject();
		logger.info("Test Project Checkbox checked");
		
		cqp.btnCreateQuote();
		logger.info("Next button clicked");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		cqp.selectPProjectType(PType);
		logger.info("Project Type selected");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		cqp.selectSubTier(PST);
		logger.info("Sub-Tier selected");
		
		Thread.sleep(3000);
		
		cqp.selectDefaultDeliverable(PSD);
		
		
		js.executeScript("window.scrollBy(0,650)");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		cqp.setComments("This is testing automated project quote generated");
		logger.info("Project Type selected");
		
		
		cqp.btnCreateQuote2();
		logger.info("Create Quote button clicked");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//cqp.clickCC();
		//logger.info("Tried to uncheck CC");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		cqp.btnCreateQuote2();
		logger.info("Create quote clicked after CC uncheck");
		
		cqp.btnReleaseQuotation();
		logger.info("Project Released successfully");
		
		//Closing popup for the release quote success
		driver.findElement(By.xpath("//*[@id=\'release-popup\']/div[2]/div[2]/div/label/input")).click();
		
		driver.findElement(By.xpath("//button[@id='send-email']")).click();
		
		driver.findElement(By.xpath("//*[@id=\"visbox-close\"]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Logout activities started
		
		//LogoutPage objLogout=new LogoutPage(driver);
		//objLogout.LogoutUser(driver);
		
		
		//$("a.visually-logo:nth-child(1)")
		driver.findElement(By.xpath("//a[@class='visually-logo']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id='main-menu-content']/div[2]/div[1]/p")).click();
		System.out.println("Menu Clicked");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Logout")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"main-header\"]/div[1]/div[2]/ul/li[1]/a")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		System.out.println("Login Screen opened");
		
		
		
		//captureScreen(driver,"createQuote");
		
	}

	
@DataProvider(name="projectData")
String [][] getData() throws IOException
{
	String path=System.getProperty("user.dir")+"/src/test/java/com/Visual/ly/testData/TestData.xlsx";
	
	int rownum=XLUtils.getRowCount(path, "Projects");
	int colcount=XLUtils.getCellCount(path, "Projects", 1);
	
	String projectdata[][]=new String[rownum][colcount];
	
	for(int r=1;r<=rownum;r++)
	{
		for(int c=0;c<colcount;c++)
		{
			projectdata[r-1][c]=XLUtils.getCellData(path, "Projects", r, c);
		}
		
	}
	return projectdata;
	
}
	

}
