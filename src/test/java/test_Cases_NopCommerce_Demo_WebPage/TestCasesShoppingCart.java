package test_Cases_NopCommerce_Demo_WebPage;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import base.Base;
import pageObjectsRepository.CommonMethods;
import pageObjectsRepository.HomePageObjects;
import pageObjectsRepository.PDPObjects;
import pageObjectsRepository.PLPObjects;
import pageObjectsRepository.ShoppingCartObjects;
import pageObjectsRepository.WishListPageObject;
import testData.TestData;

public class TestCasesShoppingCart extends Base {

	HomePageObjects hpo;
	WishListPageObject wpo;
	TestData td;
	PLPObjects plpo;
	PDPObjects pdpo;
	ShoppingCartObjects shco;
	CommonMethods cm;
	
	
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
		
	}
	
	@AfterMethod 
	public void quit () {
		driver.quit();
	}
	// Add product to cart
		@Test
		
		public void TC_CART_001 () {
			cm.mouseOver(hpo.apparelTopMenu);
			cm.waitMethodVisibility(5, hpo.clothing);
			hpo.clothing.click();
			plpo.nikeTailwindLooseShorsSleeveRunningShirt.click();
			String s= pdpo.skuField.getText();
			cm.selectSize(pdpo.selectMenuNikeLoose, 4);
			pdpo.enterQuantity.clear();
			pdpo.enterQuantity.sendKeys("4");
			pdpo.addToCartNikeLoosePDP.click();
			hpo.shoppingCartLinkPopUP.click();
			
			Assert.assertEquals(s, td.nikeLooseSKUNumber);
			
			
		}
		
	
	@Test
	
	//Check if the price changes according the discount given for the product
	public void TC_CART_022 ()  {
		cm.mouseOver(hpo.apparelTopMenu);
		cm.waitMethodVisibility(5, hpo.clothing);
		hpo.clothing.click();
		plpo.levisJeans.click();
		cm.waitMethodVisibility(10, pdpo.addToCartLevisJeans);
		cm.scrollToTheEle(pdpo.addToCartLevisJeans);
		pdpo.addToCartLevisJeans.click();
		hpo.shoppingCartLinkPopUP.click();
		Assert.assertEquals(shco.productDescriptField.getText(), td.LevisJeans);
		shco.inputQuantity.clear();
		WebElement l = shco.inputQuantity;
	  	shco.inputQuantity.sendKeys("10");
		String str = l.getAttribute("value");
		shco.updateCart.click();
		
		String s = shco.productUnitPrice.getText();
		String snew = s.replace("$", "");
		double snew1 = Double.parseDouble(snew);
		
		double price3More = 40.00 ;
		double price6More = 38.00;
		double price10More = 35.00;
		
		int quantity = Integer.parseInt(str);
		//System.out.println(quantity + "This is quantity integer");
		
		{
			
		if ( quantity >=3 	&& quantity <= 5) 	{
			Assert.assertEquals(snew1, price3More);
			//System.out.println(snew1 + "This is printed more 3");
		}
		
		else if (quantity >=6 && quantity<=9)	{
					
			Assert.assertEquals(snew1, price6More);
			//System.out.println(snew1 + "This is printed more 6")  ;
		}
		
		else if (quantity >= 10) 	{
						
			Assert.assertEquals(snew1, price10More);
			//System.out.println(snew1 + "This is printed more 10")  ;
		}}}
	
	
	
	//Remove product from Cart by selecting remove
	@Test
	
	public void TC_CART_002 () {
	
		hpo.navigateToJewelryPage();
		plpo.addToCartFlowerGirlBracelet.click();
		hpo.navigateToJewelryPage();
		plpo.addToCartvintageStyleEngagementRing.click();
		hpo.shoppingCartLinkPopUP.click();
	
		
		int size = driver.findElements(By.xpath("//*[@class=\"product-name\"]")).size();
		
		for(int i=0; i<size; i++) {
			shco.removeBtn.click();
			}
		
		Assert.assertTrue(driver.getPageSource().contains(td.shoppingCartIsEmpty));
	}
	
	
	//Test the discount option with invalid coupon
	@Test
	
	public void TC_CART_013 () {
		hpo.navigateToBooksPage();
		plpo.prideAndPrejudiceAddToCartBtn.click();
		hpo.shoppingCartLinkPopUP.click();
		cm.scrollToTheEle(shco.discCouponeCode);
		shco.discCouponeCode.sendKeys(td.invalidCouponeCode);
		shco.applyDiscountCode.click();
		Assert.assertTrue(driver.getPageSource().contains(td.couponCodeCannotBeFound));
	}
	@Test
	
	//Test the gift card option with valid code value
	public void TC_CART_015 () {
		hpo.navigateToBooksPage();
		plpo.prideAndPrejudiceAddToCartBtn.click();
		hpo.shoppingCartLinkPopUP.click();
		cm.scrollToTheEle(shco.discCouponeCode);
		shco.discCouponeCode.sendKeys(td.validCouponeCode);
		shco.applyDiscountCode.click();
		Assert.assertTrue(driver.getPageSource().contains(td.theCouponWasAdded));
	}
	@Test

	// Add standard and auto-ship(recurring) items to shopping cart
	public void TC_CART_024 () {
		
		cm.mouseOverMenu(hpo.computerTopMenu, hpo.subMenuSoftware);
		plpo.addToCartSoundForgePro11recurring.click();
		driver.navigate().refresh();
		plpo.addToCartWindows8Pro.click();
		hpo.shoppingCartLinkPopUP.click();
		cm.scrollToTheEle(shco.checkoutBtn);
		shco.checkBoxTermsOfService.click();
		shco.checkoutBtn.click();
		Assert.assertTrue(driver.getPageSource().contains(td.recurringItemsErrorMsg));
		
	}
		}



		
	