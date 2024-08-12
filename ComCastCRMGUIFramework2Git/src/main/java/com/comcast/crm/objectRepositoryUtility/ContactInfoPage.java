package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ContactInfoPage {

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement lstNmH;
	
	@FindBy(id = "dtlview_Last Name")
	private WebElement lastName;
	
	@FindBy(id = "dtlview_Support Start Date")
	private WebElement supportStrt;
	
	@FindBy(id = "dtlview_Support End Date")
	private WebElement supportEnd;
	
	@FindBy(id = "mouseArea_Organization Name")
	private WebElement orgName;
	
	public WebElement getLstNmH() {
		return lstNmH;
	}
	
	public ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getSupportStrt() {
		return supportStrt;
	}

	public WebElement getSupportEnd() {
		return supportEnd;
	}

	public WebElement getOrgName() {
		return orgName;
	}
	
	public boolean verifyContactNameHeader(String last_name) {
		String act_lastname = getLstNmH().getText();
		if(act_lastname.contains(last_name)) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean verifyContactNameTable(String last_name) {
		String act_t_lastname= getLastName().getText();
		if(act_t_lastname.equals(last_name)) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean verifySupportDate(String start_Date,String end_Date) {
		String act_date= getSupportStrt().getText();
		String act_e_date=getSupportEnd().getText();
		if(act_date.equals(start_Date) && act_e_date.equals(end_Date)) {
			return true;
		}else {
			return false;
		}	
	}
	
	public boolean verifyOrganization(String orgname) {
		String act_org = getOrgName().getText();
		//		System.out.println(act_org);
		if(act_org.trim().equals(orgname))
		{
			return true;
		}else {
			return false;
		}

	}
	
}
