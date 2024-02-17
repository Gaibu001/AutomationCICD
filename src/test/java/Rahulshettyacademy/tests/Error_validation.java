package Rahulshettyacademy.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import Rahulshettyacademy.pageobjectmodel.Cartpage;
import Rahulshettyacademy.pageobjectmodel.Checkout_page;
import Rahulshettyacademy.pageobjectmodel.Confirmation_page;
import Rahulshettyacademy.pageobjectmodel.Productcatalogue;
import Rahulshettyacademy.testcomponents.BaseTest;

public class Error_validation extends BaseTest {
	@Test()
	public void errorOrder() throws InterruptedException, IOException {
	
		String productname="ZARA COAT 3";
		Productcatalogue productcatalogue = landingpage.loginApplication("anshika@gmail.com","Iamking@000");
		List<WebElement> products = productcatalogue.getproductslist();
		productcatalogue.addProductToCart(productname);
		Cartpage cartpage = productcatalogue.gotocart();
	    boolean match =cartpage.verifyproductDisplay(productname);
	    Assert.assertTrue(match);
	    Checkout_page checkoutpage=cartpage.gotoCheckout();
	    checkoutpage.SelectCountry("India");
	    Confirmation_page confirmationpage =checkoutpage.submitOrder();
	    String text= confirmationpage.confirmation_message();
	    System.out.println(text);
	    Assert.assertTrue(text.equalsIgnoreCase("Thankyou for the Order."));
	}

}
