package com.PHPTravels.script.Accounts.Customers;

import org.testng.annotations.Test;

import com.PHPTravels.generic.BaseTest;
import com.PHPTravels.generic.Lib;
import com.PHPTravels.pom.Accounts.Customers.CustomersManagementPage;
import com.PHPTravels.pom.Accounts.Customers.UpdateCustomersPage;
import com.PHPTravels.pom.AdministratorLogin.LoginPage;
import com.PHPTravels.pom.Dashboard.DashboardPage;

public class UpdateCustomerUser extends BaseTest{
	@Test(priority=7)
	public void testUpdateCustomerUser() throws InterruptedException
	{
		String un = Lib.getCellValue(XLPATH, "ValidLogin", 1, 0);
		String pwd = Lib.getCellValue(XLPATH, "ValidLogin", 1, 1);
		LoginPage l= new LoginPage(driver);
		l.setUserName(un);
		l.setPassword(pwd);
		l.clickLoginButton();
		DashboardPage d= new DashboardPage(driver);
		d.clickOnAccounts();
		d.clickOnCustomers();
		CustomersManagementPage cm = new CustomersManagementPage(driver);
		cm.clickOnEditButton(driver);
		int rc= Lib.getRowCount(XLPATH, "UpdateCustomerUser");
		for(int i=1;i<=rc;i++)
		{
		String fname = Lib.getCellValue(XLPATH, "UpdateCustomerUser", i, 0);
		String lname = Lib.getCellValue(XLPATH, "UpdateCustomerUser", i, 1);
		String email = Lib.getCellValue(XLPATH, "UpdateCustomerUser", i, 2);
		String password = Lib.getCellValue(XLPATH, "UpdateCustomerUser", i, 3);
		String mobilenumber = Lib.getCellValue(XLPATH, "UpdateCustomerUser", i, 4);
		String Address1 = Lib.getCellValue(XLPATH, "UpdateCustomerUser", i, 5);
		String Address2 = Lib.getCellValue(XLPATH, "UpdateCustomerUser", i, 6);
	
		UpdateCustomersPage uc = new UpdateCustomersPage(driver);
		uc.setFname(fname);
		uc.setLname(lname);
		uc.setEmail(email);
		uc.setPassword(password);
		uc.setMobileNumber(mobilenumber);;
		//a.clickOnDropDownList();
		//a.selectCountry();
		
		
		uc.setAddress(Address1);
		Thread.sleep(3000);
		uc.setAddress2(Address2);
		
		//a.setStatus();
		
		//a.selectEnmailSubscribe();
		
		//a.selectAddCars();
		//a.selectTours();
		Thread.sleep(3000);
		uc.clickOnSubmit(driver);
		Thread.sleep(3000);
		}

}
}

	
