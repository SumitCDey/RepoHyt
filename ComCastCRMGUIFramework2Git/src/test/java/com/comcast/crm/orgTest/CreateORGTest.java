package com.comcast.crm.orgTest;



import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.comcast.crm.generic.fileUtility.ExcelUtility;
import com.comcast.crm.generic.fileUtility.FileUtility;
import com.comcast.crm.generic.webdriverUtility.WebDriverUtility;

public class CreateORGTest {
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

		String orgname=eLib.getDataFromExcel("org", 1, 2);
		

		WebDriver driver=null;

		//Random Numb and random string
		Random r=new Random();
		int r_no=r.nextInt(100);

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

		//Verify Expected Result
		//verify in header
		String h_info = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(h_info.contains(orgname+r_no))
		{
			System.out.println(orgname+r_no+" is Created in header====PASS");
		}else {
			System.out.println(orgname+r_no+" is not Created in header====FAIL");
		}

		//verify in table
		String org_info = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if(org_info.equals(orgname+r_no)) {
			System.out.println(orgname+r_no+" is Created in table====PASS");
		}else {
			System.out.println(orgname+r_no+" is not Created in table====FAIL");
		}

		//logout from application
		wbu.mouseMoveOnElement(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();

	}
}
