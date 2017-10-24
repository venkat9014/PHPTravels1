package com.PHPTravels.script.Accounts.GuestCustomers;

import org.testng.annotations.Test;

import com.PHPTravels.generic.BaseTest;
import com.PHPTravels.generic.Lib;
import com.PHPTravels.pom.Accounts.GuestCustomers.GuestCustomerManagementPage;
import com.PHPTravels.pom.AdministratorLogin.LoginPage;
import com.PHPTravels.pom.Dashboard.DashboardPage;

public class DeleteGuestCustomerUser extends BaseTest {
	@Test(priority=11) 
	public void testDeleteGuestCustomerUser() {
		String un = Lib.getCellValue(XLPATH, "ValidLogin", 1, 0);
		String pwd = Lib.getCellValue(XLPATH, "ValidLogin", 1, 1);
		LoginPage l= new LoginPage(driver);
		l.setUserName(un);
		l.setPassword(pwd);
		l.clickLoginButton();
		DashboardPage d= new DashboardPage(driver);
		d.clickOnAccounts();
		d.clickOnAdmins();
		GuestCustomerManagementPage gc = new GuestCustomerManagementPage(driver);
		gc.clickOnDeleteButton(driver);
		
	}

}
