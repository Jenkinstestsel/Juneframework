package commonLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRW {
	XSSFWorkbook wb;
	FileInputStream fis;
	
////	intiliaze workbook
//	public void intializeWorkbook(String path) throws Exception{
//		
//		fis = new FileInputStream(path);
////		Load the input stream
//		wb = new XSSFWorkbook(fis);		
//	}
//	Constructor
	public  ExcelRW(String path) throws Exception{
		
		fis = new FileInputStream(path);
//		Load the input stream
		wb = new XSSFWorkbook(fis);		
	}
	
//	public XSSFSheet getSheet(String Sheetname){
//		
//		XSSFSheet Sheet = wb.getSheet(Sheetname);	
//		return Sheet;
//	}
//	
	
//	get column count
	public int getColcount(String userSheetname){
		XSSFSheet Sheet = wb.getSheet(userSheetname);
		return Sheet.getRow(0).getLastCellNum();		
	}
	
	
	
	
//	get Row count
	public int getRowcount(String userSheetname){
		XSSFSheet Sheet = wb.getSheet(userSheetname);		
		int rowcount = Sheet.getLastRowNum();
		return rowcount;
		
	}
	
	
//	Read cell value
	public String readCellValue(String userSheetname,int row,int col){
		XSSFSheet Sheet = wb.getSheet(userSheetname);
		String celltext = null;
		XSSFCell cell = Sheet.getRow(row).getCell(col);
//		if the cell has string value
		if(cell.getCellType()==Cell.CELL_TYPE_STRING){
			celltext=cell.getStringCellValue();
//			if the cell has numeric value
		}else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC){
			celltext= String.valueOf(cell.getNumericCellValue());
//			if cell is having blank
		}else if(cell.getCellType()==Cell.CELL_TYPE_BLANK){
			celltext="";
		}
		
		return celltext;
		
		
	}
		
//	Write cell value
	
	public void writeCellVCalue(String userSheetname,int row,int col,String cellValue){		
		XSSFSheet Sheet = wb.getSheet(userSheetname);
		Sheet.getRow(row).getCell(col).setCellValue(cellValue);
		
	}
	
	
//	Save and close
	public void Saveandclose(String path) throws Exception{		
		FileOutputStream fos = new FileOutputStream(path);
		wb.write(fos);		
		fos.close();
		fis.close();
	}
	
	
	
	
	
	
	

}
