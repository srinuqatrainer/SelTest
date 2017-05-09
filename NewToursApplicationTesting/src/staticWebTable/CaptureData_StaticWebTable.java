package staticWebTable;

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

public class CaptureData_StaticWebTable
{

	
	public static void main(String[] args) throws IOException 
	{
		FileInputStream f = new FileInputStream("C:\\Users\\Sys\\Desktop\\testdata.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(f);
		XSSFSheet ws = wb.getSheet("Sheet1");
		
		FirefoxDriver driver = new FirefoxDriver();
		
		driver.get("http://timeanddate.com/worldclock");
		
		Sleeper.sleepTightInSeconds(15);

		// html/body/div[1]/div[7]/section[2]/div[1]/table/tbody/tr[1]/td[1]/a
		// html/body/div[1]/div[7]/section[2]/div[1]/table/tbody/tr[36]/td[1]/a
		
		String Part1 = "html/body/div[1]/div[7]/section[2]/div[1]/table/tbody/tr[";
		String Part2 = "]/td[1]/a";
		
		
		for(int i =1;i<=36;i++)
			
		{
			String x = driver.findElement(By.xpath(Part1+i+Part2)).getText();
			System.out.println(x);
			
			Row r =ws.createRow(i);
			r.createCell(0).setCellValue(driver.findElement(By.xpath(Part1+i+Part2)).getText());
			
			}
		FileOutputStream f1 = new FileOutputStream("C:\\Users\\Sys\\Desktop\\testdata.xlsx");
		wb.write(f1);
		
	}

}
