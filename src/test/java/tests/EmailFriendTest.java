package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegisterationPage;

public class EmailFriendTest extends TestBase{

	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	EmailPage emailObject;
	String FriendEmail="tes6l54t14@Test1.com";
	String MessageForfriend="this product is good for you";
	String email="esleslttpppksqq123@gmail.com";

	String productName="mac";

	@Test(priority = 1,alwaysRun = true)
	public void UserCanRegisterSuccessfully() 
	{
		homeObject=new HomePage(driver);
		homeObject.openRegisterationPage();

		registerObject=new UserRegisterationPage(driver);
		registerObject.userRegisteration("egfew","egwdvcfd",email,"123456789");
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));

	}

	@Test(priority=2)
	public void autocomplete()
	{
		searchObject=new SearchPage(driver);
		searchObject.ProductSearchUsingAutoSuggest(productName);
		detailsObject=new ProductDetailsPage(driver);
		Assert.assertEquals(detailsObject.productNameBreadCrumb.getText(),"Apple MacBook Pro 13-inch");

	}


	@Test(priority=3)
	public void RegisteredUserCanSendEmailToFriend()
	{
		detailsObject.opensendEmail();
		emailObject=new EmailPage(driver);
		emailObject.sendEmailFriend(FriendEmail,MessageForfriend);
		assertTrue(emailObject.successMessage.getText().contains("Your message has been sent."));
	}

	@Test(priority=4)
	public void RegisteredUserCanLogout() throws InterruptedException
	{
		Thread.sleep(1000);
		registerObject.userLogout();
	}
}
