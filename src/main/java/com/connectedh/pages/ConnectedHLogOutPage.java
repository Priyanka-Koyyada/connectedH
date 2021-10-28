package com.connectedh.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConnectedHLogOutPage extends BaseConnectedHAutomationPage {
	@FindBy(xpath = "//img[@src='https://images-website.s3.ap-south-1.amazonaws.com/user.svg']")
	private WebElement profileicon;

	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement LogOut;
	private static final Logger logger = Logger.getLogger(ConnectedHLogOutPage.class.getName());

	public ConnectedHLogOutPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnProfileIcon() {
		logger.info(" Starting of clickOnProfileIcon method ");

		this.mouseHoverActions(profileicon);
		this.clickOnLogOut();

		logger.info("Ending of selectPhlebo method");

	}

	public void clickOnLogOut() {
		logger.info(" Starting of clickOnLogOut method ");

		
		logger.info("Ending of clickOnLogOut method");

	}

}
