package com.DataDrivenFramework.utilities;

import com.aventstack.extentreports.ExtentTest;

public class ReportingFactory {

	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	
	public static void setTest(ExtentTest test) {
		extentTest.set(test);
	}
	
	public static ExtentTest getTest() {
		return extentTest.get();
	}
}
