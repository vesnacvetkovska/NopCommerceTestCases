package test_Cases_NopCommerce_Demo_WebPage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageObjectsRepository.AccountPageObjects;
import pageObjectsRepository.CheckoutPageObjects;
import pageObjectsRepository.CommonMethods;
import pageObjectsRepository.HomePageObjects;
import pageObjectsRepository.LoginPageObjects;
import pageObjectsRepository.PDPObjects;
import pageObjectsRepository.PLPObjects;
import pageObjectsRepository.RegisterPageObjects;
import pageObjectsRepository.ShoppingCartObjects;
import pageObjectsRepository.WishListPageObject;
import testData.TestData;

public class TestCasesAccount extends Base {
	HomePageObjects hpo;
	WishListPageObject wpo;
	TestData td;
	PLPObjects plpo;
	PDPObjects pdpo;
	ShoppingCartObjects shco;
	CommonMethods cm;
	RegisterPageObjects rpo;
	CheckoutPageObjects chpo;
	LoginPageObjects lpo;
	AccountPageObjects apo;
	@BeforeMethod
	 public void start () {
		openApp();
		
		hpo = new HomePageObjects();
		wpo = new WishListPageObject();
		td = new TestData();	
		plpo = new PLPObjects ();
		pdpo = new PDPObjects();
		shco = new ShoppingCartObjects();
		cm = new CommonMethods();
		rpo = new RegisterPageObjects();
		chpo = new CheckoutPageObjects ();
		lpo = new LoginPageObjects();
		apo = new AccountPageObjects();
	}
	@AfterMethod 
		public void quit () {
		driver.quit();}
	
	
	//Access my account page
	@Test
	public void TC_ACCOUNT_001 () {
		hpo.navigateToRegisterPage();
		rpo.yourPersonalDetails(td.firstName, td.lastName, td.validEmail, td.companyName);
		rpo.yourPassword(td.validPass, td.validConffirmPassword);
		Assert.assertEquals(driver.getTitle(), td.registertitle);
		hpo.navigateToLoginPage();
		lpo.logInUserModulCheckBox(td.validEmail, td.validPass);
		apo.myAccount.click();
		Assert.assertEquals(apo.accountPageInfo.getText(),td.accountPageTitle);
	}

	//Change Personal details in customer info
	@Test
	
	public void TC_ACCOUNT_002 () {
		hpo.navigateToRegisterPage();
		rpo.yourPersonalDetails(td.firstName, td.lastName, td.validEmail, td.companyName);
		rpo.yourPassword(td.validPass, td.validConffirmPassword);
		Assert.assertEquals(driver.getTitle(), td.registertitle);
		hpo.navigateToLoginPage();
		lpo.logInUserModulCheckBox(td.validEmail, td.validPass);
		apo.myAccount.click();
		Assert.assertEquals(apo.accountPageInfo.getText(),td.accountPageTitle);
		apo.emailField.clear();
		apo.emailField.sendKeys(td.changedEmailAdress);
		cm.scrollToTheEle(apo.saveBtn);
		apo.saveBtn.click();
		Assert.assertEquals(apo.theCostumerInfoHasBeenChanged.getText(),td.succssesfulBarNotification);
		apo.closeBtnBarNotification.click();
		lpo.logOutBtn.click();
		hpo.navigateToLoginPage();
		lpo.logInUserModulCheckBox(td.changedEmailAdress, td.validPass);
		Assert.assertTrue(lpo.logOutBtn.isDisplayed());
		
	}
	
	//Change the password from My acount - Change password section with different confirm password
	@Test
	
	public void TC_ACCOUNT_011 () {
		hpo.navigateToRegisterPage();
		rpo.yourPersonalDetails(td.firstName, td.lastName, td.validEmail, td.companyName);
		rpo.yourPassword(td.validPass, td.validConffirmPassword);
		Assert.assertEquals(driver.getTitle(), td.registertitle);
		hpo.navigateToLoginPage();
		lpo.logInUserModulCheckBox(td.validEmail, td.validPass);
		apo.myAccount.click();
		Assert.assertEquals(apo.accountPageInfo.getText(),td.accountPageTitle);
		apo.changePassword();
		Assert.assertTrue(driver.getPageSource().contains(td.theNewPassDifferentWithConfirmPass));
	}
}
