package vtiger.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteIntoExcel {

	public static void main(String[] args) throws Exception, Exception {
		// TODO Auto-generated method stub
		//step 1:load the sheet into file input stream in java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//step 2:create a workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//step 3:get inside the sheet
		Sheet sheet = wb.getSheet("Contact");
		
		//step 4:get the used row
		Row row = sheet.getRow(1);
		
		//step 5:create a cell
		Cell cell = row.createCell(8);
		
		//step 6:write data into cell
		cell.setCellValue("Hafsa");
		
		//step 7:open the file in java write format and write into workbook
	     FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
	     wb.write(fos);
	     System.out.println("Data Added to Excel Sheet");
	     wb.close();
	
	}
	

}
