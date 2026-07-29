package com.DataDrivenFramework.utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
	
	 // This method reads data from Excel and returns it as 2D Object array
	
	public static Object[][] getData(String excelPath, String sheetName){
		
		// Object array to store Excel data
		
		Object[][] data = null;
		
		try {
			// Open the Excel file in read mode
			FileInputStream file = new FileInputStream(excelPath);
			
			// Create Workbook instance (represents entire Excel file)
			Workbook workbook = WorkbookFactory.create(file);
			
			// Access the required sheet by name
			Sheet sheet = workbook.getSheet(sheetName);
			
			// Get total number of rows (including header)
			int rows = sheet.getPhysicalNumberOfRows();
			
			// Get total number of columns from first row (header)
			int cols = sheet.getRow(0).getPhysicalNumberOfCells();
			
			// Create array excluding header row
			data = new Object[rows-1][cols];
			
			// Loop through rows (starting from 1 to skip header)
			for(int i=1; i<rows; i++) {
				//Get Current Row
				Row row = sheet.getRow(i);
				
				// Loop through columns
				for(int j=0; j<cols; j++) {
					//Get Cell value
					Cell cell = row.getCell(j);
					
					//Convert the cell value to String and store in Array
					data[i-1][j] = cell.toString();
				}
				
			}
			
			// Close workbook and file to free memory
            workbook.close();
            file.close();
			
			
		}catch(Exception e) {
            // Print exception details if something goes wrong
            e.printStackTrace();
		}
		
		return data;
	}

}
