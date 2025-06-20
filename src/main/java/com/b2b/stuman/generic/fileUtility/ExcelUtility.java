package com.b2b.stuman.generic.fileUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
	public String getCellData(String sheetName,int rowNum,int colNum) throws Exception
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String stringCellValue = wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).getStringCellValue();
		wb.close();
		return stringCellValue;
	}
	
	public int getRowCount(String sheetName) throws Exception
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int lastRowNum = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return lastRowNum;
	}
	
	public int getCellCount(String sheetName,int rowNum) throws Exception
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		short lastCellNum = wb.getSheet(sheetName).getRow(rowNum).getLastCellNum();
		wb.close();
		return lastCellNum;
	}
	
	public void setDataIntoExcel(String sheetName,int rowNum,int cellNum,String data) throws Exception
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(data);
		FileOutputStream fos = new FileOutputStream("./src/test/resources/data.xlsx");
		
		wb.write(fos);
		wb.close();
	}
}
