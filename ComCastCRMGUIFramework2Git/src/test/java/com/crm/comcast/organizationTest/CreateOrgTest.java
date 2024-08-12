package com.crm.comcast.organizationTest;

import org.testng.annotations.Test;

import com.comcast.crm.baseTest.BaseClass;
import com.comcast.crm.objectRepositoryUtility.CreateNewOrganizationPage;
import com.comcast.crm.objectRepositoryUtility.HomePage;
import com.comcast.crm.objectRepositoryUtility.OrganizationInfoPage;
import com.comcast.crm.objectRepositoryUtility.OrganizationPage;

public class CreateOrgTest extends BaseClass {

	@Test(groups = "Smoketest")
	public void createOrg() throws Exception {
		
		int r_no=ju.getRandomNum(100);
		String orgname=eLib.getDataFromExcel("org", 1, 2);
		
		HomePage hp=new HomePage(driver);
		hp.NavigateToOrg();

		//Create New organization
		OrganizationPage op=new OrganizationPage(driver);
		op.getCreateOrganizationbtn().click();;

		//Enter Details
		CreateNewOrganizationPage cno=new CreateNewOrganizationPage(driver);
		cno.createOrg(orgname+r_no);

		//verify in table
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		System.out.println(oip.verifyOrgNameinHeader(driver, orgname+r_no));
		System.out.println(oip.verifyOrgNameinTable(driver, orgname+r_no));
	}
	
	@Test(groups = "RegressionTest")
	public void createOrgWithPhoneno() throws Exception {
		String orgname=eLib.getDataFromExcel("org",3,2);
		String phone_num=eLib.getDataFromExcel("org",3,4);
		int r_no=ju.getRandomNum(100);
		
		HomePage hp=new HomePage(driver);
		hp.NavigateToOrg();

		//click on new organization button
		OrganizationPage op=new OrganizationPage(driver);
		op.getCreateOrganizationbtn().click();

		//Enter Details
		CreateNewOrganizationPage cno=new CreateNewOrganizationPage(driver);
		cno.createOrg(orgname+r_no, phone_num);

		//Verify Expected Result
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		System.out.println(oip.verifyPhoneNum(phone_num));
	}
	
	@Test(groups = "RegressionTest")
	public void createOrgWithIndustryType() throws Exception {
		String orgname=eLib.getDataFromExcel("org",2,2);
		String indust=eLib.getDataFromExcel("org",2,5);
		String type=eLib.getDataFromExcel("org",2,6);
		int r_no=ju.getRandomNum(100);
		
		HomePage hp=new HomePage(driver);
		hp.getOrganizations().click();

		//click on new organization button
		OrganizationPage op=new OrganizationPage(driver);
		op.getCreateOrganizationbtn().click();

		//Enter Details
		CreateNewOrganizationPage cno=new CreateNewOrganizationPage(driver);
		cno.createOrg(orgname+r_no, indust, type);

		//Verify Expected Result
		//verify industry
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		System.out.println(oip.verifyIndustry(indust));
		System.out.println(oip.verifyType(type));
	}
}
