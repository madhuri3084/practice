package com.b2b.stuman.objectrepositoryutility;

import java.awt.Desktop.Action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.b2b.stuman.generic.webDriverUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//div[@class='user-profile']")
	private WebElement profileBtn;
	
	@FindBy(linkText = " Logout")
	private WebElement logoutBtn;

	public WebElement getProfileBtn() {
		return profileBtn;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
	
	public void logoutFromApp() throws Exception {
		profileBtn.click();
		logoutBtn.click();
	}
}
