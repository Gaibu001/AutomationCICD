package Rahulshettyacademy.pageobjectmodel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Rahulshettyacademy.AbstractComponents.AbstractComponents;

public class Cartpage extends  AbstractComponents {
	WebDriver driver;
	public Cartpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy (css=".totalRow button")
	WebElement checkoutele;
	@FindBy (css=".cartSection h3")
	List<WebElement> cartproducts;
	
	public boolean verifyproductDisplay(String productName) {
		System.out.println(productName);
		System.out.println(cartproducts.get(0).getText());
		 boolean match =cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productName));
		 System.out.println(match);
		    return match;
	}
	
	public Checkout_page gotoCheckout() {
		checkoutele.click();
		return new Checkout_page(driver);
		
	}
	



}
