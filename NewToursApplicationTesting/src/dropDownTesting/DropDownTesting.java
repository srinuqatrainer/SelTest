package dropDownTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;


public class DropDownTesting
{

	public static void main(String[] args) throws IOException
	{
		FileInputStream f = new FileInputStream("C:\\Users\\Sys\\Desktop\\DropDownTesting.xlsx");
		XSSFWorkbook wb= new XSSFWorkbook(f);
		XSSFSheet ws = wb.getSheet("Sheet1");
		
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
		
		Sleeper.sleepTightInSeconds(10);
		
		driver.findElement(By.linkText("REGISTER")).click();
		Sleeper.sleepTightInSeconds(10);
		
		WebElement LocationDrop = driver.findElement(By.name("country"));
		
		List <WebElement>Countries = LocationDrop.findElements(By.tagName("option"));
		
		System.out.println(Countries.size());
		
		for(int i =0; i<Countries.size();i++)
		{
			System.out.println(Countries.get(i).getText());
			
			Row r = ws.createRow(i);
			r.createCell(0).setCellValue(Countries.get(i).getText());
		}
		
		FileOutputStream f1 = new FileOutputStream("C:\\Users\\Sys\\Desktop\\DropDownTesting.xlsx");
		wb.write(f1);
		
		
		
		
		
		
		

	}

}
