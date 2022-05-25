package testjava;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import mainjava.BaseClass;
import mainjava.DashboardPage;
import mainjava.LoginPage;

public class BaseTest extends BaseClass {
	@BeforeSuite
	public void WebBrowserLaunching() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOption = new ChromeOptions();
		chromeOption.addArguments("--start-maximized");
		driver = new ChromeDriver(chromeOption);
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	@BeforeClass	// @BeforeClass means before every class this object will get created
	public void allPageObjects() {
		loginPage = new LoginPage(driver);
		dashboardPage = new DashboardPage(driver);	// We have to initialize this and that is in BaseClass
	}
	
	@AfterClass
	public void tearDownBrowser() {
		driver.quit();
	}
	


}
