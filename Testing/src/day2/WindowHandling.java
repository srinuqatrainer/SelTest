package day2;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class WindowHandling
{
	public static void main(String[] args) 
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://gmail.com");
		
		driver.manage().window().maximize();
		
		String ParentWindow= driver.getWindowHandle();
		
	//	System.out.println(ParentWindow);
		
		driver.findElement(By.xpath("html/body/div[1]/div[1]/footer/ul/li[1]/a")).click();
		
		for(String SubWindow:driver.getWindowHandles())
		{
			//System.out.println(SubWindow);
			driver.switchTo().window(SubWindow);
		}

		String Text = driver.findElement(By.xpath("html/body/div[2]/div[2]/section/div/article/nav/h1")).getText();
		
		System.out.println(Text);
		
		driver.findElement(By.linkText("Create a Google Account")).click();
		
		System.out.println(driver.getTitle());
		
		driver.navigate().back();
		
		driver.close();
		
		driver.switchTo().window(ParentWindow);
		
		driver.findElement(By.id("identifierId")).sendKeys("srinu.qatrainer");
		
		Sleeper.sleepTightInSeconds(5);
		
		driver.close();
		
	}

}
