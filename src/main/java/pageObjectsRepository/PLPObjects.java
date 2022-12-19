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
	 
	
	 public@FindBy (xpath = "(//a[@href=\"/shoes\"])[1]")
	WebElement shoeseMouseOver;
	 
	 public @FindBy (xpath = "(//*[@href=\"/if-you-wait-donation\"])[1]")
	 WebElement  ifYoudWnatDonation;
	 
	 public @FindBy (xpath = "//*[@alt=\"Picture of Elegant Gemstone Necklace (rental)\"]")
	 WebElement elegantGemstoneNecklace;
	 
	 public @FindBy (xpath = "//*[@alt=\"Picture for category Camera & photo\"]")
	 WebElement cameraAndPhoto;
	 public @FindBy (xpath = "//*[@alt=\"Picture of Nikon D5500 DSLR\"]")
	 WebElement nikonD550DSLR;
	
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
