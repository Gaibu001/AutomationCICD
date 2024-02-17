package Rahulshettyacademy.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Rahulshettyacademy.AbstractComponents.AbstractComponents;

public class Confirmation_page extends AbstractComponents{
	WebDriver driver;
	public Confirmation_page(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".hero-primary")
	WebElement message;
	
	public String confirmation_message() {
		return message.getText();
	}
}
