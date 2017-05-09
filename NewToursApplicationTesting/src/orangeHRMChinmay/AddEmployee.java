package orangeHRMChinmay;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;




public class AddEmployee 
{
	FirefoxDriver driver = null;
	
	@BeforeTest
	public void HRMlogin()
	{
		driver=new FirefoxDriver();
		driver.get("http://opensource.demo.orangehrmlive.com");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin");
		driver.findElement(By.id("btnLogin")).click();		
	}
	@Test
	public void adminmousehover()
	{
		WebElement admintab=driver.findElement(By.id("menu_admin_viewAdminModule"));
		Actions a= new Actions(driver);
		a.moveToElement(admintab).perform();
		Sleeper.sleepTightInSeconds(10);
		WebElement usermgmttab=driver.findElement(By.id("menu_admin_UserManagement"));
		Actions b = new Actions(driver);
		b.moveToElement(usermgmttab).perform();
		Sleeper.sleepTightInSeconds(10);
		WebElement usertab=driver.findElement(By.id("menu_admin_viewSystemUsers"));
		Actions c = new Actions(driver);
		c.click(usertab).perform();
		Sleeper.sleepTightInSeconds(10);
		driver.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/a")).click();
		Sleeper.sleepTightInSeconds(5);
	  }
	  @Test
	  public void newemployee() throws IOException
	  {
		   driver.findElement(By.xpath("html/body/div[1]/div[3]/div[2]/div/div/form/div[1]/input[1]")).click();
		   FileInputStream fis= new FileInputStream("C:\\Users\\Sys\\Desktop\\NewChin\\NewToursApplicationTesting\\src\\com\\OrangeHRMTestData\\OrangeHRM_Addemployee.xlsx");
		   XSSFWorkbook wb = new XSSFWorkbook(fis);
		   XSSFSheet ws = wb.getSheet("Sheet1");
		   int Rowcount = ws.getLastRowNum();
		   Row r = ws.getRow(1);
		   driver.findElement(By.id("systemUser_userType")).sendKeys(r.getCell(0).getStringCellValue());
		   driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys(r.getCell(1).getStringCellValue());
		   driver.findElement(By.id("systemUser_userName")).sendKeys(r.getCell(2).getStringCellValue());
		   driver.findElement(By.id("systemUser_status")).sendKeys(r.getCell(3).getStringCellValue());
		   driver.findElement(By.id("systemUser_password")).sendKeys(r.getCell(4).getStringCellValue());
		   driver.findElement(By.id("systemUser_confirmPassword")).sendKeys(r.getCell(5).getStringCellValue());
		   driver.findElement(By.id("btnSave")).click();
		   Sleeper.sleepTightInSeconds(10);
		   String ActualURL=driver.getCurrentUrl();
		   System.out.println(ActualURL);
		   Cell H = r.createCell(7);
		   H.setCellValue(ActualURL);
		   String ExpectedURL=r.getCell(6).getStringCellValue();
		   if(ActualURL.equals(ExpectedURL))
		   {
			   Cell I = r.createCell(8);
			   I.setCellValue("Employee added sucessfully");
		   }
		   else
		   {
			   Cell I = r.createCell(8);
			   I.setCellValue("Employee add failed");
		   }		   
		   File srcfile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		   FileUtils.copyFile(srcfile, new File("C:\\Users\\Chinmay\\Desktop\\Selenium_screenshots\\TestNG\\AddEmployee\\NewEmployee.jpg"));
		   FileOutputStream fos= new FileOutputStream("C:\\Users\\Chinmay\\Desktop\\TestFol\\ApplicationLaunch\\src\\com\\OrangeHRM\\excelDataDriven\\OrangeHRM_Addemployee_Result.xlsx");
		   wb.write(fos);
		   Sleeper.sleepTightInSeconds(10);
		 }
	  @Test
	  public void empsearch() throws IOException
	  {
		   FileInputStream fis= new FileInputStream("C:\\Users\\Chinmay\\Desktop\\TestFol\\ApplicationLaunch\\src\\com\\OrangeHRM\\excelDataDriven\\OrangeHRM_Searchemployee.xlsx");
		   XSSFWorkbook wb1 = new XSSFWorkbook(fis);
		   XSSFSheet ws1 = wb1.getSheet("Sheet1");
		   int Rowcount = ws1.getLastRowNum();
		   Row rw = ws1.getRow(1);
		  driver.findElement(By.id("searchSystemUser_userName")).sendKeys(rw.getCell(2).getStringCellValue());
		  /*driver.findElement(By.id("searchSystemUser_userType")).sendKeys(rw.getCell(0).getStringCellValue());
		  driver.findElement(By.id("searchSystemUser_employeeName_empName")).sendKeys(rw.getCell(1).getStringCellValue());
		  driver.findElement(By.id("searchSystemUser_status")).sendKeys(rw.getCell(3).getStringCellValue());*/
		  Sleeper.sleepTightInSeconds(5);
		  driver.findElement(By.id("searchbutton")).click();
		  File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(srcfile, new File("C:\\Users\\Sys\\Desktop\\OrangeHRMScreenShots\\searchEmployee.jpg"));
	  }
	}
