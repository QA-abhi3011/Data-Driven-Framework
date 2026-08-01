package com.DataDrivenFramework.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportingManager {

	private static ExtentReports extent;

	public static ExtentReports getExtent() {
		if (extent == null) {
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

			String reportDirectory = System.getProperty("user.dir") + "/reports/";

			String reportPath = reportDirectory + "ExtentReport_" + timeStamp + ".html";

			File reportDir = new File(System.getProperty("user.dir") + "/reports");
			if (!reportDir.exists()) {
				reportDir.mkdirs();
			}

			ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

			spark.config().setReportName("Automation Test Report");
			spark.config().setDocumentTitle("Test Executions Result");
			spark.config().setTheme(Theme.DARK);

			extent = new ExtentReports();
			extent.attachReporter(spark);
		}
		return extent;
	}

}
