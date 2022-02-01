package steps;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.UserRegisterationPage;
import tests.TestBase;

public class UserRegisteration extends TestBase {
	HomePage homeObject;
	UserRegisterationPage registerObject;
	
	@Given("The user on the Home Page")
	public void the_user_on_the_home_page()
	{
		homeObject=new HomePage(driver);
		homeObject.openRegisterationPage();
	   
	}
	
	@When("I click on Register link")
	public void i_click_on_register_link() 
	{
	   Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}
	@When("i entered {string},{string},{string},{string}")
	public void i_entered(String firstname, String lastname, String email, String password) {
		registerObject=new UserRegisterationPage(driver);
		registerObject.userRegisteration(firstname,lastname, email,password);
	   
	}
	
	/*
	@When("enter the user data")
	public void enter_the_user_data() 
	{
		registerObject=new UserRegisterationPage(driver);
		registerObject.userRegisteration("bajkbvj","jvjkvkka", "fgfvghjophv@gmail.com","123456789");
	   
	}
	*/
	
	@Then("the Registeration page displayed successfully")
	public void the_registeration_page_displayed_successfully() 
	{
		registerObject.userLogout();
	  
	}

}
