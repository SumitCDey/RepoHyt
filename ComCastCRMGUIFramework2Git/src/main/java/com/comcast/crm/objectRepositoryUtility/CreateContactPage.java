package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverUtility.WebDriverUtility;

public class CreateContactPage {
	
	WebDriverUtility wbu=new WebDriverUtility();
	
	@FindBy(name = "lastname")
	private WebElement lastname;
	
	@FindBy(id = "jscal_field_support_start_date")
	private WebElement supportStrt;
	
	@FindBy(id = "jscal_field_support_end_date")
	private WebElement supportEnd;
	
	public WebElement getSupportStrt() {
		return supportStrt;
	}

	public WebElement getSupportEnd() {
		return supportEnd;
	}

	@FindBy(xpath = "//input[@value='  Save  ']")
	private WebElement savebtn;
	
	@FindBy(xpath = "//input[@value='Cancel  ']")
	private WebElement cancelbtn;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement selectOrgBtn;
	
	public WebElement getSelectOrgBtn() {
		return selectOrgBtn;
	}

	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getCancelbtn() {
		return cancelbtn;
	}
	
	public void createContact(String last_name) {
		getLastname().sendKeys(last_name);
		getSavebtn().click();
	}
	
	public void createContact(String last_name, String start_Date,String end_Date) {
		getLastname().sendKeys(last_name);
		getSupportStrt().clear();
		getSupportStrt().sendKeys(start_Date);
		getSupportEnd().clear();
		getSupportEnd().sendKeys(end_Date);
		getSavebtn().click();
	}
	
	public void createContact(WebDriver driver,String last_name, String orgname) {
		getLastname().sendKeys(last_name);
		getSelectOrgBtn().click();
		wbu.switchToTab(driver, "Popup&popuptype");
		OrganizationPopUp opp=new OrganizationPopUp(driver);
		opp.getSearchTxt().sendKeys(orgname);
		opp.getSearchbtn().click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		wbu.switchToParentTab(driver, "Contacts&action=EditView&return");
		getSavebtn().click();
	}
}
