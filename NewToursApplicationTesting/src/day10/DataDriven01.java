package day10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DataDriven01 {

	public static void main(String[] args) throws IOException
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
		
		FileInputStream f = new FileInputStream("C:\\Users\\Sys\\Desktop\\TestData\\DataDriverLinksTestData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(f);
		XSSFSheet ws = wb.getSheet("Sheet1");
		
		 int RowCount = ws.getLastRowNum();
		 for(int i=1;i<=RowCount;i++)
		 {
			 Row r = ws.getRow(i);
			 String linkName = r.getCell(0).getStringCellValue();
			 driver.findElement(By.linkText(linkName)).click();
			 String ActUrl = driver.getCurrentUrl();
			 r.createCell(2).setCellValue(ActUrl);
			 
			 String ExpUrl = r.getCell(1).getStringCellValue();
			 
			 if(ActUrl.equals(ExpUrl))
			 {
				 r.createCell(3).setCellValue("Passed");
			 }
			 else
			 {
				 r.createCell(3).setCellValue("Failed");
			 }
			 driver.navigate().back();
			 FileOutputStream f1 = new FileOutputStream("C:\\Users\\Sys\\Desktop\\TestData\\DataDriverLinksTestData.xlsx");
			 wb.write(f1);
			 
		 }
		

	}

}
