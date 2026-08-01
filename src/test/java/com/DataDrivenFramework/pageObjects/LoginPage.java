package com.DataDrivenFramework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
//--------------------------------------------------Locators-------------------------------------------------------------	
	
	//Locator of Sample App used to demonstrate the login
	
	private By btnSampleAppLocator = By.cssSelector("a[href='/sampleapp']");
	
	//Username field locator
	private By txtUsernameLocator = By.xpath("//input[@name='UserName']");
	
	//Password field locator
	private By txtPasswordLocator = By.xpath("//input[@name='Password']");
	
	//Login Btn Locator
	private By btnLoginLocator = By.id("login");
	
//------------------------------------------------Methods------------------------------------------------------------------
	
	//Methods to perform login action
	public void navigateSampleApp() {
		click(btnSampleAppLocator, "Sample app button");
	}
	
	//Method to enter the username
	public void enterUserName(String text) {
		type(txtUsernameLocator, text, "username field");
	}
	
	//Method to enter the password
	public void enterPassword(String text) {
		type(txtPasswordLocator, text, "password field");
	}
	
	//Method to click the login button
	public void clickLoginBtn() {
		click(btnLoginLocator, "login button");
	}
	
//-------------------------------------------------Business Actions---------------------------------------------------------------
	
	public void login(String username, String password) {
			
		navigateSampleApp();
		enterUserName(username);
		enterPassword(password);
		clickLoginBtn();
	}
}
