package com.selenium.bankGuru99.utils.extentReport;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	public static ExtentReports extent;

	public synchronized static ExtentReports getReporter() {
		// set HTML reporting file location
		String workingDir = System.getProperty("user.dir");
		if (System.getProperty("os.name").toLowerCase().contains("win")) {
            extent = new ExtentReports(workingDir + "\\ExtentReports\\ExtentReportResults.html", true);

		} else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
			extent = new ExtentReports(workingDir + "/ExtentReports/ExtentReportResults.html", true);
		}
		return extent;

	}
}
