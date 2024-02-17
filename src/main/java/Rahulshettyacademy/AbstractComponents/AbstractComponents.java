package Rahulshettyacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Rahulshettyacademy.pageobjectmodel.Cartpage;
import Rahulshettyacademy.pageobjectmodel.Orderpage;

public class AbstractComponents {
	WebDriver driver;

	
	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="[routerlink*='cart']")
	WebElement cart;
	
	@FindBy(css="[routerlink*='orders']")
	WebElement order;
	
	
	
	public void waitforElementToappear(By findby) {
	 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	
	public void waitforElementTodisappear() throws InterruptedException {
		Thread.sleep(1000);
		/* WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		    wait.until(ExpectedConditions.invisibilityOf(ele));*/
		
	}
	public Cartpage gotocart() {
		cart.click();
		return new Cartpage(driver);
	}
	
	public Orderpage gotoOrder() {
		order.click();
		return new Orderpage(driver);
	}
	
	
	
	
	}

