package com.DataDrivenFramework.utilities;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

	/**
	 * Provides login test data from Excel
	 *
	 * @return Object[][] containing username, password
	 */

	@DataProvider(name = "LoginData")
	public Object[][] getLoginData() {

		// Build Excel file path dynamically
		String path = System.getProperty("user.dir") + "/src/test/resources/TestData.xlsx";

		// Read data from Excel and return to TestNG
		return ExcelReader.getData(path, "LoginData");

	}
	
	@DataProvider(name = "FileUploadData")
	public Object[][] getFilesToUpload(){
		
		// Build Excel file path dynamically
		String path = System.getProperty("user.dir") + "/src/test/resources/TestData.xlsx";

		// Read data from Excel and return to TestNG
		return ExcelReader.getData(path, "UploadFiles");
	}

}
