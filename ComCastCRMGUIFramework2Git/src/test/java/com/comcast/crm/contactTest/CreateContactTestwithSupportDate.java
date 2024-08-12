package com.comcast.crm.contactTest;

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

public class CreateContactTestwithSupportDate {
	public static void main(String[] args) throws Exception {

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

		//
		Actions act=new Actions(driver);

		//login
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();

		//Navigate to Contacts Page Module
		driver.findElement(By.linkText("Contacts")).click();

		//click on new contact button
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		//Enter Details
		driver.findElement(By.name("lastname")).sendKeys(last_name+r_no);
		driver.findElement(By.id("jscal_field_support_start_date")).clear();
		driver.findElement(By.id("jscal_field_support_start_date")).sendKeys(start_Date);
		driver.findElement(By.id("jscal_field_support_end_date")).clear();
		driver.findElement(By.id("jscal_field_support_end_date")).sendKeys(end_Date);

		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])")).click();

		//Verify Expected Results
		//verify in table
		String act_date= driver.findElement(By.id("dtlview_Support Start Date")).getText();
		String act_e_date=driver.findElement(By.id("dtlview_Support End Date")).getText();
		if(act_date.equals(start_Date) && act_e_date.equals(end_Date)) {
			System.out.println(start_Date+ "  "+ end_Date+" contact created with valid support begin and end date in table===PASS");
		}else {
			System.out.println(start_Date + "  "+ end_Date+" contact not created with valid name in table===PASS");
		}

		//logout from application
		wbu.mouseMoveOnElement(driver,driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();


	}
}
