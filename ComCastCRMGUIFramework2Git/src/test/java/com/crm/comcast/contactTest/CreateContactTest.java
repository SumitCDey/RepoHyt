package com.crm.comcast.contactTest;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.baseTest.BaseClass;
import com.comcast.crm.objectRepositoryUtility.ContactInfoPage;
import com.comcast.crm.objectRepositoryUtility.ContactPage;
import com.comcast.crm.objectRepositoryUtility.CreateContactPage;
import com.comcast.crm.objectRepositoryUtility.CreateNewOrganizationPage;
import com.comcast.crm.objectRepositoryUtility.HomePage;
import com.comcast.crm.objectRepositoryUtility.OrganizationInfoPage;
import com.comcast.crm.objectRepositoryUtility.OrganizationPage;

public class CreateContactTest extends BaseClass {

	
	
	@Test(groups = "Smoketest")
	public void createContactTest() throws Exception {
		int r_no=ju.getRandomNum(100);
		System.out.println("execute Create Contact & Verify");
		
//		String last_name="Shahani";
	
		String last_name=eLib.getDataFromExcel("contact",1,2);
		
		//Navigate to contact
		HomePage hp=new HomePage(driver);	
		hp.getContacts().click();
		
		//click on create contact button
		ContactPage cp=new ContactPage(driver);	
		cp.getCreateContactbtn().click();
		
		//Enter details
		CreateContactPage cnp=new CreateContactPage(driver);
		cnp.createContact(last_name+r_no);
		
		//Verify in Header
		ContactInfoPage cip=new ContactInfoPage(driver);
		Assert.assertTrue(cip.verifyContactNameHeader(last_name));
		
		
		//Verify in Table
		SoftAssert soft=new SoftAssert();
		soft.assertTrue(cip.verifyContactNameTable(last_name+r_no));
		soft.assertAll();
	}
	
	@Test(groups = "RegressionTest")
	public void createContactWithDate() throws Exception {
		int r_no=ju.getRandomNum(100);
		System.out.println("execute Create Contact with Date & verify");
		
		String last_name=eLib.getDataFromExcel("contact",1,2);
		
		String start_Date=ju.getSystemDate("yyyy-MM-dd");
		String end_Date=ju.getRequiredDate("yyyy-MM-dd", 30);
		
		HomePage hp=new HomePage(driver);
		hp.getContacts().click();
		
		ContactPage cp=new ContactPage(driver);
		cp.getCreateContactbtn().click();
		
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.createContact(last_name+r_no, start_Date, end_Date);
		
		ContactInfoPage cip=new ContactInfoPage(driver);
		SoftAssert soft=new SoftAssert();
		soft.assertTrue(cip.verifySupportDate(start_Date, end_Date));
		soft.assertAll();
		
//		System.out.println(cip.verifySupportDate(start_Date, end_Date));
		
	}
	
	@Test(groups = "RegressionTest")
	public void createContactWithOrg() throws Exception {
		int r_no=ju.getRandomNum(100);
		
		String orgname=eLib.getDataFromExcel("org", 1, 2);
		String last_name=eLib.getDataFromExcel("contact",1,2);
		
		HomePage hp=new HomePage(driver);
		hp.getOrganizations().click();

		//click on new organization button
		OrganizationPage op=new OrganizationPage(driver);
		op.getCreateOrganizationbtn().click();

		//Enter Details
		CreateNewOrganizationPage cop=new CreateNewOrganizationPage(driver);
		cop.createOrg(orgname+r_no);
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		WebElement wb=oip.getOrganizationName();
		wbu.waitForElement(driver, wb);

		//Navigate to contact Module
		hp.getContacts().click();

		//click on new contact button
		ContactPage cp=new ContactPage(driver);
		cp.getCreateContactbtn().click();

		//Enter Details
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.createContact(driver, last_name+r_no, orgname+r_no);

		//verify expected results
		ContactInfoPage cip=new ContactInfoPage(driver);
		SoftAssert soft=new SoftAssert();
		soft.assertTrue(cip.verifyOrganization(orgname+r_no));
		soft.assertAll();
		
		
//		System.out.println(cip.verifyOrganization(orgname+r_no));

	}
}
