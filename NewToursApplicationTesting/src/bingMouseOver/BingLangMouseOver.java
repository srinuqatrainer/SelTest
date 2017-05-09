package bingMouseOver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class BingLangMouseOver {

	
	public static void main(String[] args)
	{
		
		FirefoxDriver driver = new FirefoxDriver();
		
		driver.get("http://bing.com");
		
		WebElement links= driver.findElement(By.xpath(".//*[@id='sb_form']/div[2]"));
		
		WebElement langLink = driver.findElement(By.id("SERP,5096.1"));
		
		Actions a = new Actions(driver);
		
		a.moveToElement(links).perform();
		
		Sleeper.sleepTightInSeconds(15);
		a.moveToElement(langLink).perform();
		
		

	}

}
