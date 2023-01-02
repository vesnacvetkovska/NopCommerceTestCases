package pageObjectsRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;
import testData.TestData;

public class PLPObjects extends Base {

	HomePageObjects hpo = new HomePageObjects();
	
	TestData td = new TestData();
	CommonMethods cm = new CommonMethods();
	
	
	public
	@FindBy (xpath = "//*[@href=\"/nike-tailwind-loose-short-sleeve-running-shirt\"]")
	WebElement nikeTailwindLooseShorsSleeveRunningShirt;
	public
	@FindBy (xpath = "(//*[@class=\"button-2 product-box-add-to-cart-button\"])[3")
	WebElement addToCartNikeLoosePLP;
	 public 
	 @FindBy (xpath = "(//*[@href=\"/levis-511-jeans\"])[1]")
	 WebElement levisJeans;
	 
	 @FindBy (xpath = ("//img[@alt='Picture of Nike Floral Roshe Customized Running Shoes']"))
	 public  WebElement nikeFloralRosheCustomizedRunningShoes;
	 
	 public 
	 @FindBy (xpath = "(//*[@class=\"button-2 product-box-add-to-cart-button\"])[2]")
	 WebElement addToCartFlowerGirlBracelet;

	
	 public@FindBy (xpath = "(//a[@href=\"/shoes\"])[1]")
	WebElement shoeseMouseOver;
	 
	 public @FindBy (xpath = "(//*[@href=\"/if-you-wait-donation\"])[1]")
	 WebElement  ifYoudWnatDonation;
	 
	 public @FindBy (xpath = "//*[@alt=\"Picture of Elegant Gemstone Necklace (rental)\"]")
	 WebElement elegantGemstoneNecklace;
	 
	 public @FindBy (xpath = "(//*[@class=\"button-2 product-box-add-to-cart-button\"])[3]")
	 WebElement addToCartvintageStyleEngagementRing;
	 public @FindBy (xpath = "//*[@alt=\"Picture for category Camera & photo\"]")
	 WebElement cameraAndPhoto;
	 public @FindBy (xpath = "//*[@alt=\"Picture of Nikon D5500 DSLR\"]")
	 WebElement nikonD550DSLR;
	public @FindBy (xpath = "(//*[@class=\"button-2 product-box-add-to-cart-button\"])[3]")
	WebElement prideAndPrejudiceAddToCartBtn;
	
	public @FindBy (xpath = "(//*[@class=\"button-2 product-box-add-to-cart-button\"])[2]")
	WebElement addToCartWindows8Pro;
	
	public @FindBy (xpath = "(//*[@class=\"button-2 product-box-add-to-cart-button\"])[1]")
	WebElement addToCartSoundForgePro11recurring;
	public @FindBy (xpath = "(//*[@title=\"Show products in category Notebooks\"])[1]")
	WebElement notebooks;
	
	public @FindBy (xpath = "//*[@id=\"attribute-option-6\"]")
	WebElement i5CPU; 
	
	public @FindBy (xpath = "//*[@id=\"attribute-option-9\"]")
	WebElement ram8GB;
	public @FindBy (xpath = "//*[@alt=\"Picture of Samsung Series 9 NP900X4C Premium Ultrabook\"]")
	WebElement elementInList;
	
	public @FindBy (xpath = "//*[@title=\"Show products in category Cell phones\"]")
		WebElement cellPhones;
	
	public @FindBy (xpath = "(//*[@class=\"button-2 add-to-compare-list-button\"])[2]")
	WebElement addToCompareHTCOneMiniBlue;
	
	public @FindBy (xpath = "(//*[@class=\"button-2 add-to-compare-list-button\"])[3]")
	WebElement addToCompareNokiaLumia1020;
	
	public  @FindBy (xpath = "//*[@href=\"/compareproducts\"]")
	WebElement productComparisonLink;
	
	public @FindBy (xpath = "//*[@class=\"close\"]")
	WebElement closePopUpLink;
	public @FindBy (xpath = "//*[@class=\"breadcrumb\"]")
	WebElement breadCrumb;
	
	public @FindBy (xpath = "//*[@class=\"page compare-products-page\"]")
	WebElement compareProducts;

	public @FindBy (xpath = "//*[@class=\"button-2 remove-button\"]")
	WebElement removeBtnComparePage;
	public @FindBy (xpath = "//*[@href=\"/night-visions\"]")
	WebElement nightVision;
	
	public  PLPObjects() {
	
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void addToCart (WebElement elem) {
		cm.scrollToTheEle(elem);
		elem.click();
		
	}
	public void addToWishList (WebElement elem) {
		cm.scrollToTheEle(elem);
		elem.click();
		
	}
	public void addToCompareList (WebElement elem) {
		cm.scrollToTheEle(elem);
		elem.click();
		
	}
	public void rent (WebElement elem) {
		cm.scrollToTheEle(elem);
		elem.click();
		
	}
	public void clickOnElementLink (WebElement elem) {
		cm.scrollToTheEle(elem);
		elem.click();
		
	}
	public void clickOnElementPicture (WebElement elem) {
		cm.scrollToTheEle(elem);
		elem.click();
		
	}
}
