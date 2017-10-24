package com.PHPTravels.generic;
import java.io.FileInputStream;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Lib {
	public static String getProperty(String path, String key)
	{
		String value="";
		try{
			Properties p= new Properties();
			p.load(new FileInputStream(path));
			value= p.getProperty(key);
			}
		catch (Exception e) {
			
		}
return value;
}
	public static String getCellValue(String xlpath,String sheet,int r,int c){
		String v="";
		try{
			Workbook wb=WorkbookFactory.create(new FileInputStream(xlpath));		
			v=wb.getSheet(sheet).getRow(r).getCell(c).toString();
		}
		catch(Exception e){
		}
		return v;
		
	}
	public static int getRowCount(String xlpath,String sheet){
		  int rc=0;
		   try{
				Workbook wb=WorkbookFactory.create(new FileInputStream(xlpath));		
				rc=wb.getSheet(sheet).getLastRowNum();
			  }
		    catch(Exception e){
				}
			return rc;	
		 }
	
}


