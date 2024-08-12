package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorPopup {

	@FindBy(id = "search_txt")
	private WebElement searchtxt;
	
	@FindBy(name = "search")
	private WebElement searchbtn;
	
	public VendorPopup(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchtxt() {
		return searchtxt;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}
	
	public void searchVendor(String vendor_name) {
		getSearchtxt().sendKeys(vendor_name);
		getSearchbtn().click();
	}
}
