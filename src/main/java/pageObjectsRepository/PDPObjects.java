package pageObjectsRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;
import testData.TestData;

     public class PDPObjects extends Base {

    CommonMethods cm = new CommonMethods();
    
	HomePageObjects hpo = new HomePageObjects();
	ShoppingCartObjects shco;

	
	TestData td = new TestData();
	public
	@FindBy (xpath = "//*[@id=\"add-to-cart-button-27\"]")
	WebElement addToCartNikeLoosePDP;
	
	public
	@FindBy (xpath = "//*[@data-attr=\"11\"]")
	WebElement selectMenuNikeLoose;
	
	@FindBy (xpath = "//*[@id=\"product_enteredQuantity_27\"]")
	public
	WebElement enterQuantity;
	
	public
	@FindBy (xpath = "//*[@class=\"value\"]")
	WebElement  skuField;
	public
	@FindBy (xpath = "//*[@id=\"add-to-cart-button-30\"]")
	WebElement addToCartLevisJeans;
	
	
	@FindBy (xpath = "//*[@id=\"add-to-cart-button-24\"]")
	public WebElement addToCartNikeFloralRosheCustomizedRunningShoes;
	
	@FindBy (id = "product_attribute_6")
	public WebElement sizeNikeShoeseCostum;
	@FindBy (id = "product_attribute_7")
	public WebElement colourNikeShoeseCostum;
	
	public
	@FindBy (xpath = "//*[@for=\"product_attribute_8_20\"]")
	WebElement printNikeShoeseCostum;
	
	public 
	@FindBy (xpath = "//*[@name=\"addtocart_35.CustomerEnteredPrice\"]")
	WebElement inputEnterPriceDonation;
	
	public 
	@FindBy (xpath = "//*[@id=\"add-to-cart-button-35\"]")
	WebElement addToCartIfYouWantDonation;
	
	public 
	@FindBy (xpath = "//*[@id=\"rental_start_date_40\"]")
	WebElement stratDayForRent;
	
	public 
	@FindBy (xpath = "//*[@id=\"rental_end_date_40\"]")
	WebElement endDayForRent;
	
	public 
	@FindBy (xpath = "//*[@id=\"add-to-cart-button-40\"]")
	WebElement rentBtn;
	
	public @FindBy (xpath = "//*[@alt=\"Picture of Nikon D5500 DSLR - Black\"]")
	WebElement nikonD5500DSLRBlack;
	
	public @FindBy (xpath = "//*[@id=\"add-to-cart-button-14\"]")
	WebElement addToCartNiconD5500DSLRBlack;
	
	public @FindBy (xpath = "//*[@class=\"product-price\"]")
	WebElement productPriceItem1;
	
	public @FindBy (xpath = "//*[@class=\"product-price\"]")
	WebElement productPriceItem2;

	public
	String s2;
	

	public  PDPObjects() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void rentAnItem () {
		
		stratDayForRent.sendKeys("12/25/2022");
		endDayForRent.sendKeys("01/25/2023");
		new WebDriverWait(driver, 3);
		
		s2 = cm.stringReturnMethod(productPriceItem2);
		rentBtn.click();}
		
	
		

	
}
