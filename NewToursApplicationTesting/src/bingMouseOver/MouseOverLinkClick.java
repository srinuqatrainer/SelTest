package bingMouseOver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class MouseOverLinkClick 
{

	
	public static void main(String[] args) 
	{
		
		FirefoxDriver driver = new FirefoxDriver();
		
		driver.get("http://bing.com");
		
	//	driver.findElement(By.id("off_link")).click();
		
		Actions a = new Actions(driver);
		
		WebElement link = driver.findElement(By.linkText("Office Online"));
		
		Sleeper.sleepTightInSeconds(10);
		
		WebElement subLink = driver.findElement(By.id("officemenu_word_img"));
		
		a.moveToElement(link).perform();
		
		Sleeper.sleepTightInSeconds(10);
		
		a.click(subLink).perform();
		
		
		

	}

}
