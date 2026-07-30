package com.DataDrivenFramework.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalzyer implements IRetryAnalyzer {

	private int retryCount = 0;
	private static final int MAX_RETRIES = 2;

	@Override
	public boolean retry(ITestResult result) {
		if (retryCount < MAX_RETRIES) {
			retryCount++;
			return true;
			
		}
		return false;	
	}
}
