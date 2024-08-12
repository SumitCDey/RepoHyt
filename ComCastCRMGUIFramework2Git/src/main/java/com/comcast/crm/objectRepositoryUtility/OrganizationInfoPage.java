package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement orgHeader;
	
	@FindBy(id = "dtlview_Organization Name")
	private WebElement organizationName;
	
	@FindBy(id = "dtlview_Industry")
	private WebElement industry;
	
	@FindBy(id = "dtlview_Type")
	private WebElement Accounttype;
	
	@FindBy(id = "dtlview_Phone")
	private WebElement phone;
	
	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrganizationName() {
		return organizationName;
	}

	public WebElement getIndustry() {
		return industry;
	}

	public WebElement getAccountType() {
		return Accounttype;
	}

	public WebElement getPhone() {
		return phone;
	}
	
	public String verifyOrgNameinHeader(WebDriver driver, String orgname) {
		String org_info = getOrgHeader().getText();
		if(org_info.contains(orgname)) {
			return orgname+" is Created in header====PASS";
		}else {
			return orgname+" is not Created in header====FAIL";
		}
	}
	
	public WebElement getOrgHeader() {
		return orgHeader;
	}

	public String verifyOrgNameinTable(WebDriver driver, String orgname) {
		String org_info = getOrganizationName().getText();
		if(org_info.equals(orgname)) {
			return orgname+" is Created in table====PASS";
		}else {
			return orgname+" is not Created in table====FAIL";
		}
	}
	
	public String verifyPhoneNum(String phone_num) {
		String phno = getPhone().getText();
		if(phno.equals(phone_num)) {
			return "Organization is Created is created with phone number "+phone_num+"====PASS";
		}else {
			return "Organization is not Created with phone number "+phone_num+"====FAIL";
		}
	}
	
	public String verifyIndustry(String indust) {
		//verify industry
		String ind = getIndustry().getText();
		if(ind.contains(indust))
		{
			return "Organization is Created with industry "+indust+"====PASS";
		}else {
			return "Organization is not Created with industry "+indust+"====FAIL";
		}
	}
	public String verifyType(String type) {
		//verify in type
		String ty = getAccountType().getText();
		if(ty.equals(type)) {
			return "Organization is Created with type "+type+"====PASS";
		}else {
			return "Organization is not Created with type "+type+"====FAIL";
		}

	}

}
