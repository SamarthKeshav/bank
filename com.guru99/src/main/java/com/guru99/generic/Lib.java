package com.guru99.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Lib {
	 public String getPropertyData(String property) throws Throwable
	    {
	        FileInputStream fis= new FileInputStream("./src/test/resources/testdata.property");
	        Properties p= new Properties();
	        p.load(fis);
	        String data = p.getProperty(property);
	        return data;
	    }
	/* public String getPropertyLoginPass(String sheet,int row,int cell) throws EncryptedDocumentException, IOException
	 {
		 FileInputStream fin= new FileInputStream("./src/test/resources/Book1.xlsx");
		 Workbook workbook= WorkbookFactory.create(fin);
		 String data=workbook.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return data; 
	 }*/
	 
	 public String getTime()
	 {
		String stamp = LocalDateTime.now().toString().replaceAll(":","-");
		return stamp;
	 }
	 
	 public Object [][] toReadMultipleData(String Sheet1) throws EncryptedDocumentException, IOException {
		 FileInputStream fis= new FileInputStream("./src/test/resources/Book1.xlsx");
		 Workbook wbf= WorkbookFactory.create(fis);
		 Sheet sh = wbf.getSheet(Sheet1);
		 int rowcount=sh.getLastRowNum()+1;
		 int cellcount=sh.getRow(0).getLastCellNum();
		 Object [][] obj=new Object[rowcount][cellcount];
		 for (int i=0;i<rowcount;i++)
		 {
			 for (int j=0;j<cellcount;j++)
			 {
				 obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			 }
		 }
		 return obj;
		 }
}
