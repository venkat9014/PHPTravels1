package com.PHPTravels.pom.Accounts.Admins;

import org.openqa.selenium.Alert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class AdminsManagementPage {
	@FindBy(xpath="//button[@class='btn btn-success']")
	private WebElement AddBtn;
	@FindBy(xpath="//i[@class='glyphicon glyphicon-print']")
	private WebElement PrintBtn;
	@FindBy(xpath="//i[@class='glyphicon glyphicon-file']")
	private WebElement ExportBtn;
	@FindBy(xpath="(//i[@class='fa fa-times'])[1]")
	private WebElement DeleteBtn;
	@FindBy(xpath="//tr[@class='xcrud-row xcrud-row-0']/..//td[8]//a[@title='Edit']")
	private WebElement EditBtn;
	public AdminsManagementPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	/*public void clickOnAddButton(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try
		{
			wait.until((ExpectedConditions.elementToBeClickable(AddBtn)));
			AddBtn.click();
		}
		catch (Exception e) {
			Reporter.log("FAIL: ELement IS NOt DISPLAYED",true);
		Assert.fail();
		}
		
	}*/
	public void clickOnAddButton()
	{
		AddBtn.click();
		Reporter.log("clicked",true);
	}
	public void clickOnPrintButton()
	{
		PrintBtn.click();
	}
	public void clickOnExportButton()
	{
		ExportBtn.click();
	}
	public void clickOnEditButton(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		try{
			
		wait.until(ExpectedConditions.elementToBeClickable(EditBtn));
		EditBtn.click();
		}catch (Exception e) {
			
		}
	}
	public void clickOnDeleteButton(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try{
			
		wait.until(ExpectedConditions.elementToBeClickable(DeleteBtn));
		DeleteBtn.click();
		Alert a= driver.switchTo().alert();
		String b = a.getText();
		Reporter.log(b,true);
		a.accept();
	
		}catch (Exception e) {
			System.exit(1);
		}
		
			
			
	}

}
