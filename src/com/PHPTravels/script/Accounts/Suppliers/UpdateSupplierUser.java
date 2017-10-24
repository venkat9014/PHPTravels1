package com.PHPTravels.script.Accounts.Suppliers;

import org.testng.annotations.Test;

import com.PHPTravels.generic.BaseTest;
import com.PHPTravels.generic.Lib;
import com.PHPTravels.pom.Accounts.Suppliers.SupplierManagementPage;
import com.PHPTravels.pom.Accounts.Suppliers.UpdateSupplierPage;
import com.PHPTravels.pom.AdministratorLogin.LoginPage;
import com.PHPTravels.pom.Dashboard.DashboardPage;

public class UpdateSupplierUser extends BaseTest {
	@Test(priority=13)
	public void testUpdateSupplierUser() throws InterruptedException
	{
		String un = Lib.getCellValue(XLPATH, "ValidLogin", 1, 0);
		String pwd = Lib.getCellValue(XLPATH, "ValidLogin", 1, 1);
		LoginPage l= new LoginPage(driver);
		l.setUserName(un);
		l.setPassword(pwd);
		l.clickLoginButton();
		DashboardPage d= new DashboardPage(driver);
		d.clickOnAccounts();
		d.clickOnAdmins();
		SupplierManagementPage s = new SupplierManagementPage(driver);
		s.clickOnEditButton(driver);
		int rc= Lib.getRowCount(XLPATH, "UpdateSupplierUser");
		for(int i=1;i<=rc;i++)
		{
		String fname = Lib.getCellValue(XLPATH, "UpdateSupplierUser", i, 0);
		String lname = Lib.getCellValue(XLPATH, "UpdateSupplierUser", i, 1);
		String email = Lib.getCellValue(XLPATH, "UpdateSupplierUser", i, 2);
		String password = Lib.getCellValue(XLPATH, "UpdateSupplierUser", i, 3);
		String mobilenumber = Lib.getCellValue(XLPATH, "UpdateSupplierUser", i, 4);
		String Address1 = Lib.getCellValue(XLPATH, "UpdateSupplierUser", i, 5);
		String Address2 = Lib.getCellValue(XLPATH, "UpdateSupplierUser", i, 6);
		UpdateSupplierPage us = new UpdateSupplierPage(driver);
		us.setFname(fname);
		us.setLname(lname);
		us.setEmail(email);
		us.setPassword(password);
		us.setMobileNumber(mobilenumber);;
		//a.clickOnDropDownList();
		//a.selectCountry();
		
		us.setAddress(Address1);
		Thread.sleep(3000);
		us.setAddress2(Address2);
		
		//a.setStatus();
		
		//a.selectEnmailSubscribe();
		
		//a.selectAddCars();
		//a.selectTours();
		Thread.sleep(3000);
		us.clickOnSubmit(driver);
		Thread.sleep(3000);
		}

	}

}
