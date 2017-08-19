package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Guru
{

	public static void main(String[] args) 
	{

		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		// FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://live.guru99.com");
		
		driver.findElement(By.xpath("html/body/div[1]/div/header/div/div[2]/div/a/span[2]")).click();

	}

}
