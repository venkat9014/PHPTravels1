package com.PHPTravels.script.Accounts.Customers;

import org.testng.annotations.Test;

import com.PHPTravels.generic.BaseTest;
import com.PHPTravels.generic.Lib;
import com.PHPTravels.pom.Accounts.Customers.CustomersManagementPage;
import com.PHPTravels.pom.AdministratorLogin.LoginPage;
import com.PHPTravels.pom.Dashboard.DashboardPage;

public class DeleteCustomerUser extends BaseTest 
{
@Test(priority=8)
public void testDeleteCustomerUser() {
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
	cm.clickOnDeleteButton(driver);
}
}
