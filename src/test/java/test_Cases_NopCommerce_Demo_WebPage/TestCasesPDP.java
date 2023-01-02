package test_Cases_NopCommerce_Demo_WebPage;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
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

public class TestCasesPDP extends Base{
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
	}
	@AfterMethod 
		public void quit () {
		driver.quit();}
	
	
	@Test
	//Write and submit review for product without login in
	public void TC_DETAILS_002 () {
		hpo.navigateToBooksPage();
		pdpo.firstPrizePies.click();
		pdpo.addYourReview.click();
		Assert.assertEquals(driver.getCurrentUrl(), td.reviewPage);
		Assert.assertTrue(driver.getPageSource().contains(td.onlyRegCanWriteReviews));
	}
	@Test
	
	//Write and submit review for product with login in first
	
	public void TC_DETAILS_003() {
		hpo.navigateToRegisterPage();
		rpo.yourPersonalDetails(td.firstName, td.lastName, td.validEmail, td.companyName);
		rpo.yourPassword(td.validPass, td.validConffirmPassword);
		Assert.assertEquals(driver.getTitle(), td.registertitle);
		hpo.navigateToLoginPage();
		lpo.logInUserModulCheckBox(td.validEmail, td.validPass);
		hpo.navigateToElectronicsPage();
		plpo.cameraAndPhoto.click();
		cm.scrollToTheEle(pdpo.leicaTMirrorlessDigitalCamera);
		pdpo.leicaTMirrorlessDigitalCamera.click();
		pdpo.addYourReview.click();
		pdpo.reviewTitel.sendKeys(td.reviewTitle);
		pdpo.reviewtext.sendKeys(td.reviewText);
		pdpo.btnRating4.click();
		pdpo.submitReview.click();
		Assert.assertTrue(driver.getPageSource().contains(td.productReviewSuccessAdded));
	}
	
	//Download sample from product details
		@Test
		public void TC_DETAILS_013() throws IOException {
			hpo.navigateToDigitalDownloadsPage();
			cm.scrollToTheEle(plpo.nightVision);
			plpo.nightVision.click();
			pdpo.downloadSample.click();
			
		FileReader file = new FileReader ("C:\\Users\\vesne\\Downloads\\Night_Vision_1.txt");	 
		BufferedReader br = new BufferedReader (file);
		  
		String str = br.readLine();
		System.out.println(str);
		Assert.assertTrue(str.contains(td.sampleDownloader));
		          
		      
				}
	
}
