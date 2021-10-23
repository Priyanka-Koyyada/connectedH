package com.connectedh.test;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.connectedh.pages.ConnectedHBookingManagerPage;
import com.connectedh.pages.ConnectedHLoginPage;
import com.connectedh.test.BaseConnectedHAutomationTest.WEB_DRIVER;

public class ConnectedHBookingManagerTest extends BaseConnectedHAutomationTest {
	private static final Logger logger = Logger.getLogger(ConnectedHBookingManagerTest.class.getName());

	private WebDriver driver = null;

	private ConnectedHBookingManagerPage bookingPage;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "userName", "password" })
	public void initLogin(String browser, String siteURL, String userName, String password) throws Exception {
		logger.info("Starting of initLogin method in ConnectedHLoginTest");

		driver = this.getWebDriver(browser, WEB_DRIVER.BOOKING_DRIVER);

		this.loginPage = new ConnectedHLoginPage(driver);
		this.bookingPage = new ConnectedHBookingManagerPage(driver);
		this.siteLogin(siteURL, userName, password, driver);
		logger.info("Ending of initLogin method in ConnectedHLoginTest");
	}

	@AfterClass
	public void quitDriver() {
		this.quitDriver(WEB_DRIVER.BOOKING_DRIVER);
	}
 
	@Test(priority = 1, description = "Booking Manager")
	public void navigatingToBookingManager() {
		logger.info("Starting of bookingManager method");
		
		bookingPage.clickOnBookinghManager();
		bookingPage.clickOnNewBooking();
		
		logger.info("Ending of navigatingToInsights method");

	}
	
	@Test(priority = 2, description = "Booking Details")
	public void enterBookingDetails() {
		logger.info("Starting of enterBookingDetails method");
		
		bookingPage.selectAffiliate();
		bookingPage.selectSPL();
		bookingPage.selectDate(testDataProp.getProperty("date"));
		bookingPage.selectSlot(testDataProp.getProperty("slot"));
		
		logger.info("Ending of enterBookingDetails method");

	}

	@Test(priority = 3, description = "Booking Details")
	public void enterPatientDetails() {
		logger.info("Starting of enterPatientDetails method");
		
		bookingPage.patientDetails(
				testDataProp.getProperty("name"), 
				testDataProp.getProperty("phone"), 
				testDataProp.getProperty("alternatephone"), ,
				testDataProp.getProperty("Email"), 
				testDataProp.getProperty("Age"), 
				testDataProp.getProperty("patientAddress"), 
				testDataProp.getProperty("pincode"), 
				testDataProp.getProperty("zone"), 
				loginURL, 
				browserDriverPath);
		
		logger.info("Ending of enterPatientDetails method");

	}
	
}
