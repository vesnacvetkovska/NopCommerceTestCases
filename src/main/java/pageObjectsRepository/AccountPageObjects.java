package pageObjectsRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;
import testData.TestData;

public class AccountPageObjects extends Base {

	TestData td = new TestData ();
	CommonMethods cm = new CommonMethods();
	
	
	
	public @FindBy (xpath = "//*[@class=\"ico-account\"]")
	WebElement myAccount;
	
	public @FindBy (xpath = "//*[@class=\"page-title\"]")
	WebElement accountPageInfo;
	
	public @FindBy (xpath = "//*[@id=\"Email\"]")
	WebElement emailField;
	
	public @FindBy (xpath = "//*[@id=\"save-info-button\"]")
	WebElement saveBtn;
	
	public @FindBy (xpath = "//*[@class=\"bar-notification success\"]")
	WebElement theCostumerInfoHasBeenChanged;
	
	public @FindBy (xpath = "//*[@title=\"Close\"]")
	WebElement closeBtnBarNotification;
	
	public @FindBy (xpath = "//*[@href=\"/customer/changepassword\"]")
	WebElement costumerChangedPassword;
	public @FindBy (xpath = "//*[@id=\"OldPassword\"]")
	WebElement oldPassword;
	
	public @FindBy (xpath = "//*[@id=\"NewPassword\"]")
	WebElement newPassword;
	
	public @FindBy (xpath = "//*[@id=\"ConfirmNewPassword\"]")
	WebElement confirmNewPassword;
	
	public @FindBy (xpath = "//*[@class=\"button-1 change-password-button\"]")
	WebElement changePasswordBtn;
	
public AccountPageObjects() {
		
		PageFactory.initElements(driver, this);
	}

	public void changePassword () {
		costumerChangedPassword.click();
		oldPassword.sendKeys(td.validPass);
		newPassword.sendKeys(td.differentPass);
		confirmNewPassword.sendKeys(td.invalidPass);
		changePasswordBtn.click();
	}
}

