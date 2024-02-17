package Rahulshettyacademy.pageobjectmodel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Rahulshettyacademy.AbstractComponents.AbstractComponents;

import org.openqa.selenium.WebElement;

public class Productcatalogue extends AbstractComponents {
	WebDriver driver;
	public Productcatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(css =".mb-3")
	List<WebElement>products;
	
	@FindBy(css =".ng-animating")
	WebElement spinner;
	
	By productsby = By.cssSelector(".mb-3");
	By addTocat = By.cssSelector(".card-body button:last-of-type");
	By visible =By.cssSelector("#toast-container");
	public List<WebElement> getproductslist(){
		waitforElementToappear(productsby);
		return products;
	}
	
	public WebElement getproductname(String productName) {
		WebElement prod =products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
	 return prod;
		
	}
	
	public void addProductToCart(String productName) throws InterruptedException {
		WebElement prod=getproductname( productName);
		System.out.println(productName);
		prod.findElement(addTocat).click();
		waitforElementToappear(visible);
		waitforElementTodisappear();
		

}}
