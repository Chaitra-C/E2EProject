package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class base {
	public WebDriver driver;
	public Properties prop;
   public WebDriver initializeDriver() throws IOException
   {
	   prop = new Properties();
	   FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/data.properties");
	   prop.load(fis);
	   String browserName = System.getProperty("browser");
	   //String browserName = prop.getProperty("browser");
	   System.out.println(browserName);
	   if (browserName.contains("chrome"))
	   {
		   System.setProperty("webdriver.chrome.driver","/Users/chaitrabhat/Downloads/chromedriver 2");
		   if (browserName.contains("headless")) 
		   {
		    ChromeOptions options = new ChromeOptions();
		    options.addArguments("headless");
		    driver = new ChromeDriver(options);
		   }
		   else
			   driver =new ChromeDriver();
	   }
	   /*else if (browserName.equals("firefox") {
		   
	   }
	   else if (browserName.equals("IE") {
		   
	   }*/
	   
	   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	   return driver;
	   
   }
   
   public String getScreenshotPath(String testcasename,WebDriver driver) throws IOException
   {
	   TakesScreenshot ts = (TakesScreenshot)driver;
	   File source = ts.getScreenshotAs(OutputType.FILE);
	   String destFile = System.getProperty("user.dir")+"/reports/"+testcasename+".png";
	   FileUtils.copyFile(source,new File(destFile));
	   return destFile;
}
}
