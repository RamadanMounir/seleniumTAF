package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "Change password")
	WebElement changePasswordLink;
	
	@FindBy(id = "OldPassword")
	WebElement oldPasswordTxtBox;
	
	@FindBy(id = "NewPassword")
	WebElement newPasswordTxtBox;
	
	@FindBy(id = "ConfirmNewPassword")
	WebElement confirmPasswordTxtBox;
	
	@FindBy(css = "button.button-1.change-password-button")
	WebElement changePasswordBtn;
	
	@FindBy(css="div.bar-notification.success")
	public WebElement resultLb1;
	
	@FindBy(css="span.close")
	WebElement closeBar;
	
	
	public void changePassword(String oldPassword ,String newPassword )
	{
		setTextElementText(oldPasswordTxtBox, oldPassword);
		setTextElementText(newPasswordTxtBox, newPassword);
		setTextElementText(confirmPasswordTxtBox, newPassword);
		clickButton(changePasswordBtn);
		clickButton(closeBar);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void openChangePasswordPage()
	{
		clickButton(changePasswordLink);
	}
	
	
}
