package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationWithDDTAndPropertiesFile extends TestBase {
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	String firsName=LoadProperties.userData.getProperty("firstname");
	String lastName=LoadProperties.userData.getProperty("lastname");
	String email=LoadProperties.userData.getProperty("email");
	String password=LoadProperties.userData.getProperty("password");
	
	@Test(priority = 1,alwaysRun = true)
	public void UserCanRegisterSuccessfully() throws InterruptedException 
	{
		homeObject=new HomePage(driver);
		homeObject.openRegisterationPage();
		
		registerObject=new UserRegisterationPage(driver);
		registerObject.userRegisteration(firsName,lastName,email,password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		
	}

	@Test(priority=2)
	public void RegisteredUserCanLogout() throws InterruptedException
	{
		registerObject=new UserRegisterationPage(driver);
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
