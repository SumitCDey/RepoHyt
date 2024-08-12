package practice.testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CreateCCTest {

	@Test
	public void createContact() {
		System.out.println("execute CreateContact");
	}
	
	@Test
	public void modifyContact() {
		System.out.println("execute Modify Contact");
	}
	
	@BeforeMethod
	public void configBM() {
		System.out.println("execute Before Method");
	}
	
	@AfterMethod
	public void configAM() {
		System.out.println("execute After Method");
	}
	
	@BeforeClass
	public void configBC() {
		System.out.println("execute Before Class");
	}
	
	@AfterClass
	public void configAC() {
		System.out.println("execute After Class");
	}
	
	@BeforeSuite
	public void configBS() {
		System.out.println("execute Before Suite");
	}
	
	@AfterSuite
	public void configAS() {
		System.out.println("execute After Suite");
	}
}
