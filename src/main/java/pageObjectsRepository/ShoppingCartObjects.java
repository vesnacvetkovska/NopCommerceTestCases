package pageObjectsRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;
import testData.TestData;

public class ShoppingCartObjects extends Base {
	
	TestData td = new TestData ();
	
	public
	@FindBy (xpath = "//*[@class=\"qty-input\"]")
	WebElement inputQuantity;
	public
	@FindBy (xpath ="//*[@id=\"updatecart\"]")
	WebElement updateCart;
	public
	@FindBy (xpath = "//td[@class=\"product\"]")
	WebElement productDescriptField;
	
	public
	@FindBy (xpath = "//td[@class=\"unit-price\"]")
	WebElement productUnitPrice;
	
	public 
	@FindBy (xpath = "\"//h2[@class=\\\"product-title\\\"]\"")
	WebElement elementTitle;
	
	
	public
	@FindBy (xpath = "//td[@class=\"sku\"]")
	WebElement skuNumbersFromShoppCart;
	
	public 
	@FindBy (id="checkout_attribute_1")
	WebElement giftWrapping;

	@FindBy (id = "discountcouponcode")
	public
	WebElement discCouponeCode;
	
	@FindBy (id = "applydiscountcouponcode")
	public
	WebElement applyDiscountCode;
	
	public 
	@FindBy (id ="termsofservice")
	WebElement checkBoxTermsOfService;
	
	public 
	@FindBy (id = "checkout")
	WebElement checkoutBtn;
	
	public
	@FindBy (xpath = "(//*[@class=\"cart-total-right\"])[1]")
	WebElement subTotalSum1;
	public 
	@FindBy (xpath = "//*[@class=\"remove-btn\"]")
	WebElement removeBtn;

	
	public ShoppingCartObjects() {
	
		PageFactory.initElements(driver, this);
		
}

	public void gettextSkuFromElementsInShoppingCart () {
		int size = driver.findElements(By.xpath("//h2[@class=\"product-title\"]")).size();
		
		for(int i = 1; i < size + 1; i++) {
			
			
			String textSKU = driver.findElement(By.xpath("(//h2[@class=\"product-title\"])[" +i+ "]")).getText();
			System.out.println(textSKU);}
	}
		public void enterAndApplyDiscountCode (WebElement ele, WebElement ele1) {
			ele.clear();
			ele.sendKeys("123");
			ele1.click ();}
	
			
}	
		


