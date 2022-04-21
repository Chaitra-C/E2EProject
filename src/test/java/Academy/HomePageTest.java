package Academy;

import org.testng.annotations.Test;

import jdk.internal.org.jline.utils.Log;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.Forgot_pwd;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePageTest extends base {
	public WebDriver driver;
	public static Logger Log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialise() throws IOException
	{
		driver = initializeDriver();
		
	}
	
	@Test(dataProvider = "getData")
	public void basePageNavigation(String username,String password,String text) 
	{
		driver.get(prop.getProperty("url"));
		LandingPage ln = new LandingPage(driver);
		LoginPage lp = ln.getLogin();
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		Forgot_pwd pw =lp.reset_pwd();
		//System.out.println(text);
		Log.info(text);
		lp.Login().click();
		Log.info("login is successful");
		pw.getEmail().sendKeys("abc@yahoo.com");
		pw.send_inst().click();
		
		
	}
	@DataProvider
	public Object[][] getData()
	{
		//row stands for how many different data types test should run
		Object[][]data = new Object[2][3];
		data[0][0] = "nonrestricteduser@cw.com";
		data[0][1] = "123456";
		data[0][2] = "non restricted user";
		data[1][0] = "restricteduser@cw.com";
		data[1][1] = "123123";
		data[1][2]="restricted user";
		return data;
		
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
}
