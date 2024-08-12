package practice.testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetProductInfo {

	@Test(dataProvider = "getData")
	public void getProductInfoTest(String brandName,String productName) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.com/");
		
		//Search Product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName,Keys.ENTER);
		String x="//span[text()='"+productName+"']/../../../..//span[@class='a-price-whole']";
		String price = driver.findElement(By.xpath(x)).getText();
		System.out.println(brandName+": "+"\n"+productName+": "+"\n"+price+"\n");
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getData(){
		Object [][] objarr=new Object[3][2];
		objarr[0][0]="iphone";
		objarr[0][1]="Apple iPhone 14, 256GB, Midnight for Verizon (Renewed)";
		
		objarr[1][0]="samsung";
		objarr[1][1]="Galaxy Tab A9+ Tablet 11” 64GB Android Tablet, Big Screen, Quad Speakers, Upgraded Chipset, Multi Window Display, Slim, Light, Durable Design, US Version, 2024, Graphite";

		objarr[2][0]="samsung";
		objarr[2][1]="Galaxy A15 (SM-155M/DSN), 128GB 6GB RAM, Dual SIM, Factory Unlocked GSM, International Version (Wall Charger Bundle) (Light Blue)";

		return objarr;
	}
}




