package com.comcast.crm.baseTest;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseUtility.DBUtility;
import com.comcast.crm.generic.fileUtility.ExcelUtility;
import com.comcast.crm.generic.fileUtility.FileUtility;
import com.comcast.crm.generic.webdriverUtility.JavaUtility;
import com.comcast.crm.generic.webdriverUtility.WebDriverUtility;
import com.comcast.crm.objectRepositoryUtility.HomePage;
import com.comcast.crm.objectRepositoryUtility.LoginPage;

public class BaseClass {

	public DBUtility dbLib=new DBUtility();
	public FileUtility fLib=new FileUtility();
	public WebDriverUtility wbu=new WebDriverUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public WebDriver driver=null;
	public static WebDriver sd;
	public JavaUtility ju=new JavaUtility();
	public ExtentReports report;
	public ExtentTest test;
	public ExtentSparkReporter spark;

	@BeforeSuite(groups = {"Smoketest","RegressionTest"})
	public void configBS() throws SQLException {
		System.out.println("====Connect to DB, Report Config====");
		dbLib.getDbConnection();
		//Spark Report Config
		spark=new ExtentSparkReporter("./AdvancedReport/report.html");
		spark.config().setDocumentTitle("Crm Test Suite Result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		//Add Env info and Create Test
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Win11");
		report.setSystemInfo("Browser", "Chrome");
		test = report.createTest("createContactTest");
	}

	@AfterSuite
	public void configAS() throws SQLException {
		System.out.println("====close DB, Report Backup====");
		dbLib.closeDbConnection();
		report.flush();
	}

	//	@Parameters("Browser")
	@BeforeClass(groups = {"Smoketest","RegressionTest"})
	public void configBC() throws Exception {
		System.out.println("====Launch Browser====");
		String url=fLib.getDataFromPropertiesFile("URL");
		String browser="chrome";
		//fLib.getDataFromPropertiesFile("BROWSER");

		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}else {
			driver=new ChromeDriver();
		}


		wbu.maximizeBrowser(driver);
		sd=driver;
		wbu.waitForPageToLoad(driver);
		driver.get(url);
	}

	@AfterClass(groups = {"Smoketest","RegressionTest"})
	public void configAC() {
		System.out.println("====Close Browser====");		
		driver.quit();
	}

	@BeforeMethod(groups = {"Smoketest","RegressionTest"})
	public void configBM() throws Exception {
		LoginPage lp=new LoginPage(driver);
		System.out.println("====Login to Application====");
		String username=fLib.getDataFromPropertiesFile("USERNAME");
		String password=fLib.getDataFromPropertiesFile("PASSWORD");
		lp.LoginToApp(username, password);
	}

	@AfterMethod(groups = {"Smoketest","RegressionTest"})
	public void configAM() {
		System.out.println("====Logout from Application====");
		HomePage hp=new HomePage(driver);
		hp.signOut(driver);
	}
}
