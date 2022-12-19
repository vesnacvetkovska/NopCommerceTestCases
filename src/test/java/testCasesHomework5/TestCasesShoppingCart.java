package testCasesHomework5;

import org.testng.annotations.Test;
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
	
	@Test
	
	//Check if the price changes according the discount given for the product
	public void TC_CART_022 () throws InterruptedException {
		cm.mouseOver(hpo.apparelTopMenu);
		cm.waitMethod(5, hpo.clothing);
		hpo.clothing.click();
		plpo.levisJeans.click();
		cm.waitMethod(10, pdpo.addToCartLevisJeans);
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
	
		}



		
	