package autoIt;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class UploadFile {

	public static void main(String[] args) throws IOException
	{
		
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://imgur.com");
		
		driver.findElement(By.xpath("html/body/div[2]/div/span[2]/a/span[3]")).click();
		
		Sleeper.sleepTightInSeconds(10);
		
		driver.findElement(By.xpath("html/body/div[2]/div/span[2]/div/ul/li[1]/a"));
		
		Sleeper.sleepTightInSeconds(5);
		
		driver.findElement(By.linkText("Upload Images")).click();
		
		Sleeper.sleepTightInSeconds(5);
		
		driver.findElement(By.xpath("html/body/div[5]/div/div[2]/span/div/div/div[2]/div[2]/label")).click();
		
		java.lang.Runtime.getRuntime().exec("C:\\Users\\Sys\\Desktop\\fileUpload.exe");
	}

}
