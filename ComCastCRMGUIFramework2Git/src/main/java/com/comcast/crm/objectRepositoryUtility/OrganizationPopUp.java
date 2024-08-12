package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPopUp {

	@FindBy(id = "search_txt")
	private WebElement searchTxt;
	
	@FindBy(name = "search")
	private WebElement searchbtn;
	
	public OrganizationPopUp(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchTxt() {
		return searchTxt;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}
}
