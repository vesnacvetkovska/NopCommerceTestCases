package pageObjectsRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.Base;
import testData.TestData;

public class RegisterPageObjects extends Base {

	TestData td = new TestData ();
	CommonMethods cm = new CommonMethods() ;
	
	
	
	@FindBy(id = "gender-male")
	WebElement genderMale;
	
	@FindBy(id = "gender-female")
	WebElement genderFemale;

	@FindBy(id = "FirstName")
	WebElement firstNameField;
	
	@FindBy(id = "LastName")
	WebElement lastNameField;
	
	@FindBy(xpath = "//*[@name=\"DateOfBirthDay\"]")
	WebElement dayOfBirth;
	
	@FindBy(name ="DateOfBirthMonth")
	WebElement monthOfBirth;
	
	@FindBy(name = "DateOfBirthYear")
	WebElement yearOfBirth;
	
	@FindBy (xpath = "//*[@id=\"Email\"]")
	WebElement emailRegisterField;
	
	@FindBy(id = "Company")
	WebElement companyNameField;
	
	
	@FindBy (name = "Password")
	WebElement passRegisterField;
	
	@FindBy(id = "ConfirmPassword")
	WebElement comfirmPassField;
	
	@FindBy(name = "register-button")
	WebElement registerBtn;
	
	public RegisterPageObjects() {
		PageFactory.initElements(driver, this);
	
	
		
	}
	
	public void yourPersonalDetails(String firstName, String lastName, String email, String companyName) {
		genderMale.click () ;
		firstNameField.sendKeys(firstName);
		lastNameField.sendKeys(lastName);
		cm.selectSize(dayOfBirth, 3);
		cm.selectSize(monthOfBirth, 5);
		cm.selectSize(yearOfBirth, 50);
		emailRegisterField.sendKeys(cm.generateMail());
		companyNameField.sendKeys(companyName);
		
	}
	
	/*public void dataOfBirth (String day, String month, String year) {
		dayOfBirth.sendKeys(day);
		monthOfBirth.sendKeys(month);
		yearOfBirth.sendKeys(year);
		
	}*/
	public void yourPassword (String password, String confirmPass) {
		passRegisterField.sendKeys(password);
		comfirmPassField.sendKeys(confirmPass);
		registerBtn.click();
		
		
	}
	public void selectFromDayOfBirth (int iday) {
		WebElement dayOfBirth = driver.findElement(By.xpath("//*[@name=\"DateOfBirthDay\"]"));
		Select s = new Select(dayOfBirth);
		s.selectByIndex(iday);
		
	}
	public void selectFromMonthOfBirth(int imonth ) {
		WebElement monthOfBirth = driver.findElement(By.name("DateOfBirthMonth"));
		Select sm = new Select (monthOfBirth);
		sm.selectByIndex(imonth);
	}
		public void selectFromyearOfBirth (String year) {
			WebElement yearOfBirthElement = driver.findElement(By.name("DateOfBirthYear"));
			Select sy = new Select (yearOfBirthElement);
			sy.selectByValue(year);
			
		
		}
}