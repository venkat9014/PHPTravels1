package com.PHPTravels.pom.AdministratorLogin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPage {
	@FindBy(name="email")
	private WebElement UNameTB;
	@FindBy(name="password")
	private WebElement PwdTB;
	@FindBy(xpath="//span[.='Login']")
	private WebElement LoginBTN;
	@FindBy(xpath="//div[@class='alert alert-danger loading wow fadeIn animated animated']")
	private WebElement ErrMsg;
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void setUserName(String un)
	{
		UNameTB.clear();
		UNameTB.sendKeys(un);
	}
	public void setPassword(String pwd)
	{
		PwdTB.clear();
		PwdTB.sendKeys(pwd);
	}
	
	public void clickLoginButton()
	{
		LoginBTN.click();
	}
	public void verifyIsErrorMsgDispalyed(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try
		{
			wait.until((ExpectedConditions.elementToBeClickable(ErrMsg)));
			String ErrText = ErrMsg.getText();
			//Reporter.log("PASS: ERROR MSG IS DISPLAYED",true);
			Reporter.log(ErrText,true);
		}
		catch (Exception e) {
			Reporter.log("FAIL: ERROR MSG IS NOt DISPLAYED",true);
		Assert.fail();
		}
		
	}

}
