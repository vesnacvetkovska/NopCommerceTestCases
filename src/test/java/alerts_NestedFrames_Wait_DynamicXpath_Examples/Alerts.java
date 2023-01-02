package alerts_NestedFrames_Wait_DynamicXpath_Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {
	WebDriver driver;
	
	String url = "https://the-internet.herokuapp.com/javascript_alerts";
	
	
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
	public void clickforJSAlert () {
		driver.findElement(By.xpath("//*[@onclick=\"jsAlert()\"]")).click();
		driver.switchTo().alert().accept();
		String result = driver.findElement(By.xpath("//*[@id=\"result\"]")).getText();
		Assert.assertEquals(result, "You successfully clicked an alert");
		System.out.println(result);
	}
	@Test
	
	public void clickforJSConfirmAlert () {
		driver.findElement(By.xpath("//*[@onclick=\"jsConfirm()\"]")).click();
		driver.switchTo().alert().accept();
		String result = driver.findElement(By.xpath("//*[@id=\"result\"]")).getText();
		Assert.assertEquals(result, "You clicked: Ok");
		System.out.println(result);

	}
	@Test
	
	public void clickforJSPrompt () {
		driver.findElement(By.xpath("//*[@onclick=\"jsPrompt()\"]")).click();
		driver.switchTo().alert().sendKeys("123456");
		driver.switchTo().alert().accept();
		String result = driver.findElement(By.xpath("//*[@id=\"result\"]")).getText();
		
		Assert.assertEquals(result, "You entered: 123456");
		System.out.println(result);
	}
}
