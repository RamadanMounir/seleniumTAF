package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTest extends TestBase{
	
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	String productName="Apple MacBook Pro 13-inch";
	@Test
	public void UserCanSearchForProducts()
	{
		searchObject=new SearchPage(driver);
		detailsObject=new ProductDetailsPage(driver);
		searchObject.ProductSearch(productName);
		searchObject.openProductDetailsPage();
		//Assert.assertEquals(detailsObject.productNameBreadCrumb.getText(),productname);
		Assert.assertTrue(detailsObject.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
		
	}
	


}
