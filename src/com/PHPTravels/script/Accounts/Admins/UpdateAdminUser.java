package com.PHPTravels.script.Accounts.Admins;

import org.testng.annotations.Test;

import com.PHPTravels.generic.BaseTest;
import com.PHPTravels.generic.Lib;
import com.PHPTravels.pom.Accounts.Admins.AdminsManagementPage;
import com.PHPTravels.pom.Accounts.Admins.UpdateAdminPage;
import com.PHPTravels.pom.AdministratorLogin.LoginPage;
import com.PHPTravels.pom.Dashboard.DashboardPage;

public class UpdateAdminUser extends BaseTest {
	@Test(priority=4)
	public void testUpdateAdminUser() throws InterruptedException
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
		AdminsManagementPage am= new AdminsManagementPage(driver);
		am.clickOnEditButton(driver);
		//am.clickOnPrintButton();
		//am.clickOnExportButton();
		int rc= Lib.getRowCount(XLPATH, "UpdateAdminUser");
		for(int i=1;i<=rc;i++)
		{
		String fname = Lib.getCellValue(XLPATH, "UpdateAdminUser", i, 0);
		String lname = Lib.getCellValue(XLPATH, "UpdateAdminUser", i, 1);
		String email = Lib.getCellValue(XLPATH, "UpdateAdminUser", i, 2);
		String password = Lib.getCellValue(XLPATH, "UpdateAdminUser", i, 3);
		String mobilenumber = Lib.getCellValue(XLPATH, "UpdateAdminUser", i, 4);
		String Address1 = Lib.getCellValue(XLPATH, "UpdateAdminUser", i, 5);
		String Address2 = Lib.getCellValue(XLPATH, "UpdateAdminUser", i, 6);
		
		UpdateAdminPage  a= new UpdateAdminPage(driver);
		a.setFname(fname);
		a.setLname(lname);
		a.setEmail(email);
		a.setPassword(password);
		a.setMobileNumber(mobilenumber);;
		//a.clickOnDropDownList();
		//a.selectCountry();
		
		
		a.setAddress(Address1);
		Thread.sleep(3000);
		a.setAddress2(Address2);
		
		//a.setStatus();
		
		//a.selectEnmailSubscribe();
		
		//a.selectAddCars();
		//a.selectTours();
		Thread.sleep(3000);
		a.clickOnSubmit(driver);
		Thread.sleep(3000);
	}
	
	}

}
