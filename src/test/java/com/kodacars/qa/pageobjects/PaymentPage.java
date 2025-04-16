package com.kodacars.qa.pageobjects;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {

	WebDriverWait wait;
	WebDriver driver;
	String currentWindowHandle;
	
	public PaymentPage(WebDriver driver) {
		if (driver == null) {
			throw new IllegalArgumentException("Driver instance cannot be null");
		}
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	public PaymentPage(WebDriver driver, String currentWindowHandle) {
		if (driver == null) {
			throw new IllegalArgumentException("Driver instance cannot be null");
		}
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
		this.currentWindowHandle=currentWindowHandle;

	}

	@FindBy(xpath = "//button[@data-testid='card-accordion-item-button']")
	WebElement cardButton;
	
	@FindBy(name="cardNumber")
	WebElement cardInforationTextbox ;
	
	
	@FindBy(name="cardExpiry")
	WebElement cardExpiryTextbox ;
	
	@FindBy(name="cardCvc")
	WebElement cvcTextbox ;
	
	@FindBy(name="billingName")
	WebElement billingNameTextbox ;
	
	@FindBy(name="billingPostalCode")
	WebElement zipTextbox ;
	
	@FindBy(id="enableStripePass")
	WebElement phoneNoCheckbox ;
	
	@FindBy(xpath="//div[@class='SubmitButton-IconContainer']")
	WebElement payButton ;
	
	@FindBy(xpath="//h1[text()='Payment Successful']")
	WebElement successMessageLable ;
	
	@FindBy(xpath = "//*[@class='swal2-header']")
	@CacheLookup
	WebElement popup;
	
	@FindBy(xpath = "//button[text()='OK']")
	@CacheLookup
	WebElement OK; 
	//@FindBy(xpath = "//button[normalize-space()='Check-In/ Key-In']")
//	@CacheLookup
//	WebElement Checkin;

	

   @FindBy(xpath = "//button[text()='Ok']")
   @CacheLookup
   WebElement ok;
   
   @FindBy(xpath="//input[@value='CheckedIn']")
   @CacheLookup
   WebElement status;
   
   @FindBy(xpath="//button[text()='Edit Location']")
   @CacheLookup
   WebElement EditLocation;
   
   @FindBy(xpath="//label[text()='Parking Loc']/following-sibling::p-dropdown")
   @CacheLookup
   WebElement selectParkLocMenu;
 
   @FindBy(xpath="//div[@class ='p-dropdown-header ng-tns-c53-16 ng-star-inserted']/following-sibling::div")
   @CacheLookup
   WebElement selectParkLoc;

   @FindBy(xpath="//span[text()='Key Location']")
   @CacheLookup
   WebElement Location;
   
   @FindBy(xpath="//div[@class='p-dropdown-header ng-tns-c53-17 ng-star-inserted']/following-sibling::div")
   @CacheLookup
   WebElement SelectLocation;

   @FindBy(xpath="//button[text()='Update Location']")
   @CacheLookup
   WebElement UpdateLocation;
   
   @FindBy(xpath="//*[@class='CheckoutInput PhoneNumberInput-input SignUpForm-phoneInput CheckoutInput--hasPlaceholderIcon Input Input--empty']")
   @CacheLookup
   WebElement Phonenumber;
   
 
	
 	public AddReservationPage payPaymentByCard(String cardInformation,String cardExpiry ,String cvcNo, String cardName, String zip, String email) {
		payPaymentCardWithoutPhoneNo(cardInformation, cardExpiry, cvcNo, cardName, zip, email);
		return new AddReservationPage(driver);
	
	}

	public void payPaymentCardWithoutPhoneNo(String cardInformation, String cardExpiry, String cvcNo, String cardName, String zip,
			String email) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver1 -> driver1.getWindowHandles().size() > 1);

	Set<String> windowHandles = driver.getWindowHandles();
		for (String windowHandle : windowHandles) {
			System.out.println("**************windowHandle*******************" + windowHandle);

			if (!windowHandle.equalsIgnoreCase(currentWindowHandle)) {
				driver.switchTo().window(windowHandle);
				WebElement emailTxt = wait.until(
						ExpectedConditions.visibilityOfElementLocated(By.cssSelector("main form input[id='email']")));

				int width = cardButton.getSize().getWidth();
				int height = cardButton.getSize().getHeight();
				int xOffset = (int) (width * 0.75); 
				int yOffset = height / 2; 

				Actions actions = new Actions(driver);
				actions.moveToElement(cardButton, xOffset, yOffset).click().perform();
				actions.moveToElement(cardInforationTextbox).click().sendKeys(cardInformation).build().perform();
				actions.moveToElement(cardExpiryTextbox).click().sendKeys(cardExpiry).build().perform();
				actions.moveToElement(cvcTextbox).click().sendKeys(cvcNo).build().perform();
				actions.moveToElement(billingNameTextbox).click().sendKeys(cardName).build().perform();
				actions.moveToElement(zipTextbox).click().sendKeys(zip).build().perform();				
				actions.click(phoneNoCheckbox).perform();
				actions.moveToElement(emailTxt).click().sendKeys(email).build().perform();

				JavascriptExecutor js = (JavascriptExecutor) driver;				
				js.executeScript("arguments[0].click();", payButton);

				//By successMessageLable = By.xpath("//h1[text()='Payment Successful']");
			    wait.until(ExpectedConditions.visibilityOf(successMessageLable));
						


				driver.close();
				break;

			}

	}	driver.switchTo().window(currentWindowHandle);
	System.out.println("------------------------------" +currentWindowHandle);
	}
	public void payPaymentCardWithPhoneNo(String cardInformation, String cardExpiry, String cvcNo, String cardName, String zip,
			String email) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver1 -> driver1.getWindowHandles().size() > 1);

	Set<String> windowHandles = driver.getWindowHandles();
		for (String windowHandle : windowHandles) {

			if (!windowHandle.equalsIgnoreCase(currentWindowHandle)) {
				driver.switchTo().window(windowHandle);
				WebElement emailTxt = wait.until(
						ExpectedConditions.visibilityOfElementLocated(By.cssSelector("main form input[id='email']")));

				int width = cardButton.getSize().getWidth();
				int height = cardButton.getSize().getHeight();
				int xOffset = (int) (width * 0.75); 
				int yOffset = height / 2; 

				Actions actions = new Actions(driver);
				actions.moveToElement(cardButton, xOffset, yOffset).click().perform();
				actions.moveToElement(cardInforationTextbox).click().sendKeys(cardInformation).build().perform();
				actions.moveToElement(cardExpiryTextbox).click().sendKeys(cardExpiry).build().perform();
				actions.moveToElement(cvcTextbox).click().sendKeys(cvcNo).build().perform();
				actions.moveToElement(billingNameTextbox).click().sendKeys(cardName).build().perform();
				actions.moveToElement(zipTextbox).click().sendKeys(zip).build().perform();				
				wait.until(ExpectedConditions.elementToBeClickable(Phonenumber));
				Phonenumber.click();
				Phonenumber.sendKeys("2487676786");
	    		actions.moveToElement(emailTxt).click().sendKeys(email).build().perform();

				JavascriptExecutor js = (JavascriptExecutor) driver;				
				js.executeScript("arguments[0].click();", payButton);

				//By successMessageLable = By.xpath("//h1[text()='Payment Successful']");
			  wait.until(ExpectedConditions.visibilityOf(successMessageLable));
						


				driver.close();
				break;

			}

	}	driver.switchTo().window(currentWindowHandle);
	}
	public AddReservationPage CheckinPaymentByCard(String cardInformation,String cardExpiry ,String cvcNo, String cardName, String zip, String email) throws InterruptedException {
		payPaymentCardWithoutPhoneNo(cardInformation, cardExpiry, cvcNo, cardName, zip, email);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50)); 

		//wait.until(ExpectedConditions.elementToBeClickable(popup)).click();
		wait.until(ExpectedConditions.elementToBeClickable(OK)).click();
		
		WebElement Checkin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='assignParkingSlot']/div/div/div[3]/button")));
       Thread.sleep(1500);
		System.out.println(driver.findElement(By.xpath("//label[text()='Start Date and Time']")).getText() + "+++ I am Here ++++");
		Actions actions = new Actions(driver);
		actions.moveToElement(Checkin).click().build().perform();
		Thread.sleep(1500);
		System.out.println(driver.findElement(By.xpath("//label[text()='Start Date and Time']")).getText() + "+++ I am after Action Here ++++");

//		WebElement window =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Assign Parking Slot']")));
//		window.click();
	//	 WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(60));
		//	WebElement Checkin = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='assignParkingSlot']/div/div/div[3]/button")));
		//	 Checkin.click();
		
		   //wait1.until(ExpectedConditions.visibilityOf(Checkin));
		  //.click();
		//wait.until(ExpectedConditions.visibilityOf(checkin)).click();
		//wait.until(ExpectedConditions.elementToBeClickable(checkin)).click();
		wait.until(ExpectedConditions.elementToBeClickable(ok)).click();
		wait.until(ExpectedConditions.elementToBeClickable(status)).click();
		
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,650)");
		  wait.until(ExpectedConditions.elementToBeClickable(EditLocation)).click();
	      wait.until(ExpectedConditions.elementToBeClickable(selectParkLocMenu)).click();
		  wait.until(ExpectedConditions.elementToBeClickable(selectParkLoc)).click();
		  wait.until(ExpectedConditions.elementToBeClickable(Location)).click();
		  wait.until(ExpectedConditions.elementToBeClickable(SelectLocation)).click();
		  wait.until(ExpectedConditions.elementToBeClickable(UpdateLocation)).click();

	return new AddReservationPage(driver);
	
	}
	
	
}
