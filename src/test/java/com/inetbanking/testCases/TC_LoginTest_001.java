package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;



public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException {

		
		logger.info("Website URL has been opened");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName(userName);
		logger.info("UserName entered" + userName);
		loginPage.setPassword(password);
		logger.info("Password entered" + password);
		loginPage.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		}else {
			captureScreenshot(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login Test Failed");
		}
	}

}
