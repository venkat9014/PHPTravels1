package com.PHPTravels.script.Accounts.Suppliers;

import org.testng.annotations.Test;

import com.PHPTravels.generic.BaseTest;
import com.PHPTravels.generic.Lib;
import com.PHPTravels.pom.Accounts.Suppliers.SupplierManagementPage;
import com.PHPTravels.pom.AdministratorLogin.LoginPage;
import com.PHPTravels.pom.Dashboard.DashboardPage;

public class DeleteSupplierUser extends BaseTest {
	@Test(priority=14)
	public void testDeleteSupplierUser()
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
	}

}
