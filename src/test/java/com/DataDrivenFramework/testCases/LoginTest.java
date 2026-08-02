package com.DataDrivenFramework.testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.DataDrivenFramework.pageObjects.LoginPage;
import com.DataDrivenFramework.utilities.DriverFactory;
import com.DataDrivenFramework.utilities.RetryAnalzyer;
import com.DataDrivenFramework.utilities.TestDataProvider;

public class LoginTest extends BaseClass{
	
	@Test(dataProvider="LoginData",
		dataProviderClass = TestDataProvider.class, 
		retryAnalyzer = RetryAnalzyer.class, 
		description="Verify login with valid credentials")
		public void loginTest(String username, String password) {
		
		LoginPage lp = new LoginPage(DriverFactory.getDriver());
		
		lp.login(username, password);
		
		String statusTxt = lp.loginStatus();
		
		Assert.assertEquals(statusTxt, "Welcome, admin!");
		
	}
	
	

}
