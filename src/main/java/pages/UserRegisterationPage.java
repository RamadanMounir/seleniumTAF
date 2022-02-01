package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegisterationPage extends PageBase {

	public UserRegisterationPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id="gender-male")
	WebElement genderRdoBtn;

	@FindBy(id="FirstName")
	WebElement fnTxtBox;

	@FindBy(id="LastName")
	WebElement lnTxtBox;
	
	@FindBy(name = "DateOfBirthDay")
	WebElement day;
	
	@FindBy(name = "DateOfBirthMonth")
	WebElement month;
	
	@FindBy(name = "DateOfBirthYear")
	WebElement year;

	@FindBy(id="Email")
	WebElement emailTxtBox;

	@FindBy(id="Password")
	WebElement passwordTxtBox;

	@FindBy(id="ConfirmPassword")
	WebElement confirmPasswordTxtBox;

	@FindBy(id="register-button")
	WebElement registerBtn;

	@FindBy(css="div.result")
	public WebElement successMessage;
	
	@FindBy(css="a.ico-logout")
	WebElement logoutBtn;//=driver.findElement(By.xpath("//a[contains(text(),'Log out')]"));
	
	@FindBy(linkText = "My account")
	WebElement myAccountBtn;
	
	
	
	public void userRegisteration(String firstName ,String lastName ,String email ,String password)
	{
		clickButton(genderRdoBtn);
		setTextElementText(fnTxtBox,firstName);
		setTextElementText(lnTxtBox, lastName);	
		setTextElementText(emailTxtBox, email);
		setTextElementText(passwordTxtBox, password);
		setTextElementText(confirmPasswordTxtBox, password);
		clickButton(registerBtn);
	}
	
	public void userLogout()
	{
		clickButton(logoutBtn);
	}

	public void openMyAccountPage()
	{
		clickButton(myAccountBtn);
	}


}
