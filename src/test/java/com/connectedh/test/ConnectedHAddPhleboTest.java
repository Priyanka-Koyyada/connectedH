package com.connectedh.test;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.connectedh.pages.ConnectedHAddPhleboPage;

public class ConnectedHAddPhleboTest extends BaseConnectedHAutomationTest {

	private static final Logger logger = Logger.getLogger(ConnectedHAddPhleboTest.class.getName());

	private ConnectedHAddPhleboPage phleboPage = null;

	@BeforeClass
	@Parameters({ "browser", "siteURL", "userName", "password" })
	public void initLogin(String browser, String siteURL, String userName, String password) throws Exception {
		logger.info("Starting of initLogin method in ConnectedHLoginTest");

		this.driver = this.getWebDriver(browser, WEB_DRIVER.BOOKING_DRIVER);
		this.phleboPage = new ConnectedHAddPhleboPage(driver);

		logger.info("Ending of initLogin method in ConnectedHLoginTest");
	}

	
	  @AfterClass 
	  public void quitDriver() {
	  this.quitDriver(WEB_DRIVER.BOOKING_DRIVER); }
	 
	@Test(priority = 1, description = "Phlebo Details")
	public void assignPhleboTest() {
		logger.info("Starting of assignPhleboTest method");

		String actualText = this.phleboPage.getAssignPhleboTest();
		Assert.assertEquals(actualText, expectedAssertionsProp.getProperty("connectedh.assign.phlebo.text"));

		phleboPage.selectPhlebo(testDataProp.getProperty("phlebo"));

		logger.info("Ending of assignPhleboTest method");

	}

	@Test(priority = 2, description = "Phlebo Payment Details")
	public void selectPaymentTest() {
		logger.info("Starting of selectPaymentTest method");

		phleboPage.selectPayment(testDataProp.getProperty("amountValue"));

		logger.info("Ending of selectPaymentTest method");

	}

	@Test(priority = 3, description = "Phlebo Tests Details")
	public void addTest() {
		logger.info("Starting of selectTest method");

		phleboPage.addTest(testDataProp.getProperty("testName"));

		logger.info("Ending of selectTest method");

	}

	@Test(priority = 4, description = "Phlebo Payment Details")
	public void addSampleTest() {
		logger.info("Starting of addSampleTest method");

		phleboPage.addSample();

		logger.info("Ending of addSampleTest method");

	}

	@Test(priority = 5, description = "Save Phlebo Details")
	public void savePhleboTest() {
		logger.info("Starting of savePhleboTest method");

		phleboPage.clickOnSavePhlebo();

		logger.info("Ending of savePhleboTest method");

		String actualText = this.phleboPage.getBookingCreatedText();
		Assert.assertEquals(actualText, expectedAssertionsProp.getProperty("connectedh.Booking.Created.text"));

	}

}
