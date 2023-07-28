package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass 
{
	@Test
	public void loginTest() throws InterruptedException, IOException
	{
		logger.info("URL is opened");
		
		LoginPage lp = new LoginPage(driver);
		
		if(driver.getTitle().equals("Privacy error"))
		{
			PrivacyError();
		}
		
		lp.setUserName(username);
		logger.info("Entered username");
		
		lp.setPassword(password);
		logger.info("Entered password");
		
		lp.clickSubmit();
		logger.info("Submit is clicked");
		
		Thread.sleep(1000);
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			driver.getTitle().equals("Guru99 Bank Manager HomePage");
			logger.info("Page Title is correct");
			
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else
		{
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
		
	}
}
