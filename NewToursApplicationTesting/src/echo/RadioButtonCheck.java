package echo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class RadioButtonCheck {

	
	public static void main(String[] args)
	{
		
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://gmail.com");

		driver.findElement(By.id("Email")).sendKeys("srinu4qatesting");
		driver.findElement(By.id("next")).click();
		
		Sleeper.sleepTightInSeconds(5);
		
		driver.findElement(By.id("Passwd")).sendKeys("contact4training");
		driver.findElement(By.id("signIn")).click();
		
		Sleeper.sleepTightInSeconds(5);
		
		List<WebElement>links = driver.findElements(By.tagName("a"));
		
		for(int i=0;i<=links.size();i++)
		{
			if(links.get(i).isDisplayed())
			{
				System.out.println(links.get(i).getText());
				links.get(i).click();
				
				System.out.println(driver.getCurrentUrl());
				
				driver.navigate().back();
				links = driver.findElements(By.tagName("a"));
				
			}
		}
		
		
		
	}

}
