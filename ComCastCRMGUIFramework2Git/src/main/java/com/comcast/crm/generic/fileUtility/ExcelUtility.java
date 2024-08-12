package com.comcast.crm.generic.fileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getDataFromExcel(String sheetName,int rowNum, int celNum ) throws Exception {
		FileInputStream fise = new FileInputStream(".\\TestData\\Testdata.xlsx");
		Workbook wb=WorkbookFactory.create(fise);
		String value=wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
		wb.close();
		return value;
	}
	
	public int getRowCount(String sheetName) throws Exception {
		FileInputStream fise = new FileInputStream(".\\TestData\\Testdata.xlsx");
		Workbook wb=WorkbookFactory.create(fise);
		int value=wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return value;
	}
	
	public void setDataIntoExcel(String sheetName, int rowNum,int celNum, String data) throws Exception {
		FileInputStream fise = new FileInputStream(".\\TestData\\Testdata.xlsx");
		Workbook wb=WorkbookFactory.create(fise);
		
		wb.getSheet(sheetName).getRow(rowNum).createCell(celNum).setCellValue(data);
		
		
		FileOutputStream fose = new FileOutputStream(".\\TestData\\Testdata.xlsx");
		wb.write(fose);
		wb.close();
	}
}
