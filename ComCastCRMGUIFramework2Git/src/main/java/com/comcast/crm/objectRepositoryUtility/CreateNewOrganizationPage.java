package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverUtility.WebDriverUtility;

public class CreateNewOrganizationPage {

	//Object of Webdriver utility
	WebDriverUtility wbu=new WebDriverUtility();
	
	@FindBy(xpath = "//input[@value='  Save  ']")
	WebElement savebtn;
	
	@FindBy(xpath = "//input[@value='Cancel  ']")
	WebElement cancelbtn;
	
	@FindBy(name = "accountname")
	WebElement organizationName;
	
	@FindBy(name = "website")
	WebElement website;
	
	@FindBy(id = "tickersymbol")
	WebElement tickersymbol;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	WebElement memberOf;
	
	@FindBy(id = "employees")
	WebElement employees;
	
	@FindBy(id = "phone")
	WebElement phone;
	
	@FindBy(id = "fax")
	WebElement fax;
	
	@FindBy(id = "otherphone")
	WebElement otherphone;
	
	@FindBy(id = "email1")
	WebElement email;
	
	@FindBy(id = "ownership")
	WebElement ownership;
	
	@FindBy(name = "rating")
	WebElement rating;
	
	@FindBy(name = "industry")
	WebElement industry;
	
	@FindBy(name = "accounttype")
	WebElement accountType;
	
	public CreateNewOrganizationPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getCancelbtn() {
		return cancelbtn;
	}

	public WebElement getOrganizationName() {
		return organizationName;
	}

	public WebElement getWebsite() {
		return website;
	}

	public WebElement getTickersymbol() {
		return tickersymbol;
	}

	public WebElement getMemberOf() {
		return memberOf;
	}

	public WebElement getEmployees() {
		return employees;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getFax() {
		return fax;
	}

	public WebElement getOtherphone() {
		return otherphone;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getOwnership() {
		return ownership;
	}

	public WebElement getRating() {
		return rating;
	}

	public WebElement getIndustry() {
		return industry;
	}

	public WebElement getAccountType() {
		return accountType;
	}	
	
	public void createOrg(String orgname) {
		getOrganizationName().sendKeys(orgname);
		getSavebtn().click();
	}
	
	public void createOrg(String orgname,String phone_num) {
		getOrganizationName().sendKeys(orgname);
		getPhone().sendKeys(phone_num);
		getSavebtn().click();
	}
	
	public void createOrg(String orgname,String indust,String type) {
		getOrganizationName().sendKeys(orgname);
		wbu.select(getIndustry(), indust);
		wbu.select(getAccountType(), type);
		getSavebtn().click();
	}
}
