package com.inetbanking.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {

	WebDriver driver;

	public NewCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[@href='addcustomerpage.php']")
	@CacheLookup
	WebElement lnkAddNewCustomer;

	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement txtCustomerName;

	@FindBy(how = How.NAME, using = "rad1")
	@CacheLookup
	List<WebElement> rdGender;

	@FindBy(how = How.ID_OR_NAME, using = "dob")
	@CacheLookup
	WebElement txtdob;

	@FindBy(how = How.NAME, using = "addr")
	@CacheLookup
	WebElement txtAddress;

	@FindBy(how = How.NAME, using = "city")
	@CacheLookup
	WebElement txtCity;

	@FindBy(how = How.NAME, using = "state")
	@CacheLookup
	WebElement txtState;

	@FindBy(how = How.NAME, using = "pinno")
	@CacheLookup
	WebElement txtPinCode;

	@FindBy(how = How.NAME, using = "telephoneno")
	@CacheLookup
	WebElement txtTelephone;

	@FindBy(how = How.NAME, using = "emailid")
	@CacheLookup
	WebElement txtEmailId;

	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(how = How.NAME, using = "sub")
	@CacheLookup
	WebElement btnSubmit;

	public void clickAddNewCustomer() {
		lnkAddNewCustomer.click();
	}

	public void setCustomerName(String cname) {
		txtCustomerName.sendKeys(cname);
	}
	
	//Come back to this!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public void setGender(String gender) {
			
			
			if(gender.equalsIgnoreCase("male")) {
				rdGender.get(0).click();
			}else {
				rdGender.get(1).click();
			}
			
			//driver.findElement(By.cssSelector("input[value='f']"));		
		
	}

	public void setCustomerDOB(String mm, String dd, String yy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}

	public void setCustomerAddress(String address) {
		txtAddress.sendKeys(address);

	}
	
	public void setCustomerCity(String city) {
		txtCity.sendKeys(city);

	}
	
	
	public void setCustomerState(String state) {
		txtState.sendKeys(state);

	}
	
	public void setCustomerPinCode(String pin) {
		txtPinCode.sendKeys(String.valueOf(pin));

	}
	
	public void setCustomerTelephone(String telephone) {
		txtTelephone.sendKeys(telephone);

	}
	
	public void setCustomerEmail(String email) {
		txtEmailId.sendKeys(email);

	}
	
	public void setCustomerPassword(String pwd) {
		txtPassword.sendKeys(pwd);

	}
	
	public void clickSubmit() {
		btnSubmit.click();
	}

}
