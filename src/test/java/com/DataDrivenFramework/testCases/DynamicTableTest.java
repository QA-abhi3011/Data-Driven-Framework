package com.DataDrivenFramework.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.DataDrivenFramework.pageObjects.DynamicTablePage;
import com.DataDrivenFramework.utilities.DriverFactory;
import com.DataDrivenFramework.utilities.RetryAnalyzer;

public class DynamicTableTest extends BaseClass {
	
	@Test(retryAnalyzer=RetryAnalyzer.class,
		  description="Dynamic Table Data Handling")
	public void dynamicTableHandle() {
		
		DynamicTablePage dp = new DynamicTablePage(DriverFactory.getDriver());
		
		dp.fetchChromeCpuFromTable();
		
		dp.fetchChromeCpuFromLabel();
		
		Assert.assertTrue(dp.compareCpuValues());
	}

}
