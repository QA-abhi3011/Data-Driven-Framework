package com.DataDrivenFramework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage extends BasePage {

	public FileUploadPage(WebDriver driver) {
		super(driver);
	}

//--------------------------------------------------Locators-------------------------------------------------------------
	// File Upload Functionality Locator
	By btnFileUploadFunctionalityLocator = By.cssSelector("a[href='/upload']");

	// File Upload Area Click
	By iFrameAreaLocator = By.cssSelector("iframe[src='/static/upload.html']");

	// File Upload Button Locator
	By txtFileUploadLocator = By.cssSelector("input[type='file']");

	// File Upload Assetion Locators
	By staticTxtSuccessLocator = By.xpath("//div[@class='success-file']/p");

//--------------------------------------------------Methods--------------------------------------------------------------

	public void clickFileUploadFuncBtn() {
		click(btnFileUploadFunctionalityLocator, "file upload functoinality button");
	}

	public void switchToFileUploadArea() {
		switchToFrame(iFrameAreaLocator);
	}

	public void enableFileUploadBtn() {
		enableElement(txtFileUploadLocator);
	}

	public void enterFile(String filePath) {
		type(txtFileUploadLocator, filePath, "file upload button");
	}

//--------------------------------------------------Business Actions---------------------------------------------------

	public void uploadFileUsingBrowser(String filePath) {
		clickFileUploadFuncBtn();
		switchToFileUploadArea();
		enableFileUploadBtn();
		enterFile(filePath);

	}

	public void switchBackToDefault() {
		switchBackToDefault();
	}

	public String getUploadStatus() {
		return getText(staticTxtSuccessLocator, "file upload status");
	}
	
	
}
