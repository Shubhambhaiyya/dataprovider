package testjava;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginpageTest extends BaseTest{
	
	@Test(dataProvider="Logindata")
   public void	verifyLoginOfPag(String user,String pass,String exp) {
		
		loginPage.loginMethod(user,pass);
		
		String exptitle="https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		if(exp.equals("valid"))
		{
		if(exptitle.equals(loginPage.pageUrl()))
		{
			dashboardPage.logoutProcess();
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		}
		
		else if(exp.equals("invalid"))
		{
			if(exptitle.equals(loginPage.pageUrl()))
			{
				dashboardPage.logoutProcess();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
	}

	
	@DataProvider(name="Logindata")
	public String [][]getdata()
	       {
		String logindata[][]= {
				{"Admin","admin123","valid"},
				{"Admin123","adminbha123","invalid"},
				{"Admin1234","admin45123","invalid"},
				{"Admin00","admin","invalid"}
		            };
		return logindata;
	}
}
