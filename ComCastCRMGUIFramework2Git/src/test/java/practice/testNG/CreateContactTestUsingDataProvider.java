package practice.testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactTestUsingDataProvider {

	@Test(dataProvider = "getData")
	public void createContactTest(String fn,String ln) {
		System.out.println("FirstName: "+fn+" LastName: "+ln);
//		System.out.println("LastName: "+ln);
	}
	
	@DataProvider
	public Object[][] getData(){
		Object [][] objarr=new Object[3][2];
		objarr[0][0]="Hiten";
		objarr[0][1]="Shahani";
		objarr[1][0]="Gopika";
		objarr[1][1]="K";
		objarr[2][0]="NagaLakshmi";
		objarr[2][1]="KR";
		
		return objarr;
		
	}
}
