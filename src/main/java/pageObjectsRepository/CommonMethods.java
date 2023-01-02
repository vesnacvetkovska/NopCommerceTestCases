package pageObjectsRepository;



import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;
import testData.TestData;


public class CommonMethods extends Base {

 PDPObjects pdpo = new PDPObjects();
 TestData td = new TestData();
 ShoppingCartObjects shco = new ShoppingCartObjects();
	
	

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
	
	public void waitMethodVisibility (int sec, WebElement elem) {
		WebDriverWait wait = new WebDriverWait(driver,sec);
		wait.until(ExpectedConditions.visibilityOf( elem )) ;
	}
	
	public void waitMethodInvisibility (int sec, WebElement elem1) {
		WebDriverWait wait = new WebDriverWait(driver,sec);
		wait.until(ExpectedConditions.invisibilityOf( elem1 )) ;
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
		
		// get the price from pdp
		public String getThePriceFromPDP(WebElement elem) {
			String s = pdpo.productPriceItem.getText();
			String snew = s.replace("$", "");
			double snew1 = Double.parseDouble(snew);
			return snew;
			
		}
		
		// convert string to double
		public  double stringToDouble (WebElement elem) {
			String s= elem.getText();
			String snew = s.replace("$", "");
			double doub = Double.parseDouble(snew);
			return doub;
			
		}

		// datePicker
		public void datePicker (String dateForRent, WebElement dataField, WebElement nextBtn ) {
		String dateForRent2 = dateForRent;
		String emonth2 = dateForRent2.split("-")[1];
		String eyear2 = dateForRent2.split("-")[2];
		String eday2 = dateForRent2.split("-")[0];
			
			//new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class=\"datepicker hasDatepicker\"])[1]"))); 
			
			dataField.click();
			
			 String cmonth2 = pdpo.monthInDatePicker.getText().trim();
			 String cyear2 =pdpo.yearInDatePicker.getText().trim();
			
			  
			  //month and year picker
			 while (!(cmonth2.equals(emonth2)) || !(cyear2.equals(eyear2))) {
				
				// new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ui-datepicker-div\"]"))); 
				
				nextBtn.click();
							 
				 cmonth2 =pdpo.monthInDatePicker.getText().trim();
				 cyear2 =pdpo.yearInDatePicker.getText().trim();
				 
				 System.out.println(eyear2);
				 System.out.println(emonth2);
				 
						 
			 }
			
			 //day picker
			 List<WebElement> dates2 = driver.findElements(By.xpath("//*[@class=\"ui-state-default\"]"));
			 
			 for (WebElement e1:dates2) {
				 
				 if (e1.getText().trim().equals(eday2)) {
					 e1.click();
					 break;
				 }
		
	
			 }
		}
			 public void printLn (String s) {
				 System.out.println(s);
				 
			 }
			 public void print(String s) {
					System.out.println(s);
				}

		}