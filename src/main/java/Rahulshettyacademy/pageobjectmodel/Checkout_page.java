package Rahulshettyacademy.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Rahulshettyacademy.AbstractComponents.AbstractComponents;

public class Checkout_page extends AbstractComponents{
	WebDriver driver;
	public Checkout_page(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
@FindBy (xpath="(//button[contains(@class,'ta-item')])[2]")
WebElement selectCountry;

@FindBy (css="[placeholder='Select Country']")
WebElement country;

@FindBy (css=".action__submit")
WebElement submit;

By results = By.cssSelector(".ta-results");

public void SelectCountry(String countryname) {
	Actions a = new Actions(driver);
    a.sendKeys(country,countryname).build().perform();
    waitforElementToappear(results);
    selectCountry.click();
}

public Confirmation_page submitOrder() throws InterruptedException {
	JavascriptExecutor js = (JavascriptExecutor)driver;
    js.executeScript("window.scrollBy(0,500)");
    Thread.sleep(2000);
    submit.click();
    return new Confirmation_page(driver);	
}

}
