package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.inetbanking.base.BaseClass;
import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.reports.ExtFactory;

public class TC_AddCustomerTest_003 extends BaseClass
{

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		ExtFactory.getInstance().getExtent().log(Status.INFO, "User name is provided");
		
		lp.setPassword(password);
		logger.info("Passsword is provided");
		ExtFactory.getInstance().getExtent().log(Status.INFO, "Passsword is provided");
		
		lp.clickSubmit();
		logger.info("Submitted");
		ExtFactory.getInstance().getExtent().log(Status.INFO, "Submitted");
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		logger.info("providing customer details....");
		ExtFactory.getInstance().getExtent().log(Status.INFO, "providing customer details....");
		
		
		addcust.custName("Venkatakrishna");
		addcust.custgender("male");
		addcust.custdob("01","06","1992");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("500074");
		addcust.custtelephoneno("987890091");
		
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("validation started....");
		ExtFactory.getInstance().getExtent().log(Status.INFO, "validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			ExtFactory.getInstance().getExtent().log(Status.PASS, "test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			ExtFactory.getInstance().getExtent().log(Status.FAIL, "test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
			
	}
	
	
}
