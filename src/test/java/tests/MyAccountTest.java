package tests;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegisterationPage;

public class MyAccountTest extends TestBase{
	
	
	String firstName="kjnlnlolcnk";
	String lastName="chjbjkdcnkbl";
	String email="ttekqopogtsatrstt15t@gmail.com";
	String oldPassword="123456789";
	String newPassword="12345678";
	
	
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	MyAccountPage MyAccountObject;
	
	
	@Test(priority = 1)
	public void UserCanRegisterSuccessfully()
	{
		homeObject=new HomePage(driver);
		homeObject.openRegisterationPage();
		
		registerObject=new UserRegisterationPage(driver);
		registerObject.userRegisteration(firstName,lastName,email,oldPassword);
		//Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		
	}

	@Test(priority = 2)
	public void RegisteredUserCanChangePassword()
	{
		MyAccountObject=new MyAccountPage(driver);
		registerObject.openMyAccountPage();
		MyAccountObject.openChangePasswordPage();
		MyAccountObject.changePassword(oldPassword,newPassword);
		
	
		
	}
	

	@Test(priority = 3)
	public void RegisteredUserCanLogout()
	{
		registerObject.userLogout();
	}
	
	@Test(priority = 4)
	public void RegisteredUserCanLogin()
	{
		homeObject=new HomePage(driver);
		homeObject.openLoginPage();
		
		loginObject=new LoginPage(driver);
		loginObject.userLogin(email,newPassword );
	}
}
