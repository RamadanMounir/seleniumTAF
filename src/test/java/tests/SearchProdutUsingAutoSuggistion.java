package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProdutUsingAutoSuggistion extends TestBase{
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	String productName="mac";
	@Test
	public void autocomplete()
	{
		searchObject=new SearchPage(driver);
		searchObject.ProductSearchUsingAutoSuggest(productName);
		detailsObject=new ProductDetailsPage(driver);
		Assert.assertEquals(detailsObject.productNameBreadCrumb.getText(),"Apple MacBook Pro 13-inch");
		
	}


}
