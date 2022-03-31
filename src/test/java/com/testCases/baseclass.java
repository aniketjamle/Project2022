package com.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.utilities.readConfig;

public class baseclass {
	
	readConfig rconfig=new readConfig();
	public String baseurl=rconfig.getApplicationBaseUrl();
	public String username=rconfig.getUsername();
	public String passwd=rconfig.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	
	@SuppressWarnings("deprecation")
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {

		
		logger = logger.getLogger("Projet2022");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",rconfig.getChromePath());
			driver = new ChromeDriver();
			
		}else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",rconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
		//C:\Users\Aniket\eclipse-workspace\Project2022\Screenshots
	}
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
}
