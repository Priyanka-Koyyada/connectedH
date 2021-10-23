package com.connectedh.test;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.connectedh.pages.ConnectedHLoginPage;

public class ConnectedHLoginTest extends BaseConnectedHAutomationTest {
	private static final Logger logger = Logger.getLogger(ConnectedHLoginTest.class.getName());

	private WebDriver driver = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "userName", "password" })
	public void initLogin(String browser, String siteURL, String userName, String password) throws Exception {
		logger.info("Starting of initLogin method in ConnectedHLoginTest");

		driver = this.getWebDriver(browser, WEB_DRIVER.LOGIN_DRIVER);

		this.loginPage = new ConnectedHLoginPage(driver);
		this.siteLogin(siteURL, userName, password, driver);
		logger.info("Ending of initLogin method in ConnectedHLoginTest");
	}

	@AfterClass
	public void quitDriver() {
		this.quitDriver(WEB_DRIVER.LOGIN_DRIVER);
	}

	@Test
	public void loginTest() {
		logger.info("Starting of loginTest method");
		String actualTitle = this.loginPage.getConnectedHDashboardTitle();
		Assert.assertEquals(actualTitle, expectedAssertionsProp.getProperty("connectedh.dashboard.title"));
		logger.info("Ending of loginTest method");
	}

}
