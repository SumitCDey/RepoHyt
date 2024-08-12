package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverUtility.WebDriverUtility;

public class PricebookInfoPage {

	//webdriver utility
	WebDriverUtility wbu=new WebDriverUtility();
	
	@FindBy(linkText = "More Information")
	private WebElement moreInfo;
	
	@FindBy(id = "dtlview_Price Book Name")
	private WebElement pricebookname;
	
	@FindBy(id = "show_PriceBooks_Products")
	private WebElement productsTab;
	
	@FindBy(id = "show_PriceBooks_Services")
	private WebElement serviceTab;
	
	@FindBy(xpath = "//input[@title='Select Products']")
	private WebElement selectproductsbtn;
	
	@FindBy(xpath = "//input[@title='Select Services']")
	private WebElement selectservicesbtn;
	
	@FindBy(name = "selectall")
	private WebElement selectAllProd;
	
	@FindBy(xpath = "//input[@value='Add To Price Books']")
	private WebElement addToPricebookbtn;
	
	public PricebookInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getMoreInfo() {
		return moreInfo;
	}

	public WebElement getPricebookname() {
		return pricebookname;
	}

	public WebElement getAddToPricebookbtn() {
		return addToPricebookbtn;
	}

	public WebElement getProductsTab() {
		return productsTab;
	}

	public WebElement getServiceTab() {
		return serviceTab;
	}

	public WebElement getSelectproductsbtn() {
		return selectproductsbtn;
	}

	public WebElement getSelectservicesbtn() {
		return selectservicesbtn;
	}
	
	
	
	public WebElement getSelectAllProd() {
		return selectAllProd;
	}

	public void addProductsToPricebook() {
		getMoreInfo().click();
		getProductsTab().click();
		getSelectproductsbtn().click();;
		getSelectAllProd().click();
		getAddToPricebookbtn().click();
		
		
	}
}
