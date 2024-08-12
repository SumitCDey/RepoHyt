package com.comcast.crm.contactTest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileUtility.ExcelUtility;
import com.comcast.crm.generic.fileUtility.FileUtility;
import com.comcast.crm.generic.webdriverUtility.JavaUtility;
import com.comcast.crm.generic.webdriverUtility.WebDriverUtility;

public class CreateContactWithOrg {
	public static void main(String[] args) throws Exception {

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
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();

		//Navigate to Organization Module
		driver.findElement(By.linkText("Organizations")).click();

		//click on new organization button
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		//Enter Details
		driver.findElement(By.name("accountname")).sendKeys(orgname+r_no);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])")).click();
		WebElement wb=driver.findElement(By.id("dtlview_Organization Name"));
		wbu.waitForElement(driver, wb);

		//Navigate to contact Module
		driver.findElement(By.linkText("Contacts")).click();

		//click on new contact button
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		//Enter Details
		driver.findElement(By.name("lastname")).sendKeys(last_name+r_no);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		wbu.switchToTab(driver, "Popup&popuptype");
		driver.findElement(By.id("search_txt")).sendKeys(orgname+r_no);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgname+r_no+"']")).click();
		wbu.switchToParentTab(driver, "Contacts&action=EditView&return");
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])")).click();

		//verify expected results
		String act_org = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		//		System.out.println(act_org);
		if(act_org.trim().equals(orgname+r_no))
		{
			System.out.println("Contact Created With Org===PASS");
		}else {
			System.out.println("Contact not Created With Org===FAIL");
		}


		//logout from application
		wbu.mouseMoveOnElement(driver,driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();

	}
}
