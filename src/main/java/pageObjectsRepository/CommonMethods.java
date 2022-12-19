package pageObjectsRepository;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;

public class CommonMethods extends Base {


	
	public Object gettextSkuFromElementsInShoppingCart;

	public  CommonMethods() {
		
		PageFactory.initElements(driver, this);
	}
	
	//raboti kako mouse over, odi do elementot
	public void mouseOver (WebElement elem) {
		Actions actions = new Actions(driver);
		actions.moveToElement(elem);
		actions.perform();
	}
	public void scrollToTheEle (WebElement scroll)  {
		 JavascriptExecutor jse = (JavascriptExecutor) driver;
		 
		 jse.executeScript("arguments[0].scrollIntoView", scroll);
		 
		 }
	
	//mouseover
	public void mouseOverMenu (WebElement ele, WebElement ele2) {
		Actions actions = new Actions(driver);
		actions.moveToElement(ele);
		actions.moveToElement(ele2);	
		actions.click().build().perform();}
	
	
	//wait method
	
	public void waitMethod (int sec, WebElement elem) {
		WebDriverWait wait = new WebDriverWait(driver,sec);
		wait.until(ExpectedConditions.visibilityOf( elem )) ;
	}
//random email
			public  String generateMail () {
		
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		String randomEmail = ("test" + generatedstring + "@test.com").toLowerCase();
		
		return (randomEmail);
		
	}
//random password
		public  String generatePassword () {
	
	String generatedstring=RandomStringUtils.randomAlphabetic(6);
	String randomPass =  generatedstring;
	return (randomPass);

}
		
		//select dropdown list
		public  void selectSize(WebElement size , int index) {
		      Select drop = new Select(size);
		      drop.selectByIndex(index);
			}
		
		//not finished yet
		/*public void getSkuValue (WebElement elem) {
			 String el = elem.getAttribute("value");
		
			 System.out.println("This is the SKU " + el);
			 
			 
		}*/
		
		public String getSkuValue (WebElement elem) {
			 String el = elem.getText();
			return el;
					 
		}
		
		//hidden element/covered
		public void  hiddenElement (WebElement elem) {
	
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();" , elem );
		}
		
		public static String stringReturnMethod (WebElement elem) {
			   return elem.getText();
			}
		
			
}
