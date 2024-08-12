package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateVendorPage {

	@FindBy(name = "vendorname")
	private WebElement vendornameEdt;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement savebtn;
	
	public CreateVendorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getVendornameEdt() {
		return vendornameEdt;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public void createVendor(String v_name) {
		getVendornameEdt().sendKeys(v_name);
		getSavebtn().click();
	}
}
