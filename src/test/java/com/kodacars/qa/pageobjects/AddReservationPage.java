package com.kodacars.qa.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchFrameException;
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

	// Reservation Link
	@FindBy(xpath = "//div[@class='text-center mt-4']//button[text()='Receive Payment']")
	@CacheLookup
	private WebElement clickReceivePayment;

	@FindBy(xpath = "//span[contains(@class, 'p-dropdown-label') and text()='Select Payment Mode']")
	@CacheLookup
	private WebElement selectPaymentMode;

	@FindBy(xpath = "//li[@role='option']//span[text()='Cash']")
	@CacheLookup
	private WebElement selectCash;

	@FindBy(xpath = "//button[@id='closeModal' and text()='Collect Payment']")
	@CacheLookup
	private WebElement collectPayment;

	@FindBy(xpath = "//div[@class='swal2-actions']//button[contains(@class, 'swal2-confirm')]")
	@CacheLookup
	private WebElement paymentReceivedSuccessfully;

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
	
		
		public String getTextConfirmationNumber(String expectedConfirmationNumber) {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		    // Wait until the input field is visible
		    WebElement confirmationInput = wait.until(ExpectedConditions.presenceOfElementLocated(
		        By.xpath("//input[@formcontrolname='confirmationNo']")));

		    WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(60));
		    WebElement confirmationElement = waits.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmationNumber")));

		    new WebDriverWait(driver, Duration.ofSeconds(30)).until(
		    	    webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete")
		    	);

		    // Get the confirmation number from the input field
		    String actualConfirmationNumber = confirmationInput.getDomAttribute("value");
		    		//getAttribute();
return actualConfirmationNumber;
		    // Assertion to compare expected vs actual confirmation number
		   
		}

	

	public void enterstartDate() {
		enterstartDate.sendKeys("04/21/2025");
	}

	public void enterstartTime() {
		enterstartTime.sendKeys("09:00 AM");
	}

	public void enterEndDate() {
		enterEndDate.sendKeys("04/22/2025");
	}

	public void enterEndTime() {
		enterEndTime.sendKeys("10:00 AM");
	}

//	public void selectReservationPrepaidOrPartial2(String prepaid) {
//		prepaidPartial.sendKeys(prepaid, Keys.ENTER);
//	}

	public void selectReservationPrepaid(String prepaid) {
		prepaidPartial.sendKeys(prepaid, Keys.ENTER);
	}

	public void enterTotalAmount() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement totalAmountInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@formcontrolname='totalAmount']")));
		totalAmountInput.sendKeys("20");
	}

	public void enterPrepaidAmount() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement totalAmountField = wait.until(ExpectedConditions.visibilityOf(prepaidAmount));
		totalAmountField.sendKeys("8");
	}

	public void clicksearchBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
		searchButton.click();
	}

	public void enterConfirmationNumber(String ConfirmationNum) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

	public void clickReceivePayment() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

		// Ensure the page has fully loaded
		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
				.equals("complete"));

		try {
			// Ensure the element is present
			WebElement receivePaymentButton = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//button[contains(text(),'Receive Payment')]")));

			// Scroll into view
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", receivePaymentButton);

			// Wait for the button to be clickable
			wait.until(ExpectedConditions.elementToBeClickable(receivePaymentButton));

			// Click the button, use JS click if necessary
			try {
				receivePaymentButton.click();
			} catch (ElementClickInterceptedException e) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", receivePaymentButton);
			}

		} catch (TimeoutException e) {
			System.out.println("Timeout: 'Receive Payment' button not found.");
		}
	}

	public boolean isReceivePaymentMethod() {
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
		utilsObj.visibilityOfExtraWaitTime(selectPaymentMode);
		selectPaymentMode.click();
	}

	public void selectCash() {
		utilsObj.visibilityOf(selectCash);
		selectCash.click();
	}

	public void clickcollectPayment() {
		utilsObj.visibilityOfExtraWaitTime(collectPayment);
		collectPayment.click();
	}

	public void clickpaymentReceivedSuccessfully() {
		utilsObj.visibilityOfExtraWaitTime(paymentReceivedSuccessfully);
		paymentReceivedSuccessfully.click();
	}

	public boolean KodaWalkAddReservation(String sourceName, String prepaidPartial, String carColor, String carMake,
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
		//selectReservationPrepaid(prepaidPartial);
//		enterTotalAmount();
//		enterPrepaidAmount();

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

	public boolean KodaWalkAddReservation(String sourceName, String confirmationNumber, String PrepaidPartial,
			String carColor, String carMake, String carModel, String license, String state)
			throws InterruptedException {

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

	public AddReservationPage(WebDriver driver) {
		if (driver == null) {
			throw new IllegalArgumentException("Driver instance cannot be null");
		}
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
}
