package com.DataDrivenFramework.utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportingManager {
	
	private static ExtentReports extent;
	
	public static ExtentReports getExtent() {
		if(extent == null) {
			String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport.html";
			
			File reportDir = new File(System.getProperty("user.dir") + "/reports");
			if (!reportDir.exists()) {
			    reportDir.mkdirs();
			}
			
			ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
			
			spark.config().setReportName("Automation Test Report");
			spark.config().setDocumentTitle("Test Executions Result");
			
			extent = new ExtentReports();
			extent.attachReporter(spark);
		}
		return extent;
	}

}
