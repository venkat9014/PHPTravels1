package com.PHPTravels.script.Accounts.Admins;
import org.testng.annotations.Test;
import com.PHPTravels.generic.BaseTest;
import com.PHPTravels.generic.Lib;
import com.PHPTravels.pom.Accounts.Admins.AddAdminPage;
import com.PHPTravels.pom.Accounts.Admins.AdminsManagementPage;
import com.PHPTravels.pom.AdministratorLogin.LoginPage;
import com.PHPTravels.pom.Dashboard.DashboardPage;

public class CreateAdminUser extends BaseTest {
	@Test(priority=3)
	public void testCreateAdminUser() throws InterruptedException
	{
		// Login with Valid Credentials-->
		String un = Lib.getCellValue(XLPATH, "ValidLogin", 1, 0);
		String pwd = Lib.getCellValue(XLPATH, "ValidLogin", 1, 1);
		LoginPage l= new LoginPage(driver);
		l.setUserName(un);
		l.setPassword(pwd);
		l.clickLoginButton();
		DashboardPage d= new DashboardPage(driver);
		d.clickOnAccounts();
		d.clickOnAdmins();
		
		int rc= Lib.getRowCount(XLPATH, "CreateAdminUser");
		for(int i=1;i<=rc;i++)
		{
		String fname = Lib.getCellValue(XLPATH, "CreateAdminUser", i, 0);
		String lname = Lib.getCellValue(XLPATH, "CreateAdminUser", i, 1);
		String email = Lib.getCellValue(XLPATH, "CreateAdminUser", i, 2);
		String password = Lib.getCellValue(XLPATH, "CreateAdminUser", i, 3);
		String mobilenumber = Lib.getCellValue(XLPATH, "CreateAdminUser", i, 4);
		String Address1 = Lib.getCellValue(XLPATH, "CreateAdminUser", i, 5);
		String Address2 = Lib.getCellValue(XLPATH, "CreateAdminUser", i, 6);
		
		AdminsManagementPage am= new AdminsManagementPage(driver);
		//am.clickOnPrintButton();
		am.clickOnAddButton();
		
		//am.clickOnExportButton();
		
		AddAdminPage  a= new AddAdminPage(driver);
		a.setFname(fname);
		a.setLname(lname);
		a.setEmail(email);
		a.setPassword(password);
		a.setMobileNumber(mobilenumber);;
		//a.clickOnDropDownList();
		a.selectCountry();
		
		a.setAddress(Address1);
		Thread.sleep(3000);
		a.setAddress2(Address2);
		Thread.sleep(3000);
		a.setStatus();
		Thread.sleep(3000);
		a.selectEnmailSubscribe();
		Thread.sleep(3000);
		a.selectAddCars();
		Thread.sleep(3000);
		a.selectTours();
		Thread.sleep(3000);
		a.clickOnSubmit(driver);
		Thread.sleep(3000);
	}
	}
}
