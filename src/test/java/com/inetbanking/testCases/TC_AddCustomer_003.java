package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomer_003 extends BaseClass
{
	
	@Test
	public void addCustomer() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		
		//Chrome Privacy Error
		if(driver.getTitle().equals("Privacy error"))
		{
			PrivacyError();
		}
		
		lp.setUserName(username);
		logger.info("Username is provided");
		lp.setPassword(password);
		logger.info("Password is provided");
		lp.clickSubmit();
		logger.info("Submit is clicked");
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		
		driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[2]/a")).sendKeys(Keys.PAGE_DOWN);
		
		Thread.sleep(3000);
		
		addcust.clickAddNewCustomer();
		logger.info("Add Customer Page");
		
		addcust.custName("Arif");
		addcust.custgender("male");
		addcust.custdob("01", "22", "1985");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[2]/a")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(3000);
		
		addcust.custaddress("UK");
		addcust.custcity("LONDON");
		addcust.custstate("GB");
		addcust.custpinno("123456");
		addcust.custtelephoneno("0123456789");
		
		String email = randomString()+"@testuat.co";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		logger.info("Customer details entered");
		
		driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[2]/a")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(3000);
		
		addcust.clicksubmit();
		Thread.sleep(3000);
		logger.info("Submit clicked");
		
		boolean result = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if (result == true)
		{
			Assert.assertTrue(true);
			logger.info("Test Case Passed");
		}
		else
		{
			logger.info("Test Case Failed");
			captureScreen(driver, "addCustomer");
			Assert.assertTrue(false);
		}
	}

}
