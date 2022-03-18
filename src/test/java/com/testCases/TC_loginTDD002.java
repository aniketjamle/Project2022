package com.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pom.loginpage;
import com.utilities.XLUtils;



public class TC_loginTDD002 extends baseclass {
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException, IOException
	{
		driver.get(baseurl);
		logger.info("url is opened.");
		loginpage lp=new loginpage(driver);
		lp.userIP(user);
		logger.info("user name provided");
		lp.password(pwd);
		logger.info("password provided");
		Thread.sleep(1000);
		lp.clicksubmit();
		
		Thread.sleep(3000);
		boolean res=((TC_loginTDD002) driver).isAlertPresent();

		
		if(res!=true){
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
			

		}
		else
		{
			logger.info("Login failed");
			captureScreen(driver,"loginDDT");
			logger.info("screenshot taken");

			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		
		
	}
	
	
	public boolean isAlertPresent() //user defined method created to check alert is presetn or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException //src\test\java\com\testData\LoginData.xlsx
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/testData/LoginData.xlsx";
		
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
