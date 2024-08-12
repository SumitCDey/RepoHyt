package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {

	WebDriver driver;
	
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createOrganizationbtn;
	
	@FindBy(xpath = "//img[@alt='Search in Organizations...']")
	private WebElement searchOrganization;
	
	@FindBy(xpath = "//img[@alt='Open Calendar...']")
	private WebElement openCalendar;
	
	@FindBy(xpath = "//img[@alt='Show World Clock...']")
	private WebElement worldClock;
	
	@FindBy(xpath = "//img[@alt='Open Calculator...']")
	private WebElement calculator;
	
	@FindBy(xpath = "//img[@alt='Chat...']")
	private WebElement chat;
	
	@FindBy(xpath = "//img[@alt='Last Viewed']")
	private WebElement lastViewed;
	
	@FindBy(xpath = "//img[@alt='Import Organizations']")
	private WebElement importOrganizations;
	
	@FindBy(xpath = "//img[@alt='Export Organizations']")
	private WebElement exportOrganizations;
	
	@FindBy(xpath = "//img[@title='Find Duplicates']")
	private WebElement findDuplicates;
	
	@FindBy(xpath = "//img[@alt='Organizations Settings']")
	private WebElement organizationSetting;
	
	public OrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateOrganizationbtn() {
		return createOrganizationbtn;
	}

	public WebElement getSearchOrganization() {
		return searchOrganization;
	}

	public WebElement getOpenCalendar() {
		return openCalendar;
	}

	public WebElement getWorldClock() {
		return worldClock;
	}

	public WebElement getCalculator() {
		return calculator;
	}

	public WebElement getChat() {
		return chat;
	}

	public WebElement getLastViewed() {
		return lastViewed;
	}

	public WebElement getImportOrganizations() {
		return importOrganizations;
	}

	public WebElement getExportOrganizations() {
		return exportOrganizations;
	}

	public WebElement getFindDuplicates() {
		return findDuplicates;
	}

	public WebElement getOrganizationSetting() {
		return organizationSetting;
	}
	
//	public void createNewOrganization() {
//		createOrganization.click();
//	}
	
}
