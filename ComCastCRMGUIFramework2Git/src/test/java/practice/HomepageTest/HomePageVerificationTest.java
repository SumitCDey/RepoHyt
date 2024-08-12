package practice.HomepageTest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileUtility.FileUtility;
import com.comcast.crm.generic.webdriverUtility.WebDriverUtility;
import com.comcast.crm.objectRepositoryUtility.HomePage;
import com.comcast.crm.objectRepositoryUtility.LoginPage;


public class HomePageVerificationTest {

	FileUtility fLib=new FileUtility();
	
	WebDriverUtility wbu=new WebDriverUtility();
	
	@Test
	public void homePagetest() throws Exception {
		WebDriver driver=new ChromeDriver();
		
		String expPage = "Home";
		wbu.maximizeBrowser(driver);
		wbu.waitForPageToLoad(driver);
		String url=fLib.getDataFromPropertiesFile("URL");
		driver.get(url);
		
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		
		lp.LoginToApp(fLib.getDataFromPropertiesFile("USERNAME"), fLib.getDataFromPropertiesFile("PASSWORD"));
		String home=hp.getHomeLink().getText();
		
		Assert.assertTrue(expPage.trim().equalsIgnoreCase(home));
			
		driver.quit();
	}
	
	@Test
	public void verifyHomePageLogo() throws Exception {
		WebDriver driver=new ChromeDriver();
		
		wbu.maximizeBrowser(driver);
		wbu.waitForPageToLoad(driver);
		String url=fLib.getDataFromPropertiesFile("URL");
		driver.get(url);
		
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		
		lp.LoginToApp(fLib.getDataFromPropertiesFile("USERNAME"), fLib.getDataFromPropertiesFile("PASSWORD"));
				
		Assert.assertTrue(hp.getVtigerLogo().isEnabled());
			
		driver.quit();
	}
}
