package practice.HomepageTest;



import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.baseTest.BaseClass;



@Listeners(com.comcast.crm.listener.listen.class)
@Test(retryAnalyzer = com.comcast.crm.listener.RetryListener.class)
public class InvoiceTest extends BaseClass {

	@Test/*(retryAnalyzer = com.comcast.crm.listener.RetryListener.class)*/
	public void createInvoiceTest() {
		Assert.assertEquals(driver.getTitle(), "login");
	}
	
//	@Test
//	public void createInvoicewithContactTest() {
//		
//	}
}
