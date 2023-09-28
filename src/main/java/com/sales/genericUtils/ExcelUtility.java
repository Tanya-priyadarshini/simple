 package com.sales.genericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExcelUtility   {
	/**
	 * This method will fetch the data from the excel sheet
	 * @param sheetname
	 * @param rowno
	 * @param cellno
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readFromExcelsheet(String sheetname,int rowno,int cellno) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IPathconstants.excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		Row rw = sh.getRow(rowno);
		Cell ce = rw.getCell(cellno);
		String data = ce.getStringCellValue();
		return data;
	}
	/**
	 * This method will write the data from excel sheet
	 * @param sheetname
	 * @param rowno
	 * @param cellno
	 * @param cellvalue
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
   public void writeDtaInToExcellsheet(String sheetname,int rowno,int cellno,String cellvalue) throws EncryptedDocumentException, IOException {
	   FileInputStream fis=new FileInputStream(IPathconstants.excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		Row rw = sh.createRow(rowno);
		Cell ce = rw.createCell(cellno);
		ce.setCellValue(cellvalue);
		FileOutputStream fos=new FileOutputStream(IPathconstants.excelpath);
		wb.write(fos);
		wb.close();
		 }
   /**
    * This method will fetch count row created in excel sheet
    * @param sheetname
    * @return
    * @throws EncryptedDocumentException
    * @throws IOException
    */
   public int getRowCount(String sheetname) throws EncryptedDocumentException, IOException {
	   FileInputStream fis=new FileInputStream(IPathconstants.excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int row = sh.getLastRowNum();
		return row;
		}
   /**
    * This method will fetch all the data in excel sheet
    * @param sheetname
    * @param keycoloumn
    * @param valuecoloumn
    * @param driver
    * @return
    * @throws EncryptedDocumentException
    * @throws IOException
    */
   public HashMap<String, String> getMultipleDataFromExcelSheet(String sheetname,int keycoloumn,int valuecoloumn,WebDriver driver) throws EncryptedDocumentException, IOException {
	   FileInputStream fis=new FileInputStream(IPathconstants.excelpath);
	   Workbook wb = WorkbookFactory.create(fis);
	   Sheet sh = wb.getSheet(sheetname);
	   int count = sh.getLastRowNum();
	  HashMap<String, String> map = new HashMap<String, String>();
	  for(int i=1;i<=count;i++) {
		  String key = sh.getRow(i).getCell(keycoloumn).getStringCellValue();
		  String value = sh.getRow(i).getCell(valuecoloumn).getStringCellValue();
		  map.put(key, value);
	  }
	  
	  return map; 
   }
   public Object[][] getMultipleSetOfData(String sheetname) throws Throwable {
	    FileInputStream fis=new FileInputStream(IPathconstants.excelpath);
	    Workbook wb = WorkbookFactory.create(fis);
	    Sheet sh = wb.getSheet(sheetname);
	    int lastrow = sh.getLastRowNum()+1;
	    int lastcell = sh.getRow(0).getLastCellNum();
	    Object[][] obj=new Object[lastrow][lastcell];
	    for(int i=0;i<lastrow;i++) {
	    	for(int j=0;j<lastcell;j++) {
	    		obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
	    	}
	    }
	   
	   return obj;
   }

}

