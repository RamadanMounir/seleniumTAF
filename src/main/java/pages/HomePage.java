package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
		action=new Actions(driver);
	}

	@FindBy(css="a.ico-register")
	WebElement registerLink;
	
	@FindBy(linkText ="Log in")
	WebElement loginLink;
	
	@FindBy(css = "div.footer")
	public WebElement footer;
	
	@FindBy(linkText = "Computers")
	WebElement ComputersMenu;
	
	@FindBy(linkText = "Notebooks")
	WebElement NotebooksMenu;
	
	 
	
	public void openRegisterationPage() 
	{
		clickButton(registerLink);
	}
	public void openLoginPage()
	{
		clickButton(loginLink);
	}
	
	// this function will scroll you to the WebElement you want using (link text=value)
	// value used to can enter the value you want when invoking this function() and the function will tell you to enter the value so i had made an String variable called (TargetLink on contactUsPage) 
	public void scrollTo(String value)
	{
		// this target is an WebElement variable on PageBase used control the WebElement you want to search on it
		//footer variable used to limiting the driver to search on footer only 
		Target=footer.findElement(By.linkText(value));
		clickButton(Target);
	 
	}
	public void selectNotebooksMenu()
	{
		action.moveToElement(ComputersMenu).build().perform();
		action.moveToElement(NotebooksMenu).click().build().perform();
	}

	
	
	

}
