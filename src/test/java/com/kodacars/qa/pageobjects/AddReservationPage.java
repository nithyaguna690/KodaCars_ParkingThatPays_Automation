package com.kodacars.qa.pageobjects;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;
import com.kodacars.qa.uilities.CommonUtils;

public class AddReservationPage {
	Faker faker = new Faker();
	WebDriverWait wait;
	WebDriver driver;
	CommonUtils utilsObj = CommonUtils.getInstance(driver);

	public AddReservationPage(WebDriver driver) {
		if (driver == null) {
			throw new IllegalArgumentException("Driver instance cannot be null");
		}
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@formcontrolname='firstName']")
	@CacheLookup
	private WebElement enterFirstName;

	@FindBy(xpath = "//input[@formcontrolname='lastName']")
	@CacheLookup
	private WebElement enterLastName;

	@FindBy(xpath = "//input[@formcontrolname='phoneNumber']")
	@CacheLookup
	private WebElement enterPhoneNumber;

	@FindBy(xpath = "//input[@type='email']")
	@CacheLookup
	private WebElement enterEmail;

	@FindBy(xpath = "//div[@class='ng-select-container ng-has-value']/div/div[@aria-expanded='true']")
	@CacheLookup
	private WebElement selectCity;

	@FindBy(xpath = "//ng-select[@bindlabel='name' and @formcontrolname='location']//input")
	@CacheLookup
	private WebElement selectLocationdropdown;

	@FindBy(xpath = "//ng-select[@formcontrolname='location' and @bindlabel='name']//span[contains(text(),'Barcelona')]")
	@CacheLookup
	private WebElement selectLocation;

	@FindBy(xpath = "//ng-select[@formcontrolname='source']//div[contains(@class,'ng-select-container')]")
	@CacheLookup
	private WebElement selectSourcedropdown;

	@FindBy(xpath = "//ng-dropdown-panel//span[@class='ng-option-label ng-star-inserted']")
	@CacheLookup
	private WebElement source_dropdownOptionsList;

	@FindBy(xpath = "//input[@formcontrolname='confirmationNo']")
	@CacheLookup
	private WebElement confirmationNumber;

	@FindBy(xpath = "//input[@formcontrolname='startDate']")
	@CacheLookup
	private WebElement enterstartDate;

	@FindBy(xpath = "//input[@formcontrolname='startTime']")
	@CacheLookup
	private WebElement enterstartTime;

	@FindBy(xpath = "//input[@formcontrolname='endDate']")
	@CacheLookup
	private WebElement enterEndDate;

	@FindBy(xpath = "//input[@formcontrolname='endTime']")
	@CacheLookup
	private WebElement enterEndTime;

	@FindBy(xpath = "//ng-select[@formcontrolname='reservationType']//input[@type='text']")
	private WebElement prepaidPartial;

	@FindBy(xpath = "//button[contains(text(),'Add Vehicle')]")
	@CacheLookup
	private WebElement clickAddVehicle;

	@FindBy(xpath = "//ng-select[@bindlabel='color']//div[@class='ng-select-container ng-has-value']")
	@CacheLookup
	private WebElement carColorDropdown;

	@FindBy(xpath = "//ng-select[@formcontrolname='carColor']//input[@type='text']")
	@CacheLookup
	private WebElement selectCarcolor;

	@FindBy(xpath = "//div[@class='col-3 form-group']/ng-select[@formcontrolname='make']//input[@type='text']")
	@CacheLookup
	private WebElement carMakeDropdown;

	@FindBy(xpath = "//span[@class='ng-option-label ng-star-inserted']")
	@CacheLookup
	private WebElement carMakeDropdownOptions;

	@FindBy(xpath = "//div[contains(@id,'a94ed9d17181')]//span[contains(@class, 'ng-option-label ng-star-inserted')]")
	@CacheLookup
	private WebElement carMake;

	@FindBy(xpath = "//ng-select[@formcontrolname='model']/div/div/div[3]/input")
	@CacheLookup
	private WebElement carModel;

	@FindBy(xpath = "//input[@formcontrolname='licenseNo']")
	@CacheLookup
	private WebElement enterLicenceno;

	@FindBy(xpath = "//ng-select[@formcontrolname='state']//input[@type='text']")
	@CacheLookup
	private WebElement Statedropdown;

	@FindBy(xpath = "//button[text()='Create Reservation']")
	@CacheLookup
	private WebElement createReservationBtn;

	@FindBy(xpath = "//div[@class='modal-content']/div[@class='p-3 m-auto']/div/button[text()='Ok']")
	@CacheLookup
	private WebElement reservationSuccessBtn;

	@FindBy(xpath = "//label[normalize-space()='Reservation Created Successfully.']")
	@CacheLookup
	private WebElement reservationSuccessTextMessage;

	@FindBy(xpath = "//span[@id='cell-515']//button[@title='Delete Reservation']")
	@CacheLookup
	private WebElement deleteReservation;

	@FindBy(xpath = "//button[@title='Cancel Reservation']")
	@CacheLookup
	private WebElement cancelReservation;

	@FindBy(xpath = "//div[@role='combobox']")
	@CacheLookup
	private WebElement selectThirdPartySource;

	@FindBy(xpath = "//input[@formcontrolname='prepaidAmount']")
	@CacheLookup
	private WebElement prepaidAmount;

	@FindBy(xpath = "//div[@class='modal-footer']//button[text()='Search']")
	@CacheLookup
	private WebElement searchBtn;

	@FindBy(xpath = "//input[@formcontrolname='confirmationNo']")
	@CacheLookup
	private WebElement enterConfirmationNumber;

	@FindBy(xpath = "//button[contains(@class, 'btn-primary') and contains(text(),'Create Manually')]")
	@CacheLookup
	private WebElement createManually;

	@FindBy(xpath = "//div[@class='text-center mt-4']//button[text()='Receive Payment']")
	WebElement receivePaymentButton;

	@FindBy(xpath = "//span[text()='Select Payment Mode']")
	WebElement selectPaymentModeDDB;

	@FindBy(xpath = "//p-dropdownitem[contains(@class,'p-element ng-tns-c53-18 ng-star-inserted')]//span[@class='ng-star-inserted' and text()='Card']")
	WebElement cardOption;

	@FindBy(xpath = "//p-dropdownitem[contains(@class,'p-element ng-tns-c53-18 ng-star-inserted')]//span[@class='ng-star-inserted' and text()='Cash']")
	WebElement cashOption;

	@FindBy(xpath = "(//button[text()='Pay Now'])[2]")
	WebElement payNowBtn;

	@FindBy(xpath = "//button[text()='OK']")
	WebElement oKPaymentReceviedButton;

	@FindBy(xpath = "//button[text()='Collect Payment']")
	WebElement collectPaymentButton;

	@FindBy(xpath = "//span[contains(@class, 'p-dropdown-label') and text()='Select Payment Mode']")
	@CacheLookup
	private WebElement selectPaymentMode;
		
	@FindBy(xpath = "//div[@class='text-center mt-4']//button[text()='Receive Payment']")
	@CacheLookup
	private WebElement clickReceivePayment;
	
	@FindBy(xpath = "//button[@class='btn btn-primary ng-star-inserted'][normalize-space()='Receive Payment']")
	@CacheLookup
	WebElement ReceivePayment;
	
	@FindBy(xpath = "//button[@id='closeModal' and text()='Collect Payment']")
	@CacheLookup
	private WebElement collectPayment;
	
	@FindBy(xpath = "//*[text()='Check-In/ Key-In']")
	@CacheLookup
	WebElement checkin;
	
	@FindBy(xpath ="//button[normalize-space()='Check In / Key In']")
	@CacheLookup
	WebElement check_in;
	
	@FindBy(xpath = "//div[@class='modal-footer ng-star-inserted'][2]/button[text()='Pay Now']")
    @CacheLookup
    WebElement Pay_Now;
	
   @FindBy(xpath= "//input[@id='email']")
   @CacheLookup
   WebElement Email;
   
   @FindBy(xpath= "//div[@class='flex-container']")
   @CacheLookup
   WebElement Card_radiobtn;
   
  
  @FindBy(id = "cardNumber")
  @CacheLookup
  WebElement Card_num;

@FindBy(css = "#cardExpiry")
@CacheLookup
WebElement Card_expirydate;

@FindBy(id = "cardCvc")
@CacheLookup
WebElement Card_CVC;

@FindBy(id = "billingName")
@CacheLookup
WebElement CardHolder_Name;

@FindBy(id = "billingPostalCode")
@CacheLookup
WebElement CardHolder_zipcode;

@FindBy(id = "//*[@class='SignUpForm SignUpForm--expanded']//div[@class='Checkbox'")
@CacheLookup
WebElement unchecksave;

@FindBy(xpath="//input[@value='CheckedIn']")
@CacheLookup
WebElement status;

@FindBy(xpath = "//div[@class= 'ConfirmPayment']")
@CacheLookup
WebElement pay;

@FindBy(xpath = "//*[@class='swal2-header']")
@CacheLookup
WebElement popup;

@FindBy(xpath = "//button[text()='OK']")
@CacheLookup
WebElement OK;

@FindBy(xpath = "//button[text()='Ok']")
@CacheLookup
WebElement ok;

@FindBy(xpath = "//*[@id='checkOut']//button[text()='Pay Now']")
@CacheLookup
private WebElement PayNow;

@FindBy(xpath = "//button[text()='Check Out / Key Out']")
@CacheLookup
private WebElement Checkout;
	
@FindBy(xpath = "//button[@id='closeModal'and contains(text(),'Check-Out/ Key-Out')]")
@CacheLookup
private WebElement Checkout_click;
	
@FindBy(xpath = "//div[@class='swal2-header']")
@CacheLookup
private WebElement ConfirmPayment;
	
@FindBy(xpath = "//button[text()='Yes, go ahead.']")
@CacheLookup
private WebElement yes;
	
@FindBy(xpath = "//button[text()='Ok']")
@CacheLookup
private WebElement checkout_ok;
	 
	
	public void enterFirstName() {
		String firstName = faker.name().firstName();
		System.out.println("The First Name : " + firstName);
		enterFirstName.sendKeys(firstName);
	}

	public void enterLastName() {
		String lastName = faker.name().lastName();
		System.out.println("The Last Name : " + lastName);
		enterLastName.sendKeys(lastName);
	}

	public void enterPhoneNumber() {
		String phoneNumber = faker.phoneNumber().cellPhone();
		System.out.println("The Phone Number : " + phoneNumber);
		enterPhoneNumber.sendKeys(phoneNumber);
	}

	public void enterEmail() {
		String uniqueEmail = faker.internet().safeEmailAddress();
		System.out.println("Unique Email: " + uniqueEmail);
		enterEmail.sendKeys(uniqueEmail);
	}

	public void selectCity() {
		selectCity.click();
	}

	public void selectLocationdropdown() throws InterruptedException {
		Thread.sleep(3000);
		utilsObj.visibilityOf(selectLocationdropdown);
		selectLocationdropdown.click();
	}

	public void selectLocation() throws InterruptedException {
		Thread.sleep(3000);
		utilsObj.visibilityOf(selectLocation);
		selectLocation.click();
	}

//	public void selectLocationDropdown() {
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//
//	    // Wait for any modal overlay to disappear
//	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("modal-backdrop")));
//
//	    // Locate the dropdown input element
//	    By locationInputLocator = By.xpath("//ng-select[@bindlabel='name' and @formcontrolname='location']//input");
//	    WebElement locationInput = wait.until(ExpectedConditions.presenceOfElementLocated(locationInputLocator));
//
//	    // Scroll into view
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", locationInput);
//
//	    // Wait for the input to be clickable
//	    wait.until(ExpectedConditions.elementToBeClickable(locationInput));
//
//	    // Try clicking the input
//	    try {
//	        locationInput.click();
//	    } catch (ElementClickInterceptedException e) {
//	        // Fallback to JS click if intercepted
//	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", locationInput);
//	    }
//
//	    System.out.println("Clicked on location dropdown input.");
//	}

	public void selectSource(String selectSourceName) {
		utilsObj.elementToBeClickableWaitTime(selectSourcedropdown);
		selectSourcedropdown.click();
		By optionLocator = By.xpath("//ng-dropdown-panel//span[contains(text(),'" + selectSourceName + "')]");
		WebElement option = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
		option.click();
	}

	public void selectSourcePopUp(String selectSourceName) {
		By optionLocator = By.xpath("//ng-dropdown-panel[@id='acab4c61e7f3']//span[text()='" + selectSourceName + "']");
		WebElement option = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
		option.click();
	}

	public void enterconfirmationNumber(String confirmationNum) {
		confirmationNumber.sendKeys(confirmationNum);
	}

	public void enterstartDate() {
		enterstartDate.sendKeys("04/08/2025");
	}

	public void enterstartTime() {
		enterstartTime.sendKeys("09:00 AM");
	}

	public void enterEndDate() {
		enterEndDate.sendKeys("04/09/2025");
	}

	public void enterEndTime() {
		enterEndTime.sendKeys("06:30 PM");
	}

//	public void selectReservationPrepaidOrPartial2(String prepaid) {
//		prepaidPartial.sendKeys(prepaid, Keys.ENTER);
//	}

	public void selectReservationPrepaid(String prepaid) {
		prepaidPartial.sendKeys(prepaid, Keys.ENTER);
	}

	public void enterTotalAmount() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement totalAmountInput = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@formcontrolname='totalAmount']")));
		totalAmountInput.sendKeys("16.25");
	}

	public void enterPrepaidAmount() {
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement totalAmountField = wait.until(ExpectedConditions.visibilityOf(prepaidAmount));
		totalAmountField.sendKeys("8");
	}

	public void clicksearchBtn() {
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
		searchButton.click();
	}
	
	public void unchecksavecarddetails() {
		utilsObj.visibilityOfExtraWaitTime(unchecksave);
		unchecksave.click();
	}

	public void enterConfirmationNumber(String ConfirmationNum) {
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement confirmationField = wait.until(ExpectedConditions.visibilityOf(enterConfirmationNumber));
		confirmationField.sendKeys(ConfirmationNum);
	}

	public void clickAddVehicle() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("overlay")));
		clickAddVehicle.click();
	}

	public void carColordropdown() throws InterruptedException {
		WebElement colorDropdown = utilsObj.elementToBeClickableExtraWaitTime(carColorDropdown);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", colorDropdown);
	}

	public void selectCarcolor(String color) {
		selectCarcolor.sendKeys(color, Keys.ENTER);
	}

	public void clickCarMakeDropdown() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("overlay")));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", carMakeDropdown);

	}

	private static final By CAR_MODEL_DROPDOWN_OPTIONS = By.xpath("//span[@class='ng-option-label ng-star-inserted']");
	private static final By CAR_MODEL_DROPDOWN = By
			.xpath("//div[@class='col-3 form-group']/ng-select[@formcontrolname='model']//input[@type='text']");

	public void selectCarModel(String carModel) {

		WebElement modelDropdown = wait.until(ExpectedConditions.elementToBeClickable(CAR_MODEL_DROPDOWN));
		modelDropdown.click();

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		List<WebElement> options = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(CAR_MODEL_DROPDOWN_OPTIONS));
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase(carModel)) {
				option.click();
				break;
			}
		}
	}

	private static final By CAR_MAKE_DROPDOWN = By
			.xpath("//div[@class='col-3 form-group']/ng-select[@formcontrolname='make']//input[@type='text']");
	private static final By CAR_MAKE_DROPDOWN_OPTIONS = By.xpath("//span[@class='ng-option-label ng-star-inserted']");

	public void selectCarMake(String carMake) {
		WebElement makeDropdown = wait.until(ExpectedConditions.elementToBeClickable(CAR_MAKE_DROPDOWN));
		makeDropdown.click();

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		List<WebElement> options = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(CAR_MAKE_DROPDOWN_OPTIONS));

		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase(carMake)) {
				option.click();
				break;
			}
		}
	}

	public void selectLicenceno(String licenseNumber) {
		enterLicenceno.sendKeys(licenseNumber, Keys.ENTER);
	}

	public void selectState(String state) {
		Statedropdown.sendKeys(state, Keys.ENTER);
	}

	public void clickCreateReservation() {
		createReservationBtn.click();
	}

	public void clickReservationSuccessBtn() {
		reservationSuccessBtn.click();
	}

	public boolean isReservationSuccessBtnDisplayed() {
		return reservationSuccessBtn.isDisplayed();
	}

	public void clickThirdPartySource() {
		utilsObj.visibilityOfExtraWaitTime(selectThirdPartySource);
		selectThirdPartySource.click();
	}

	public void clickcreateManually() {
		utilsObj.visibilityOfExtraWaitTime(createManually);
		createManually.click();
	}

	public void clickActionButtonBtnDisplayed(String buttonText) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
				.equals("complete"));

//	    boolean buttonClicked = false;
//
//	    for (String buttonText : buttonTex) {
		try {
			WebElement actionButton = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//button[contains(text(),'" + buttonText + "')]")));

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", actionButton);
			wait.until(ExpectedConditions.elementToBeClickable(actionButton));

			try {
				actionButton.click();
			} catch (ElementClickInterceptedException e) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", actionButton);
			}

			System.out.println("Clicked button: " + buttonText);
//	            buttonClicked = true;
//	            break;

		} catch (TimeoutException e) {
			System.out.println("Button not found: " + buttonText);
		}
	}

	public boolean isReceivePaymentMethodDispalyed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

		// Ensure the page has fully loaded
		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
				.equals("complete"));
		WebElement receivePaymentButton = null;
		try {
			// Ensure the element is present
			receivePaymentButton = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//button[contains(text(),'Receive Payment')]")));

			// Scroll into view
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", receivePaymentButton);
		} catch (TimeoutException e) {
			System.out.println("Timeout: 'Receive Payment' button not found.");
		}
		return receivePaymentButton.isDisplayed();

	}

	public void selectPaymentMode() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("overlay")));

		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//span[contains(@class, 'p-dropdown-label') and text()='Select Payment Mode']")));
		dropdown.click();
	}

	// Test Koda And WalkIn Method
	public boolean AddReservation(String sourceName, String prepaidPartial, String carColor, String carMake,
			String carModel, String license, String state) throws InterruptedException {

		// Customer Details
		enterPhoneNumber();
		enterEmail();
		enterFirstName();
		enterLastName();

		// Reservation Details
		selectLocationdropdown();
		selectLocation();
		selectSource(sourceName);
		enterstartDate();
		enterstartTime();
		enterEndDate();
		enterEndTime();
		if (sourceName.equalsIgnoreCase("koda")) {
			selectReservationPrepaid(prepaidPartial);
		}

		// Add Vehicle Details
		clickAddVehicle();
		carColordropdown();
		selectCarcolor(carColor);
		clickCarMakeDropdown();
		selectCarMake(carMake);
		selectCarModel(carModel);
		selectLicenceno(license);
		selectState(state);
		clickCreateReservation();
		boolean isOkBtnDispalyed = isReservationSuccessBtnDisplayed();
		clickReservationSuccessBtn();
		return isOkBtnDispalyed;

	}

	public boolean AddReservation(String sourceName, String confirmationNumber, String PrepaidPartial, String carColor,
			String carMake, String carModel, String license, String state) throws InterruptedException {

		enterconfirmationNumber(confirmationNumber);

		clickcreateManually();
		// Customer Details
		enterPhoneNumber();
		enterEmail();
		enterFirstName();
		enterLastName();

		// Reservation Details
		selectLocationdropdown();
		selectLocation();
		selectSource(sourceName);
		enterstartDate();
		enterstartTime();
		enterEndDate();
		enterEndTime();
		selectReservationPrepaid(PrepaidPartial);
		enterTotalAmount();
		enterPrepaidAmount();

		// Add Vehicle Details
		clickAddVehicle();
		carColordropdown();
		selectCarcolor(carColor);
		clickCarMakeDropdown();
		selectCarMake(carMake);
		selectCarModel(carModel);
		selectLicenceno(license);
		selectState(state);
		clickCreateReservation();
		boolean isOkBtnDispalyed = isReservationSuccessBtnDisplayed();
		clickReservationSuccessBtn();
		return isOkBtnDispalyed;

	}

	public void clickOkButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement okButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'swal2-confirm')]")));
		okButton.click();
	}

	public boolean updateReservationokBtnIsDisplayed(String updateReservation) {
		clickActionButtonBtnDisplayed(updateReservation);
		boolean isOkBtnDispalyed = okBtnisDisplayedupdate();
		okBtnUpdateReservation();
		return isOkBtnDispalyed;

	}

	public void okBtnUpdateReservation() {
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Ok']")));
		okButton.click();
	}

	public boolean okBtnisDisplayedupdate() {
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Ok']")));
		return okButton.isDisplayed();
	}

	// **************CheckIn / Key In
	public void checkInKeyIn(String checkInButton) {
		clickActionButtonBtnDisplayed(checkInButton);

	}

	public void clickButtonByText(String buttonText) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait until at least one button with the given text is present
		wait.until(ExpectedConditions
				.presenceOfAllElementsLocatedBy(By.xpath("//button[contains(text(), '" + buttonText + "')]")));

		List<WebElement> buttons = driver.findElements(By.xpath("//button[contains(text(), '" + buttonText + "')]"));

		for (WebElement button : buttons) {
			try {
				if (button.isDisplayed() && button.isEnabled()) {
					try {
						button.click();
					} catch (Exception e) {
						// Fallback to JS click
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
					}
					System.out.println("Clicked button with text: " + buttonText);
					return;
				}
			} catch (StaleElementReferenceException e) {
				// Try the next one
				continue;
			}
		}

		throw new RuntimeException("No visible and enabled button found with text: " + buttonText);
	}

	public void clickReceivePayment() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

		// Ensure the page has fully loaded
		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
				.equals("complete"));

		try {
			WebElement receivePaymentButton = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//button[contains(text(),'Receive Payment')]")));

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", receivePaymentButton);
			wait.until(ExpectedConditions.elementToBeClickable(receivePaymentButton));
			try {
				receivePaymentButton.click();
			} catch (ElementClickInterceptedException e) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", receivePaymentButton);
			}

		} catch (TimeoutException e) {
			System.out.println("Timeout: 'Receive Payment' button not found.");
		}
	}

	public void selectPaymentCard() {
		selectPaymentMode.click();
		cardOption.click();
	}

	public void selectPaymentCash() {
		selectPaymentMode.click();
		cashOption.click();
	}

	public void enterCardReferenceNumber(String cardRefNumber) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement cardRefInput = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@formcontrolname='CRN']")));
		cardRefInput.clear();
		cardRefInput.sendKeys(cardRefNumber);
	}

	public boolean isoKPaymentReceviedButtonDisplayed() {
		boolean status = wait.until(ExpectedConditions.visibilityOf(oKPaymentReceviedButton)).isDisplayed();
		oKPaymentReceviedButton.click();
		return status;
	}

	public PaymentPage goToReceivePaymentCard(String cardInformation) {

		clickReceivePayment();
		String currentWindowHandle = driver.getWindowHandle();
		selectPaymentCard();
		enterCardReferenceNumber(cardInformation);
		payNowBtn.click();
		return new PaymentPage(driver, currentWindowHandle);
	}
	
	//public void checkin(String cardnumber,String cardExpiry ,String cvv, String customerName, String zipcode, String customeremail) throws InterruptedException {
		 public void checkin() throws InterruptedException {
	     Thread.sleep(8000);
		   check_in.click();
		   Thread.sleep(6000);
	 	   WebElement parkingslotwindow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='assignParkingSlot']//div[contains(text(),'Reservation No: ')]")));
	 	   parkingslotwindow.click();
	 	  Thread.sleep(6000);
	 	    ReceivePayment.click();
	 	   selectPaymentMode.click();
	 	   cardOption.click();
	 	   String mainWindowHandle = driver.getWindowHandle();   
	 	   Pay_Now.click();
	 	  Thread.sleep(6000);
	 	  Set<String> allWindowHandles = driver.getWindowHandles();
		  for (String handle : allWindowHandles) {
			    if (!handle.equals(mainWindowHandle)) {
			        driver.switchTo().window(handle); // Switch to child window
			        Thread.sleep(6000);
			        Email.click();
			        Email.sendKeys("customeremail@example.com");
			        Thread.sleep(2500);
			        Card_radiobtn.click();
			        Card_num.click();
			        Card_num.sendKeys("4242424242424242");
			        Card_expirydate.sendKeys("08/27");
			        Card_CVC.click();
			        Card_CVC.sendKeys("111");
			        CardHolder_Name.sendKeys("customerName");
			        CardHolder_zipcode.sendKeys("67816");
			        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,650)");
					 Thread.sleep(10000);
					WebElement unSave= driver.findElement(By.xpath("//*[@class='SignUpForm SignUpForm--expanded']//div[@class='Checkbox']"));
					wait.until(ExpectedConditions.elementToBeClickable(unSave));
					unSave.click();
					// driver.findElement(By.id("enableStripePass")).click();
					pay.click();
			     	Thread.sleep(6000);
			         driver.close(); 
		        	driver.switchTo().window(mainWindowHandle);
			         	    }
			    }
		  
		  Thread.sleep(5000);
		  popup.click();
		  OK.click();
		  Thread.sleep(6000);
		  checkin.click();
		  Thread.sleep(1000);
		  ok.click();
		  Thread.sleep(1500);
		  status.click();
		  
		}
	public void clickCollectPaymentButton() {
		collectPayment.click();
	}
	
	public void checkout() throws InterruptedException{
		
		  Thread.sleep(6000);
		  Checkout.click();
 		  Thread.sleep(8000);
 		 ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,650)");
 		  Checkout_click.click();
 		  Thread.sleep(6000);		        		 
 		  ConfirmPayment.click();
 		  yes.click();
 		  Thread.sleep(8000);
 		  checkout_ok.click();
 		  System.out.println("Check out completed");
}

	
	
public AddReservationPage goToReceivePaymentCash() {
		
		clickReceivePayment();
		selectPaymentCash();
		clickCollectPaymentButton();
		return new AddReservationPage(driver);		
	}

}
