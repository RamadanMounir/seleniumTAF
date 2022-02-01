package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="FullName")
	WebElement FullNameTxt;
	
	@FindBy(id="Email")
	WebElement emailTxt;
	
	@FindBy(id="Enquiry")
	WebElement enquiryTxt;
	
	@FindBy(css="button.button-1.contact-us-button")
	WebElement submitBtn;
	
	@FindBy(css="div.result")
	public WebElement successMessage;
	 
	public void ContactUs(String name , String email , String enquiryMsg )
	{
		
		setTextElementText(FullNameTxt, name);
		clear(emailTxt);
		setTextElementText(emailTxt, email);
		setTextElementText(enquiryTxt, enquiryMsg);
		clickButton(submitBtn);
		
	}
	
	
	
	
	

}
