package mainjava;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass{
	@FindBy(id="txtUsername")			// id from the page in " "
	WebElement userName;	// we can take any name of WebElement, here we have taken username
	
	@FindBy(id="txtPassword")
	WebElement password;
	
	@FindBy(id="btnLogin")
	WebElement btnLogin;
	
	@FindBy(id="spanMessage")
	WebElement invalidMsg;
	
	// All of these locators are nothing but the variables
	
	// Initialization of variables of page (locators)----We require constructor
	public LoginPage(WebDriver driver) {	// This is the constructor and initialization on WebDriver
		this.driver=driver;
		
	// @FindBy annotation is always comes with the support of pageFactory
	// PageFactory is a class present in the selenium which offers wonderful utility for a Page Object Model (POM)
	// That utility involves @FindBy, initElements method
	// initElements method is nothing but the initialization of elements upon driver and location of that driver
	// (WebDriver driver)this driver which is initialized with the global driver need to be initialized with the element in the sequential manner
		
		PageFactory.initElements(driver, this);
	}
	
	// Steps or methods to perform test cases related to current page
	
	// Test Case 1 : Verify Page Title
	
	@SuppressWarnings("deprecation")
	public void loginMethod(String usernameData, String passwordData) {
	//	userName.clear();
		userName.sendKeys(usernameData);
	//	password.clear();
		password.sendKeys(passwordData);
		btnLogin.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}

	public String pageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public String pageUrl() {
		String url = driver.getCurrentUrl();
 	    return url;
	}
	
	public String msgUponInvalidCred(String expectedInvMsg) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String invMsg= invalidMsg.getText();
		return invMsg;
	}
	
	public boolean verifyBtnLoginIsDisplayed() {
		return btnLogin.isDisplayed();
	}


}
