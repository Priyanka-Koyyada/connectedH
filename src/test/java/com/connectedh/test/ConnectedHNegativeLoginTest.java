//package com.connectedh.test;
//
//import org.apache.log4j.Logger;
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import com.connectedh.pages.ConnectedHLoginPage;
//
//public class ConnectedHNegativeLoginTest extends BaseConnectedHAutomationTest {
//	private static final Logger logger = Logger.getLogger(ConnectedHNegativeLoginTest.class.getName());
//
//	private WebDriver driver = null;
//
//	@BeforeClass
//	@Parameters({ "browser" })
//	public void initConnectedHLogin(String browser) throws Exception {
//		logger.info("Starting of initConnectedHLogin method in ConnectedHNegativeLoginTest");
//
//		driver = this.getWebDriver(browser, WEB_DRIVER.NEGATIVE_LOGIN_DRIVER);
//		this.goToSite(this.driver);
//		this.loginPage = new ConnectedHLoginPage(driver);
//
//		logger.info("Ending of initConnectedHLogin method in ConnectedHNegativeLoginTest");
//	}
//
//	@AfterClass
//	public void quitDriver() {
//		this.quitDriver(WEB_DRIVER.NEGATIVE_LOGIN_DRIVER);
//	}
//
//	@Parameters({ "password" })
//	@Test(priority = 1, description = "Invalid Email Address")
//	public void invalidEmail(String password) throws InterruptedException {
//		logger.info("Starting of invalidEmail method");
//
//		loginPage.setUsername(testDataProp.getProperty("invalid.email"));
//
//		loginPage.setPassword(password);
//
//		loginPage.clickOnLoginButton();
//
//		String actualTitle = this.loginPage.getInvalidEmailText();
//		Assert.assertEquals(actualTitle, expectedAssertionsProp.getProperty("invalid.email.text"));
//
//		logger.info("Ending of invalidEmail method");
//	}
//
//	@Parameters({ "userName" })
//	@Test(priority = 2, description = "Invalid Password")
//	public void invalidPassword(String userName) throws InterruptedException {
//		logger.info("Starting of invalidPassword method");
//
//		loginPage.setUsername(userName);
//
//		loginPage.setPassword(testDataProp.getProperty("invalid.password"));
//
//		loginPage.clickOnLoginButton();
//
//		String actualTitle = this.loginPage.getInvalidPasswordText();
//		Assert.assertEquals(actualTitle, expectedAssertionsProp.getProperty("invalid.password.text"));
//
//		logger.info("Ending of invalidPassword method");
//	}
//
//	@Test(priority = 3, description = "Invalid Email & Password")
//	public void invalidEmailAndPassword() throws InterruptedException {
//		logger.info("Starting of invalidEmailAndPassword method");
//
//		loginPage.setUsername(testDataProp.getProperty("invalid.email"));
//
//		loginPage.setPassword(testDataProp.getProperty("invalid.password"));
//
//		loginPage.clickOnLoginButton();
//
//		// Thread.sleep(2000);
//
//		// loginPage.clickOnOk();
//
//		String actualTitle = this.loginPage.getInvalidEmailText();
//		Assert.assertEquals(actualTitle, expectedAssertionsProp.getProperty("invalid.email.text"));
//
//		logger.info("Ending of invalidEmailAndPassword method");
//	}
//
//}
