package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	
	//By SignIn = By.cssSelector("a[href*=sign_in]");
	private By SignIn = By.xpath("//span[contains(text(),'Login')]");
	private By Title = By.cssSelector(".text-center");
	private By navBar = By.xpath("//ul[@class='nav navbar-nav navbar-right']");
	private By 	hdr	=By.cssSelector("div[class*='video-banner'] h3");
	
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
			this.driver = driver;
	
	}
	
	

	public LoginPage getLogin() {
		driver.findElement(SignIn).click();
		LoginPage lp = new LoginPage(driver);
		return lp;
	}
	
	
	
	public WebElement getTitle()
	{
		return driver.findElement(Title);
	}
	public WebElement getNavigationBar()
	{
		return driver.findElement(navBar);
	}
	public WebElement getHdr()
	{
		return driver.findElement(hdr);
	}
	
	}


