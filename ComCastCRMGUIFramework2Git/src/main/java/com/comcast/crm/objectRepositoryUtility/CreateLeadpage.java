package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateLeadpage {

	@FindBy(name = "lastname")
	private WebElement lastnametxt;
	
	@FindBy(name = "company")
	private WebElement companytxt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	public CreateLeadpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastnametxt() {
		return lastnametxt;
	}

	public WebElement getCompanytxt() {
		return companytxt;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public void createLead(String lastname, String company) {
		getLastnametxt().sendKeys(lastname);
		getCompanytxt().sendKeys(company);
		getSavebtn().click();
	}
	
}
