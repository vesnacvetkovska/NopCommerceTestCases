package alerts_NestedFrames_Wait_DynamicXpath_Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynmaicXPath {

	WebDriver driver;
	
	String url = "http://uitestingplayground.com/dynamictable";
	
	
	@BeforeMethod
	
	public void openApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	@AfterMethod
	
	public void close () {
		driver.close();}
	@Test
	
	public void dynamicXpath () {
		String xpathString= driver.findElement(By.xpath("//span[contains(text(),'Chrome')]//following-sibling ::span[contains(text(),'%')]")).getText();
		String result = driver.findElement(By.xpath("//*[@class=\"bg-warning\"]")).getText();
		//System.out.println(result);
		String snew = result.replace("Chrome CPU: ", "");
		//System.out.println(snew);
		Assert.assertEquals(xpathString, snew);
	}
	
	
}
