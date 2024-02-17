package Rahulshettyacademy.getReports;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsclass {
	

	
	
	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir")+"//reportd/extent.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Testing");
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports extent = new ExtentReports(); 
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Gaibu");
		extent.createTest(path);
		return extent;

		
		
	}

}
