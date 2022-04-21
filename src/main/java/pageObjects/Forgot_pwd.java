package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Forgot_pwd {
	
	WebDriver driver;
	public Forgot_pwd(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	private By username = By.id("user_email");
	private By send_inst = By.xpath("//input[@type='submit']");
	
	
		
	

	public WebElement getEmail() 
	{
		return driver.findElement(username);
	}
	public WebElement send_inst() {
		return driver.findElement(send_inst);
	}
	
}
