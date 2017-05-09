package bingMouseOver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertTesting {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		FirefoxDriver driver = new FirefoxDriver();
		
		driver.get("http://sys/valubank/");
		
		WebElement UserId = driver.findElement(By.id("txtuId"));
		
		WebElement Pwd = driver.findElement(By.id("txtPword"));
		
		UserId.sendKeys("hello");
		
		driver.findElement(By.id("login")).click();
		
		Alert a = driver.switchTo().alert();
		
		System.out.println(a.getText());
		
		a.accept();
		
		UserId.clear();
		
		UserId.sendKeys("Admin");
		Pwd.sendKeys("Admin");
		
		driver.findElement(By.id("login")).click();
		
		System.out.println(driver.getCurrentUrl());
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath(".//*[@id='Table_02']/tbody/tr/td[3]/a/img")).click();
		
		
		
		
		
		
		

	}

}
