package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
	
	public WebDriver driver;
	
	@FindBy(xpath="//input[@name='uid']")
	private WebElement userid;

	@FindBy(xpath="//input[@name='password']")
	private WebElement pass;

	@FindBy(xpath="//input[@name='btnLogin']")
	private WebElement submit;
	
	@FindBy(xpath="//a[@href='Logout.php']")
	private WebElement logout;
	
	public loginpage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void userIP(String username) {
		userid.sendKeys(username);
	}

	public void password(String passwd) {
		pass.sendKeys(passwd);
	}
	public void clicksubmit() {
		submit.click();
	}
	
	public void clickLogout() {
		logout.click();
	}
}
