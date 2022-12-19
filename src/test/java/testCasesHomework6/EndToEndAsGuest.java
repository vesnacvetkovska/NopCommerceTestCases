package testCasesHomework6;

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

public class EndToEndAsGuest extends Base {
	
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
	/*@AfterMethod 
		public void quit () {
		driver.quit();}*/
	
	@Test
	
	public void ednToEndScenarioAsGuest () {
		
		hpo.navigateToJewelryPage();
		plpo.elegantGemstoneNecklace.click();
		pdpo.rentAnItem();
		
		hpo.navigateToElectronicsPage();
		plpo.cameraAndPhoto.click();
		plpo.addToCart(plpo.nikonD550DSLR);
		cm.scrollToTheEle(pdpo.nikonD5500DSLRBlack);
		String s = cm.stringReturnMethod(pdpo.productPriceItem1);
		pdpo.addToCartNiconD5500DSLRBlack.click();
		hpo.shoppingCartLinkPopUP.click();
		System.out.println(s);
		System.out.println(pdpo.s2);
	}

}
