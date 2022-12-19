package testCasesHomework4;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import base.Base;
import pageObjectsRepository.CommonMethods;
import pageObjectsRepository.HomePageObjects;
import testData.TestData;

public class TestScrollToElementAndMouseOverForLoop extends Base {
	HomePageObjects hpo;
	TestData td;
	CommonMethods cm;
	@BeforeMethod
	public void start () {
		openApp ();
		hpo = new HomePageObjects();
		td = new TestData();
		cm = new CommonMethods();
		}
	@AfterMethod
	public void  quit () throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		
	
	}
	
	@Test
	public void scrolling () throws InterruptedException {
		
		cm.scrollToTheEle(hpo.excelent);
		hpo.excelent.click();
		cm.scrollToTheEle(hpo.registerBtnHomePage);
		hpo.registerBtnHomePage.click();
	
		
		//hpo.scrollToTheEle(hpo.registerBtnHomePage);
		
	
	}
	@Test
	public void mousOver () {
		cm.mouseOverMenu(hpo.computerTopMenu, hpo.desctopSumMenu);
		
		
		
	}
	public void addItemsToCart () {
		driver.get("https://demo.nopcommerce.com/others");
		
		int others = driver.findElements(By.xpath("//*[@class=\"item-box\"]")).size();
		System.out.println(others);
		
		for (int i = 1;  i <= others; i++) {
			
			System.out.println(driver.findElement(By.xpath("(//h2[@class=\"product-title\"])[" +i+ "]")).getText());
			
		}
	}}

