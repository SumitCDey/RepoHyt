package com.comcast.crm.orgTest;

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

public class CreateORGTestwithPhoneNum {
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
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

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
		driver.findElement(By.id("phone")).sendKeys(phone_num);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])")).click();

		//Verify Expected Result
		//verify Phone Number
		String phno = driver.findElement(By.id("dtlview_Phone")).getText();
		if(phno.equals(phone_num)) {
			System.out.println(orgname+r_no+" is Created is created with phone number====PASS");
		}else {
			System.out.println(orgname+r_no+" is not Created with phone number====FAIL");
		}

		//logout from application
		wbu.mouseMoveOnElement(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();

	}
}
