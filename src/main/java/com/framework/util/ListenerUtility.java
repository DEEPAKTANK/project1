package com.framework.util;

import java.util.Random;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.framework.baseclass.DriverFactory;
import com.framework.baseclass.TestBase;


public class ListenerUtility implements ITestListener{
	ExtentReports report;
	ExtentTest test;
	protected LogUtility log=new LogUtility();
	CurrentDateAndTime date=new CurrentDateAndTime();
	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName); // test is created which will initialize the individual test execution
		
		Reporter.log(methodName+" => test script execution started",true);
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+" ---> passed");
		Reporter.log(" Successful"+methodName);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.FAIL, methodName+ "---> Failed");
		test.log(Status.FAIL, result.getThrowable());
		Javautility.captureScreenShot(DriverFactory.driver);
		Reporter.log("Failed -"+methodName);
		log.error(methodName);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName +" ---> Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log("skipped -"+methodName);
	}

	@Override
	public void onStart(ITestContext context) {
		Reporter.log("Test started",true);
		
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("./Reports/"+date.getDateNTime()+".html");
		htmlReport.config().setDocumentTitle("OutLook Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("OutLook Report");
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base-Browser", "Chrome");
		report.setSystemInfo("Base-platform", "Windows");
		//report.setSystemInfo("Base-URL", "http://localhost:8888");
		report.setSystemInfo("Reporter Name", "Deepak");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
		Reporter.log("Test Finished.");
		
	}
	
}
