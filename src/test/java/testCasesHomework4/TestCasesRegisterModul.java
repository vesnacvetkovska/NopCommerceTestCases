package testCasesHomework4;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageObjectsRepository.CommonMethods;
import pageObjectsRepository.HomePageObjects;
import pageObjectsRepository.LoginPageObjects;
import pageObjectsRepository.RegisterPageObjects;
import testData.TestData;


public class TestCasesRegisterModul extends Base {

	
	HomePageObjects hpo;
	RegisterPageObjects rpo;
	TestData td;
	LoginPageObjects lpo;
	CommonMethods cm;
	
	@BeforeMethod
public void start () {
	openApp();
	hpo = new HomePageObjects();
	rpo = new RegisterPageObjects();
	td = new TestData();
	lpo = new LoginPageObjects();
	cm = new CommonMethods();
		
	}
	
	@AfterMethod
	public void quit () throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
	@Test
	
	//Register new user with valid email
	public void TC_REGISTER_002 () {
		hpo.navigateToRegisterPage();
		rpo.yourPersonalDetails(td.firstName, td.lastName, cm.generateMail(), td.companyName);
		rpo.selectFromDayOfBirth(5);
		rpo.selectFromMonthOfBirth(5);
		rpo.selectFromyearOfBirth("1955");
		rpo.yourPassword(td.validPass, td.validConffirmPassword);
		System.out.println(cm.generateMail());
		Assert.assertEquals((driver.getCurrentUrl()), "https://demo.nopcommerce.com/registerresult/1?returnUrl=/");
		
	}
	@Test
	//Register new user with different password and confirm passwork field
	public void TC_REGISTER_005 () throws InterruptedException {
		hpo.navigateToRegisterPage();
	
		rpo.yourPersonalDetails(td.firstName, td.lastName, td.validEmail, td.companyName);
		
		rpo.selectFromDayOfBirth(8);
		
		Thread.sleep(2000);
		rpo.selectFromMonthOfBirth(6);
		
		Thread.sleep(3000);
		
		rpo.selectFromyearOfBirth("1980");
		
		rpo.yourPassword(td.validPass, td.inValidPass);
		
		Assert.assertEquals((driver.findElement(By.xpath("//*[@id=\"ConfirmPassword-error\"]")).getText()), "The password and confirmation password do not match.");
	}
}
