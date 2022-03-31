package com.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.loginpage;

public class TC_login001 extends baseclass {

	@Test
	public void loginTest() throws IOException {
		driver.get(baseurl);
		logger.info("url is opened.");
		
		loginpage lp = new loginpage(driver);
		lp.userIP(username);
		logger.info("username is entered.");

		lp.password(passwd);
		logger.info("password is entered.");

		
		lp.clicksubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else
		{
			captureScreen(driver,"loginTest");
			logger.info("Login test failed");

			Assert.assertTrue(false);
		}
		
//		Assert.assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage");
//		System.out.println("sucessfully login to homepage.");
//		logger.info("homepage is opened.");

	}
}
