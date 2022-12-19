package pageObjectsRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;
import testData.TestData;

public class WishListPageObject extends Base {

	TestData td = new TestData ();
	public 
	@FindBy (xpath= "(//*[@title=\"Add to wishlist\"])[2]")
	WebElement addtowishlist;
	public 
	@FindBy(xpath = "(//*[@href=\"/wishlist\"])[1]")
	WebElement wishlistLinkPopUp;
	
	@FindBy (xpath = "//*[@class=\"footer-upper\"]")
	public
	WebElement footer;
	
	
	public WishListPageObject() {
		 
		PageFactory.initElements(driver, this);
	}
	
	
	 

			
	
}
