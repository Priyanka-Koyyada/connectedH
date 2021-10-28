package com.connectedh.pages;


import org.apache.log4j.Logger;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConnectedHLoginPage extends BaseConnectedHAutomationPage {

	@FindBy(xpath = "//input[@type = 'text']")
	private WebElement email;

	@FindBy(xpath = "//input[@type = 'password']")
	private WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//div[contains(text(),'Total Revenue')]")
	private WebElement TotalRevenue;
	

	private static final Logger logger = Logger.getLogger(ConnectedHLoginPage.class.getName());

	public ConnectedHLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void setUsername(String strUsername) {
		logger.info("Starting of setUsername method");
		this.email.clear();
		this.email.sendKeys(strUsername);

		logger.info("Ending of setUsername method");
	}

	public void setPassword(String strPassword) {
		logger.info("Starting of setPassword method");
		this.password.clear();
		this.password.sendKeys(strPassword);
		logger.info("Ending of setPassword method");
	}

	public void clickOnLoginButton() {
		logger.info("Starting of clickOnLoginButton method");
		this.loginButton.click();
		// clickOnWebElement(loginButton);
		logger.info("Ending of clickOnLoginButton method");

	}
	public void loginToConnectedH(String strUserName, String strPassword) {
		logger.info("Starting of loginToConnectedH method");
		this.setUsername(strUserName);
		this.setPassword(strPassword);
		this.clickOnLoginButton();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("Ending of loginToConnectedH method");
	}
	

	public String getConnectedHDashboardTitle() {
		logger.info("Starting of getConnectedHDashboardTitle method");
		logger.info("Ending of getConnectedHDashboardTitle method");
		return driver.getTitle();
	}
	public String getCompaignManagerText() {
		return TotalRevenue.getText();
	}
		
	}

