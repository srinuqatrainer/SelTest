package excelRead;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcelSheetData {

	public static void main(String[] args) throws IOException  
	{
	
		FileInputStream f = new FileInputStream("C:\\testdata.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(f);
		XSSFSheet ws = wb.getSheet("Sheet1");
	
		int rowCount = ws.getLastRowNum();
		
		for( int i=0;i<=rowCount;i++)
		{
			// Identifying the ith Row
			Row r = ws.getRow(i);
			
			// Identifying the Column in the ROW
			int colCount = r.getLastCellNum();
			
			for(int j=0;j<colCount;j++)
			{
				// Pointing to the jth Cell
				Cell c = r.getCell(j);
				System.out.print(c.getStringCellValue()+" ");
				
			}
			System.out.println();
					
		}
	
	}

}
