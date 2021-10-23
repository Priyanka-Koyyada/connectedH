package com.connectedh.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConnectedHBookingManagerPage extends BaseConnectedHAutomationPage {

	@FindBy(xpath = "//a[contains(text(),'Booking Manager')]")
	private WebElement bookingManager;

	@FindBy(xpath = "//div[contains(text(),'New Booking')]")
	private WebElement newBooking;

	@FindBy(xpath = "//span[contains(text(),'Select or Search Affiliate')]")
	private WebElement clickAffiliate;
	
	@FindBy(xpath="//span[contains(text(),'LGP1')]")
	private WebElement selectAffiliate;
	
	@FindBy(xpath = "//span[contains(text(),'Select or Search SPL')]")
	private WebElement clickSPL;
	
	//span[normalize-space()='28']
	
	@FindBy(xpath="//span[contains(text(),'Neuberg diagnostics')]")
	private WebElement selectSPL;
	
	@FindBy(xpath = "//input[@placeholder='Collection Date']")
	private WebElement selectDate;
	
	@FindBy(xpath="//span[contains(text(),'Slot')]")
	private WebElement clickSlot;
	
	
	@FindBy(xpath="//input[@placeholder='Patient Name']")
	private WebElement patientName;
	
	@FindBy(xpath="//input[@placeholder='Patient Phone']")
	private WebElement patientPhone;
	
	@FindBy(xpath="//input[@placeholder='Patient Alternate Number']")
	private WebElement patientalternateNumber;
	
	@FindBy(xpath="//input[@placeholder='Patient Email']")
	private WebElement patientEmail;
	
	@FindBy(xpath="//input[@placeholder='Patient Age']")
	private WebElement patientAge;
	
	@FindBy(xpath="//span[contains(text(),'Select Gender')]")
	private WebElement clickGender;
	
	@FindBy(xpath="//span[contains(text(),'Select Gender')]")
	private WebElement selectGender;
	
	
	@FindBy(xpath="//input[@placeholder='Patient Address']")
	private WebElement patientAddress;
	
	@FindBy(xpath="//input[@placeholder='Pincode']")
	private WebElement patientPincode;
	
	@FindBy(xpath="//span[normalize-space()='Select']")
	private WebElement clickZone;
	
	@FindBy(xpath="//input[@placeholder='Enter a location']")
	private WebElement patientGoogleAddress;
	
	
	
	
	
	
	


	private static final Logger logger = Logger.getLogger(ConnectedHLoginPage.class.getName());

	public ConnectedHBookingManagerPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}


	public void clickOnBookinghManager() {
		logger.info("Starting of clickOnBookinghManager method");
		this.bookingManager.click();
		// clickOnWebElement(loginButton);
		logger.info("Ending of clickOnBookinghManager method");

	}
	
	public void clickOnNewBooking() {
		logger.info("Starting of clickOnNewBooking method");
		this.newBooking.click();
		
		logger.info("Ending of clickOnNewBooking method");
	}
	
	public void selectAffiliate() {
		logger.info("Starting of selectAffiliate method");
		this.clickAffiliate.click();
		this.selectAffiliate.click();
		
		logger.info("Ending of selectAffiliate method");
	}
	
	public void selectSPL() {
		logger.info("Starting of selectSPL method");
		this.clickSPL.click();
		this.selectSPL.click();
		
		logger.info("Ending of selectSPL method");
	}
	
	
//	public void createBooking(String strUserName, String strPassword) {
//		logger.info("Starting of loginToConnectedH method");
//		this.setUsername(strUserName);
//		this.setPassword(strPassword);
//		this.clickOnLoginButton();
//		try {
//			Thread.sleep(6000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		logger.info("Ending of loginToConnectedH method");
//	}
	
	
	public void selectDate(String dateValue) {
		logger.info("Starting of selectDate method");
		
		this.selectDate.click();
		WebElement date = driver.findElement(By.xpath("//span[normalize-space()='"+dateValue+"']"));
		date.click();
		
		logger.info("Ending of selectDate method");
	}
	
	public void selectSlot(String slotValue) {
		logger.info("Starting of selectSlot method");
		this.clickSlot.click();
		WebElement slot = driver.findElement(By.xpath("//span[contains(text(),'"+slotValue+"')]"));
		//08:30 - 09:00 AM
		slot.click();
		logger.info("Ending of selectSlot method");	
	}
	
	public void patientDetails(String pName, String pEmail, String pPhone, String aPhone, String pAge,String pPin, String zoneValue, String pAddress, String pGAddress) {
		logger.info("Starting of patientDetail method");
		this.patientName.sendKeys(pName);
		this.patientPhone.sendKeys(pPhone);
		this.patientalternateNumber.sendKeys(aPhone);
		this.patientPhone.sendKeys(pAge);
		this.clickGender.click();
		this.patientAddress.sendKeys(pPin);
		this.clickZone.click();
		WebElement zone = driver.findElement(By.xpath("//span[normalize-space()='"+zoneValue+"']"));
		zone.click();
		this.patientGoogleAddress.sendKeys(pGAddress);
		logger.info("Ending of patientDetail method");
	}
}
