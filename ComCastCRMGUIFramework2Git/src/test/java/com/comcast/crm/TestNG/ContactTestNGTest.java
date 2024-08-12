package com.comcast.crm.TestNG;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileUtility.ExcelUtility;
import com.comcast.crm.generic.fileUtility.FileUtility;
import com.comcast.crm.generic.webdriverUtility.JavaUtility;
import com.comcast.crm.generic.webdriverUtility.WebDriverUtility;
import com.comcast.crm.objectRepositoryUtility.ContactInfoPage;
import com.comcast.crm.objectRepositoryUtility.ContactPage;
import com.comcast.crm.objectRepositoryUtility.CreateContactPage;
import com.comcast.crm.objectRepositoryUtility.CreateNewOrganizationPage;
import com.comcast.crm.objectRepositoryUtility.HomePage;
import com.comcast.crm.objectRepositoryUtility.LoginPage;
import com.comcast.crm.objectRepositoryUtility.OrganizationInfoPage;
import com.comcast.crm.objectRepositoryUtility.OrganizationPage;

public class ContactTestNGTest {

	@Test
	public void createContactTest() throws Exception {

		//Create object for property file
		FileUtility fLib=new FileUtility();

		//Create Object for excel file
		ExcelUtility eLib=new ExcelUtility();

		//create object for java utility
		JavaUtility ju=new JavaUtility();

		//create object for webdriverutility
		WebDriverUtility wbu=new WebDriverUtility();

		String url=fLib.getDataFromPropertiesFile("URL");
		String username=fLib.getDataFromPropertiesFile("USERNAME");
		String password=fLib.getDataFromPropertiesFile("PASSWORD");
		String browser=fLib.getDataFromPropertiesFile("BROWSER");

		String last_name=eLib.getDataFromExcel("contact",1,2);

		WebDriver driver=null;

		//Random Numb and random string
		int r_no=ju.getRandomNum(100);

		//launch browser
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

		//Navigate to Organization Page Module
		HomePage hp=new HomePage(driver);
		hp.getContacts().click();

		//click on new organization button
		ContactPage cp=new ContactPage(driver);
		cp.getCreateContactbtn().click();

		//Enter Details
		CreateContactPage cnp=new CreateContactPage(driver);
		cnp.createContact(last_name+r_no);

		//Verify Expected Results
		//verify with header
		ContactInfoPage cip=new ContactInfoPage(driver);
		//verify in header
		System.out.println(cip.verifyContactNameHeader(last_name));

		//verify in table
		System.out.println(cip.verifyContactNameTable(last_name));

		//logout from application
		hp.signOut(driver);
		driver.quit();
	}

	@Test
	public void createContactWithSupportDate() throws Exception {

		//Create object for property file
		FileUtility fLib=new FileUtility();

		//Create Object for excel file
		ExcelUtility eLib=new ExcelUtility();
		
		//create object for java utility
		JavaUtility ju=new JavaUtility();
		
		//create object for webdriver utility
		WebDriverUtility wbu=new WebDriverUtility();


		String url=fLib.getDataFromPropertiesFile("URL");
		String username=fLib.getDataFromPropertiesFile("USERNAME");
		String password=fLib.getDataFromPropertiesFile("PASSWORD");
		String browser=fLib.getDataFromPropertiesFile("BROWSER");

		//capture dates
		String start_Date=ju.getSystemDate("yyyy-MM-dd");
		String end_Date=ju.getRequiredDate("yyyy-MM-dd", 30);

		String last_name=eLib.getDataFromExcel("contact",1,2);

		WebDriver driver=null;

		//Random Numb and random string
		int r_no=ju.getRandomNum(100);

		//launch browser
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
		driver.get(url);
		LoginPage lp=new LoginPage(driver);
		lp.LoginToApp(username, password);

		//Navigate to Contacts Page Module
		HomePage hp=new HomePage(driver);
		hp.getContacts().click();

		//click on new contact button
		ContactPage cp=new ContactPage(driver);
		cp.getCreateContactbtn().click();

		//Enter Details
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.createContact(last_name+r_no, start_Date, end_Date);

		

		//Verify Expected Results
		//verify in table
		ContactInfoPage cip=new ContactInfoPage(driver);
		System.out.println(cip.verifySupportDate(start_Date, end_Date));

		//logout from application
		hp.signOut(driver);
		driver.quit();

	}

	@Test
	public void createContactWithOrgTest() throws Exception {

		//Create object for property file
		FileUtility fLib=new FileUtility();

		//Create Object for excel file
		ExcelUtility eLib=new ExcelUtility();

		//create object for java utility
		JavaUtility ju=new JavaUtility();

		//create object for db utility
		WebDriverUtility wbu=new WebDriverUtility();


		String url=fLib.getDataFromPropertiesFile("URL");
		String username=fLib.getDataFromPropertiesFile("USERNAME");
		String password=fLib.getDataFromPropertiesFile("PASSWORD");
		String browser=fLib.getDataFromPropertiesFile("BROWSER");

		String orgname=eLib.getDataFromExcel("org", 1, 2);
		String last_name=eLib.getDataFromExcel("contact",1,2);

		WebDriver driver=null;

		//Random Numb and random string
		int r_no=ju.getRandomNum(100);

		//launch browser
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
		driver.get(url);
		LoginPage lp=new LoginPage(driver);
		lp.LoginToApp(username, password);
		
		//Navigate to Organization Module
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
		System.out.println(cip.verifyOrganization(orgname+r_no));

		//logout from application
		hp.signOut(driver);
		driver.quit();

	}
}