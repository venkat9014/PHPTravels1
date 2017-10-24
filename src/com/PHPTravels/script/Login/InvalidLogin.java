package com.PHPTravels.script.Login;

import org.testng.annotations.Test;

import com.PHPTravels.generic.BaseTest;
import com.PHPTravels.generic.Lib;
import com.PHPTravels.pom.AdministratorLogin.LoginPage;

public class InvalidLogin extends BaseTest{
	
@Test(priority=2)
public void testInvalidLogin() throws InterruptedException
{
	int rc= Lib.getRowCount(XLPATH, "InvalidLogin");
	for(int i=1;i<=rc;i++)
	{
	String un = Lib.getCellValue(XLPATH, "InvalidLogin", i, 0);
	String pwd = Lib.getCellValue(XLPATH, "InvalidLogin", i, 1);
	
	// Enter Invalid UN
	LoginPage l= new LoginPage(driver);
	l.setUserName(un);
	//Enter Invalid PWD
	l.setPassword(pwd);
	l.clickLoginButton();
	Thread.sleep(2000);
	//verification of Error Message
	l.verifyIsErrorMsgDispalyed(driver);
	
	}
 }
}
