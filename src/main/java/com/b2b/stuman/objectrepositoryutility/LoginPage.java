package com.b2b.stuman.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.b2b.stuman.generic.webDriverUtility.WebDriverUtility;

/**
 * 
 * @author madhuri
 * 
 * contains login page elements and business library like login()
 * 
 * 
 */


public class LoginPage extends WebDriverUtility {
	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement usernameOrEmailEdt;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordEdt;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitBtn;
	
	public WebElement getUsernameOrEmail()
	{
		return usernameOrEmailEdt;
	}
	
	public WebElement getPassword()
	{
		return passwordEdt;
	}
	
	public WebElement getLoginBtn()
	{
		return submitBtn;
	}
	
	/**
	 * Login to application based on username ,password ,url arguments
	 * @param url
	 * @param usernameOrEmail
	 * @param password
	 */
	
	public void loginToApp(String url,String usernameOrEmail,String password)
	{
		waitForPageToLoad(driver);
		driver.get(url);
		usernameOrEmailEdt.sendKeys(usernameOrEmail);
		passwordEdt.sendKeys(password);
		mouseMoveOnElementAndClick(driver, submitBtn);
	}
}
