package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationWithDDTAndDataprovider extends TestBase {
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	
	@DataProvider(name="testData")
	public static Object[][] userData()
	{
		return new Object[][]
				{
					{"ramadan","mazaly","ramadan2@gmail.com","123456789"},
					{"mazaly","mazaly","mazaly2@gmail.com","123456789"}
				};
	}
	
	@Test(priority = 1,alwaysRun = true,dataProvider = "testData")
	public void UserCanRegisterSuccessfully(String fname,String lname,String email,String password) throws InterruptedException 
	{
		homeObject=new HomePage(driver);
		homeObject.openRegisterationPage();
		
		registerObject=new UserRegisterationPage(driver);
		registerObject.userRegisteration(fname,lname,email,password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		registerObject.userLogout();
		homeObject.openLoginPage();	
		loginObject=new LoginPage(driver);
		loginObject.userLogin(email,password);
		registerObject.userLogout();
	}
/*
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
	//	loginObject.userLogin(email,password);
	}
	
	@Test(priority=4)
	public void RegisteredUserCanLogout2()
	{
		registerObject.userLogout();
	}*/
}
