package writeDataInExcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WrittingDataIntoExcelSheet {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		FileInputStream f = new FileInputStream("C:\\Users\\Sys\\Desktop\\testdata.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(f);
		XSSFSheet ws = wb.getSheet("sheet1");
				
		Row r = ws.createRow(3);
		Cell c = r.createCell(0);
		c.setCellValue("Hello");
		
		FileOutputStream f1 = new FileOutputStream("C:\\Users\\Sys\\Desktop\\testdata.xlsx");
		
		wb.write(f1);
		

	}

}
