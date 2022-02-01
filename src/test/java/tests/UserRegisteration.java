package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisteration extends TestBase {
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	String email="bemngfakjpngsaklslameeqr16@gmail.com";
	String password="123456789";
	
	@Test(priority = 1,alwaysRun = true)
	public void UserCanRegisterSuccessfully() throws InterruptedException 
	{
		homeObject=new HomePage(driver);
		homeObject.openRegisterationPage();
		
		registerObject=new UserRegisterationPage(driver);
		registerObject.userRegisteration("Ramadan","Mounir",email,password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		
	}

	@Test(priority=2)
	public void RegisteredUserCanLogout() throws InterruptedException
	{
		registerObject.userLogout();
		
	}
	
	@Test(priority=3 )
	public void RegisteredUserCanLogin() throws InterruptedException
	{
		homeObject=new HomePage(driver);
		homeObject.openLoginPage();
	
		loginObject=new LoginPage(driver);
		loginObject.userLogin(email,password);
	}
	
	@Test(priority=4)
	public void RegisteredUserCanLogout2()
	{
		registerObject.userLogout();
	}
}
