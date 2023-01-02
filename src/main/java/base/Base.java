package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver driver;
	String homePage = "https://demo.nopcommerce.com/";
	
	
	public void openApp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(homePage);
		driver.manage().window().maximize();
		
	}

public void openAppEdge () {
		
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get(homePage);
		driver.manage().window().maximize();
		
	}
public void openAppFF () {
	
	WebDriverManager.firefoxdriver().setup();
	driver = new FirefoxDriver();
	driver.get(homePage);
	driver.manage().window().maximize();
	
}
public void headlessBrowserChrome () {
	ChromeOptions options = new ChromeOptions();
	options.addArguments("headless");
}

	
}