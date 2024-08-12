package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvoicePage {

	@FindBy(xpath = "//img[@alt='Create Invoice...']")
	private WebElement createinvbtn;
	
	public InvoicePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateinvbtn() {
		return createinvbtn;
	}
	
	
}
