package com.PHPTravels.pom.Accounts.Admins;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class UpdateAdminPage {
	@FindBy(name="fname")
	private WebElement FName;
	@FindBy(name="lname")
	private WebElement LName;
	@FindBy(name="email")
	private WebElement Email;
	@FindBy(name="password")
	private WebElement Password;
	@FindBy(name="mobile")
	private WebElement Mobile;
	//@FindBy(xpath="//select[@name='country']/..")
	//private WebElement selectCountry;
	@FindBy(xpath="//select[@name='country']/..//option[.='India']")
	private WebElement selectCountry;
	@FindBy(name="address1")
	private WebElement Address1;
	@FindBy(name="address2")
	private WebElement Address2;
	@FindBy(xpath="//select[@name='status']")
	private WebElement status;
	@FindBy(xpath="//div[@class='col-md-12']/..//div[@class='icheckbox_square-grey']")
	private WebElement EmailSubscribe;
	@FindBy(xpath="//input[@value='addCars']/..")
	private WebElement addCars;
	@FindBy(xpath="//input[@value='addTours']/..")
	private WebElement addTours;
	@FindBy(xpath="//button[.='Submit']")
	private WebElement submitBtn;
	public UpdateAdminPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void setFname(String fname)
	{
		FName.clear();
		FName.sendKeys(fname);
	}
	public void setLname(String lname)
	{
		LName.clear();
		LName.sendKeys(lname);
	}
	public void setEmail(String email)
	{
	Email.clear();
	Email.sendKeys(email);	
	}
	public void setPassword(String pass)
	{	Password.clear();
		Password.sendKeys(pass);
	}
	public void setMobileNumber(String mobile)
	{
		Mobile.clear();
		Mobile.sendKeys(mobile);
	}
	public void clickOnDropDownList()
	{
		selectCountry.click();
	}
	public void selectCountry()
	{
		//Select s= new Select(selectCountry);
		//s.selectByVisibleText("India");
		selectCountry.click();
	}
	public void setAddress(String addr1)
	{
		Address1.clear();
		Address1.sendKeys(addr1);
	}
	public void setAddress2(String addr2)
	{
		Address2.clear();
		Address2.sendKeys(addr2);
	}
	public void setStatus()
	{
		Select select = new Select (status);
		select.selectByIndex(0);
		
		//status.click();
	}
	public void selectEnmailSubscribe()
	{
		EmailSubscribe.click();
	}
	public void selectAddCars()
	{
		addCars.click();
	}
	public void selectTours()
	{
		addTours.click();
		
	}
	public void clickOnSubmit(WebDriver driver)
	{
		JavascriptExecutor j= (JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try
		{
			j.executeScript("arguments[0].click()",submitBtn);
			Reporter.log("csuccess",true);
			//wait.until(ExpectedConditions.elementToBeClickable(CloseBtn));
			//CloseBtn.click();
			Reporter.log("updated");
	
	}
		catch (Exception e) {
			
		}
		submitBtn.click();
		Reporter.log("success",true);
		Reporter.log("updated");
	}

}
