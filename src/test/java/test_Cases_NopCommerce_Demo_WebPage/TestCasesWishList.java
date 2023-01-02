package test_Cases_NopCommerce_Demo_WebPage;

import org.testng.annotations.Test;
import org.testng.Assert;
import base.Base;
import pageObjectsRepository.CommonMethods;
import pageObjectsRepository.HomePageObjects;
import pageObjectsRepository.LoginPageObjects;
import pageObjectsRepository.PDPObjects;
import pageObjectsRepository.PLPObjects;
import pageObjectsRepository.RegisterPageObjects;
import pageObjectsRepository.ShoppingCartObjects;
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
	RegisterPageObjects rpo = new RegisterPageObjects() ;
	LoginPageObjects lpo = new LoginPageObjects();
	ShoppingCartObjects shco = new ShoppingCartObjects();
	
	@BeforeMethod
	 public void start () {
		openApp();
		
		hpo = new HomePageObjects();
		wpo = new WishListPageObject();
		td = new TestData();	
		plpo = new PLPObjects ();
		pdpo = new PDPObjects();
		cm = new CommonMethods();
		rpo = new RegisterPageObjects();
		shco = new ShoppingCartObjects();
	}
	
				
	/*@AfterMethod 
	public void quit () {
		
		driver.quit();     }*/
	
	// Check Add products to Cart from wishlist page functionality is working correctly
	@Test
	
	public void TC_WISHLIST_003 () {
		hpo.navigateToBooksPage();
		plpo.addToCart(wpo.addtowishlistFirstPrizePies);
		wpo.wishlistLinkPopUp.click();
		
		
		
		Assert.assertEquals(driver.getTitle(), td.wishlistTitle);
		
	}
	
	@Test
	
	//Check the Share wishlist functionality, only registered can email
	public void TC_WISHLIST_004 () {
		
		hpo.navigateToBooksPage();
		plpo.addToCart(wpo.addtowishlistFirstPrizePies);
		wpo.wishlistLinkPopUp.click();
		wpo.emailAFriendFromWishList.click();
		
		Assert.assertEquals(driver.getCurrentUrl(), td.emailfriend);
		wpo.emailAFriend ();
		Assert.assertTrue(driver.getPageSource().contains(td.onlyRegisCanEmail));
		
	}
	@Test
	
	// Check if it is possible to change the quantity of the product in wish list 
	public void TC_WISHLIST_006() {
	
		hpo.navigateToBooksPage();
		plpo.addToCart(wpo.addtowishlistFirstPrizePies);
		wpo.wishlistLinkPopUp.click();
		shco.inputQuantity.clear();
		shco.inputQuantity.sendKeys("3");
		shco.updateCart.click();
		
		Assert.assertEquals(shco.inputQuantity.getAttribute("value"), td.QuantityInWishlist);
		
	}
	@Test
	
	// Access the added product details from the wish list by clicking the image
	public void TC_WISHLIST_009() {
	
		hpo.navigateToBooksPage();
		plpo.addToCart(wpo.addtowishlistFirstPrizePies);
		wpo.wishlistLinkPopUp.click();
		wpo.productPictureWishlist.click();
		Assert.assertEquals(driver.getCurrentUrl(), td.firstPrizePiesUrl);
	}
	
	//Check if the total price is calculated correctly
	@Test
	
	public void TC_WISHLIST_007 () {
		
		hpo.navigateToBooksPage();
		plpo.addToCart(wpo.addtowishlistFirstPrizePies);
		wpo.wishlistLinkPopUp.click();
		shco.inputQuantity.clear();
		shco.inputQuantity.sendKeys(td.QuantityInWishlist);
		shco.updateCart.click();
		
		Assert.assertEquals(wpo.subTotalPrice.getText(), td.subTotalExpectedSum);
		
	}
}
