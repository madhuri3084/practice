package com.b2b.stuman.generic.listenerUtility;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.b2b.stuman.baseTest.BaseClass;
import com.b2b.stuman.generic.webDriverUtility.JavaUtility;
import com.b2b.stuman.generic.webDriverUtility.UtilityClassObject;

public class ListenerImpleClass implements ITestListener,ISuiteListener{
	public ExtentSparkReporter spark;
	public ExtentReports reports;
	public ExtentTest test;
	public WebDriver driver;
	JavaUtility jLib = new JavaUtility();
	public void onStart(ISuite iSuite)
	{
		// Spark report config
		String time = jLib.getSystemDate("yyyy-MM-dd_HH-mm-ss");
		spark = new ExtentSparkReporter("./AdvanceReport/report"+time+".html");
		spark.config().setDocumentTitle("B2B Test Suite results");
		spark.config().setReportName("Student Management report");
		spark.config().setTheme(Theme.DARK);
	
		//Add Environment information and create test
		reports = new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("os","Windows-11");
		reports.setSystemInfo("Browser","chrome");
	}
	
	public void onTestStart(ITestResult result)
	{
		System.out.println(result.getMethod().getMethodName());
		test = reports.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO,result.getMethod().getMethodName()+" Started" );
		UtilityClassObject.setTest(test);
	}
	
	public void onTestSuccess(ITestResult result)
	{
		System.out.println(result.getMethod().getMethodName());
		test.log(Status.INFO,result.getMethod().getMethodName()+" completed");
	}
	
	public void onTestFailure(ITestResult result)
	{
		String time = jLib.getSystemDate("yyyy:MM:dd_HH:mm:ss");
		String testName = result.getMethod().getMethodName();
		TakesScreenshot ts = (TakesScreenshot) UtilityClassObject.getDriver();
		String srcFile = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(srcFile,testName+"_"+time);
		test.log(Status.INFO,result.getMethod().getMethodName()+" failed");
	}
	
	public void onTestSkipped(ITestResult result)
	{
		test.log(Status.INFO,result.getMethod().getMethodName()+" skipped");
	}
	
	public void onTestFinish(ITestResult result)
	{
		
	}
	
	public void onFinish(ISuite iSuite)
	{
		reports.flush();
		System.out.println("Report backup");
		
	}
}
