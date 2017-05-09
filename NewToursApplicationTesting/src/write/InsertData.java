package write;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class InsertData {

	/**
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @param args
	 * @throws  
	 */
	public static void main(String[] args) throws IOException 
	{
		
		FileInputStream f = new FileInputStream("C:\\Users\\Sys\\Desktop\\testdata.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(f);
		XSSFSheet ws = wb.getSheet("Sheet1");
		
		Row r = ws.createRow(0);
		Cell C =r.createCell(1);
		C.setCellValue("Hyderabad");
		
		FileOutputStream f1 = new FileOutputStream("C:\\Users\\Sys\\Desktop\\testdata.xlsx");
		
		wb.write(f1);
		
		

	}

}
