package vTiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheetPractice {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//Step 1: Load File location Into File input stream
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step 2: Create a work book
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step 3: Navigate to required sheet
		Sheet sh = wb.getSheet("Organizations");
		
		//Step 4: Navigate to required row
		Row rw = sh.getRow(7);
		
		//Step 5: navigate to required Cell
		Cell ce = rw.getCell(4);
		
		//Step 6: Capture the data present in that cell
		String value = ce.getStringCellValue();
		System.out.println(value);
		
		String value1 = rw.getCell(2).getStringCellValue();
		System.out.println(value1);
		
	}

}
