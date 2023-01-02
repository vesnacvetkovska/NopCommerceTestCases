package test_Cases_NopCommerce_Demo_WebPage;




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
	@AfterMethod 
		public void quit () {
		driver.quit();}
	
	@Test
	
	public void ednToEndScenarioAsGuest () {
		
		//add to cart elegant gemstone necklace with calendar picker
		hpo.navigateToJewelryPage();
		plpo.elegantGemstoneNecklace.click();
		cm.datePicker(td.startingDateRent, pdpo.startDateForRent, pdpo.nextBtnInDatePicker);
		cm.datePicker(td.endDateRent, pdpo.endDateForRent, pdpo.nextBtnInDatePicker);
		cm.waitMethodInvisibility(3, pdpo.calendar);
		cm.scrollToTheEle(pdpo.rentBtn);
		pdpo.rentBtn.click();
		String price1 = cm.getThePriceFromPDP(pdpo.productPriceItem);
		//System.out.println(price1);
		
		//add to cart camera nikon D550DSLR
		hpo.navigateToElectronicsPage();
		plpo.cameraAndPhoto.click();
		plpo.addToCart(plpo.nikonD550DSLR);
		cm.scrollToTheEle(pdpo.nikonD5500DSLRBlack);
		String price2 = cm.getThePriceFromPDP(pdpo.productPriceItem);
		//System.out.println(price2);
		pdpo.addToCartNiconD5500DSLRBlack.click();
		hpo.shoppingCartLinkPopUP.click();
		double priceNeack = Double.parseDouble(price1);
		double priceCamera = Double.parseDouble(price2);
		double priceSum = (priceNeack + priceCamera);
		System.out.println(priceSum);
		double subtotal = cm.stringToDouble(shco.subTotalSum1);
		System.out.println(subtotal);
		// assert is sum price from pdp items, is equal with price from sum total, on shopping cart
		Assert.assertEquals(priceSum, subtotal);
		
		// scrool to the ckeck box, press chekout
		cm.scrollToTheEle(shco.checkBoxTermsOfService);
		shco.checkBoxTermsOfService.click();
		shco.checkoutBtn.click();
		
		// select checkout as a guest
		chpo.checkOutAsGuest.click();
		chpo.billingAddressForRegistered();
		
		//Shipping method
		chpo.shippingmethod();
		
		
		//PyamentMethod
		chpo.paymentMethodMoneyOrder();
		
		//confirm method
		chpo.confirmMethod();
		
		Assert.assertTrue(driver.getPageSource().contains(td.address1));
		
		chpo.confirmBtn.click();
		
		Assert.assertEquals(driver.getCurrentUrl(), td.confirmOrder);
		
	}

	
	}
	
