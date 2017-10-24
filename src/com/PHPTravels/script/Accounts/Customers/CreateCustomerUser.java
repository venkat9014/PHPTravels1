package com.PHPTravels.script.Accounts.Customers;

import org.testng.annotations.Test;

import com.PHPTravels.generic.BaseTest;
import com.PHPTravels.generic.Lib;
import com.PHPTravels.pom.Accounts.Customers.AddCustomersPage;
import com.PHPTravels.pom.Accounts.Customers.CustomersManagementPage;
import com.PHPTravels.pom.AdministratorLogin.LoginPage;
import com.PHPTravels.pom.Dashboard.DashboardPage;

public class CreateCustomerUser extends BaseTest {
	@Test(priority=6)
	public void testCreateCustomerUser() throws InterruptedException
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
		d.clickOnAccounts();
		d.clickOnCustomers();
		
		int rc= Lib.getRowCount(XLPATH, "CreateCustomerUser");
		for(int i=1;i<=rc;i++)
		{
		String fname = Lib.getCellValue(XLPATH, "CreateCustomerUser", i, 0);
		String lname = Lib.getCellValue(XLPATH, "CreateCustomerUser", i, 1);
		String email = Lib.getCellValue(XLPATH, "CreateCustomerUser", i, 2);
		String password = Lib.getCellValue(XLPATH, "CreateCustomerUser", i, 3);
		String mobilenumber = Lib.getCellValue(XLPATH, "CreateCustomerUser", i, 4);
		String Address1 = Lib.getCellValue(XLPATH, "CreateCustomerUser", i, 5);
		String Address2 = Lib.getCellValue(XLPATH, "CreateCustomerUser", i, 6);
		
		CustomersManagementPage c= new CustomersManagementPage(driver);
		c.clickOnAddButton();
		//cm.clickOnPrintButton();
		//cm.clickOnExportButton();
		AddCustomersPage a = new AddCustomersPage(driver);
		a.setFname(fname);
	
		a.setLname(lname);
		
		a.setEmail(email);
	
		a.setPassword(password);
		
		a.setMobileNumber(mobilenumber);
		
		a.selectCountry();
		
		a.setAddress(Address1);
	
		a.setAddress2(Address2);
	
		a.setStatus();
		
		a.selectEnmailSubscribe();
		Thread.sleep(3000);
		a.clickOnSubmit(driver);
		Thread.sleep(3000);
		
	}

}

}