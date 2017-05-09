package bingMouseOver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.SwitchToFrame;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class Ohrm_ConfigurationMouseOver {

	
	public static void main(String[] args) 
	{
		
FirefoxDriver driver = new FirefoxDriver();
		
		driver.get("http://sys:8090/orangehrm");
		
		Sleeper.sleepTightInSeconds(5);
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Admin");
		driver.findElement(By.name("Submit")).click();
		
		//driver.manage().window().maximize();
		
		Sleeper.sleepTightInSeconds(10);
		
		Actions a = new Actions(driver);
		
		WebElement PerfMenu = driver.findElement(By.id("menu_performance_viewPerformanceModule"));
		
		Sleeper.sleepTightInSeconds(5);
		
		//WebElement custFiled  = driver.findElement(By.xpath(".//*[@id='menu_performance_saveReview']"));
		
		a.moveToElement(PerfMenu).perform();
		
		System.out.println("Performance Done");
		
		
		driver.findElement(By.xpath(".//*[@id='menu_performance_saveReview']")).click();
		
		//a.moveToElement(custFiled).perform();
		
		//a.contextClick(custFiled);
		System.out.println("Review is clicked");
		
		driver.findElement(By.id("saveReview_employeeName_empName")).sendKeys("Hello");
		
		System.out.println("Emp Name Entered");
		
	}

}
