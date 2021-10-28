package com.connectedh.test;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.connectedh.pages.ConnectedHBookingManagerPage;
import com.connectedh.pages.ConnectedHLoginPage;

public class ConnectedHBookingManagerTest extends BaseConnectedHAutomationTest {
	private static final Logger logger = Logger.getLogger(ConnectedHBookingManagerTest.class.getName());
	private ConnectedHBookingManagerPage bookingPage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "userName", "password" })
	public void initLogin(String browser, String siteURL, String userName, String password) throws Exception {
		logger.info("Starting of initLogin method in ConnectedHLoginTest");

		this.driver = this.getWebDriver(browser, WEB_DRIVER.BOOKING_DRIVER);

		this.loginPage = new ConnectedHLoginPage(driver);
		this.bookingPage = new ConnectedHBookingManagerPage(driver);
		this.siteLogin(siteURL, userName, password, driver);
		logger.info("Ending of initLogin method in ConnectedHLoginTest");
	}

	@Test(priority = 1, description = "Booking Manager")
	public void navigatingToBookingManagerTest() {
		logger.info("Starting of bookingManager method");

		bookingPage.clickOnBookinghManager();

		/*
		 * String actualText = this.bookingPage.getBookingManagerText();
		 * Assert.assertEquals(actualText,
		 * expectedAssertionsProp.getProperty("connectedh.Booking.Manager.text"));
		 */
		bookingPage.clickOnNewBooking();

		logger.info("Ending of navigatingToInsights method");

	}

	@Test(priority = 2, description = "Booking Details")
	public void enterBookingDetailsTest() {
		logger.info("Starting of enterBookingDetails method");

		/*
		 * String actualText = this.bookingPage.getSelectAffiliateText();
		 * Assert.assertEquals(actualText,
		 * expectedAssertionsProp.getProperty("connectedh.select.affiliate.text"));
		 */
		bookingPage.selectAffiliate();
		bookingPage.selectSPL();
		bookingPage.selectDate(testDataProp.getProperty("date"));
		bookingPage.selectSlot(testDataProp.getProperty("slot"));

		logger.info("Ending of enterBookingDetails method");

	}

	@Test(priority = 3, description = "Booking Details")
	public void enterPatientDetailsTest() {
		logger.info("Starting of enterPatientDetails method");

		bookingPage.patientDetails(testDataProp.getProperty("pName"), testDataProp.getProperty("pEmail"),
				testDataProp.getProperty("pPhone"), testDataProp.getProperty("aPhone"),
				testDataProp.getProperty("pAge"));

		logger.info("Ending of enterPatientDetails method");

	}

	@Test(priority = 4, description = "Booking Details")
	public void enterZoneDetailsTest() {
		logger.info("Starting of enterZoneDetails method");

		bookingPage.selectZone(testDataProp.getProperty("zoneValue"));

		logger.info("Ending of enterZoneDetails method");
	}

	@Test(priority = 5, description = "Set Address")
	public void setAddress() {
		logger.info("Starting of setAddress method");

		bookingPage.setAddress(testDataProp.getProperty("pAddress"), testDataProp.getProperty("pPin"),
				testDataProp.getProperty("pGAddress"));

		

		logger.info("Ending of setAddress method");
	}
	
	@Test(priority = 6, description="Next Button") 
	public void moveToNextTest() {
		logger.info("Starting of moveToNextTest method");
		
		bookingPage.clickOnNextButton();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		logger.info("Ending of moveToNextTest method");
	}

}
