package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverUtility.WebDriverUtility;

public class CreateSalesOrderPage {

	WebDriverUtility wbu=new WebDriverUtility();
	
	@FindBy(name = "subject")
	private WebElement subjecttxt;
	
	@FindBy(xpath = "//input[@id='single_accountid']/following-sibling::img")
	private WebElement selectorgbtn;
	
	@FindBy(name = "bill_street")
	private WebElement billingstreettxt;
	
	@FindBy(name = "ship_street")
	private WebElement shippingStreettxt;
	
	@FindBy(id = "searchIcon1")
	private WebElement productbtn;
	
	@FindBy(id = "qty1")
	private WebElement qtytxt;
	
	@FindBy(id = "listPrice1")
	private WebElement listPricetxt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	public CreateSalesOrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSubjecttxt() {
		return subjecttxt;
	}

	public WebElement getSelectorgbtn() {
		return selectorgbtn;
	}

	public WebElement getBillingstreettxt() {
		return billingstreettxt;
	}

	public WebElement getShippingStreettxt() {
		return shippingStreettxt;
	}

	public WebElement getProductbtn() {
		return productbtn;
	}

	public WebElement getQtytxt() {
		return qtytxt;
	}

	public WebElement getListPricetxt() {
		return listPricetxt;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public void createSalesOrder(WebDriver driver,String salesOrderName,String OrganizationName,StringBuilder billingaddr, StringBuilder shippingaddr,String productName,String qty,String listPrice) {
		getSubjecttxt().sendKeys(salesOrderName);
		getSelectorgbtn().click();
		wbu.switchToTab(driver, "module=Accounts&action=Popup");
		OrganizationPopUp opp=new OrganizationPopUp(driver);
		opp.getSearchTxt().sendKeys(OrganizationName);
		opp.getSearchbtn().click();
		driver.findElement(By.xpath("//a[text()='"+OrganizationName+"']")).click();
		wbu.switchToAlertAndAccept(driver);
		wbu.switchToParentTab(driver, "SalesOrder&action=EditView");
		getBillingstreettxt().sendKeys(billingaddr);
		getShippingStreettxt().sendKeys(shippingaddr);
		getProductbtn().click();
		wbu.switchToTab(driver, "Products&action=Popup");
		ProductPopup ppp=new ProductPopup(driver);
		ppp.getSearchtxt().sendKeys(productName);
		ppp.getSearchbtn().click();
		driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
		wbu.switchToParentTab(driver, "SalesOrder&action=EditView");
		getQtytxt().sendKeys(qty);
		getSavebtn().click();
		
	}
}
