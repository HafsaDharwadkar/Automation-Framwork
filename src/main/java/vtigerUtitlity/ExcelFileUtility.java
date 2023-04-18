package vtigerUtitlity;



import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class consist of generic method related to excel
 * @author ADMIN
 *
 */
public class ExcelFileUtility {
	
	/**
	 * this method will read the data from excel sheet
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws Exception
	 */
	public String readDataFromExcel(String sheet,int row,int cell) throws Exception
	{
		FileInputStream fis=new FileInputStream(Iconstant.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		 String value = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		 wb.close();
		 return value;
	}
	
	
	
	public void writeDataInExcel(String sheet,int roe,int cell,String value) throws Exception
	{
		FileInputStream fis=new FileInputStream(Iconstant.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheet).createRow(roe).createCell(cell).setCellValue(value);
		FileOutputStream fos=new FileOutputStream(Iconstant.excelFilePath);
		wb.write(fos);
		wb.close();
		
	}

}
