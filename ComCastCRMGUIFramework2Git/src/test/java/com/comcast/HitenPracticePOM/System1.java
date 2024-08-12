package com.comcast.HitenPracticePOM;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileUtility.ExcelUtility;
import com.comcast.crm.generic.fileUtility.FileUtility;
import com.comcast.crm.generic.webdriverUtility.JavaUtility;
import com.comcast.crm.generic.webdriverUtility.WebDriverUtility;
import com.comcast.crm.objectRepositoryUtility.CampaignPage;
import com.comcast.crm.objectRepositoryUtility.CreateCampaignPage;
import com.comcast.crm.objectRepositoryUtility.CreateInvoicePage;
import com.comcast.crm.objectRepositoryUtility.CreateLeadpage;
import com.comcast.crm.objectRepositoryUtility.CreatePricebookPage;
import com.comcast.crm.objectRepositoryUtility.CreateProductPage;
import com.comcast.crm.objectRepositoryUtility.CreatePurchaseOrderPage;
import com.comcast.crm.objectRepositoryUtility.CreateSalesOrderPage;
import com.comcast.crm.objectRepositoryUtility.CreateVendorPage;
import com.comcast.crm.objectRepositoryUtility.HomePage;
import com.comcast.crm.objectRepositoryUtility.InvoicePage;
import com.comcast.crm.objectRepositoryUtility.LeadInfoPage;
import com.comcast.crm.objectRepositoryUtility.LeadPage;
import com.comcast.crm.objectRepositoryUtility.LoginPage;
import com.comcast.crm.objectRepositoryUtility.PricebookInfoPage;
import com.comcast.crm.objectRepositoryUtility.PricebookPage;
import com.comcast.crm.objectRepositoryUtility.ProductPage;
import com.comcast.crm.objectRepositoryUtility.PurchaseOrderPage;
import com.comcast.crm.objectRepositoryUtility.SalesOrderPage;
import com.comcast.crm.objectRepositoryUtility.VendorPage;

public class System1 {

	public static void main(String[] args) throws Exception {

		// object of file utility
		FileUtility fLib=new FileUtility();

		//object of excel utility
		ExcelUtility eLib=new ExcelUtility();

		//object of webdriver utility
		WebDriverUtility wbu=new WebDriverUtility();

		//object of java utility
		JavaUtility ju=new JavaUtility();

		//fetching data from property
		String url=fLib.getDataFromPropertiesFile("URL");
		String username=fLib.getDataFromPropertiesFile("USERNAME");
		String password=fLib.getDataFromPropertiesFile("PASSWORD");
		String browser=fLib.getDataFromPropertiesFile("BROWSER");

		//Fetching data from Excel
		String cmp = eLib.getDataFromExcel("crtcmp",1,0);
		String l_name = eLib.getDataFromExcel("crtcmp",1,1);
		String c_name = eLib.getDataFromExcel("crtcmp",1,2);
		String v_name = eLib.getDataFromExcel("crtcmp",1,3);
		String pr_name = eLib.getDataFromExcel("crtcmp",1,4);
		String pb_nm = eLib.getDataFromExcel("crtcmp",1,6);
		String po_nm = eLib.getDataFromExcel("crtcmp",1,7);
		String so_nm = eLib.getDataFromExcel("crtcmp",1,8);

		//Random Numb and random string
		int r_no=ju.getRandomNum(100);
		StringBuilder sb=ju.getAlphabeticString(25);

		//launch browser
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}else {
			driver=new ChromeDriver();
		}

		//maximize browser and enter url
		wbu.maximizeBrowser(driver);
		driver.get(url);
		wbu.waitForPageToLoad(driver);

		//step1: login
		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(username, password);

		//create vendor
		HomePage hp=new HomePage(driver);
		wbu.mouseMoveOnElement(driver, hp.getMore());
		hp.getVendors().click();
		VendorPage vp=new VendorPage(driver);
		vp.getCreateVendorBtn().click();
		CreateVendorPage cvp=new CreateVendorPage(driver);
		cvp.createVendor(v_name+r_no);

		//Create Product
		hp.getProducts().click();
		ProductPage pp=new ProductPage(driver);
		pp.getCreateProductbtn().click();
		CreateProductPage cpp=new CreateProductPage(driver);
		cpp.createProduct(driver, pr_name+r_no,v_name+r_no,""+r_no);


		//Create Price Book
		wbu.mouseMoveOnElement(driver, hp.getMore());
		hp.getPriceBooks().click();
		PricebookPage pbp=new PricebookPage(driver);
		pbp.getCreatepricebookbtn().click();
		CreatePricebookPage cpr=new CreatePricebookPage(driver);
		cpr.createPriceBook(pb_nm+r_no);
		

		//Add Products to Price Book
		PricebookInfoPage pbi=new PricebookInfoPage(driver);
		pbi.addProductsToPricebook();


		//create new campaign
		wbu.mouseMoveOnElement(driver, hp.getMore());
		hp.getCampaigns().click();
		CampaignPage cp=new CampaignPage(driver);
		cp.getCreateCampbtn().click();
		CreateCampaignPage ccp=new CreateCampaignPage(driver);
		ccp.createCampaign(cmp+r_no);
		
		//Create Lead
		hp.getLeads().click();
		LeadPage lpg=new LeadPage(driver);
		lpg.getCreateLeadbtn().click();
		CreateLeadpage clp=new CreateLeadpage(driver);
		clp.createLead(l_name+r_no, c_name+r_no);
		
		//Convert the lead
		LeadInfoPage lip=new LeadInfoPage(driver);
		lip.convertLead();

		//Create Purchase Order
		wbu.mouseMoveOnElement(driver, hp.getMore());
		hp.getPurchaseOrder().click();
		PurchaseOrderPage pop=new PurchaseOrderPage(driver);
		pop.getCreatePObtn().click();
		CreatePurchaseOrderPage cpop=new CreatePurchaseOrderPage(driver);
		cpop.createPurchaseOrder(driver, po_nm+r_no, v_name+r_no, ""+r_no,""+r_no,sb,sb,pr_name+r_no);
		
		//Create Sales Order
		wbu.mouseMoveOnElement(driver, hp.getMore());
		hp.getSalesOrder().click();
		SalesOrderPage sop=new SalesOrderPage(driver);
		sop.getCreateSalesOrderbtn().click();
		CreateSalesOrderPage csop=new CreateSalesOrderPage(driver);
		csop.createSalesOrder(driver, so_nm+r_no, c_name+r_no, sb, sb, pr_name+r_no, ""+r_no, ""+r_no);
		
		//create invoice
		wbu.mouseMoveOnElement(driver, hp.getMore());
		hp.getInvoice().click();
		InvoicePage ip=new InvoicePage(driver);
		ip.getCreateinvbtn().click();
		CreateInvoicePage cip=new CreateInvoicePage(driver);
		cip.createInvoice(driver,so_nm+r_no,so_nm+r_no,c_name+r_no,sb, sb);

		Thread.sleep(5000);
		//signout
		hp.signOut(driver);
		driver.quit();

	}
}
