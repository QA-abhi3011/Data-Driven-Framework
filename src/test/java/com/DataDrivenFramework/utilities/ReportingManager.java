package com.DataDrivenFramework.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportingManager {
	
	private static ExtentReports extent;
	
	public static ExtentReports getExtent() {
		if(extent == null) {
			String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport.html";
			
			ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
			
			spark.config().setReportName("Automation Test Report");
			spark.config().setDocumentTitle("Test Executions Result");
			
			extent = new ExtentReports();
			extent.attachReporter(spark);
		}
		return extent;
	}

}
