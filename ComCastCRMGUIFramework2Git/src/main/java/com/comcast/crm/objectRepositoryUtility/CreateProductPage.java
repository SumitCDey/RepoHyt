package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverUtility.WebDriverUtility;

public class CreateProductPage {

	//webdriver utility
	WebDriverUtility wbu=new WebDriverUtility();
	
	@FindBy(name = "productname")
	private WebElement productnametxt;
	
	@FindBy(xpath = "//input[@name='vendor_name']/following-sibling::img")
	private WebElement selectvendorbtn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	@FindBy(id = "qtyinstock")
	private WebElement qtytxt;
	
	public WebElement getQtytxt() {
		return qtytxt;
	}

	public CreateProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductnametxt() {
		return productnametxt;
	}

	public WebElement getSelectvendorbtn() {
		return selectvendorbtn;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public void createProduct(WebDriver driver,String pr_name,String vendor_name, String qty) {
		getProductnametxt().sendKeys(pr_name);
		getSelectvendorbtn().click();
		wbu.switchToTab(driver, "Vendors&action=Popup&html");
		VendorPopup vp=new VendorPopup(driver);
		vp.searchVendor(vendor_name);
		driver.findElement(By.linkText(vendor_name)).click();
		wbu.switchToParentTab(driver, "Products&action=EditView");
		getQtytxt().sendKeys(qty);
		getSavebtn().click();
		
		
	}
	
	
}
