package vaveTuts.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import vaveTuts.resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener{
	
	ExtentTest test;
	
	ExtentReports extent=ExtentReporterNG.getReport();
	
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		
		test=extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		
		    // not implemented
	  }
	public  void onTestFailure(ITestResult result) {
	    // not implemented
		extentTest.get().fail(result.getThrowable()); 
		String path=null;
		 try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
			 path=takeFailureScreenshot(result.getMethod().getMethodName(), driver);
			
		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}extentTest.get().addScreenCaptureFromPath(path, result.getMethod().getMethodName());
		
	  }
	
	 public  void onFinish(ITestContext context) {
		    extent.flush();
		  }

}
