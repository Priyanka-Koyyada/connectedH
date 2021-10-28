package com.connectedh.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConnectedHAddPhleboPage extends BaseConnectedHAutomationPage {

	@FindBy(xpath = "//label[contains(text(),'Assign Phlebo')]")
	private WebElement phleboAssertion;

	@FindBy(xpath = "//span[contains(text(), 'Select or Search Phlebo')]")
	private WebElement assignPhlebo;
	
	@FindBy(xpath = "//input[@placeholder=\"Select or Search Phlebo\"]")
	private WebElement setPhlebo;

	@FindBy(xpath = "(//span[contains(text(),'Demo phlebo')])[5]")
	private WebElement selectPhlebo;

	@FindBy(xpath = "//body/div[@id='app']/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]")
	private WebElement clickPayment;

	@FindBy(xpath = "//body/div[@id='app']/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[3]/ul[1]/li[1]/span[1]")
	private WebElement selectPayment;

	@FindBy(xpath = "//body/div[@id='app']/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/input[1]")
	private WebElement amountPaid;

	@FindBy(xpath = "//div[7]//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//input[1]")
	private WebElement clickTest;

	@FindBy(xpath = "//body/div[@id='app']/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[7]/div[1]/div[1]/div[2]/button[1]")
	private WebElement addTest;

	@FindBy(xpath = "//label[text()='Samples']/parent::div/*/*/*/*//input[@type='search']")
	private WebElement clickSample;

	@FindBy(xpath = "//a[normalize-space()='Blood Culture']")
	private WebElement selectSample;

	@FindBy(xpath = "//body/div[@id='app']/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[8]/div[1]/div[1]/div[2]/button[1]")
	private WebElement addSample;

	@FindBy(xpath = "//a[contains(text(),'Save')]")
	private WebElement save;

	@FindBy(xpath = "//h2[contains(text(),'Booking Created!')]")
	private WebElement BookingCreated;

	private static final Logger logger = Logger.getLogger(ConnectedHLoginPage.class.getName());

	public ConnectedHAddPhleboPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String getAssignPhleboTest() {
		return phleboAssertion.getText();
	}

	public void selectPhlebo(String demoValue) {
		logger.info("Starting of selectPhlebo method");
		
		this.assignPhlebo.click();
		this.setPhlebo.sendKeys(demoValue + Keys.ENTER);

		logger.info("Ending of selectPhlebo method");

	}

	public void selectPayment(String amountValue) {
		logger.info("Starting of selectPayment method");
		this.clickPayment.click();
		this.selectPayment.click();
		this.amountPaid.sendKeys(amountValue);
		logger.info("Ending of selectPayment method");

	}

	public void addTest(String testName) {

		logger.info("Starting of addTest method");

		this.clickTest.sendKeys(testName);
		this.clickTest.sendKeys(Keys.ENTER);

		logger.info("Ending of addTest method");

	}

	public void addSample() {

		logger.info("Starting of addSample method");

		this.clickSample.click();
		this.selectSample.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.addSample.click();
		this.addTest.click();

		this.scrollIntoView(save);

		logger.info("Ending of addSample method");

	}

	public void clickOnSavePhlebo() {
		logger.info("Starting of clickOnSavePhlebo method");

		this.save.click();

		logger.info("Ending of clickOnSavePhlebo method");
	}

	public String getBookingCreatedText() {
		return BookingCreated.getText();
	}
}