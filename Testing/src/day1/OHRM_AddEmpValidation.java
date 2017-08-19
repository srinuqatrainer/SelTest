package day1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class OHRM_AddEmpValidation {

	public static void main(String[] args) throws IOException
	{
		
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://opensource.demo.orangehrmlive.com");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin");
		driver.findElement(By.id("btnLogin")).click();
		
				
		Actions act = new Actions(driver);
		
		WebElement PIM = driver.findElement(By.id("menu_pim_viewPimModule"));
		
		act.moveToElement(PIM).perform();
		
		Sleeper.sleepTightInSeconds(10);
		
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		
		FileInputStream f = new FileInputStream("C:\\Users\\Sys\\Desktop\\OHRM_NewAddEmp.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(f);
		XSSFSheet ws = wb.getSheet("Sheet1");
		
		int RowCount = ws.getLastRowNum();
		
		for(int i=1;i<=RowCount;i++)
		{
			Row r = ws.getRow(i);
						
		driver.findElement(By.id("firstName")).sendKeys(r.getCell(0).getStringCellValue());
		Sleeper.sleepTightInSeconds(5);
		driver.findElement(By.id("lastName")).sendKeys(r.getCell(1).getStringCellValue());
		Sleeper.sleepTightInSeconds(5);
		driver.findElement(By.id("btnSave")).click();
		
		String RegisteredUser = driver.findElement(By.xpath("html/body/div[1]/div[3]/div/div[1]/div/h1")).getText();
		
		String Text = r.getCell(0).getStringCellValue();
		
		if(RegisteredUser.contains(Text))
		{
			System.out.println(r.getCell(0).getStringCellValue()  +"PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
			
		
		driver.navigate().back();
		
		driver.findElement(By.id("firstName")).clear();
		driver.findElement(By.id("lastName")).clear();
		Sleeper.sleepTightInSeconds(10);
		
	}

		driver.close();
}
}