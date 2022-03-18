package com.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.AddCustomer;
import com.pom.loginpage;

public class TC_addcust003 extends baseclass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		driver.get(baseurl);
		loginpage lp=new loginpage(driver);
		lp.userIP(username);
		logger.info("User name is provided");
		lp.password(passwd);
		logger.info("Passsword is provided");
		lp.clicksubmit();
		
		Thread.sleep(3000);
		
		AddCustomer addcust=new AddCustomer(driver);
		
		addcust.clickAddNewCustomer();
		
		logger.info("providing customer details....");
		
		
		addcust.custName("Aniket");
		addcust.custgender("male");
		addcust.custdob("10","15","1996");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("MUM");
		addcust.custstate("MH");
		addcust.custpinno("400701");
		addcust.custtelephoneno("9812390091");
		
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
			
	}
}
