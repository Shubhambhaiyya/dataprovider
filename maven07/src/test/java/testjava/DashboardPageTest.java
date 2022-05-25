package testjava;

import org.testng.annotations.Test;

import org.testng.Assert;


public class DashboardPageTest extends BaseTest{
	@Test(priority=5)
	public void verifyLogoutOption() {
		loginPage.loginMethod("Admin", "admin123");
		dashboardPage.logoutProcess();
		boolean verifyLoginBtnDisplayed = loginPage.verifyBtnLoginIsDisplayed();
		Assert.assertEquals(verifyLoginBtnDisplayed, true);


	}}
