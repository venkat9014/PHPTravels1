package com.PHPTravels.script.Login;
import org.testng.annotations.Test;
import com.PHPTravels.generic.BaseTest;
import com.PHPTravels.generic.Lib;
import com.PHPTravels.pom.AdministratorLogin.LoginPage;
import com.PHPTravels.pom.Dashboard.DashboardPage;
public class ValidLogin extends BaseTest {
	@Test(priority=1)
	public void testValidLogin() throws InterruptedException
	{
		String un = Lib.getCellValue(XLPATH, "ValidLogin", 1, 0);
		String pwd = Lib.getCellValue(XLPATH, "ValidLogin", 1, 1);
		String title = Lib.getCellValue(XLPATH, "ValidLogin", 1, 2);
		LoginPage l= new LoginPage(driver);
		l.setUserName(un);
		l.setPassword(pwd);
		l.clickLoginButton();
		DashboardPage db= new DashboardPage(driver);
	db.verifyTitle(driver, title);
	db.clickOnLogoutLink();
	db.clikOnLogout(driver);
	
	}

}
