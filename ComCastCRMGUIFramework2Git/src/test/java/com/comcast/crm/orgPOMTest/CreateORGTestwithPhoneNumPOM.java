package com.comcast.crm.orgPOMTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.comcast.crm.generic.fileUtility.ExcelUtility;
import com.comcast.crm.generic.fileUtility.FileUtility;
import com.comcast.crm.generic.webdriverUtility.JavaUtility;
import com.comcast.crm.generic.webdriverUtility.WebDriverUtility;
import com.comcast.crm.objectRepositoryUtility.CreateNewOrganizationPage;
import com.comcast.crm.objectRepositoryUtility.HomePage;
import com.comcast.crm.objectRepositoryUtility.LoginPage;
import com.comcast.crm.objectRepositoryUtility.OrganizationInfoPage;
import com.comcast.crm.objectRepositoryUtility.OrganizationPage;

public class CreateORGTestwithPhoneNumPOM {
	public static void main(String[] args) throws Exception {

		//Create object for property file
		FileUtility fLib=new FileUtility();

		//Create Object for excel file
		ExcelUtility eLib=new ExcelUtility();
		
		//Create Object for Java Utility
		JavaUtility ju=new JavaUtility();
		
		//create object for webdriver utility
		WebDriverUtility wbu=new WebDriverUtility();

		String url=fLib.getDataFromPropertiesFile("URL");
		String username=fLib.getDataFromPropertiesFile("USERNAME");
		String password=fLib.getDataFromPropertiesFile("PASSWORD");
		String browser=fLib.getDataFromPropertiesFile("BROWSER");

		String orgname=eLib.getDataFromExcel("org",3,2);
		String phone_num=eLib.getDataFromExcel("org",3,4);
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
		hp.NavigateToOrg();

		//click on new organization button
		OrganizationPage op=new OrganizationPage(driver);
		op.getCreateOrganizationbtn().click();

		//Enter Details
		CreateNewOrganizationPage cno=new CreateNewOrganizationPage(driver);
		cno.createOrg(orgname+r_no, phone_num);

		//Verify Expected Result
		//verify Phone Number
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		System.out.println(oip.verifyPhoneNum(phone_num));

		//logout from application
		hp.signOut(driver);
		driver.quit();

	}
}
