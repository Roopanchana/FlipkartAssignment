package com.flipkart.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.flipkart.qa.base.TestBase;


public class ExcelUtil extends TestBase{


	
public static Map<String, String> getMap() throws IOException {
		HashMap<String, String> data = new HashMap<String, String>();
		try {
			//FileInputStream fileInput = new FileInputStream("/Users/sabithahammed/OneDrive/Book 1.xlsx");
			FileInputStream fileInput = new FileInputStream("C:\\Users\\ROOPANCHANA KS\\eclipse-workspace\\AutomationProjectId\\src\\main\\java\\com\\flipkart\\qa\\testdata\\Flipcart.xlsx");
			Workbook workbook = new XSSFWorkbook(fileInput);
			Sheet sheet = workbook.getSheet("Sheet1");
			
			
			for(int i=0;i<3;i++) {
				data.put(sheet.getRow(0).getCell(i).toString(), sheet.getRow(1).getCell(i).toString());
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	
		return data;
	}

}




