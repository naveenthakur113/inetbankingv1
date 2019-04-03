package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	//FInd out what is the purpose/functionality of @CacheLookup
	WebElement btnLogin;
	
	
	@FindBy(xpath="//a[@href='Logout.php']")
	@CacheLookup
	//FInd out what is the purpose/functionality of @CacheLookup
	WebElement btnLogout;
	
	
	public void setUserName(String userName) {
		txtUserName.sendKeys(userName);
	}
	
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit() {
		btnLogin.click();
	}
	
	public void clickLogout() {
		btnLogout.click();
	}
	
	

}
