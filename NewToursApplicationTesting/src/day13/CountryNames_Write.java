package day13;

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

public class CountryNames_Write 
{
	static void main(String[] args) throws IOException {
		
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
		
		driver.findElement(By.linkText("REGISTER")).click();
		
		driver.manage().window().maximize();
		Sleeper.sleepTightInSeconds(7);
		
		FileInputStream f = new FileInputStream("C:\\Users\\Sys\\Desktop\\CountryData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(f);
		XSSFSheet ws = wb.getSheet("Sheet");
		
		
		WebElement drop = driver.findElement(By.name("country"));
		List <WebElement> dropDown = drop.findElements(By.tagName("options"));
		
		for(int i=0;i<=dropDown.size();i++)
		{
			Row r = ws.createRow(0);
			
			r.createCell(0).setCellValue(dropDown.get(i).getText());
			
			
		}
		
		FileOutputStream f1 = new FileOutputStream("C:\\Users\\Sys\\Desktop\\CountryData.xlsx");
		wb.write(f1);

	}

}
