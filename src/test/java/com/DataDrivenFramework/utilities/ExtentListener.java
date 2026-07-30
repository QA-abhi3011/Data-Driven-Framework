package com.DataDrivenFramework.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentListener implements ITestListener {

	private static ExtentReports extent = ReportingManager.getExtent();
	
    @Override
    public void onStart(ITestContext context) {
        extent.setSystemInfo("Project", "Selenium Data Driven Framework");
        extent.setSystemInfo("Tester", "Abhishek Gautam");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        extent.setSystemInfo("Browser", ConfigReader.getProperty("browser"));
    }
	
	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest test = extent.createTest(result.getMethod().getMethodName());
		
		ReportingFactory.setTest(test);
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		ReportingFactory.getTest().pass("Test Passed");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		String screenshotPath = ScreenshotUtils.captureScreenshot(result.getMethod().getMethodName());
		
		try {
		ReportingFactory.getTest().fail(result.getThrowable()).addScreenCaptureFromPath(screenshotPath);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		ReportingFactory.getTest().skip(result.getThrowable());
	}
	
	@Override
	public void onFinish(org.testng.ITestContext context) {
		extent.flush();
		System.out.println("Execution Completed...");
	}
	
	

}
