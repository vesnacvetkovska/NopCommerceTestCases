package pageObjectsRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;
import testData.TestData;

public class WishListPageObject extends Base {

	TestData td = new TestData ();
	CommonMethods cm = new CommonMethods() ;
	RegisterPageObjects rpo = new RegisterPageObjects() ;
	public 
	@FindBy (xpath= "(//*[@title=\"Add to wishlist\"])[2]")
	WebElement addtowishlistFirstPrizePies;
	public 
	@FindBy(xpath = "(//*[@href=\"/wishlist\"])[1]")
	WebElement wishlistLinkPopUp;
	
	@FindBy (xpath = "//*[@class=\"footer-upper\"]")
	public
	WebElement footer;
	public 
	@FindBy (xpath = "//*[@class=\"button-2 email-a-friend-wishlist-button\"]")
	WebElement emailAFriendFromWishList;
	
	public @FindBy (xpath = "//*[@class=\"product-subtotal\"]")
	WebElement subTotalPrice;
	public 
	@FindBy (id = "FriendEmail")
	WebElement friendEmail;
	public 
	@FindBy (id = "YourEmailAddress")
	WebElement yourEmail;
	
	public
	@FindBy (xpath = "//*[@placeholder=\"Enter personal message (optional).\"]")
	WebElement yourpersonalMessage;
	public
	@FindBy (xpath = "//*[@name=\"send-email\"]")
	WebElement sendEmailBtn;
	
	public 
	@FindBy (xpath = "(//*[@class=\"product-picture\"])[2]")
	WebElement productPictureWishlist;
	
	public WishListPageObject() {
		 
		PageFactory.initElements(driver, this);
	}
	
	
	 public void emailAFriend () {
		 friendEmail.sendKeys(td.validEmail);
		 yourEmail.sendKeys(cm.generateMail());
		 yourpersonalMessage.sendKeys("Have a Good Day");
		 cm.scrollToTheEle(sendEmailBtn);
		 sendEmailBtn.click();
	 }

			
	
}
