package Rahulshettyacademy.pageobjectmodel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Rahulshettyacademy.AbstractComponents.AbstractComponents;

public class Orderpage extends AbstractComponents {
	WebDriver driver;
	public Orderpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy (css=".totalRow button")
	WebElement checkoutele;
	@FindBy (css="tr td:nth-child(3)")
	List<WebElement> productnames;
	
	public boolean verifyOrderDisplay(String productName) {
		System.out.println(productName);
		 boolean match =productnames.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
		 System.out.println(match);
		    return match;
	}

}
