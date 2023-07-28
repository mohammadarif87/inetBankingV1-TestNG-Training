package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrivacyErrorPage {
	
	WebDriver ldriver;
	
	public PrivacyErrorPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(id="details-button")
	@CacheLookup
	WebElement btnAdvanced;
	
	@FindBy(id="proceed-link")
	@CacheLookup
	WebElement linkProceed;
	
	public void clickAdvanced()
	{
		btnAdvanced.click();
	}
	
	public void clickProceed()
	{
		linkProceed.click();
	}

}
