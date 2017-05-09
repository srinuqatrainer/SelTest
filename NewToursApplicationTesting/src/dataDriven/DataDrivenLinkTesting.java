package dataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DataDrivenLinkTesting {
	
	public static void main(String[] args) throws IOException 
	{
		
		FileInputStream f = new FileInputStream("C:\\Users\\Sys\\Desktop\\NewChin\\NewToursApplicationTesting\\src\\com\\srinu\\excelfiles\\DataDriverLinksTestData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(f);
		XSSFSheet ws = wb.getSheet("Sheet1");
		
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
		
	     Iterator <Row> r = ws.iterator();
	     r.next();
	     while(r.hasNext())
	     {
	    	 Row NewRow = r.next();
	    	 String LinkName = NewRow.getCell(0).getStringCellValue();
	    	 driver.findElement(By.linkText(LinkName)).click();
	    	 String ActUrl = driver.getCurrentUrl();
	    	 
	    	 Cell c = NewRow.createCell(2);
	    	 c.setCellValue(ActUrl);
	    	 
	    	 String ExpUrl = NewRow.getCell(1).getStringCellValue();
	    	 
	    	 if(ActUrl.equals(ExpUrl))
	    	 {
	    		Cell  C = NewRow.createCell(3);
	    		 C.setCellValue("Passed");
	    	 }
	    		 else
	    		 {
	    			Cell C = NewRow.createCell(3);
		    		 C.setCellValue("Passed"); 
	    		 }
	    	 driver.navigate().back();
	    	 }
	    	 FileOutputStream f1 = new FileOutputStream("C:\\Users\\Sys\\Desktop\\NewChin\\NewToursApplicationTesting\\src\\com\\srinu\\excelfiles\\DataDriverLinksTestData.xlsx");
	    	 wb.write(f1);
	    	 
	    	 
	    	 
	     }
		

	}


