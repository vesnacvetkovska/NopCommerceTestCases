package pageObjectsRepository;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;
import testData.TestData;

     public class PDPObjects extends Base {

    
	HomePageObjects hpo = new HomePageObjects();
	ShoppingCartObjects shco = new ShoppingCartObjects();

	
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
	@FindBy (xpath = "(//span[@class=\"value\"])[2]")
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
	WebElement productPriceItem;
	
	public @FindBy (xpath ="//*[@id=\"rental_start_date_40\"]")
	WebElement startDateForRent;
	
	public @FindBy (xpath = "//*[@class=\"ui-datepicker-month\"]")
	WebElement monthInDatePicker;
	public @FindBy (xpath = "//*[@class=\"ui-datepicker-year\"]")
	WebElement yearInDatePicker;
	public @FindBy (xpath = "//*[@title=\"Next\"]")
	WebElement nextBtnInDatePicker;
	public @FindBy (xpath = "//*[@class=\"ui-state-default\"]")
	WebElement dayInDatePicker;
	
	public @FindBy (xpath ="//*[@id=\"rental_end_date_40\"]")
	WebElement endDateForRent;
	public @FindBy (xpath= "//*[@id=\"ui-datepicker-div\"]")
	WebElement calendar;
	public @FindBy (xpath = "//*[@class=\"short-description\"]")	
	WebElement shortDescription;
	
	public @FindBy (xpath = "//*[@href=\"/first-prize-pies\"]")	
	WebElement firstPrizePies;
	
	public @FindBy (xpath = "//*[contains(text(),'Add your review')]")	
	WebElement addYourReview;
	public @FindBy (xpath = "//*[@href=\"/leica-t-mirrorless-digital-camera\"]")
	WebElement leicaTMirrorlessDigitalCamera;
	
	public @FindBy (xpath = "//input[@class=\"review-title\"]")
	WebElement reviewTitel;
	
	public @FindBy (xpath = "//textarea[@class=\"review-text\"]")
	WebElement reviewtext;
	
	public @FindBy (xpath = "//input [@value=\"4\"]")
	WebElement btnRating4;
	public @FindBy (xpath = "(//*[@type=\"submit\"])[2]")
	WebElement submitReview;
	
	public @FindBy (xpath = "//*[@class=\"button-2 download-sample-button\"]")
	WebElement downloadSample;
	
	public  PDPObjects() {
		
		PageFactory.initElements(driver, this);
	}
	
	
		
	// get the price from PDP
		public int getThePriceFromPDP (WebElement elem) {
			String price = elem.getText();
			String price2 = price.replace("$", "");
			int number = Integer.parseInt(price2);
			return number;
			
		}

	
}
