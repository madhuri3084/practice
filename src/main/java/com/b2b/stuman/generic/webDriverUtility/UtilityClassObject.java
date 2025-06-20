package com.b2b.stuman.generic.webDriverUtility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityClassObject 
{
	static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public static ExtentTest getTest() {
		return test.get();
	}
	public static void setTest(ExtentTest act_Test) {
		test.set(act_Test);
	}
	public static WebDriver getDriver() {
		return driver.get();
	}
	public static void setDriver(WebDriver act_driver) {
		driver.set(act_driver);
	}
}
