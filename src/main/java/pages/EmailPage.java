package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends PageBase {

	public EmailPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="FriendEmail")
	WebElement  FriendEmailTxt;
	
	@FindBy(id="PersonalMessage")
	WebElement  PersonalMessageTxt;
	
	@FindBy(css="button.button-1.send-email-a-friend-button")
	WebElement sendEmailtBtn;
	
	@FindBy(css="div.result")
	public WebElement successMessage;
	
	public void sendEmailFriend(String friendEmail ,String PersonalMessage )
	{
		clear(FriendEmailTxt);
		setTextElementText(FriendEmailTxt, friendEmail);
		setTextElementText(PersonalMessageTxt, PersonalMessage);
		clickButton(sendEmailtBtn);
	}
	
	

}
