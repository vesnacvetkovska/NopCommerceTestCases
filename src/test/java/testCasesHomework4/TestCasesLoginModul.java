package testCasesHomework4;


import org.openqa.selenium.By;
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
	@Test
	
	public void TC_LOGIN_003() {
		hpo.navigateToLoginPage();
		lpo.logInUserModulCheckBox(td.validEmail, td.inValidPass);
		Assert.assertEquals((driver.findElement(By.xpath("//*[@class=\"message-error validation-summary-errors\"]")).getText()), 
				(driver.findElement(By.xpath("//*[@class=\"message-error validation-summary-errors\"]")).getText()));       
	}
	@Test
	
	public void TC_LOGIN_007 () {
		hpo.navigateToLoginPage();
		lpo.logInUserModulCheckBox(td.validEmail, td.emptyPassword);
		
		
		Assert.assertEquals((driver.findElement(By.xpath("//*[@class=\"message-error validation-summary-errors\"]")).getText()), 
				(driver.findElement(By.xpath("//*[@class=\"message-error validation-summary-errors\"]")).getText()));
	}
	@Test
	
	public void TC_LOGIN_008() {
		
		hpo.navigateToLoginPage();
		lpo.logInUserModulCheckBox(td.emptyEmail, td.validPass);
		
		Assert.assertEquals((driver.findElement(By.xpath("//*[@class=\"field-validation-error\"]")).getText()), "Please enter your email");
	}
}