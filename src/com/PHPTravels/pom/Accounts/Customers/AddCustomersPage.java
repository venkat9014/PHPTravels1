package com.PHPTravels.pom.Accounts.Customers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

//#######Declaration of WebElements in the AddCustomer page#####

public class AddCustomersPage {
	@FindBy(name="fname")
	private WebElement FName;
	@FindBy(name="lname")
	private WebElement LName;
	@FindBy(name="email")
	private WebElement Email;
	@FindBy(xpath="//i[@class='fa fa-times-circle']")
	private WebElement CloseBtn;
	@FindBy(name="password")
	private WebElement Password;
	@FindBy(name="mobile")
	private WebElement Mobile;
	@FindBy(xpath="//span[.='Please Select']")
	private WebElement Dropdown;
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
	@FindBy(xpath="//button[.='Submit']")
	private WebElement submitBtn;
	@FindBy(xpath="//h4[text()='Changes Saved!']")
	private WebElement ConfirmationMsg;
	
	//######## Initialization of AddCustomer Page###########
	
	public AddCustomersPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//######### Methods of AddCustomer Page###############
	public void setFname(String fname)
	{
		FName.sendKeys(fname);
	}
	public void setLname(String lname)
	{
		LName.sendKeys(lname);
	}
	public void setEmail(String email)
	{
		boolean suceess = Email.isEnabled();
		try {
		if(!suceess)
		{
			Email.clear();
			Email.sendKeys(email);
			
			Reporter.log("Already existed",true);
		}
		else
			//Reporter.log("Already existed",true);
			Email.getText();
		
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	Email.sendKeys(email);	
	}
	public void setPassword(String pass)
	{
		Password.sendKeys(pass);
	}
	public void setMobileNumber(String mobile)
	{
		Mobile.sendKeys(mobile);
	}
	public void clickOnDropDownList()
	{
		selectCountry.click();
	}
	public void selectCountry()
	{
		selectCountry.click();
	}
	public void setAddress(String addr1)
	{
		Address1.sendKeys(addr1);
	}
	public void setAddress2(String addr2)
	{
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
	
	public void clickOnSubmit(WebDriver driver)
	{
		
		JavascriptExecutor j= (JavascriptExecutor)driver;
		
		
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try
		{
			j.executeScript("arguments[0].click()",submitBtn);
			//Reporter.log("csuccess",true);
			//wait.until(ExpectedConditions.elementToBeClickable(CloseBtn));
			//CloseBtn.click();
			boolean cmsg = ConfirmationMsg.isDisplayed();
			if(cmsg)
			{
				Reporter.log("User created sucessfully");
				String sucessMsg = ConfirmationMsg.getText();
				Reporter.log(sucessMsg,true);
			}
	}
		catch (Exception e) {
			
		}
		/*try {
			boolean cmsg = ConfirmationMsg.isDisplayed();
			if(cmsg)
			{
				Reporter.log("User created sucessfully");
				String sucessMsg = ConfirmationMsg.getText();
				Reporter.log(sucessMsg,true);
			}
			}catch (Exception e) {
				e.printStackTrace();
			}*/
		
	}
}

