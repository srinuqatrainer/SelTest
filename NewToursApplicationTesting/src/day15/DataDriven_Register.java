package day15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DataDriven_Register {

	
	public static void main(String[] args) throws IOException {
		
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
		
		driver.findElement(By.linkText("REGISTER")).click();
		
		FileInputStream f = new FileInputStream("C:\\Users\\Sys\\Desktop\\DataDrivenTestData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(f);
		XSSFSheet ws = wb.getSheet("Sheet1");
		
		Row r = ws.getRow(1);
		
		driver.findElement(By.name("firstName")).sendKeys(r.getCell(0).getStringCellValue());
		driver.findElement(By.name("lastName")).sendKeys(r.getCell(1).getStringCellValue());
		driver.findElement(By.name("phone")).sendKeys(r.getCell(2).getStringCellValue());
		driver.findElement(By.name("userName")).sendKeys(r.getCell(3).getStringCellValue());
		driver.findElement(By.name("address1")).sendKeys(r.getCell(4).getStringCellValue());
		driver.findElement(By.name("city")).sendKeys(r.getCell(5).getStringCellValue());
		driver.findElement(By.name("state")).sendKeys(r.getCell(6).getStringCellValue());
		driver.findElement(By.name("postalCode")).sendKeys(r.getCell(7).getStringCellValue());
		driver.findElement(By.name("country")).sendKeys(r.getCell(8).getStringCellValue());
		driver.findElement(By.name("email")).sendKeys(r.getCell(9).getStringCellValue());
		driver.findElement(By.name("password")).sendKeys(r.getCell(10).getStringCellValue());
		driver.findElement(By.name("confirmPassword")).sendKeys(r.getCell(11).getStringCellValue());
		

	}

}
