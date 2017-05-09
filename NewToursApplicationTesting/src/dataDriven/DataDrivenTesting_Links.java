package dataDriven;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DataDrivenTesting_Links {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com/");
		
		List <WebElement> Links = driver.findElements(By.tagName("a"));
		System.out.println(Links.size());
		
		for(int i=0;i<Links.size();i++)
		{
			String linkName = Links.get(i).getText();
			System.out.println(linkName);
			Links.get(i).click();
			System.out.println(driver.getCurrentUrl());
			driver.navigate().back();
			Links = driver.findElements(By.tagName("a"));
			
		}
		
		

	}

}
