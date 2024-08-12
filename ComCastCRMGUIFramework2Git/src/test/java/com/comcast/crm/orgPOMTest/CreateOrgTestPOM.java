package com.comcast.crm.orgPOMTest;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import com.comcast.crm.generic.fileUtility.ExcelUtility;
import com.comcast.crm.generic.fileUtility.FileUtility;
import com.comcast.crm.generic.webdriverUtility.WebDriverUtility;
import com.comcast.crm.objectRepositoryUtility.CreateNewOrganizationPage;
import com.comcast.crm.objectRepositoryUtility.HomePage;
import com.comcast.crm.objectRepositoryUtility.LoginPage;
import com.comcast.crm.objectRepositoryUtility.OrganizationInfoPage;
import com.comcast.crm.objectRepositoryUtility.OrganizationPage;

public class CreateOrgTestPOM {

	public static void main(String[] args) throws Exception {


		//Create object for property file
		FileUtility fLib=new FileUtility();

		//Create Object for excel file
		ExcelUtility eLib=new ExcelUtility();

		//Create Object of WebdriverUtility
		WebDriverUtility wbu=new WebDriverUtility();

		String url=fLib.getDataFromPropertiesFile("URL");
		String username=fLib.getDataFromPropertiesFile("USERNAME");
		String password=fLib.getDataFromPropertiesFile("PASSWORD");
		String browser=fLib.getDataFromPropertiesFile("BROWSER");

		//Random Numb and random string
		Random r=new Random();
		int r_no=r.nextInt(100);

		WebDriver driver=null;

		String orgname=eLib.getDataFromExcel("org", 1, 2);

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

		//login
		LoginPage lp=new LoginPage(driver);
		lp.LoginToApp(username, password);

		//Navigate to Organization Page
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

		//signout
		hp.signOut(driver);
		driver.quit();




	}
}
