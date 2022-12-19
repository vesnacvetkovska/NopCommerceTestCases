package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


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
	
	
}