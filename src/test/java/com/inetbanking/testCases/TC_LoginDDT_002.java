package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void loginDDT(String uname, String pwd) throws InterruptedException, IOException {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName(uname);
		loginPage.setPassword(pwd);
		loginPage.clickSubmit();
		Thread.sleep(3000);
		if (isAlertPresent()) {
			captureScreenshot(driver, "loginDDT");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);			
			logger.warn("Login Failed");
		} else {
			Assert.assertTrue(true);
			logger.info("Login Passed");
			loginPage.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}

	}

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/inetbanking/testData/LoginData.xlsx";

		int rowCount = XLUtils.getRowCount(path, "Sheet1");
		int cellCount = XLUtils.getCellCount(path, "Sheet1", 1);

		String loginData[][] = new String[rowCount][cellCount];

		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				loginData[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return loginData;
	}

	// User defined method to check if Alert is present or not
	public boolean isAlertPresent() {

		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}

	}

}
