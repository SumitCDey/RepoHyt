package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadInfoPage {

	@FindBy(linkText = "Convert Lead")
	private WebElement convertLead;
	
	@FindBy(name = "Save")
	private WebElement savebtn;
	
	public LeadInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getConvertLead() {
		return convertLead;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public void convertLead() {
		getConvertLead().click();
		getSavebtn().click();
	}
}
