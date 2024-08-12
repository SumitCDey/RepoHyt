package com.comcast.crm.contactTest;

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

public class CreateContactTest {
	public static void main(String[] args) throws Exception {

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
		driver.manage().window().maximize();
		driver.get(url);
		wbu.waitForPageToLoad(driver);

		//login
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();

		//Navigate to Contacts Page Module
		driver.findElement(By.linkText("Contacts")).click();

		//click on new organization button
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		//Enter Details
		driver.findElement(By.name("lastname")).sendKeys(last_name+r_no);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])")).click();

		//Verify Expected Results
		//verify with header
		String act_lastname = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(act_lastname.contains(last_name+r_no)) {
			System.out.println(last_name+" contact created with valid name in header===PASS");
		}else {
			System.out.println(last_name+" contact not created with valid name in header===FAIL");
		}

		//verify in table
		String act_t_lastname= driver.findElement(By.id("dtlview_Last Name")).getText();
		if(act_t_lastname.equals(last_name+r_no)) {
			System.out.println(last_name+" contact created with valid name in table===PASS");
		}else {
			System.out.println(last_name+" contact not created with valid name in table===PASS");
		}

		//logout from application
		wbu.mouseMoveOnElement(driver,driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();

	}
}
