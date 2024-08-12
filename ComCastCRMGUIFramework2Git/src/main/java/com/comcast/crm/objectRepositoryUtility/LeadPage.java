package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadPage {

	@FindBy(xpath = "//img[@alt='Create Lead...']")
	private WebElement createLeadbtn;
	
	public LeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateLeadbtn() {
		return createLeadbtn;
	}
	
}
