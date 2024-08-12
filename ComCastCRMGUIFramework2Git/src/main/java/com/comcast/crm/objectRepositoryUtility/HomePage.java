package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverUtility.WebDriverUtility;

public class HomePage {
	
	WebDriverUtility wbu=new WebDriverUtility();
	
	
	@FindBy(linkText = "Calendar")
	private WebElement calendar;
	
	@FindBy(xpath = "//a[contains(text(),'Home')]")
	private WebElement HomeLink;
	
	@FindBy(linkText = "Leads")
	private WebElement leads;
	
	@FindBy(linkText = "Organizations")
	private WebElement Organizations;
	
	@FindBy(linkText = "Contacts")
	private WebElement contacts;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunities;
	
	@FindBy(linkText = "Products")
	private WebElement products;
	
	@FindBy(linkText ="Documents")
	private WebElement documents;
	
	@FindBy(linkText ="Email")
	private WebElement email;
	
	@FindBy(linkText = "Trouble Tickets")
	private WebElement troubleTickets;
	
	@FindBy(linkText = "Dashboard")
	private WebElement dashboard;
	
	@FindBy(linkText = "More")
	private WebElement more;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaigns;
	
	@FindBy(linkText = "Purchase Order")
	private WebElement purchaseOrder;
	
	
	@FindBy(linkText = "Price Books")
	private WebElement priceBooks;
	
	@FindBy(linkText = "Vendors")
	private WebElement vendors;
	
	@FindBy(linkText = "Invoice")
	private WebElement invoice;
	
	@FindBy(linkText = "Sales Order")
	private WebElement salesOrder;
	
	@FindBy(linkText = "Quotes")
	private WebElement quotes;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/mainSettings.PNG']")
	private WebElement mainsetting;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/info.PNG']")
	private WebElement info;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement account;
	
	@FindBy(id = "_my_preferences_")
	private WebElement myPreferences;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOut;
	
	@FindBy(xpath = "//img[@title='vtiger-crm-logo.gif']")
	private WebElement vtigerLogo;
	
	public WebElement getVtigerLogo() {
		return vtigerLogo;
	}

	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCalendar() {
		return calendar;
	}

	public WebElement getLeads() {
		return leads;
	}

	public WebElement getOrganizations() {
		return Organizations;
	}

	public WebElement getContacts() {
		return contacts;
	}

	public WebElement getOpportunities() {
		return opportunities;
	}

	public WebElement getProducts() {
		return products;
	}

	public WebElement getDocuments() {
		return documents;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getTroubleTickets() {
		return troubleTickets;
	}

	public WebElement getDashboard() {
		return dashboard;
	}

	public WebElement getMore() {
		return more;
	}

	public WebElement getCampaigns() {
		return campaigns;
	}

	public WebElement getPurchaseOrder() {
		return purchaseOrder;
	}

	public WebElement getPriceBooks() {
		return priceBooks;
	}

	public WebElement getVendors() {
		return vendors;
	}

	public WebElement getInvoice() {
		return invoice;
	}

	public WebElement getSalesOrder() {
		return salesOrder;
	}

	public WebElement getQuotes() {
		return quotes;
	}
	
	public void NavigateToOrg() {
		Organizations.click();
	}
	
	public WebElement getMainsetting() {
		return mainsetting;
	}

	public WebElement getInfo() {
		return info;
	}

	public WebElement getAccount() {
		return account;
	}

	public WebElement getMyPreferences() {
		return myPreferences;
	}

	public WebElement getSignOut() {
		return signOut;
	}
	
	public WebElement getHomeLink() {
		return HomeLink;
	}
	

	public void signOut(WebDriver driver) {
		wbu.mouseMoveOnElement(driver, account);
		signOut.click();
	}
	
}
