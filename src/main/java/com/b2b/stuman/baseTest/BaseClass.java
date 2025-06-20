package com.b2b.stuman.baseTest;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.b2b.stuman.generic.databaseUtility.DatabaseUtility;
import com.b2b.stuman.generic.fileUtility.ExcelUtility;
import com.b2b.stuman.generic.fileUtility.FileUtility;
import com.b2b.stuman.generic.webDriverUtility.JavaUtility;
import com.b2b.stuman.generic.webDriverUtility.UtilityClassObject;
import com.b2b.stuman.objectrepositoryutility.HomePage;
import com.b2b.stuman.objectrepositoryutility.LoginPage;

public class BaseClass {

	public WebDriver driver;
	public DatabaseUtility db = new DatabaseUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	@BeforeSuite(groups = { "smoke", "regression" })
	public void connToDb() {
		System.out.println("connected to db");
		// db.getConnect(null, null, null);
	}

	@Parameters("browser")
	@BeforeClass(groups = { "smoke", "regression" })
	public void launchBrowser(@Optional("chrome") String browser) throws Exception {
		System.out.println("Launch the browser");
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		UtilityClassObject.setDriver(driver);
	}

	@BeforeMethod(groups = { "smoke", "regression" })
	public void login() throws Exception {
		System.out.println("Login to application");
		//String url = fLib.getDataFromPropertyFile("login_url");
		
		String url = System.getProperty("url",fLib.getDataFromPropertyFile("login_url"));
		
//		String emailId = eLib.getCellData("SM_Login", 6, 2);
//		String password = eLib.getCellData("SM_Login", 6, 3);
		
		String emailId = System.getProperty("emailId",eLib.getCellData("SM_Login", 6, 2));
		String password = System.getProperty("password",eLib.getCellData("SM_Login", 6, 3));
		LoginPage lp = new LoginPage(driver);
		
		lp.loginToApp(url, emailId, password);
	}

	@AfterMethod(groups = { "smoke", "regression" })
	public void logout() {
		HomePage homePage = new HomePage(driver);
		homePage.getLogoutBtn();
		System.out.println("Logout from application");
	}

	@AfterClass(groups = { "smoke", "regression" })
	public void closeBrowser() {
		System.out.println("browser closed");
		driver.quit();
	}

	@AfterSuite(groups = { "smoke", "regression" })
	public void colseDb() {
		System.out.println("db connection is closed");
		// db.closeConnection();
		
	}

//	@BeforeTest
//	public void preCondition()
//	{
//		System.out.println("Pre-conditions");
//	}
//	
//	@AfterTest
//	public void postConditions()
//	{
//		System.out.println("Post-conditions");
//	}
}
