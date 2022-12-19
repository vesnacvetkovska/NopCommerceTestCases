package pageObjectsRepository;

import base.Base;
import testData.TestData;

import org.testng.annotations.Test;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HomePageObjects extends Base {
	TestData td = new TestData();
	
	
	@FindBy(xpath = "//*[@class=\"ico-register\"]")
	public
	WebElement registerBtnHomePage;
	
	@FindBy(xpath = "//*[@href=\"/login?returnUrl=%2F\"]")
	WebElement loginBtnHomePage;
	
	@FindBy(xpath = "//*[@class=\"search-box-text ui-autocomplete-input\"]")
	WebElement searchFieldHomePage;
		
	@FindBy(xpath = "//*[@class=\"button-1 search-box-button\"]")
	WebElement searchBtnHomePage;
	
	@FindBy (xpath = "//*[@class=\"top-menu notmobile\"]//child::a[@href=\"/computers\"]")
	public
	WebElement computerTopMenu;
	
	@FindBy(xpath = "//*[@class=\"top-menu notmobile\"]//child::a[@href=\"/electronics\"]")
	WebElement electronicsTopMenu;
	
	@FindBy(xpath = "//*[@class=\"top-menu notmobile\"]//child::a[@href=\"/apparel\"]")
	public
	WebElement apparelTopMenu;
	
	public
	@FindBy (xpath = "(//*[@href=\"/clothing\"])[1]" )
	WebElement clothing;
	
	
	public 
	@FindBy(linkText = "Digital downloads")
	WebElement digitalDownloadsTopMenu;
	
	@FindBy (xpath = "//*[@class=\"top-menu notmobile\"]//child::a[@href=\"/books\"]")
	WebElement booksTopMenu;
	
	@FindBy(xpath = "//*[@href=\"/jewelry\"]")
	public
	WebElement jewelryTopMenu;
	
	@FindBy(xpath = "//*[@class=\"top-menu notmobile\"]//child::a[@href=\"/gift-cards\"]")
	WebElement giftCardsTopMenu;
		
	@FindBy (xpath = "//*[@id=\"vote-poll-1\"]")
	public
	WebElement vote ;
	@FindBy (xpath = "//*[@for=\"pollanswers-1\"]")
	WebElement exellent;
	
	@FindBy (xpath = "((//*[@href=\"/desktops\"])[1])")
	public
	WebElement desctopSumMenu;
	
	@FindBy (xpath = "//*[@class=\"wishlist-label\"]")
	WebElement wishList;
	@FindBy (xpath = "//*[@id=\"pollanswers-1\"]")
	public
	WebElement excelent ;
	
	public
	@FindBy (xpath = "(//*[@href=\"/cart\"])[1]")
	WebElement shoppingCartLinkPopUP;
	
	
	
	public HomePageObjects () {
		PageFactory.initElements(driver, this);
		
	}
	@Test
	
	public void navigateToRegisterPage () {
		registerBtnHomePage.click();
	}
	
	
	public void navigateToLoginPage() {
		loginBtnHomePage.click();
			}
	public void navigateToComputersPage() {
		computerTopMenu.click();}
	
	public void navigateToElectronicsPage() {
		electronicsTopMenu.click();}
	
	public void navigateApparelPage() {
		apparelTopMenu.click();}
		
	public void  navigateToDigitalDownloadsPage() {
		digitalDownloadsTopMenu.click();}
	
	public void navigateToBooksPage() {
		booksTopMenu.click();}
	
	public void navigateToJewelryPage() {
		jewelryTopMenu.click();
	}
	public void navigateToGiftCardsPage () {
		giftCardsTopMenu.click();
	}
	
	public void searchItem(String item) {
		searchFieldHomePage.sendKeys(item);
		searchBtnHomePage.click();}
	
	
//scroll to specific element


	
	
	
}

