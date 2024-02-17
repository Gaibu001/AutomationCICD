package Rahulshettyacademy.tests;
import java.time.Duration;
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


import Rahulshettyacademy.pageobjectmodel.Landing_page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest2  {

	public static void main(String[]args) throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "C:/Users/User/Downloads/KGV/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Landing_page landingpage = new Landing_page(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/");
		String productname="ZARA COAT 3";
		driver.findElement(By.cssSelector("#userEmail")).sendKeys("anshika@gmail.com");
		driver.findElement(By.cssSelector("#userPassword")).sendKeys("Iamking@000");
		driver.findElement(By.id("login")).click();
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod =products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
	    prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	    //ng-animating-->ask to developer which element to be used for invisibility of the element
	    //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
	    wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	    driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	    List<WebElement> Cartproducts = driver.findElements(By.cssSelector(".cartSection h3"));
	    boolean match =Cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productname));
	    Assert.assertTrue(match);
	    driver.findElement(By.cssSelector(".totalRow button")).click();
	    Actions a = new Actions(driver);
	    a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"India").build().perform();
	    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ta-results")));
	    driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
	    //JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,500)");
	    Thread.sleep(3000);
	    //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".actions .btnn.action__submit.ng-star-inserted")));
	    driver.findElement(By.xpath("//*[@class='btnn action__submit ng-star-inserted']")).click();
	    String text =driver.findElement(By.cssSelector(".hero-primary")).getText();
	    //Assert.assertEquals(text, "Thankyou for the order.");
	    Assert.assertTrue(text.equalsIgnoreCase("Thankyou for the order."));
	}
}
