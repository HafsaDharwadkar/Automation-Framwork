package vtiger.practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFilePractice {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//step1:Load the file in java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//step 2:create workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//step 3:get control over sheet
		Sheet sheet = wb.getSheet("Organization");
		
		//step 4:get control over row
		Row rw = sheet.getRow(0);
		
		//step 5:get control over cell
		Cell cell = rw.getCell(2);
		
		//step 6:read the data inside the cell
		System.out.println(cell.getStringCellValue());

	}

}
