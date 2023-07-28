package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException, IOException
	{
		logger.info("URL is opened");
		
		LoginPage lp = new LoginPage(driver);
		
		//Chrome Privacy Error
		if(driver.getTitle().equals("Privacy error"))
		{
			PrivacyError();
		}
		
		lp.setUserName(user);
		logger.info("username is provided");
		lp.setPassword(pwd);
		logger.info("password is provided");
		lp.clickSubmit();
		logger.info("Submit is clicked");
		
		Thread.sleep(3000);
		
		if (isAlertPresent() == true)
		{
			driver.switchTo().alert().accept(); //close alert
			
			driver.switchTo().defaultContent(); //focus back to main browser page
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login passed");
			
			lp.clickLogout();
			
			Thread.sleep(3000);
			
			driver.switchTo().alert().accept(); //Close the Logout alert
			driver.switchTo().defaultContent();
		}
		
	}
	
	public boolean isAlertPresent() //User defined method to check if alert is present or not on browser
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch (NoAlertPresentException e)
		{
			return false;
		}
	}
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return logindata;
	}
	
}
