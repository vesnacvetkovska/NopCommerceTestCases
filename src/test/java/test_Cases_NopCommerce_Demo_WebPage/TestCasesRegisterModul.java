package test_Cases_NopCommerce_Demo_WebPage;

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
		Assert.assertEquals((driver.getCurrentUrl()), td.urlregistredSuccsses);
		
	}
	@Test
	//Register new user with different password and confirm password field
	public void TC_REGISTER_005 ()  {
		hpo.navigateToRegisterPage();
		rpo.yourPersonalDetails(td.firstName, td.lastName, td.validEmail, td.companyName);
		rpo.selectFromDayOfBirth(8);
	
		rpo.selectFromMonthOfBirth(6);
		
		rpo.selectFromyearOfBirth("1980");
		rpo.yourPassword(td.validPass, td.differentPass);
		Assert.assertEquals(rpo.confirmPassError.getText(), td.errorMsgConfirmPassword);
	}
	
	@Test
	// Register new user with invalid password
	public void TC_REGISTER_009 () {
		hpo.navigateToRegisterPage();
		rpo.yourPersonalDetails(td.firstName, td.lastName, td.validEmail, td.companyName);
		rpo.selectFromDayOfBirth(7);
		rpo.selectFromMonthOfBirth(5);
		rpo.selectFromyearOfBirth("2002");
		rpo.yourPassword(td.validPass, td.invalidPass);
		Assert.assertEquals(rpo.confirmPassError.getText(), td.errorMsgConfirmPassword);
		
	}
	//Register new user with empty LastName field
	@Test 
	public void TC_REGISTER_011 () {
	hpo.navigateToRegisterPage();
	rpo.yourPersonalDetails(td.firstName, td.emptyLastName, td.validEmail, td.companyName);
	rpo.selectFromDayOfBirth(7);
	rpo.selectFromMonthOfBirth(5);
	rpo.selectFromyearOfBirth("2002");
	rpo.yourPassword(td.validPass, td.validConffirmPassword);
	Assert.assertEquals(rpo.lasNameErrorMsg.getText(), td.lastNameMsgError);
	
	}	
}
