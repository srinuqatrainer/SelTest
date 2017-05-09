package day12;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrowserLaunch
{

	FirefoxDriver driver;
	
	@BeforeTest
	
	public void launch()
	{
		driver=new FirefoxDriver();
		
		driver.get("http://gmail.com");
	}
	@Test
	
	public void LogIn()
	{
		driver.findElement(By.id("Email")).sendKeys("srinu4qatraining");
	}
}
