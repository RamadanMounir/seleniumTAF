package tests;

import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationWithDDTAndCSV extends TestBase {
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;

	
	CSVReader reader;
	@Test
	public void UserCanRegisterSuccessfully() throws InterruptedException, CsvValidationException, IOException 
	{
		//get path of CSV file
		String CSV_File=System.getProperty("user.dir")+"\\src\\test\\java\\data\\UserData2.csv";
		reader=new CSVReader(new FileReader(CSV_File));
		String []csvCell;
		
		while((csvCell=reader.readNext())!=null)
		{
			String firstname =csvCell[0];
			String lastname =csvCell[1];
			String email =csvCell[2];
			String password=csvCell[3];
		
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


	}}
}
