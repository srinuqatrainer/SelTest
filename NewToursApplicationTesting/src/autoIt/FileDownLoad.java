package autoIt;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FileDownLoad {

	public static void main(String[] args) throws IOException
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("http://seleniumhq.org");
		
		driver.findElement(By.xpath("html/body/div[3]/div[1]/ul/li[4]/a")).click();
		
		driver.findElement(By.xpath("html/body/div[3]/div[2]/div[2]/p[3]/a")).click();
		
		Runtime.getRuntime().exec("C:\\Users\\Sys\\Desktop\\FileDownLoad.exe");

	}

}
