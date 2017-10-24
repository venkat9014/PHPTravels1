package com.PHPTravels.script.Accounts.Suppliers;

import org.testng.annotations.Test;

import com.PHPTravels.generic.BaseTest;
import com.PHPTravels.generic.Lib;
import com.PHPTravels.pom.Accounts.Suppliers.AddSupplierPage;
import com.PHPTravels.pom.Accounts.Suppliers.SupplierManagementPage;
import com.PHPTravels.pom.AdministratorLogin.LoginPage;
import com.PHPTravels.pom.Dashboard.DashboardPage;

public class CreateSupplierUser extends BaseTest {
@Test(priority=12)
public void testCreateSupplierUser() throws InterruptedException
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
	d.clickOnSuppliers();
	Thread.sleep(3000);
	int rc= Lib.getRowCount(XLPATH, "CreateSupplierUser");
	for(int i=1;i<=rc;i++)
	{
	String fname = Lib.getCellValue(XLPATH, "CreateSupplierUser", i, 0);
	String lname = Lib.getCellValue(XLPATH, "CreateSupplierUser", i, 1);
	String email = Lib.getCellValue(XLPATH, "CreateSupplierUser", i, 2);
	String password = Lib.getCellValue(XLPATH, "CreateSupplierUser", i, 3);
	String mobilenumber = Lib.getCellValue(XLPATH, "CreateSupplierUser", i, 4);
	String Address1 = Lib.getCellValue(XLPATH, "CreateSupplierUser", i, 5);
	String Address2 = Lib.getCellValue(XLPATH, "CreateSupplierUser", i, 6);
	SupplierManagementPage sm = new SupplierManagementPage(driver);
	sm.clickOnAddButton();
	//sm.clickOnPrintButton();
	//sm.clickOnExportButton();
	AddSupplierPage s= new AddSupplierPage(driver);
	s.setFname(fname);
	s.setLname(lname);
	s.setEmail(email);
	s.setPassword(password);
	s.setMobileNumber(mobilenumber);
	s.selectCountry();
	s.setAddress(Address1);
	s.setAddress2(Address2);
	s.setStatus();
	s.clickOnSupplierFor();
	s.setItemName(lname);
	s.selectEnmailSubscribe();
	s.clickOnAssignHotels();
	s.clickOnAssignTours();
	s.clickOnAssignCars();
	Thread.sleep(2000);
	
	s.clickOnSubmit(driver);
	
	
}
}
}
