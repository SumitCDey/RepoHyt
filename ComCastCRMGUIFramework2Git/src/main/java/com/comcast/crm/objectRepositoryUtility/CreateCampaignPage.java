package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {

	@FindBy(name = "campaignname")
	private WebElement campaignnametxt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	public CreateCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCampaignnametxt() {
		return campaignnametxt;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public void createCampaign(String cmp_name) {
		getCampaignnametxt().sendKeys(cmp_name);
		getSavebtn().click();
	}
}
