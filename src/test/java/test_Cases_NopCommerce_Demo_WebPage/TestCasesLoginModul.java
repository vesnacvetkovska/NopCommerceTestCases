package test_Cases_NopCommerce_Demo_WebPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.Base;
import pageObjectsRepository.HomePageObjects;
import pageObjectsRepository.LoginPageObjects;
import testData.TestData;

public class TestCasesLoginModul extends Base {
	
	HomePageObjects hpo;
	LoginPageObjects lpo;
	TestData td;
	
	@BeforeMethod 
	
	public void start () {
		openApp();
		hpo = new HomePageObjects();
		lpo = new LoginPageObjects();
		td = new TestData();
		
	}
	@AfterMethod
	
	public void quit () throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		
	}
	
	// login with vaild email, invalid password
	@Test
	
	public void TC_LOGIN_003() {
		hpo.navigateToLoginPage();
		lpo.logInUserModulCheckBox(td.validEmail, td.invalidPass);
		Assert.assertEquals(lpo.errorMsgLogin.getText(), td.errorMsgLogin);
	}
	
	// login with valid email, empty password field
	@Test
	
	public void TC_LOGIN_007 () {
		hpo.navigateToLoginPage();
		lpo.logInUserModulCheckBox(td.validEmail, td.emptyPassword);
		Assert.assertEquals(lpo.errorMsgLogin.getText(), td.errorMsgLogin);
	}
	
	// login with empty email filed, valid password
	@Test
	
	public void TC_LOGIN_008() {
		
		hpo.navigateToLoginPage();
		lpo.logInUserModulCheckBox(td.emptyEmail, td.validPass);
		Assert.assertEquals(lpo.errorMsgEmail.getText(), td.errorMsgEmailField);
	}
}