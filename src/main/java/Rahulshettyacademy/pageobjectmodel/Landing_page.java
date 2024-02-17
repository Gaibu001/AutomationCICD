package Rahulshettyacademy.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Rahulshettyacademy.AbstractComponents.AbstractComponents;

public class Landing_page extends AbstractComponents {
	
	WebDriver driver;
	public Landing_page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
    //pagefactory --> we can reduce the syntax to creating web element
	//WebElement user_mail1 =driver.findElement(By.cssSelector("#userEmail"));
	
	@FindBy(id="userEmail")
	WebElement user_mail;
	
	@FindBy(id="userPassword")
	WebElement passwordele;
	
	@FindBy(id="login")
	WebElement submit;
	
	public Productcatalogue loginApplication(String mail,String password) {
		user_mail.sendKeys(mail);
		passwordele.sendKeys(password);
		submit.click();
		return new Productcatalogue(driver);
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}
	

}
