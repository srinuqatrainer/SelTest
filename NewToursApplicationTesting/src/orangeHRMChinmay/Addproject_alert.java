package orangeHRMChinmay;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Addproject_alert {
	FirefoxDriver driver=null;
	
	@BeforeTest
	public void login()
	{
		driver = new FirefoxDriver();
		driver.get("http://opensource.demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin");
		driver.findElement(By.id("btnLogin")).click();
	}
	@Test
	public void MousehoveronTimeModule()
	{
		WebElement Timetab=driver.findElement(By.id("menu_time_viewTimeModule"));
		Actions a = new Actions(driver);
		a.moveToElement(Timetab).perform();
		Sleeper.sleepTightInSeconds(10);
		WebElement prjctinfotab=driver.findElement(By.id("menu_admin_ProjectInfo"));
		Actions b = new Actions(driver);
		b.moveToElement(prjctinfotab).perform();
		Sleeper.sleepTightInSeconds(10);
		WebElement Projects=driver.findElement(By.id("menu_admin_viewProjects"));
		Actions c = new Actions(driver);
		c.click(Projects).perform();
		Sleeper.sleepTightInSeconds(10);
		driver.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/a")).click();//Toggle button hide
		Sleeper.sleepTightInSeconds(5);
		driver.findElement(By.id("btnAdd")).click();
		Sleeper.sleepTightInSeconds(10);
	}
	@Test
	public void addcustomer()
	{
		driver.findElement(By.id("addCustomerLink")).click();
		String addcustomer=driver.getWindowHandle();
		System.out.println(addcustomer);
	}
}
