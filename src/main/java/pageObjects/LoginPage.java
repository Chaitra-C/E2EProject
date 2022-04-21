package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	private By username = By.id("user_email");
	private By Password = By.id("user_password");
	private By LogIn = By.cssSelector("input[type='submit']");
	private By Forgot_paswrd = By.xpath("//a[contains(text(),'Forgot Password')]");
	
	public Forgot_pwd reset_pwd() 
	{
		driver.findElement(Forgot_paswrd).click();
		Forgot_pwd pw=new Forgot_pwd(driver);
		return pw;
		
	}

	public WebElement getEmail() 
	{
		return driver.findElement(username);
	}
	public WebElement getPassword() 
	{
		return driver.findElement(Password);
	}
	
	public WebElement Login()
	{
		return driver.findElement(LogIn);
	}
}
