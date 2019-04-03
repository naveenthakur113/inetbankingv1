package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.pageObjects.NewCustomerPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {

		// login
		LoginPage loginPage = new LoginPage(driver);

		loginPage.setUserName(userName);
		loginPage.setPassword(password);
		loginPage.clickSubmit();

		Thread.sleep(3000);

		// Add Customer

		NewCustomerPage addCustomer = new NewCustomerPage(driver);
		addCustomer.clickAddNewCustomer();
		addCustomer.setCustomerName("Saloni");
		logger.info("Customer Name is set");
		addCustomer.setGender("Female");
		addCustomer.setCustomerDOB("07", "29", "91");
		Thread.sleep(3000);
		addCustomer.setCustomerAddress("India");
		addCustomer.setCustomerCity("Bangalore");
		addCustomer.setCustomerState("KA");
		addCustomer.setCustomerPinCode("560066");
		addCustomer.setCustomerTelephone("3767867567");
		addCustomer.setCustomerEmail(randomString() + "@gmail.com");
		addCustomer.setCustomerPassword("abc123");
		addCustomer.clickSubmit();

		Thread.sleep(3000);
		if (driver.getPageSource().contains("Customer Registered Successfully")) {
			Assert.assertTrue(true);
			logger.info("Test case has passed");

		} else {
			captureScreenshot(driver, "addNewCustomer");
			Assert.assertTrue(false);
			logger.info("Test case has failed");

		}

	}

}
