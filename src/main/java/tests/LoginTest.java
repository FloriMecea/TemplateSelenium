package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;





import pages.LoginPage;
import pages.NavMenuPage;
import utils.BaseTest;

public class LoginTest extends BaseTest {

	@Parameters({"user","pass"})
	@Test(priority=0, groups="LoginFunctionality")
	public void loginTest(String username, String password) throws InterruptedException {
		NavMenuPage navMenu= new NavMenuPage(driver);
		navMenu.navigateTo(navMenu.loginLink);
		
		LoginPage loginPage= new LoginPage(driver);
		
		loginPage.loginInApp(username, password);
		
		//varianta1
		assertTrue(loginPage.loginSuccessMessageIsDisplayed());

		loginPage.logoutFromApp();
	}
	
	@Parameters({"invalidUser","invalidPass"})
	@Test(priority=1)
	public void invalidLoginTest(String username, String password) throws InterruptedException {
		NavMenuPage navMenu= new NavMenuPage(driver);
		navMenu.navigateTo(navMenu.loginLink);
			
		LoginPage loginPage= new LoginPage(driver);
		
		loginPage.loginInApp(username, password);
		
		//varianta1
	  assertTrue(loginPage.loginErrorMessageIsDisplayed());
	   
	}
}
