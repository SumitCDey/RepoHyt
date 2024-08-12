package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverUtility.WebDriverUtility;

public class CreateInvoicePage {
	
	WebDriverUtility wbu=new WebDriverUtility();
	
	@FindBy(name = "subject")
	private WebElement invoicenametxt;
	
	@FindBy(xpath = "//input[@name='salesorder_name']/following-sibling::img")
	private WebElement selectSObtn;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement selectOrgbtn;
	
	@FindBy(name = "bill_street")
	private WebElement billingstrtxt;
	
	@FindBy(name = "ship_street")
	private WebElement shippingstrtxt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	public CreateInvoicePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getInvoicenametxt() {
		return invoicenametxt;
	}

	public WebElement getSelectSObtn() {
		return selectSObtn;
	}

	public WebElement getSelectOrgbtn() {
		return selectOrgbtn;
	}

	public WebElement getBillingstrtxt() {
		return billingstrtxt;
	}

	public WebElement getShippingstrtxt() {
		return shippingstrtxt;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public void createInvoice(WebDriver driver,String invoicename,String soname,String orgname,StringBuilder billingaddr, StringBuilder shippingaddr) {
		getInvoicenametxt().sendKeys(invoicename);
		getSelectSObtn().click();
		wbu.switchToTab(driver, "SalesOrder&action=Popup");
		SalesOrderPopup sop=new SalesOrderPopup(driver);
		sop.getSearchtxt().sendKeys(soname);
		sop.getSearchbtn().click();
		driver.findElement(By.xpath("//a[text()='"+soname+"']")).click();
		wbu.switchToParentTab(driver, "Invoice&action=EditView");
		getSelectOrgbtn().click();
		wbu.switchToTab(driver, "Accounts&action=Popup");
		OrganizationPopUp opp=new OrganizationPopUp(driver);
		opp.getSearchTxt().sendKeys(orgname);
		opp.getSearchbtn().click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		wbu.switchToAlertAndAccept(driver);
//		wbu.switchToParentTab(driver, "Invoice&action=EditView");
		wbu.switchToParentTab(driver, "index.php");
		getBillingstrtxt().sendKeys(billingaddr);
		getShippingstrtxt().sendKeys(shippingaddr);
		getSavebtn().click();
		
		
	}
}
