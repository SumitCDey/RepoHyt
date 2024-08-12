package practice.HomepageTest;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest {

	@Test
	public void createContactTest() {
		
		//Spark Report Config
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvancedReport/report.html");
		spark.config().setDocumentTitle("Crm Test Suite Result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//Add Env info and Create Test
		ExtentReports report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Win11");
		report.setSystemInfo("Browser", "Chrome");
		ExtentTest test = report.createTest("createContactTest");
		
		
		test.log(Status.INFO, "Login to App");
		test.log(Status.INFO,"Navigate to contact page");
		test.log(Status.INFO,"Create Contact");
		if("HDFC".equals("HFC")) {
			test.log(Status.PASS, "Contact Created");
		}else {
			test.log(Status.FAIL,"Contact not Created");
		}
		report.flush();
	}
}
