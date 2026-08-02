package com.DataDrivenFramework.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	
	protected WebElement waitForPresence(By locator) {
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
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
	
	protected String getText(By locator, String elementName) {
		ReportingFactory.getTest().info("Extracting text for " + elementName);
		WebElement element = waitForClickable(locator);
		return element.getText();
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
    
    protected void switchToFrame(By locator) {
    	WebElement element = waitForPresence(locator);
    	driver.switchTo().frame(element);
    	
    }
    
    protected void switchBackToDefault() {
    	driver.switchTo().defaultContent();
    }
    
    protected void enableElement(By locator) {
    	WebElement element = waitForPresence(locator);
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	
    	js.executeScript("arguments[0].style.display = 'block';", element);
    }
}
