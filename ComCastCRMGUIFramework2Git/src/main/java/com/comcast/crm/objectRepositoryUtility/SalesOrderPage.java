package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesOrderPage {

	@FindBy(xpath = "//img[@alt='Create Sales Order...']")
	private WebElement createSalesOrderbtn;
	
	public SalesOrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateSalesOrderbtn() {
		return createSalesOrderbtn;
	}
	
	
}
