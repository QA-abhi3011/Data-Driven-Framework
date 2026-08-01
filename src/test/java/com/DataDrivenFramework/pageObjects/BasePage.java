package com.DataDrivenFramework.pageObjects;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.DataDrivenFramework.utilities.ReportingFactory;

public class BasePage {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

    /* =====================
    WAIT UTILITIES
    ===================== */
	
	protected WebElement waitForVisibility(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	protected WebElement waitForClickable(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	
	/* ================
	 * COMMON ACTIONS
	 */
	
	
	protected void click(By locator, String elementName){
		//Each step action log
		ReportingFactory.getTest().info("Clicking " + elementName);
		waitForClickable(locator).click();

	}
	
	protected void type(By locator, String text, String elementName) {
		ReportingFactory.getTest().info("Entering the value into " + elementName);
		WebElement element = waitForClickable(locator);
		element.clear();
		element.sendKeys(text);
	}
	
	protected void getText(By locator, String elementName) {
		ReportingFactory.getTest().info("Extracting text for " + elementName);
		WebElement element = waitForClickable(locator);
		element.getText();
	}
	
    protected boolean isDisplayed(By locator, String elementName) {
    	ReportingFactory.getTest().info("Validating visibility of " + elementName);
		try {
			WebElement el = waitForVisibility(locator);
			return el.isDisplayed();
		}catch(Exception e) {
			return false;
		}
    }
}
