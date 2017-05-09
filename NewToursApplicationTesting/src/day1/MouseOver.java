package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class MouseOver {

	
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
		Actions A = new Actions(driver);
		
		// menu_pim_Configuration
		WebElement config = driver.findElement(By.id("menu_pim_Configuration"));
		
		A.moveToElement(config).perform();
		
		driver.findElement(By.linkText("Custom Fields")).click();
		
		
		
		
		
		
		
		
		
	}

}
