package com.DataDrivenFramework.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DynamicTablePage extends BasePage{
	
	public DynamicTablePage(WebDriver driver) {
		super(driver);
	}
	
//--------------------------------------------------Locators-------------------------------------------------------------	
	
	// Dynamic Table Functionality Button
	By btnDynamicTableFunctionalityLocator = By.cssSelector("a[href='/dynamictable']");

	// Table Headers
	By lstTableHeadersLocator = By.xpath("//span[@role='columnheader']");

	// Table Rows (excluding header row)
	By lstTableRowsLocator = By.xpath("//div[@role='row'][span[@role='cell']]");
	
	//Locator for chrome
	By txtChrome = By.xpath("//div[@role='row'][span[text()='Chrome']]");

	// Yellow Label
	By txtChromeCpuLabelLocator = By.xpath("//*[contains(text(),'Chrome CPU')]");
	
//--------------------------------------------------Methods--------------------------------------------------------------
	
	public void clickDynamicTableFunctionalityBtn() {
		click(btnDynamicTableFunctionalityLocator, "dynamic table functionality button");
	}
	
	//Returns CPU column index dynamically
	
	public int getCpuColumnIndex() {
		List<WebElement> headers = waitForVisibilityOfElements(lstTableHeadersLocator);
		
		for(int i=0; i<headers.size(); i++) {
			
			if(headers.get(i).getText().trim().equalsIgnoreCase("CPU")){
				return i+1;
			}
		}
		
		throw new RuntimeException("CPU Column not found.");
	}
	
	//Returns CPU value for Chrome row
	
	public String getChromeCPUValue() {
		int cpuColumn = getCpuColumnIndex();
		
		WebElement chromeRow = driver.findElement(txtChrome);
		
		return chromeRow.findElement(By.xpath("./span["+ cpuColumn + "]")).getText().trim();
		
	}
	
	//Returns value displayed in yellow label
	
	public String getYellowLabelValue() {

		String label = getText(txtChromeCpuLabelLocator, "Chrome CPU label");

		return label.replace("Chrome CPU: ", "").trim();
	}

//--------------------------------------------------Business Actions-----------------------------------------------------
	
	//Opens Dynamic Table page and returns CPU value from table
	public String fetchChromeCpuFromTable() {

		clickDynamicTableFunctionalityBtn();

		return getChromeCPUValue();
	}
	
	//Returns CPU value from yellow label
	public String fetchChromeCpuFromLabel() {

		return getYellowLabelValue();
	}
	
	//Returns true if both values are equal
	
	public boolean compareCpuValues() {

		return getChromeCPUValue().equals(getYellowLabelValue());
	}
	
	
	
}
