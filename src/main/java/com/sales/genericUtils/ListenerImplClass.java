package com.sales.genericUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplClass implements ITestListener {
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		//Actual Testscripts Execution starts from here.
		String MethodName = result.getMethod().getMethodName();
		 test = report.createTest(MethodName);
		Reporter.log(MethodName+"---> Execution starts");
	
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS,MethodName+"--->Testscripts executed succesfully" );
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		String failedscript = WebDriverUtility.takeScreenshot(BaseClass.sdriver, MethodName);
		test.addScreenCaptureFromPath(failedscript);
		
		test.log(Status.FAIL, result.getThrowable());
		test.log(Status.FAIL, MethodName+"--->Failed");
		Reporter.log(MethodName+"--->Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, result.getThrowable());
		test.log(Status.SKIP, MethodName+"--->skipped" );
		Reporter.log(MethodName+"--->skipped");
		
	}

	@Override
	public void onStart(ITestContext context) {
		//create reports
	 ExtentSparkReporter htmlrepot=new ExtentSparkReporter("./Extentreport/report.html");
	 htmlrepot.config().setDocumentTitle("SDET-51");
	 htmlrepot.config().setTheme(Theme.DARK);
	 htmlrepot.config().setReportName("Sales-and-inventory");
	 
	 report=new ExtentReports();
	 report.attachReporter(htmlrepot);
	 report.setSystemInfo("OS", "Window-11");
	 report.setSystemInfo("Base-Browser", "chrome");
	 report.setSystemInfo("Base-URL", "http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/login.php");
	 report.setSystemInfo("Reporter-Name", "Tanya");
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}
	

}
