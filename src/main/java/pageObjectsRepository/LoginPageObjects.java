package pageObjectsRepository;

import base.Base;
import testData.TestData;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

@Test
public class LoginPageObjects extends Base {
	TestData td = new TestData ();
	
	
	@FindBy(name = "Email")
	WebElement emailField;
	
	@FindBy(name = "Password")
	WebElement passwordField;
	
	@FindBy(xpath = "//*[@type=\"checkbox\"]")
	WebElement remembermeCheckBox;
	
	@FindBy(xpath = "//*[@class=\"button-1 login-button\"]")
	WebElement loginBtn;
	
	public
	@FindBy (xpath ="//div[@class=\"message-error validation-summary-errors\"]")
	WebElement errorMsgLogin;
	
	public 
	@FindBy (xpath = "//*[@id=\"Email-error\"]")
	WebElement errorMsgEmail;
	
	public @FindBy (xpath = "//*[@href=\"/logout\"]")
	WebElement logOutBtn;
	
	
	public LoginPageObjects () {
		PageFactory.initElements(driver, this);
	}
		
		public void logInUserModulCheckBox (String email, String passwrod) {
			emailField.sendKeys(email);
			passwordField.sendKeys(passwrod);
			remembermeCheckBox.click();
			loginBtn.click();
			
		}
		
		

		
}
