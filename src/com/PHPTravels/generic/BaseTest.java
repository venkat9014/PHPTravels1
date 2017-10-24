package com.PHPTravels.generic;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
@Listeners(CustomListener.class)
public class BaseTest implements IAutoConstValues {
	public WebDriver driver;
	static
	{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}
@Parameters({"node","browser"})	
@BeforeMethod(alwaysRun=true)
public void openApplication(String node, String browser) throws MalformedURLException
{
	URL whichSystem= new URL(node);
	DesiredCapabilities whichBrowser = new DesiredCapabilities();
	whichBrowser.setBrowserName(browser);
	driver = new RemoteWebDriver(whichSystem,whichBrowser);
	driver.manage().window().maximize();
	//driver = new ChromeDriver();
	// write code to Automate Implicit timeout from property file 
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	//driver.get("http://localhost/login.do");
	String url = Lib.getProperty(CONFIG_PATH, "URL");
	driver.get(url);
	
}
@AfterMethod(alwaysRun=true)
public void closeApplication()
{
	
		driver.close();
	
	}
}

