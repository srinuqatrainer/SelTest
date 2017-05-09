package day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class Alerts {

	
	public static void main(String[] args)
	{
FirefoxDriver driver = new FirefoxDriver();
		
		driver.get("http://sys:8090/orangehrm");
		
		Sleeper.sleepTightInSeconds(15);
		
		 driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		 driver.findElement(By.id("txtPassword")).sendKeys("Admin");
		 driver.findElement(By.name("Submit")).click();
			
			driver.manage().window().maximize();
			
			Sleeper.sleepTightInSeconds(15);
			
			
			
			driver.findElement(By.id("welcome")).click();
			
			WebElement menu = driver.findElement(By.id("welcome"));
			
			Actions a = new Actions(driver);
			
			Sleeper.sleepTightInSeconds(15);
			
			a.moveToElement(menu).perform();
			
			driver.findElement(By.linkText("Logout")).click();			
	
		
	}

}
