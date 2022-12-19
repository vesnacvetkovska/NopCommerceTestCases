package testCasesHomework6;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NestedFrames {

	WebDriver driver;
	
	String url = "https://testpages.herokuapp.com/styled/frames/frames-test.html";
	
	
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
	
	//select lement from frame with index 1
	public void leftFrame () {
		driver.switchTo().frame(1);
		String element = driver.findElement(By.xpath("//*[@id=\"left6\"]")).getText();
		System.out.println (element);
		
	}
	// list to the element inside the frame, with scroll method, from Frame with index 2
	@Test
	public void middleFrame () {
		driver.switchTo().frame(2);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView", driver.findElement(By.xpath("//*[@id=\"middle32\"]")));
		String srolledElem = driver.findElement(By.xpath("//*[@id=\"middle32\"]")).getText();
		System.out.println(srolledElem);
			}
	
	// Switch to parent Frame, select the text "Nested Frames Example"
	@Test
	
	public void mainFrame () {
		String s = driver.switchTo().parentFrame().getTitle();
		System.out.println(s);
	}
	@Test
	
	// Switch to the footer frame, select the "EvilTester.com, Compendium Developments" text
	public void footerFrame () {
		String s = driver.switchTo().frame ("footer").getPageSource();
		Assert.assertTrue(s.contains("EvilTester.com"));
		Assert.assertTrue(s.contains( "Compendium Developments"));
		System.out.println(s);
	}
	
	// right Frame, with invisible elements, find an invisible element
	@Test
	public void rightFrame () {
	driver.switchTo().frame ("right");
	String invisibleElement= driver.findElement(By.xpath("//*[@id=\"right10\"]")).getText();
	System.out.println(invisibleElement);
	
	//get number of all elements
	int in = driver.findElements(By.xpath("//*[contains(text(),'Right List Item ')]")).size();
	
	System.out.println(in);}
	

}

