package vaveTuts.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public  class ExtentReporterNG {
	
	public static ExtentReports getReport() {

	ExtentSparkReporter reporter=new ExtentSparkReporter("user.dir"+"\\reports\\index.html");
	reporter.config().setReportName("Web Automation report");
	reporter.config().setDocumentTitle("TestResults");
	
	ExtentReports extent=new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "vave");
	return extent;
}
}