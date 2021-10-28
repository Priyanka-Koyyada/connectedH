package com.connectedh.test;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.connectedh.pages.ConnectedHLogOutPage;
import com.connectedh.pages.ConnectedHLoginPage;
import com.connectedh.test.BaseConnectedHAutomationTest.WEB_DRIVER;

public class ConnectedHLogOutTest extends BaseConnectedHAutomationTest{
	private static final Logger logger = Logger.getLogger(ConnectedHLogOutPage.class.getName());

	private WebDriver driver = null;
	
	

	private ConnectedHLogOutPage logoutPage;
	
		
	

	@BeforeClass
	@Parameters({ "browser", "siteURL", "userName", "password" })
	public void initLogin(String browser, String siteURL, String userName, String password) throws Exception {
		logger.info("Starting of initLogin method in ConnectedHLoginTest");

		driver = this.getWebDriver(browser, WEB_DRIVER.LOGIN_DRIVER);
		this.logoutPage= new ConnectedHLogOutPage(driver);
		this.loginPage = new ConnectedHLoginPage(driver);
		this.siteLogin(siteURL, userName, password, driver);
		logger.info("Ending of initLogin method in ConnectedHLoginTest");
	}

	@AfterClass
	public void quitDriver() {
		this.quitDriver(WEB_DRIVER.LOGIN_DRIVER);
	}
	
	@Test(priority = 1,description = "LogOut Test")
	public void LogOutTest() {
		logger.info("Starting of LogOutTest method");
		logoutPage.clickOnProfileIcon();
		logger.info("Ending of LogOutTest method");
	}

}
