package Rahulshettyacademy.tests;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Rahulshettyacademy.pageobjectmodel.Cartpage;
import Rahulshettyacademy.pageobjectmodel.Checkout_page;
import Rahulshettyacademy.pageobjectmodel.Confirmation_page;
import Rahulshettyacademy.pageobjectmodel.Landing_page;
import Rahulshettyacademy.pageobjectmodel.Orderpage;
import Rahulshettyacademy.pageobjectmodel.Productcatalogue;
import Rahulshettyacademy.testcomponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class SubmitOrderTest extends BaseTest {
	
	String productname="ZARA COAT 3";
	@Test(dataProvider = "getData",groups = "purchase")
	public void SubmitOrder(HashMap<String,String>input) throws InterruptedException, IOException {
	
		
		Productcatalogue productcatalogue = landingpage.loginApplication(input.get("email"),input.get("password"));
		List<WebElement> products = productcatalogue.getproductslist();
		productcatalogue.addProductToCart(input.get("productname"));
		Cartpage cartpage = productcatalogue.gotocart();
	    boolean match =cartpage.verifyproductDisplay(input.get("productname"));
	    Assert.assertTrue(match);
	    Checkout_page checkoutpage=cartpage.gotoCheckout();
	    checkoutpage.SelectCountry("India");
	    Confirmation_page confirmationpage =checkoutpage.submitOrder();
	    String text= confirmationpage.confirmation_message();
	    Assert.assertTrue(text.equalsIgnoreCase("Thankyou for the order."));
	}
	//parallel Tests
	//allwaysRun = true
	@Test(dependsOnMethods = {"SubmitOrder"})
	public void Orderlist() {
		Productcatalogue productcatalogue = landingpage.loginApplication("anshika@gmail.com","Iamking@000");
		Orderpage orderpage = productcatalogue.gotoOrder();
		Assert.assertTrue(orderpage.verifyOrderDisplay(productname));
		
	}
	@DataProvider
	public Object[][] getData() throws IOException{
		/*HashMap<String,String>map = new HashMap<String,String>();
		map.put("email","anshika@gmail.com");
		map.put("password","Iamking@000");
		map.put("productname","ZARA COAT 3");
		//return new Object[][] {{"anshika@gmail.com","Iamking@000","ZARA COAT 3"},{"shetty@gmail.com","Iamking@000","ADIDAS ORIGINAL"}};
		HashMap<String,String>map1 = new HashMap<String,String>();
		map1.put("email","shetty@gmail.com");
		map1.put("password","Iamking@000");
		map1.put("productname","ADIDAS ORIGINAL");*/
		List<HashMap<String, String>> data= getjsonDatatoMap("C:\\Users\\User\\eclipse-workspace\\SeleniumFrameworkDesign\\src\\main\\java\\Rahulshettyacademy\\Data\\purchaseorder.json")
				;
		
		return new Object[][] {{data.get(0)},{data.get(1)}};
	
	}
}

	

