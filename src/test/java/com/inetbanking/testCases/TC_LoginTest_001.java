package com.inetbanking.testCases;


import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.reports.ExtFactory;
import com.aventstack.extentreports.Status;
import com.inetbanking.base.BaseClass;
import com.inetbanking.pageObjects.LoginPage;


public class TC_LoginTest_001 extends BaseClass
{

	@Test
	public void loginTest() throws IOException 
	{
			
		logger.info("URL is opened");
		ExtFactory.getInstance().getExtent().log(Status.INFO, "URL is opened");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered username");
		ExtFactory.getInstance().getExtent().log(Status.INFO, "Entered username");
		
		lp.setPassword(password);
		logger.info("Entered password");
		ExtFactory.getInstance().getExtent().log(Status.INFO, "Entered password");
		
		lp.clickSubmit();
		logger.info("Submitted");
		ExtFactory.getInstance().getExtent().log(Status.INFO, "Submitted");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
			ExtFactory.getInstance().getExtent().log(Status.PASS, "Login test passed");
		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
			ExtFactory.getInstance().getExtent().log(Status.FAIL, "Login test failed");
		}
		
	}
}
