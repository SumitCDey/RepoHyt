package com.comcast.crm.generic.webdriverUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.xml.crypto.KeySelector;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	//1
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	//2
	public void waitForElement(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	//3
	public void switchToTab(WebDriver driver,String partialURL) {
		Set<String> setwin = driver.getWindowHandles();
		for(String w:setwin) {
			driver.switchTo().window(w);
			String url=driver.getCurrentUrl();
			if(url.contains(partialURL)) {
				break;
			}	
		}
	}
	//4
	public void switchToParentTab(WebDriver driver,String parentURL) {
		Set<String> pwin = driver.getWindowHandles();
		for(String w:pwin) {
			driver.switchTo().window(w);
			String url=driver.getCurrentUrl();
			if(url.contains(parentURL)) {
				break;
			}
		}	
	}
	//5
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	//6
	public void switchToFrame(WebDriver driver,String nameID) {
		driver.switchTo().frame(nameID);
	}
	//7
	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	//8
	public void switchToFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	//9
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	//10
	public void switchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	//11
	public void select(WebElement element,String li) {
		Select sel=new Select(element);
		sel.selectByVisibleText(li);
	}
	//12
	public void selectMultiple(WebElement element,ArrayList<String> text) {
		Select sel=new Select(element);
		for(String t:text) {
			sel.selectByVisibleText(t);
		}
	}
	//13
	public void selectMultipleWithIndex(WebElement element,ArrayList<Integer> index) {
		Select sel=new Select(element);
		for(Integer t:index) {
			sel.selectByIndex(t);
		}
	}
	//14
	public void select(WebElement element,int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	//15
	public void mouseMoveOnElement(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	//16
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement trg) {
		Actions act=new Actions(driver);
		act.dragAndDrop(src, trg);
	}
	//17
	public void rightClick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element);
	}
	//18
	public void typeByKeyboard(WebDriver driver, WebElement element, String data ) {
		Actions act=new Actions(driver);
		act.sendKeys(element, data);
	}
	//19
	public void scrollToElement(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.scrollToElement(element);
	}
	//20
	public void scrollUntillElementIsVisible(WebDriver driver, WebElement element) {
		int y=element.getLocation().getY();
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,"+y+")");
	}
	//21
	public void doubleClick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	//22
	public void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	//23
	public void minimizeBrowser(WebDriver driver) {
		driver.manage().window().minimize();;
	}
	//24
	public void getPageScreenShot(WebDriver driver,String dest) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File srcfile = ts.getScreenshotAs(OutputType.FILE);
		File desfile=new File(dest);
		FileHandler.copy(srcfile, desfile);
	}
	//25
	public void getWebElementScreenShot(WebDriver driver,WebElement element,String dest) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File srcfile = element.getScreenshotAs(OutputType.FILE);
		File desfile=new File(dest);
		FileHandler.copy(srcfile, desfile);
	}
	
//	public void openBrowser(WebDriver driver, String browser) {
//		if(browser.equalsIgnoreCase("chrome")) {
//			driver=new ChromeDriver();
//		}else if(browser.equalsIgnoreCase("firefox")) {
//			driver=new FirefoxDriver();
//		}else if(browser.equalsIgnoreCase("edge")) {
//			driver=new EdgeDriver();
//		}else {
//			driver=new ChromeDriver();
//		}
//	}
//	public void keyPress(WebDriver driver, String key) {
//		Actions act=new Actions(driver);
//		
//		act.sendKeys(Keys.key);
//	}
}
