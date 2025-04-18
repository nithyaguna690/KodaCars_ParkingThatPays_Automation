package com.kodacars.qa.pageobjects;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
	
    @FindBy(id = "phoneNumber")
	WebElement phoneNoTextBox;
    
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
	
	@FindBy(xpath = "//div[text()='Assign Parking Slot']")
	@CacheLookup
	WebElement checkinpopup; 
	
	
	@FindBy(xpath = "//button[normalize-space()='Check-In/ Key-In']")
	@CacheLookup
	WebElement Checkin;

    @FindBy(xpath = "//button[text()='Ok']")
    @CacheLookup
    WebElement ok;
   
    @FindBy(xpath="//input[@value='CheckedIn']")
    @CacheLookup
    WebElement status;
   
   @FindBy(xpath="//button[text()='Edit Location']")
   @CacheLookup
   WebElement EditLocation;
   
   @FindBy(xpath="//span[text()='Select Location']")
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

   @FindBy(xpath = "//div[@class='OtpInput']/input")
	List<WebElement> sixDigitTextbox;
	
   public AddReservationPage payPaymentByCard(String cardInformation, String cardExpiry, String cvcNo, String cardName,
			String zip, String email,String checkBoxStatus, String phoneNo) {
		payPament(cardInformation, cardExpiry, cvcNo, cardName, zip, email, checkBoxStatus, phoneNo);
		return new AddReservationPage(driver);

	}
	public void okBtnforlocationupdate() {

		WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Ok']")));
		okButton.click();
	}
	
  private void payPament(String cardInformation, String cardExpiry, String cvcNo, String cardName, String zip,
			String email, String checkBoxStatus, String phoneNo) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver1 -> driver1.getWindowHandles().size() > 1);

		Set<String> windowHandles = driver.getWindowHandles();
		for (String windowHandle : windowHandles) {

			if (!windowHandle.equalsIgnoreCase(currentWindowHandle)) {
				driver.switchTo().window(windowHandle);
				WebElement emailTxt = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("main form input[id='email']")));				

				int width = cardButton.getSize().getWidth();
				int height = cardButton.getSize().getHeight();
				int xOffset = (int) (width * 0.75);
				int yOffset = height / 2;

				Actions actions = new Actions(driver);
				actions.moveToElement(cardButton, xOffset, yOffset).click().perform();
				cardInforationTextbox.sendKeys(cardInformation);
				cardExpiryTextbox.sendKeys(cardExpiry);
				cvcTextbox.sendKeys(cvcNo);
				billingNameTextbox.sendKeys(cardName);
				actions.moveToElement(zipTextbox).click().sendKeys(zip).build().perform();
				zipTextbox.sendKeys(zip);
				if(checkBoxStatus.equalsIgnoreCase("TRUE")) {
					phoneNoTextBox.sendKeys(phoneNo);
				}
				else {
					actions.click(phoneNoCheckbox).perform();					
				}
				emailTxt.sendKeys(email);
				
				if(wait.until(ExpectedConditions.visibilityOf(emailTxt)).isDisplayed()) {
					for(WebElement element: sixDigitTextbox)
					{
						element.sendKeys("0");
					}
					
				}
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", payButton);
				wait.until(ExpectedConditions.visibilityOf(successMessageLable));

				driver.close();
				break;
			}
		}
		driver.switchTo().window(currentWindowHandle);
	}

	public AddReservationPage CheckinCardPayment(String cardInformation, String cardExpiry, String cvcNo, String cardName, String zip,
			String email, String checkBoxStatus, String phoneNo) throws InterruptedException {
		
		Actions actions = new Actions(driver);
		payPament( cardInformation,cardExpiry, cvcNo, cardName, zip, email,checkBoxStatus, phoneNo);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50)); 
		wait.until(ExpectedConditions.elementToBeClickable(popup)).click();
		wait.until(ExpectedConditions.elementToBeClickable(OK)).click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(60));
	    wait1.until(ExpectedConditions.visibilityOf(Checkin));
		Thread.sleep(6000);
	    Checkin.click();		
		Thread.sleep(6000);
		wait.until(ExpectedConditions.elementToBeClickable(ok)).click();
		Thread.sleep(6000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", EditLocation);
		wait.until(ExpectedConditions.elementToBeClickable(EditLocation)).click();
	    wait.until(ExpectedConditions.elementToBeClickable(selectParkLocMenu)).click();
	    actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
	    wait.until(ExpectedConditions.elementToBeClickable(Location)).click();
	    actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
	    Thread.sleep(6000);
		wait.until(ExpectedConditions.elementToBeClickable(UpdateLocation)).click();
		okBtnforlocationupdate();
	
	return new AddReservationPage(driver);
	
	}
	
	public AddReservationPage UpdateLocation()throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50)); 
		Actions actions = new Actions(driver);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", EditLocation);
		wait.until(ExpectedConditions.elementToBeClickable(EditLocation)).click();
	    wait.until(ExpectedConditions.elementToBeClickable(selectParkLocMenu)).click();
	    actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
	    wait.until(ExpectedConditions.elementToBeClickable(Location)).click();
	    actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
	    Thread.sleep(6000);
		wait.until(ExpectedConditions.elementToBeClickable(UpdateLocation)).click();
		okBtnforlocationupdate();
		return new AddReservationPage(driver);
	
	}


	public AddReservationPage CheckinCashPayment() throws InterruptedException {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	    Thread.sleep(6000);
	    checkinpopup.click();
		Thread.sleep(8000);
		WebElement checkin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Check-In/ Key-In']")));
		checkin.click();
		wait.until(ExpectedConditions.elementToBeClickable(ok)).click();
		Thread.sleep(6000);
	    UpdateLocation();
	
	return new AddReservationPage(driver);
	
	}
	
	}
