package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase{

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="small-searchterms")
	WebElement searchTextBox;

	@FindBy(css="button.button-1.search-box-button")
	WebElement searchBtn;

	@FindBy(id="ui-id-1")
	List<WebElement> productList;
	
	@FindBy(css="h2.product-title")
	WebElement productTitle;

	public void ProductSearch(String ProductName)
	{
		clear(searchTextBox);
		setTextElementText(searchTextBox, ProductName);
		clickButton(searchBtn);
	}
	
	public void openProductDetailsPage()
	{
		clickButton(productTitle);
	}

	public void ProductSearchUsingAutoSuggest(String searchTxt)
	{
		clear(searchTextBox);
		setTextElementText(searchTextBox, searchTxt);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		productList.get(0).click();
		
	}





}



