package testCasesHomework5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitExamples {

	@Test
	public class addToCart {
		WebDriver driver;
		String url1 = "https://the-internet.herokuapp.com/dynamic_loading/1";
		String url2 = "https://bonigarcia.dev/selenium-webdriver-java/loading-images.html";
		String url3 = "https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html";
		String url4 = "http://uitestingplayground.com/ajax";
		
		
		
		
		@BeforeMethod
		
		public void openApp() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
		@Test
		
		public void helloWorldBtn () {
			driver.get(url1);
			driver.findElement(By.xpath("//*[@id=\"start\"]//child::button")).click();
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"finish\"]")));
						
			Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"finish\"]")).getText(), "Hello World!");
			
		}
		@Test
		
		public void doneText () {
			driver.get(url2);
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Done!')])[1]")));
			Assert.assertEquals(driver.findElement(By.id("text")).getText(), "Done!");
			
		}
		@Test
		
		public void allButtonsClicked () {
			driver.get(url3);
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("button00"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("button01"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("button02"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.id("button03"))).click();
			
			Assert.assertEquals(driver.findElement(By.xpath("(//*[contains(text(),'All Buttons Clicked')])")).getText(), "All Buttons Clicked");
		}
		
		@Test
		
		public void last () {
			driver.get(url4);
			driver.findElement(By.xpath("//*[@id=\"ajaxButton\"]")).click();
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"bg-success\"]"))).click();
			driver.findElement(By.xpath("//*[@class=\"bg-success\"]")).click();
			
			Assert.assertEquals(driver.findElement(By.xpath("//*[@class=\"bg-success\"]")).getText(), "Data loaded with AJAX get request.");
		}
		}
}