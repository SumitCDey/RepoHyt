package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PricebookPage {

	@FindBy(xpath = "//img[@alt='Create Price Book...']")
	private WebElement createpricebookbtn;
	
	public PricebookPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreatepricebookbtn() {
		return createpricebookbtn;
	}
	
	
}
