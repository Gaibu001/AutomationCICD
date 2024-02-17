package Rahulshettyacademy.testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Rahulshettyacademy.Data.DataReader;
import Rahulshettyacademy.pageobjectmodel.Landing_page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
public WebDriver driver;
public Landing_page landingpage;
	public WebDriver initializeDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Rahulshettyacademy\\Resources\\Globalbrowser.properties");
		prop.load(fis);
		String browsername = System.getProperty("browser")!= null?System.getProperty("browser"):prop.getProperty("browser");
				// prop.getProperty("browser");
		if(browsername.contains("chrome")) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		if(browsername.contains("headless")) {
		options.addArguments("headless");
		}
		//System.setProperty("webdriver.chrome.driver", "C:/Users/User/Downloads/KGV/chromedriver.exe");
		 driver = new ChromeDriver(options);
		 driver.manage().window().setSize(new Dimension(1440,900));
		}
		else if(browsername.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
		
	}public List<HashMap<String, String>> getjsonDatatoMap(String file) throws IOException {
		String jsoncontent=FileUtils.readFileToString(new File(file),StandardCharsets.UTF_8);
	    ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsoncontent,new TypeReference<List<HashMap<String,String>>>(){});
	   return data;
	}
	
	@BeforeMethod
	public Landing_page  launchapplication() throws IOException {
		driver=initializeDriver();
		 landingpage = new Landing_page(driver);
		landingpage.goTo();
		return landingpage;
}
	public String getscreenshot(String testname,WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir")+"//reports//"+testname+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//"+testname+".png";
		
	}
	
	
}
