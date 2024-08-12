package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorPage {

	@FindBy(xpath = "//img[@alt='Create Vendor...']")
	private WebElement createVendorBtn;
	
	
	public VendorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateVendorBtn() {
		return createVendorBtn;
	}

	
	
	
}
