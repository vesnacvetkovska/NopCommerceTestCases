package testCasesHomework6;

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

public class EndToEndAsRegisterdUser extends Base {

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
	public void endToEndScenarioAsRegist () {
		//register as a new user, with random generated mail
		
		hpo.navigateToRegisterPage();
		rpo.yourPersonalDetails(td.firstName, td.lastName, cm.generateMail(), td.companyName);
		rpo.yourPassword(td.validPass, td.validConffirmPassword);
		Assert.assertEquals(driver.getTitle(), td.registertitle);
		
		// add item to cart Nike shoese custom
		cm.mouseOverMenu(hpo.apparelTopMenu, plpo.shoeseMouseOver);
		cm.scrollToTheEle(plpo.nikeFloralRosheCustomizedRunningShoes);
		plpo.nikeFloralRosheCustomizedRunningShoes.click();
		cm.scrollToTheEle(pdpo.addToCartNikeFloralRosheCustomizedRunningShoes);
		String skuPDP = cm.getSkuValue(pdpo.skuField);
		cm.selectSize(pdpo.sizeNikeShoeseCostum, 2);
		cm.selectSize(pdpo.colourNikeShoeseCostum, 2);
		pdpo.printNikeShoeseCostum.click();
		cm.hiddenElement(pdpo.addToCartNikeFloralRosheCustomizedRunningShoes);
		
		// add item to cart If You Want Donation
		cm.scrollToTheEle(hpo.digitalDownloadsTopMenu);
		hpo.digitalDownloadsTopMenu.click();
		plpo.ifYoudWnatDonation.click();
		String skuIfYouWant = cm.getSkuValue(pdpo.skuField);
		pdpo.inputEnterPriceDonation.clear();
		pdpo.inputEnterPriceDonation.sendKeys("100");
		cm.scrollToTheEle(pdpo.addToCartIfYouWantDonation);
		pdpo.addToCartIfYouWantDonation.click();
		hpo.shoppingCartLinkPopUP.click();
		
		//Assert equals of SKU number from PDP, with SKU number from shopping cart
		
		// Не знам како да го направам да не е со вакви xpaths, пробав со web element, не ми дозволува да му дадам size метод, samo GetSize
		int size = driver.findElements(By.xpath("//h2[@class=\"product-title\"]")).size();
		
		for(int i = 1; i < size + 1; i++) {
			
		String textSKU = driver.findElement(By.xpath("(//h2[@class=\"product-title\"])[" +i+ "]")).getText();
		//System.out.println(textSKU);
		Assert.assertEquals(textSKU, skuPDP.concat(skuIfYouWant));}
		
		cm.scrollToTheEle(shco.checkoutBtn);
		
		//select option for wripping
		cm.selectSize(shco.giftWrapping, 1);
		//enter discount coupone
		shco.enterAndApplyDiscountCode(shco.discCouponeCode, shco.applyDiscountCode);
		//check the box for Terms of Service
		shco.checkBoxTermsOfService.click();
		shco.checkoutBtn.click();
		
		Assert.assertEquals(driver.getTitle(), td.checkoutTitle);
		
		//billing Address
		if (chpo.shippToTheSameAddress.isSelected()) {
			chpo.shippToTheSameAddress.click();
		};
		chpo.billingAddressForRegistered();
		
		//Shipping address
		chpo.shippingAddr();		
		//Shipping method
		chpo.shippingmethod();
		
		
		//PyamentMethod
		chpo.paymentMethodCrediteCard();
		
		//confirm method
		chpo.confirmMethod();
		
		Assert.assertTrue(driver.getPageSource().contains(skuIfYouWant));
		Assert.assertTrue(driver.getPageSource().contains(skuPDP));
		Assert.assertTrue(driver.getPageSource().contains(td.address1));
		
		chpo.confirmBtn.click();
		
		Assert.assertEquals(driver.getCurrentUrl(), td.confirmOrder);
		
	
	}	
	
	}
	
	
