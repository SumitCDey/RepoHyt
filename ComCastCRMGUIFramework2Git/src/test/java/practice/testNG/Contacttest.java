package practice.testNG;

import org.testng.annotations.Test;

public class Contacttest {

	@Test(invocationCount = 3)
	public void createContactTest() {
		System.out.println("createContactTest");
	}
	
	@Test(dependsOnMethods = "createContactTest")
	public  void modifyContactTest() {
		System.out.println("modifyContactTest");
	}
	
	@Test(dependsOnMethods = "modifyContactTest")
	public  void deleteContactTest() {
		System.out.println("deleteContactTest");
	}
}
