package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase {
	HomePage homeObject;
	ContactUsPage contactObject;
	String TargetLink="Contact us";
	String FullName="ghvsjcbkk";
	String email="zammll1qwutywqeww1hjhg13@test.com";
	String enquiryMessagesg="this is jhbfek jb";
	
	@Test
	public void contactUs()
	{
		homeObject=new HomePage(driver);
		
		homeObject.scrollTo(TargetLink);
		contactObject=new ContactUsPage(driver);
		contactObject.ContactUs(FullName, email, enquiryMessagesg);
		Assert.assertEquals(contactObject.successMessage.getText(),"Your enquiry has been successfully sent to the store owner.");
		
	}
	
	
}
