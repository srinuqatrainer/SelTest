package learn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		FileInputStream f = new FileInputStream("C:\\Users\\Sys\\Desktop\\TestData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(f);
		XSSFSheet ws = wb.getSheet("chin");
		
		int RowCount = ws.getLastRowNum();
		
		for(int i=0;i<=RowCount;i++)
		{
			
			Row r = ws.getRow(i);
			int ColCount = r.getLastCellNum();
			
			for(int j=0;j<ColCount;j++)
			{
				Cell c = r.getCell(j);
				System.out.println(c.getStringCellValue());
			}
			
			System.out.println();
			
			
			
			
		}
		
		
		
		
		

	}

}
