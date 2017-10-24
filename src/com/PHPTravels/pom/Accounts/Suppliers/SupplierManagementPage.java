package com.PHPTravels.pom.Accounts.Suppliers;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class SupplierManagementPage {
	@FindBy(xpath="//button[@class='btn btn-success']")
	private WebElement SAddBtn;
	@FindBy(xpath="//i[@class='glyphicon glyphicon-print']")
	private WebElement PrintBtn;
	@FindBy(xpath="//i[@class='glyphicon glyphicon-file']")
	private WebElement ExportBtn;
	@FindBy(xpath="//i[@class='fa fa-times']")
	private WebElement DeleteBtn;
	@FindBy(xpath="//i[@class='fa fa-edit']")
	private WebElement EditBtn;
	public SupplierManagementPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickOnAddButton()
	{
		SAddBtn.click();
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
