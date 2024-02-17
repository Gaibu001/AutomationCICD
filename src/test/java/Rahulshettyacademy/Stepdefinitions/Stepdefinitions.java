package Rahulshettyacademy.Stepdefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Rahulshettyacademy.pageobjectmodel.Cartpage;
import Rahulshettyacademy.pageobjectmodel.Checkout_page;
import Rahulshettyacademy.pageobjectmodel.Confirmation_page;
import Rahulshettyacademy.pageobjectmodel.Landing_page;
import Rahulshettyacademy.pageobjectmodel.Productcatalogue;
import Rahulshettyacademy.testcomponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefinitions extends BaseTest {
	public Landing_page landingpage;
	 public Productcatalogue productcatalogue;
	 public Cartpage cartpage;
	 public Confirmation_page confirmationpage;
	 @Given("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_page() throws IOException {
		 landingpage= launchapplication();
	}
	 @Given("^Login with user name (.+) and password (.+)$")
	 public void Login_with_user_name_and_password(String name,String password) {
		 productcatalogue = landingpage.loginApplication(name,password);
	 }
	 @When("^I add product (.+) to the cart$")
	 public void I_add_product_to_the_cart(String product) throws InterruptedException {
		 List<WebElement> products = productcatalogue.getproductslist();
			productcatalogue.addProductToCart(product);

	 }
	 @When("^Checkout (.+) and submit the cart$")
	 public void checkout(String product) throws InterruptedException {
		  cartpage = productcatalogue.gotocart();
		    boolean match =cartpage.verifyproductDisplay(product);
		    Assert.assertTrue(match);
		    Checkout_page checkoutpage=cartpage.gotoCheckout();
		    checkoutpage.SelectCountry("India");
		     confirmationpage =checkoutpage.submitOrder();
	 }
	 @Then ("{string} is displayed in the configuration page")
	 public void the_configuration_page(String string) {
		 String text= confirmationpage.confirmation_message();
		    Assert.assertTrue(text.equalsIgnoreCase(string));
	 }
}
