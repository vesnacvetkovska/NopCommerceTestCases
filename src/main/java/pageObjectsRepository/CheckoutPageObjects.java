package pageObjectsRepository;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;
import testData.TestData;

public class CheckoutPageObjects extends Base {
	
	TestData td = new TestData ();
	CommonMethods cm = new CommonMethods();

	
	
	@FindBy (id = "BillingNewAddress_FirstName")
	WebElement firtsName;
	@FindBy (id = "BillingNewAddress_LastName")
	WebElement lastName;
	
	@FindBy (id = "BillingNewAddress_Email")
	WebElement email;
	@FindBy (id = "BillingNewAddress_CountryId")
	WebElement country;
	
	@FindBy (id = "BillingNewAddress_City")
	WebElement city;
	@FindBy (id = "BillingNewAddress_Address1")
	WebElement address1;
	
	@FindBy (id="BillingNewAddress_ZipPostalCode")
	WebElement zipPostalCode;
	
	@FindBy (id="BillingNewAddress_PhoneNumber")
	WebElement phoneNumber;
	
	@FindBy (xpath = "(//*[@class=\"button-1 new-address-next-step-button\"])[1]")
	WebElement contInue;
	
	public
	@FindBy (xpath = "//*[@id=\"shippingoption_0\"]")
	
	WebElement groundShipping;
	
	public
	@FindBy (xpath = "//*[@for=\"shippingoption_1\"]")
	WebElement nextDayAir;
	
	public
	@FindBy (xpath = "//*[@value=\"Next Day Air___Shipping.FixedByWeightByTotal\"]")
	
	WebElement secoundDayAir;
	
	public
	@FindBy (xpath = "//*[@onclick='ShippingMethod.save()']") 
	WebElement conShippingMethod;
	
	@FindBy (xpath = "//*[@value=\"Payments.CheckMoneyOrder\"]")
	WebElement checkmoneyOrder;
	@FindBy (xpath = "//*[@onclick=\"PaymentMethod.save()\"]" )
	WebElement continuePaymentmethod;
	
	public @FindBy (xpath = "//*[@class=\"order-total\"]/td/span")
	WebElement totalSumOreder;
	
	
	public
	@FindBy (id="paymentmethod_1")
	WebElement creditCard;
	@FindBy (id = "CreditCardType")
	WebElement crediteCardIdDropDown;
	@FindBy (id = "CardholderName")
	WebElement cardHoldernameFiled ;
	@FindBy (id = "CardNumber")
	WebElement cardNumber ;
	
	@FindBy (id = "ExpireMonth")
	WebElement expMonth ;
	@FindBy (id = "ExpireYear")
	WebElement expYear ;
	
	@FindBy (id = "CardCode")
	WebElement cardCode ;
	@FindBy (xpath = "//*[@class=\"button-1 payment-info-next-step-button\"]")
	public
	WebElement continueBtnPayInfo ;
	
	public 
	@FindBy (xpath = "//*[@onclick=\"ConfirmOrder.save()\"]")
	WebElement confirmBtn;
	
	
	public 
	@FindBy (xpath = "//*[@type=\"checkbox\"]") 
	WebElement shippToTheSameAddress;
	
	public 
	@FindBy (xpath = "//*[@class=\"button-1 checkout-as-guest-button\"]")
	WebElement checkOutAsGuest;
	
	public 
	@FindBy (xpath = "//*[@id=\"paymentmethod_0\"]")
	WebElement moneyPayment;
	
	public CheckoutPageObjects() {
	
		PageFactory.initElements(driver, this);
	}
	
	public void billingAddressForGuest ()
	{
		
		shippToTheSameAddress.clear();
		firtsName.sendKeys(td.firstName);
		lastName.sendKeys(td.lastName);
		email.sendKeys(td.validEmail);
		cm.selectSize(country, 15);
		city.sendKeys(td.city);
		address1.sendKeys(td.address1);
		zipPostalCode.sendKeys(td.zip);
		phoneNumber.sendKeys(td.phoneNumber);
		contInue.click();
	}
	
	
	public void billingAddressForRegistered ()
	{
		firtsName.sendKeys(td.firstName);
		lastName.sendKeys(td.lastName);
		email.sendKeys(td.validEmail);
		cm.selectSize(country, 15);
		city.sendKeys(td.city);
		address1.sendKeys(td.address1);
		zipPostalCode.sendKeys(td.zip);
		phoneNumber.sendKeys(td.phoneNumber);
		contInue.click();
		
		

	}
	
	//Shipping address
	public void shippingAddr () {
		
			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@onclick=\"Shipping.save()\"]"))).click(); };
	
		//Shipping method	
			public void shippingmethod () {
	new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@value=\"Next Day Air___Shipping.FixedByWeightByTotal\"]"))).click();
		conShippingMethod.click();};
	
	
	
		
	
	//Payment method
				
	public void paymentMethodCrediteCard ()  {
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("paymentmethod_1"))).click();
		creditCard.click();
		continuePaymentmethod.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("CreditCardType")));
		cm.selectSize(crediteCardIdDropDown,1);
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("CardholderName")));
		cardHoldernameFiled.sendKeys(td.firstName);
		cardNumber.sendKeys(td.cardNumber);
		cm.selectSize(expMonth, 5);
		cm.selectSize(expYear, 3);
		cardCode.sendKeys(td.cardCodeNumber);
		continueBtnPayInfo.click();
	
		
	}
	
	public void paymentMethodMoneyOrder () {
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("paymentmethod_0"))).click();
		moneyPayment.click();
		continuePaymentmethod.click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("payment-info-buttons-container")));
		continueBtnPayInfo.click();
	}
	//confirm button
	public void confirmMethod() {
	cm.scrollToTheEle(confirmBtn);
	new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(confirmBtn));};
	
	
	
}
