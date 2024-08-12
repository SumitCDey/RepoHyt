package com.comcast.crm.objectRepositoryUtility;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverUtility.WebDriverUtility;

public class CreatePurchaseOrderPage {

	WebDriverUtility wbu=new WebDriverUtility();
	
	@FindBy(name = "subject")
	private WebElement subjecttxt;
	
	@FindBy(xpath = "//input[@name='vendor_name']/following-sibling::img")
	private WebElement selectVendorbtn;
	
	@FindBy(name = "bill_street")
	private WebElement billstreettxt;
	
	@FindBy(name = "ship_street")
	private WebElement shipstreettxt;
	
	@FindBy(id = "searchIcon1")
	private WebElement productsearchbtn;
	
	@FindBy(id = "qty1")
	private WebElement quantitytxt;
	
	@FindBy(id = "listPrice1")
	private WebElement listpricetxt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	public CreatePurchaseOrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSubjecttxt() {
		return subjecttxt;
	}

	public WebElement getSelectVendorbtn() {
		return selectVendorbtn;
	}

	public WebElement getBillstreettxt() {
		return billstreettxt;
	}

	public WebElement getShipstreettxt() {
		return shipstreettxt;
	}

	public WebElement getProductsearchbtn() {
		return productsearchbtn;
	}

	public WebElement getQuantitytxt() {
		return quantitytxt;
	}

	public WebElement getListpricetxt() {
		return listpricetxt;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public void createPurchaseOrder(WebDriver driver,String po_nm,String v_name,String qty,String price,StringBuilder billingaddr,StringBuilder shippingaddr,String productname) {
		getSubjecttxt().sendKeys(po_nm);
		getSelectVendorbtn().click();
		wbu.switchToTab(driver, "Vendors&action=Popup&html");
		VendorPopup vpop=new VendorPopup(driver);
		vpop.getSearchtxt().sendKeys(v_name);
		vpop.getSearchbtn().click();
		driver.findElement(By.xpath("//a[text()='"+v_name+"']")).click();
		wbu.switchToParentTab(driver, "PurchaseOrder");
		getBillstreettxt().sendKeys(billingaddr);
		getShipstreettxt().sendKeys(shippingaddr);
		getProductsearchbtn().click();
		wbu.switchToTab(driver, "Products&action=Popup");
		ProductPopup ppp=new ProductPopup(driver);
		ppp.getSearchtxt().sendKeys(productname);
		ppp.getSearchbtn().click();
		driver.findElement(By.xpath("//a[text()='"+productname+"']")).click();
		wbu.switchToParentTab(driver, "PurchaseOrder");
		getQuantitytxt().sendKeys(qty);
		getListpricetxt().sendKeys(price);
		getSavebtn().click();
	}
}
