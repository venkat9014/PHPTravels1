package com.PHPTravels.pom.Dashboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class DashboardPage {
	@FindBy(xpath="//a[@href='#ACCOUNTS']")
	private WebElement AccountLink;
	@FindBy(xpath="//a[.='Admins']")
	private WebElement AdminsTab;
	@FindBy(xpath="//a[.='Suppliers']")
	private WebElement SuppliersTab;
	@FindBy(xpath="//a[.='Customers']")
	private WebElement CustomerssTab;
	@FindBy(xpath="//a[.='Guest Customers']")
	private WebElement GuestCustomersTab;
	@FindBy(className = "dropdown-toggle")
	private WebElement LogoutMousehover;
	@FindBy(xpath="//a[@href='http://www.phptravels.net/admin/logout']")
	private WebElement LogoutBtn;
	//@FindBy(xpath="(//a[@class='dropdown-toggle']/..//i[@class='fa fa-sign-out']")
	//private WebElement LogoutBtn;
	//private WebElement MyProfileBtn;
	public DashboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void clickOnAccounts()
	{
		AccountLink.click();
	}
	public void clickOnAdmins()
	{
		AdminsTab.click();
	}
	public void clickOnSuppliers()
	{
		SuppliersTab.click();
	}
	public void clickOnCustomers()
	{
		CustomerssTab.click();
	}
	public void clickOnGuestCustomers()
	{
		GuestCustomersTab.click();
	}
	
	
	public void verifyTitle(WebDriver driver , String eTitle)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try
		{
			wait.until(ExpectedConditions.titleIs(eTitle));
			Reporter.log("PASS: TITLES ARE MATCHED",true);
		}
		catch (Exception e) {
			Reporter.log("FAIL: TITLES ARE NOT MATCHED",true);
			Assert.fail();
		}
	}
	public void clickOnLogoutLink()
	{
		LogoutMousehover.click();
	}
	public void clikOnLogout(WebDriver driver )
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(LogoutBtn));
			LogoutBtn.click();
		
		Reporter.log("Pass:Logout Sucessfully",true);
	}
		catch (Exception e) {
			Reporter.log("Fail:Not Logout Sucessfully",true);
			Assert.fail();
		}
	}
}

	



