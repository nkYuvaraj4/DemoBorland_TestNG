package com.qa.testdata;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtil {
	private static XSSFWorkbook workbook;
	private static XSSFSheet worksheet;
	private static XSSFCell cell;
	private static XSSFRow row;
	
	public static Object[][] getExcelFileData(String FilePath, String SheetName) throws IOException{
		String[][] excAry=null;
		FileInputStream fis = new FileInputStream(FilePath);
		workbook = new XSSFWorkbook(fis);
		worksheet = workbook.getSheet(SheetName);
		int lastRowCount = worksheet.getLastRowNum();
		int lastColCount= 2;
		excAry = new String[lastRowCount][lastColCount];
		for(int i = 1;i<=lastRowCount;i++)
		{
			for (int j=1;j<=lastColCount;j++) {
				excAry[i-1][j-1]=getCellData(i,j);		
			}			
		}
		return excAry;
	}
	
	public static String getCellData(int rowNum, int colNum) {
		cell = worksheet.getRow(rowNum).getCell(colNum);
		int cellDataType = cell.getCellType();
		if (cellDataType==3) {			
			return "";
		}
		else
		{
			DataFormatter formatter = new DataFormatter();
			String cellValue = formatter.formatCellValue(cell);
			return cellValue;
		}
	}
}
