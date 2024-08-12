package practice.HomepageTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleTestScreenShot {

	@Test
	public void sampleScreenshot() {
		 WebDriver driver=new ChromeDriver();
		 driver.get("https://www.amazon.com");
		 
		 
	}
}
