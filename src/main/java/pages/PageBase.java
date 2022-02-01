package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {

	protected static WebDriver driver;

	public Select select;
	public Actions action;
	//constructor
	public PageBase(WebDriver driver)
	{
		PageFactory.initElements(driver, this);

	}
	
	protected static void clickButton(WebElement button) 
	{
		button.click();	
	}
	
	protected static void setTextElementText(WebElement element,String value) 
	{
		element.sendKeys(value);
	}
	//javascript function to scroll to WebElement
	WebElement Target;
	
	public void scrollBottom()
	{
		JavascriptExecutor js =((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);",Target);
		clickButton(Target);

	}
	public void clear(WebElement element)
	{
		element.clear();
		
	}
	
	

}
