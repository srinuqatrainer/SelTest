package testing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Linkstesting
{
		FirefoxDriver driver;
	 @BeforeTest
	  public void ApplLaunch()
	  {
	   driver=  new FirefoxDriver();
	   driver.get("http://newtours.demoaut.com");
	   
	   driver.manage().window().maximize();
	   Sleeper.sleepTightInSeconds(5);
	   
	  }
	  
	  @Test
	  public void LinksTesting() throws IOException
	  {
	   FileInputStream f = new FileInputStream("C:\\Users\\Sys\\Desktop\\DataDrivenLinksTestData.xlsx");
	   XSSFWorkbook wb = new XSSFWorkbook(f);
	   XSSFSheet ws = wb.getSheet("Sheet1");
	   
	   int RowCount = ws.getLastRowNum();
	   for(int i=1;i<=RowCount;i++)
	   {
	    Row r = ws.getRow(i);
	    
	    String LinkName = r.getCell(0).getStringCellValue();
	    
	    driver.findElement(By.linkText(LinkName)).click();
	    
	    String ActualURL = driver.getCurrentUrl();
	    
	    r.createCell(2).setCellValue(ActualURL);
	    
	    if(ActualURL.equals(r.getCell(1).getStringCellValue()))
	    {
	     r.createCell(3).setCellValue("PASS");
	    }
	    else
	    {
	     r.createCell(3).setCellValue("FAIL");
	    }
	    
	    driver.navigate().back();
	    FileOutputStream f1 = new FileOutputStream("C:\\Users\\Sys\\Desktop\\DataDrivenLinksTestData.xlsx");
	    wb.write(f1);
	     
	   }
	  }

	  @AfterTest
	  public void ApplClose()
	  {
	   driver.close();
	  }
	  
	  }
	
	
	

