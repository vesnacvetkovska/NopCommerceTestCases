package test_Cases_NopCommerce_Demo_WebPage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageObjectsRepository.CheckoutPageObjects;
import pageObjectsRepository.CommonMethods;
import pageObjectsRepository.HomePageObjects;
import pageObjectsRepository.PDPObjects;
import pageObjectsRepository.PLPObjects;
import pageObjectsRepository.RegisterPageObjects;
import pageObjectsRepository.ShoppingCartObjects;
import pageObjectsRepository.WishListPageObject;
import testData.TestData;

public class TestCasesPLP extends Base {
	HomePageObjects hpo;
	WishListPageObject wpo;
	TestData td;
	PLPObjects plpo;
	PDPObjects pdpo;
	ShoppingCartObjects shco;
	CommonMethods cm;
	RegisterPageObjects rpo;
	CheckoutPageObjects chpo;
		
	@BeforeMethod
	 public void start () {
		openApp();
		
		hpo = new HomePageObjects();
		wpo = new WishListPageObject();
		td = new TestData();	
		plpo = new PLPObjects ();
		pdpo = new PDPObjects();
		shco = new ShoppingCartObjects();
		cm = new CommonMethods();
		rpo = new RegisterPageObjects();
		chpo = new CheckoutPageObjects ();
		
	}
	@AfterMethod 
		public void quit () {
		driver.quit();}
	
	
	// Verify the filter option is working 
	@Test
	
	public void TC_PRODUCT_002 () {
		
		hpo.navigateToComputersPage();
		plpo.notebooks.click();
		plpo.i5CPU.click();
		plpo.ram8GB.click();
		driver.navigate().refresh();
		plpo.elementInList.click();
		Assert.assertTrue(pdpo.shortDescription.getText().contains(td.i5CPU));
		Assert.assertTrue(pdpo.shortDescription.getText().contains(td.ram8GB));
	}
	
	@Test
	// Compare two products
	public void TC_PRODUCT_009() {
		hpo.navigateToElectronicsPage();
		plpo.cellPhones.click();
		plpo.addToCompareHTCOneMiniBlue.click();
		driver.navigate().refresh();
		plpo.addToCompareNokiaLumia1020.click();
		driver.navigate().refresh();
		plpo.productComparisonLink.click();
		Assert.assertTrue(plpo.compareProducts.getText().contains(td.nokiaLumia1020));
		Assert.assertTrue(plpo.compareProducts.getText().contains(td.htcOneMiniBlue));
	}
	
	@Test
	//Remove product from comparison page
	public void TC_PRODUCT_010 () {
		hpo.navigateToElectronicsPage();
		plpo.cellPhones.click();
		plpo.addToCompareHTCOneMiniBlue.click();
		driver.navigate().refresh();
		plpo.addToCompareNokiaLumia1020.click();
		driver.navigate().refresh();
		plpo.productComparisonLink.click();
		
		int size = driver.findElements(By.xpath("//*[@class=\"button-2 remove-button\"]")).size();
		
		for(int i=0; i<size; i++) {
			plpo.removeBtnComparePage.click();
			}
		
		Assert.assertTrue(driver.getPageSource().contains(td.youHaveNoItemsToCompare));
		
		
	}
}
