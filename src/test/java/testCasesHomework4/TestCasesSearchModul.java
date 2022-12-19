package testCasesHomework4;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageObjectsRepository.HomePageObjects;
import testData.TestData;

public class TestCasesSearchModul extends Base {
	
	HomePageObjects hpo;
	TestData td;
	
	@BeforeMethod
	public void start () {
		openApp ();
		hpo = new HomePageObjects();
		td = new TestData();
		
	}
	
	@AfterMethod
	
	public void quit () throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	@Test
	
	//Search for existing product
	public void TC_SEARCH_001 () {
		hpo.searchItem(td.nike);
		
		int size = driver.findElements(By.xpath("//h2[@class=\"product-title\"]")).size();
		
		for(int i = 1; i < size + 1; i++) {
			
			String text = driver.findElement(By.xpath("(//h2[@class=\"product-title\"])[" +i+ "]")).getText();
			assertTrue((text.toLowerCase().contains((td.nike).toLowerCase())), "Error: item " + td.nike + " is not available in the results");
		                  
	}
	}
	//Search for non-existing product
	@Test
	
	public void TC_SEARCH_002 () {
		hpo.searchItem(td.sony);
		
		Assert.assertEquals((driver.findElement(By.xpath("//div[@class=\"products-container\"]")).getText()),
		"No products were found that matched your criteria."); }
		
	
	// Test if search works for a less then 3 character keyword
	@Test
	
		public void TC_SEARCH_004 () throws InterruptedException {
			hpo.searchItem(td.hp);
			Thread.sleep(2000);
			String text = driver.findElement(By.xpath("//div[@class=\"page search-page\"]")).getText();
			
			assertTrue(text.contains("Search term minimum length is 3 characters"), "The test faild");
			
		}
		
		
		
		
	}
	


