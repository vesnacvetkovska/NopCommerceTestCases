package testCasesHomework4;

import org.testng.annotations.Test;
import org.testng.Assert;
import base.Base;
import pageObjectsRepository.CommonMethods;
import pageObjectsRepository.HomePageObjects;
import pageObjectsRepository.PDPObjects;
import pageObjectsRepository.PLPObjects;
import pageObjectsRepository.WishListPageObject;
import testData.TestData;
import org.testng.annotations.BeforeMethod;


public class TestCasesWishList extends Base {

	HomePageObjects hpo;
	WishListPageObject wpo;
	TestData td;
	PLPObjects plpo;
	PDPObjects pdpo;
	CommonMethods cm;
	
	@BeforeMethod
	 public void start () {
		openApp();
		
		hpo = new HomePageObjects();
		wpo = new WishListPageObject();
		td = new TestData();	
		plpo = new PLPObjects ();
		pdpo = new PDPObjects();
		cm = new CommonMethods();
		
	}
	
				
	/*@AfterMethod 
	public void quit () {
		
		driver.quit();     }*/
	@Test
	
	public void addToWishlistSucssesfuly () {
		hpo.navigateToBooksPage();
		plpo.addToCart(wpo.addtowishlist);
		wpo.wishlistLinkPopUp.click();
		
		Assert.assertEquals(driver.getTitle(), td.wishlistTitle);
		
	}
	
	//add to cart Nike Loose
	@Test
	
	public void addToCartItems () {
		cm.mouseOver(hpo.apparelTopMenu);
		cm.waitMethod(5, hpo.clothing);
		hpo.clothing.click();
		plpo.nikeTailwindLooseShorsSleeveRunningShirt.click();
		cm.selectSize(pdpo.selectMenuNikeLoose, 4);
		pdpo.enterQuantity.clear();
		pdpo.enterQuantity.sendKeys("4");
		pdpo.addToCartNikeLoosePDP.click();
		hpo.shoppingCartLinkPopUP.click();
		
		Assert.assertEquals((pdpo.skuField.getText()), td.nikeLooseSKUNumber);
		
		
	}
}
