package com.PHPTravels.script.Accounts.GuestCustomers;

import org.testng.annotations.Test;

import com.PHPTravels.generic.BaseTest;
import com.PHPTravels.generic.Lib;
import com.PHPTravels.pom.Accounts.GuestCustomers.AddGuestCustomerPage;
import com.PHPTravels.pom.Accounts.GuestCustomers.GuestCustomerManagementPage;
import com.PHPTravels.pom.AdministratorLogin.LoginPage;
import com.PHPTravels.pom.Dashboard.DashboardPage;

public class CreateGuestCustomerUser extends BaseTest {
	@Test(priority=9)
	public void testCreateGuestCustomerUser() throws InterruptedException
	{
		String un = Lib.getCellValue(XLPATH, "ValidLogin", 1, 0);
		String pwd = Lib.getCellValue(XLPATH, "ValidLogin", 1, 1);
		//String title = Lib.getCellValue(XLPATH, "ValidLogin", 1, 2);
		LoginPage l= new LoginPage(driver);
		l.setUserName(un);
		l.setPassword(pwd);
		l.clickLoginButton();
		Thread.sleep(3000);
		DashboardPage d= new DashboardPage(driver);
		Thread.sleep(3000);
		d.clickOnAccounts();
		Thread.sleep(3000);
		d.clickOnGuestCustomers();
		Thread.sleep(3000);
		int rc= Lib.getRowCount(XLPATH, "CreateGuestCustomerUser");
		for(int i=1;i<=rc;i++)
		{
		String fname = Lib.getCellValue(XLPATH, "CreateGuestCustomerUser", i, 0);
		String lname = Lib.getCellValue(XLPATH, "CreateGuestCustomerUser", i, 1);
		String email = Lib.getCellValue(XLPATH, "CreateGuestCustomerUser", i, 2);
		String password = Lib.getCellValue(XLPATH, "CreateGuestCustomerUser", i, 3);
		String mobilenumber = Lib.getCellValue(XLPATH, "CreateGuestCustomerUser", i, 4);
		String Address1 = Lib.getCellValue(XLPATH, "CreateGuestCustomerUser", i, 5);
		String Address2 = Lib.getCellValue(XLPATH, "CreateGuestCustomerUser", i, 6);
		
		GuestCustomerManagementPage gc = new GuestCustomerManagementPage(driver);
		gc.clickOnAddButton();
		//gc.clickOnPrintButton();
		//gc.clickOnExportButton();
		AddGuestCustomerPage g = new AddGuestCustomerPage(driver);
		g.setFname(fname);
		g.setLname(lname);
		g.setEmail(email);
		g.setPassword(password);
		g.setMobileNumber(mobilenumber);
		g.selectCountry();
		g.setAddress(Address1);
		g.setAddress2(Address2);
		g.setStatus();
		g.selectEnmailSubscribe();
		g.clickOnSubmit(driver);
		
		
	}

}
}
