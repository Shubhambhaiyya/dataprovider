package extentUtility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class CustomReportssss {
public static ExtentReports extent;
	
	public static ExtentReports extentReportGenerator() {	// return type ExtentReportsis 
	//	System.getProperty("C:\\Users\\asus\\eclipse-workspace\\Katraj8Jan2022BatchMaven\\reports");// This is our local PC location, this will not work in client PC
		String path = System.getProperty("user.dir")+"\\reportss\\OrangeHRMExtentReport.html";
		ExtentHtmlReporter extentHtmlReporterr = new ExtentHtmlReporter(path);
		extentHtmlReporterr.config().setReportName("Regression Test Report");
		extentHtmlReporterr.config().setDocumentTitle("OrangeHRM Regression Suit");
		extentHtmlReporterr.config().setTheme(Theme.DARK);
		extentHtmlReporterr.config().setTimeStampFormat("EEEE, MMMM DD, YYYY, hh:mm a'('zzz')'");
		
		extent = new ExtentReports();
		extent.setSystemInfo("Os", "windows");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("org", "OrangeHRM");
		extent.attachReporter(extentHtmlReporterr);
		return extent;
	}

}



