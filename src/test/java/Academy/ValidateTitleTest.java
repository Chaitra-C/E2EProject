package Academy;

import org.testng.annotations.Test;
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

public class ValidateTitleTest extends base {
	
	public WebDriver driver;
	LandingPage ln;
	
	public static Logger Log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialise() throws IOException
	{
		driver = initializeDriver();
		Log.info("Driver is initialised");
		driver.get(prop.getProperty("url"));
		Log.info("Navigated to Home Page");
	}
	
	@Test
	public void validateAppTitle() throws IOException 
	{
		 ln =  new LandingPage(driver);
			Assert.assertEquals(ln.getTitle().getText(),"FEATURED123COURSES");
			Log.info("Text display is success");
		}
	@Test
	public void validateHeader()
	{
		Assert.assertEquals(ln.getHdr().getText(),"AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
}
