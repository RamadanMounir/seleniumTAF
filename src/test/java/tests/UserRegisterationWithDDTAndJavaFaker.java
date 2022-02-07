package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationWithDDTAndJavaFaker extends TestBase {
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	Faker fakeData =new Faker();
	String firstname =fakeData.name().firstName();
	String lastname=fakeData.name().lastName();
	String email=fakeData.internet().emailAddress();
	String password=fakeData.number().digits(9).toString();


	@Test
	public void UserCanRegisterSuccessfully( ) 
	{
		homeObject=new HomePage(driver);
		homeObject.openRegisterationPage();

		registerObject=new UserRegisterationPage(driver);
		registerObject.userRegisteration(firstname,lastname,email,password);
		System.out.println("The user data is :\n"+"first Name =  "+firstname+"\n"+"last Name =  "+lastname+"\n"+"email =  "+email+"\n"+"password =  "+password+"\n");
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		registerObject.userLogout();
		homeObject.openLoginPage();		
		loginObject=new LoginPage(driver);
		loginObject.userLogin(email,password);
		registerObject.userLogout();


	}
}
