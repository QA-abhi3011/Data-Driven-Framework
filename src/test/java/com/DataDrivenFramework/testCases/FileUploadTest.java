package com.DataDrivenFramework.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.DataDrivenFramework.pageObjects.FileUploadPage;
import com.DataDrivenFramework.utilities.DriverFactory;
import com.DataDrivenFramework.utilities.RetryAnalyzer;
import com.DataDrivenFramework.utilities.TestDataProvider;

public class FileUploadTest extends BaseClass{
	
	@Test(dataProvider="FileUploadData", 
		dataProviderClass=TestDataProvider.class,
		retryAnalyzer=RetryAnalyzer.class,
		description="Verify file upload functionality using button")
	public void uploadFileTest(String fileName) {
			
		FileUploadPage fp = new FileUploadPage(DriverFactory.getDriver());
		
		String filePath = System.getProperty("user.dir") + "/src/test/resources/TestFiles/" + fileName;
		
		fp.uploadFileUsingBrowser(filePath);
		
		String statusTxt = fp.getUploadStatus();
		
		Assert.assertTrue(statusTxt.contains(" file(s) selected"), "File Upload successfull");
		
	}
	
	@Test(dataProvider="FileUploadData",
		  dataProviderClass=TestDataProvider.class,
		  retryAnalyzer=RetryAnalyzer.class,
		  description="Verify file upload functionality using drag & drop")
	public void uploadFileDragNDropTest() {
		
	}

}
