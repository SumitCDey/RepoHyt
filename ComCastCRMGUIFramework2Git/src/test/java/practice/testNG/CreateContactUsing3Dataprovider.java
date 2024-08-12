package practice.testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(dataProvider = "getData")
public class CreateContactUsing3Dataprovider {

	public void createContactTest(String fn,String ln,long phonenum) {
		System.out.println("FirstName: "+fn);
		System.out.println("LastName: "+ln);
		System.out.println("PhoneNumber: "+phonenum);
		System.out.println();
	}

	@DataProvider
	public Object[][] getData(){
		Object [][] objarr=new Object[3][3];
		objarr[0][0]="Hiten";
		objarr[0][1]="Shahani";
		objarr[0][2]=9897961250l;

		objarr[1][0]="Gopika";
		objarr[1][1]="K";
		objarr[1][2]=9123192110l;

		objarr[2][0]="NagaLakshmi";
		objarr[2][1]="KR";
		objarr[2][2]=9123192121l;

		return objarr;

	}
}
