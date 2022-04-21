package Academy;

import org.testng.annotations.Test;

import jdk.internal.org.jline.utils.Log;

import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class ValidateNavigationBarTest extends base {
	
	public WebDriver driver;
	
	public static Logger Log = LogManager.getLogger(base.class.getName());
	
	
	@BeforeTest
	public void initialise() throws IOException
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void ValidateAppNavigation() throws IOException {
		
		LandingPage ln = new LandingPage(driver);
		//Assert.assertEquals(ln.getTitle().getText(),"FEATURED COURSES123");
		Assert.assertTrue(ln.getNavigationBar().isDisplayed());
		Log.info("Navigation bar is displayed");
		
		
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

}
