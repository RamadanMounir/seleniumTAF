package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationWithDDTAndExcel extends TestBase {
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;

	@DataProvider(name="ExceldData")
	public Object[][] userRegisterData() throws IOException
	{
		ExcelReader ER = new ExcelReader();
		return ER.getExcelData();
	}

	@Test(dataProvider ="ExceldData")
	public void UserCanRegisterSuccessfully(String firstname , String lastname , String email , String password) throws InterruptedException 
	{
		homeObject=new HomePage(driver);
		homeObject.openRegisterationPage();

		registerObject=new UserRegisterationPage(driver);
		registerObject.userRegisteration(firstname,lastname,email,password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		registerObject.userLogout();
		homeObject.openLoginPage();		
		loginObject=new LoginPage(driver);
		loginObject.userLogin(email,password);
		registerObject.userLogout();


	}
}
