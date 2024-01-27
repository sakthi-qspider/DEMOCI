package BrowserFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Utility.ConfigReader;

public class BaseClass {
	public WebDriver driver;
	
	//String browserName="Firefox";
	
	
	@BeforeMethod
	
	public void openApplication() throws Exception {
		
		if(ConfigReader.getConfig("browser").equalsIgnoreCase("chrome")) {
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--headless");
			
			driver=new ChromeDriver(options);
			
		}else if(ConfigReader.getConfig("browser").equalsIgnoreCase("Firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			
			driver=new FirefoxDriver(options);
			
		}else if(ConfigReader.getConfig("browser").equalsIgnoreCase("IE")) {
			
			driver=new EdgeDriver();
			
		}else {
			System.out.println("Please Specifi the browser....");
		}
		driver.manage().window().maximize();
		driver.get(ConfigReader.getConfig("url"));
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.getConfig("PageLoad"))));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.getConfig("ImplicitWait"))));
		System.out.println(ConfigReader.getConfig("ImplicitWait"));
		
	}
	
	
	
	@AfterMethod
	public void closeApplication() {
		
		driver.quit();
		System.out.println("Successfully closed browser");
	}

}
