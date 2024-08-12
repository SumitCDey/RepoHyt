package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatePricebookPage {

	@FindBy(name = "bookname")
	private WebElement pricebooknametxt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	public CreatePricebookPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	
	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getPricebooknametxt() {
		return pricebooknametxt;
	}
	
	public void createPriceBook(String pricebookname) {
		getPricebooknametxt().sendKeys(pricebookname);
		getSavebtn().click();
		
	}
}
