package com.kodacars.qa.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
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
import org.testng.Assert;

import com.github.javafaker.Faker;

public class AddReservationPage {
	Faker faker = new Faker();
	WebDriverWait wait;
	WebDriverWait longwait;
	static WebDriver driver;
	private double totalAmount;
	private double prepaidAmount;

	public AddReservationPage(WebDriver driver) {
		if (driver == null) {
			throw new IllegalArgumentException("Driver instance cannot be null");
		}
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.longwait = new WebDriverWait(driver, Duration.ofSeconds(30));
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

	@FindBy(xpath = "//ng-select[@formcontrolname='location' and @bindlabel='name']//span[contains(text(),'Madrid')]")
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

	@FindBy(css = "p-checkbox[formcontrolname='isOverSized'] .p-checkbox-box")
	@CacheLookup
	private WebElement overSizeVehicleCheckBox;

	@FindBy(css = "ng-select[formcontrolname='vehicleOversizeCategoryId']")
	@CacheLookup
	private WebElement overSizeVehicleDropdown;

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
	private WebElement receivePaymentButton;

	@FindBy(xpath = "//span[text()='Select Payment Mode']")
	private WebElement selectPaymentModeDDB;

	@FindBy(xpath = "//p-dropdownitem[contains(@class,'p-element ng-tns-c53-18 ng-star-inserted')]//span[@class='ng-star-inserted' and text()='Card']")
	private WebElement cardOption;

	@FindBy(xpath="//p-dropdownitem[2]//*[contains(text(),'Card')]")
	private WebElement card;
	
	@FindBy(xpath="//p-dropdownitem//*[contains(text(),'Cash')]")
	private WebElement cash;
	
	@FindBy(xpath = "//p-dropdownitem[contains(@class,'p-element ng-tns-c53-18 ng-star-inserted')]//span[@class='ng-star-inserted' and text()='Cash']")
	private WebElement cashOption;

	@FindBy(xpath = "(//button[text()='Pay Now'])[2]")
	private WebElement payNowBtn;

	@FindBy(xpath = "//button[text()='OK']")
	private WebElement oKPaymentReceviedButton;

	@FindBy(xpath = "//button[text()='Collect Payment']")
	private WebElement collectPaymentButton;

	@FindBy(xpath = "//span[contains(@class, 'p-dropdown-label') and text()='Select Payment Mode']")
	@CacheLookup
	private WebElement selectPaymentMode;

	@FindBy(xpath = "//button[@id='closeModal' and text()='Collect Payment']")
	@CacheLookup
	private WebElement collectPayment;

	@FindBy(xpath = "//div[@class='text-center mt-4']//button[text()='Receive Payment']")
	@CacheLookup
	private WebElement clickReceivePayment;

	@FindBy(xpath = "//button[@class='btn btn-primary ng-star-inserted'][normalize-space()='Receive Payment']")
	@CacheLookup
	WebElement ReceivePayment;

	@FindBy(xpath = "//button[normalize-space()=''Check In / Key In']")
	@CacheLookup
	WebElement Check_in;

	@FindBy(xpath = "//button[text()='Edit Location']")
	@CacheLookup
	WebElement EditLocation;

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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait until the element is visible
		wait.until(ExpectedConditions.visibilityOf(enterPhoneNumber));

		// Scroll the element into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", enterPhoneNumber);

		// Scroll up slightly in case it's hidden behind a sticky header
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -200);");

		// Send the input
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

	public void selectLocationdropdown(String locationName) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("modal-backdrop")));
			WebElement selectLocationdropdown = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//ng-select[@formcontrolname='location']//div[contains(@class,'ng-select-container')]")));
			selectLocationdropdown.click();
			By optionLocator = By
					.xpath(String.format("//ng-dropdown-panel//span[contains(text(),'%s')]", locationName));
			WebElement locationOption = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
			locationOption.click();
			System.out.println("Location selected: " + locationName);
		} catch (TimeoutException e) {
			System.out.println("Timeout while selecting location: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("An error occurred while selecting the location: " + e.getMessage());
		}
	}

	public void selectLocation() {
		wait.until(ExpectedConditions.visibilityOf(selectLocation));
		wait.until(ExpectedConditions.elementToBeClickable(selectLocation));
		selectLocation.click();
	}

	public void selectSource(String selectSourceName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("modal-backdrop")));

			WebElement selectSourcedropdown = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//ng-select[@formcontrolname='source']//div[contains(@class,'ng-select-container')]")));
			selectSourcedropdown.click();

			By optionLocator = By
					.xpath(String.format("//ng-dropdown-panel//span[contains(text(),'%s')]", selectSourceName));
			WebElement option = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
			option.click();

		} catch (TimeoutException e) {
			System.out.println(" Timeout while selecting source: " + e.getMessage());
		} catch (Exception e) {
			System.out.println(" An error occurred while selecting the source: " + e.getMessage());
		}
	}

	public void enterconfirmationNumber(String confirmationNum) {
		confirmationNumber.sendKeys(confirmationNum);
	}

	public void enterstartDate(String StartDate) {
		enterstartDate.sendKeys(StartDate);

	}

	public void enterstartTime() {
		enterstartTime.sendKeys("09:00 AM");
	}

	public void enterEndDate(String EndDate) {
		enterEndDate.sendKeys(EndDate);
	}

	public void enterEndTime() {
		enterEndTime.sendKeys("06:30 PM");
	}

	public void selectReservationPrepaid(String prepaid) {
		prepaidPartial.sendKeys(prepaid, Keys.ENTER);
	}

	@FindBy(xpath = "//input[@formcontrolname='totalAmount']")
	private WebElement totalAmountInput;

	@FindBy(xpath = "//input[@formcontrolname='prepaidAmount']")
	private WebElement prepaidAmountInput;

	@FindBy(xpath = "//input[@formcontrolname='dueAmount']")
	private WebElement dueAmountInput;

	public void enterTotalAmount(double amount) {
		this.totalAmount = amount;
		wait.until(ExpectedConditions.visibilityOf(totalAmountInput)).clear();
		totalAmountInput.sendKeys(String.valueOf(amount));
	}

	public void enterPrepaidAmount(double amount) {
		this.prepaidAmount = amount;
		wait.until(ExpectedConditions.visibilityOf(prepaidAmountInput)).clear();
		prepaidAmountInput.sendKeys(String.valueOf(amount));
	}

	public void validateDueAmount() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		boolean isPageLoaded = js.executeScript("return document.readyState").equals("complete");
		System.out.println("Page load complete: " + isPageLoaded);

		if (!isPageLoaded) {
			throw new AssertionError("Page not fully loaded, cannot validate due amount.");
		}

		// Attempt to handle modal if it appears
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal")));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".modal-backdrop")));

			WebElement closeButton = wait
					.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".modal .close")));

			try {
				closeButton.click();
				System.out.println("Modal closed successfully.");
			} catch (ElementNotInteractableException e) {
				System.out.println(" Standard click failed, using JS click.");
				js.executeScript("arguments[0].click();", closeButton);
				System.out.println("Modal closed via JS.");
			}

			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".modal")));
		} catch (TimeoutException e) {
			System.out.println("Modal not found or already closed: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error closing modal: " + e.getMessage());
		}

		// Validate due amount
		WebElement dueField = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[formcontrolname='dueAmount']")));
		wait.until(ExpectedConditions.attributeToBeNotEmpty(dueField, "value"));

		String dueAmountValue = dueField.getDomProperty("value");
		System.out.println("Due amount value: " + dueAmountValue);

		if (dueAmountValue == null || dueAmountValue.trim().isEmpty()) {
			throw new AssertionError("Due amount field value is empty or null.");
		}

		double actualDue;
		try {
			actualDue = Double.parseDouble(dueAmountValue);
		} catch (NumberFormatException e) {
			throw new AssertionError("Due amount value is not a valid number.");
		}

		System.out.println("Total Amount: " + totalAmount);
		System.out.println("Prepaid Amount: " + prepaidAmount);

		double expectedDue = totalAmount - prepaidAmount;
		if (Math.round(actualDue * 100) != Math.round(expectedDue * 100)) {
			throw new AssertionError("Due amount mismatch. Expected: " + expectedDue + ", but was: " + actualDue);
		}

		System.out.println("Due amount is correct: " + actualDue);

		js.executeScript("arguments[0].scrollIntoView(true);", dueField);
		js.executeScript("arguments[0].click();", dueField);
	}

	public void clicksearchBtn() {
		WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
		searchButton.click();
	}

	public void enterConfirmationNumber(String ConfirmationNum) {
		WebElement confirmationField = wait.until(ExpectedConditions.visibilityOf(enterConfirmationNumber));
		confirmationField.sendKeys(ConfirmationNum);
	}

	public void clickAddVehicle() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("overlay")));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".modal-backdrop")));
		} catch (TimeoutException e) {
			System.out.println("Overlay or modal backdrop may still be present: " + e.getMessage());
		}

		try {
			wait.until(ExpectedConditions.elementToBeClickable(clickAddVehicle)).click();
		} catch (ElementClickInterceptedException e) {
			js.executeScript("arguments[0].click();", clickAddVehicle);
		}
	}

	public void carColordropdown() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement colorDropdown = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//ng-select[@bindlabel='color']//div[@class='ng-select-container ng-has-value']")));
		js.executeScript("arguments[0].click();", colorDropdown);
	}

	public void selectCarcolor(String color) {
		selectCarcolor.sendKeys(color, Keys.ENTER);
	}

	private static final By CAR_MODEL_DROPDOWN_OPTIONS = By.xpath("//span[@class='ng-option-label ng-star-inserted']");
	private static final By CAR_MODEL_DROPDOWN = By
			.xpath("//div[@class='col-3 form-group']/ng-select[@formcontrolname='model']//input[@type='text']");

	public void selectCarModel(String carModel) {
		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(35));

			try {
				wait.until(
						ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".overlay.ng-star-inserted")));
			} catch (TimeoutException e) {
				System.out.println(".overlay.ng-star-inserted did not disappear within specified seconds.");
			}

			// Wait for the model dropdown to be clickable and then click it
			WebElement modelDropdown = wait.until(ExpectedConditions.elementToBeClickable(CAR_MODEL_DROPDOWN));
			modelDropdown.click();

			// Wait for the options to be visible
			List<WebElement> options = wait
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(CAR_MODEL_DROPDOWN_OPTIONS));
		
			for (WebElement option : options) {
				if (option.getText().equalsIgnoreCase(carModel)) {
					option.click();
					break;
				}
			}

		} catch (TimeoutException e) {
			System.out.println("The overlay did not disappear in time or the element was not clickable.");
		} catch (Exception e) {
			System.out.println("An error occurred while selecting the car model: " + e.getMessage());
		}
	}

	private final By CAR_MAKE_INPUT = By
			.xpath("//div[@class='col-3 form-group']/ng-select[@formcontrolname='make']//input[@type='text']");
	private final By CAR_MAKE_DROPDOWN_OPTIONS = By.xpath("//span[@class='ng-option-label ng-star-inserted']");

	public void selectCarMake1(String carMake) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(35));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".modal-backdrop.fade.show")));
		} catch (TimeoutException e) {
			System.out.println("Modal backdrop did not disappear within 15 seconds. Proceeding with caution.");
		}

		WebElement makeInput = wait.until(ExpectedConditions.elementToBeClickable(CAR_MAKE_INPUT));

		try {
			makeInput.click();
		} catch (ElementClickInterceptedException e) {
			js.executeScript("arguments[0].click();", makeInput);
		}

		// 2. Wait for dropdown options and select the matching one
		List<WebElement> options = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(CAR_MAKE_DROPDOWN_OPTIONS));

		for (WebElement option : options) {
			if (option.getText().trim().equalsIgnoreCase(carMake)) {
				option.click();
				break;
			}
		}
	}

	public void selectCarMake(String carMake) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(35));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".modal-backdrop.fade.show")));
		} catch (TimeoutException e) {
			System.out.println("Modal backdrop did not disappear within specified seconds.");
		}

		WebElement makeInput = wait.until(ExpectedConditions.elementToBeClickable(CAR_MAKE_INPUT));

		try {
			makeInput.click();
		} catch (ElementClickInterceptedException e) {
			js.executeScript("arguments[0].click();", makeInput);
		}

		List<WebElement> options = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(CAR_MAKE_DROPDOWN_OPTIONS));

		for (WebElement option : options) {
			if (option.getText().trim().equalsIgnoreCase(carMake)) {
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

	public void clickOverSizeVehicleCheckbox() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.overlay")));
		longwait.until(ExpectedConditions.elementToBeClickable(overSizeVehicleCheckBox));
		overSizeVehicleCheckBox.click();
	}

	public void clickOverSizeVehicleSize(String vehichleSize) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.overlay.ng-star-inserted")));
		longwait.until(ExpectedConditions.elementToBeClickable(overSizeVehicleDropdown));
		overSizeVehicleDropdown.click();
		WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[@role='option']//span[contains(text(),'" + vehichleSize + "')]")));
		option.click();
	}

	public void clickCreateReservation() {
		longwait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".overlay.ng-star-inserted")));

		// Scroll the button into view if needed
		WebElement createReservationBtn = driver.findElement(By.xpath("//button[text()='Create Reservation']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", createReservationBtn);
		wait.until(ExpectedConditions.elementToBeClickable(createReservationBtn)).click();
	}

	public void clickReservationSuccessBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[contains(@class, 'modal-content')]//button[normalize-space()='Ok']"))).click();
		WebElement confirmationInput = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@formcontrolname='confirmationNo']")));
		wait.until(driver -> !confirmationInput.getDomProperty("value").isEmpty());
		String confirmationNumber = confirmationInput.getDomProperty("value");
		System.out.println("Confirmation Number: " + confirmationNumber);
	}

	public boolean isReservationSuccessBtnDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='modal-content']/div[@class='p-3 m-auto']/div/button[text()='Ok']")));
		return element.isDisplayed();
	}

	public void clickThirdPartySource() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOf(selectThirdPartySource));
		selectThirdPartySource.click();
	}

	public void clickcreateManually() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOf(createManually));
		createManually.click();
	}

	public void clickActionButtonBtnDisplayed(String buttonText) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
				.equals("complete"));
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

		} catch (TimeoutException e) {
			System.out.println("Button not found: " + buttonText);
		}
	}

	public boolean isReceivePaymentMethodDispalyed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
				.equals("complete"));
		try {
			// Ensure the element is present
			WebElement receivePaymentButton = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//button[contains(text(),'Receive Payment')]")));

			// Scroll into view
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", receivePaymentButton);
		} catch (TimeoutException e) {
			System.out.println("Timeout: 'Receive Payment' button not found.");
		}
		return receivePaymentButton.isDisplayed();

	}

	public void selectPaymentMode() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("overlay")));
		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//span[contains(@class, 'p-dropdown-label') and text()='Select Payment Mode']")));
		dropdown.click();
	}

	public void customerDetails() {
		enterPhoneNumber();
		enterEmail();
		enterFirstName();
		enterLastName();
	}

	public void addVehicleDetails(String carColor, String carMake, String carModel, String license, String state)
			throws InterruptedException {
		// Add Vehicle Details
		clickAddVehicle();
		carColordropdown();
		selectCarcolor(carColor);
		selectCarMake(carMake);
		selectCarModel(carModel);
		selectLicenceno(license);
		selectState(state);
	}

	public void reservationDetails(String sourceName, String StartDate, String EndDate) throws InterruptedException {
		selectLocationdropdown("Madrid");
		selectSource(sourceName);
		enterstartDate(StartDate);
		enterstartTime();
		enterEndDate(EndDate);
		enterEndTime();
	}

	// Test Koda And WalkIn Method

	public boolean AddReservation(String sourceName, String StartDate, String EndDate, String prepaidPartial,
			String carColor, String carMake, String carModel, String license, String state)
			throws InterruptedException {
		customerDetails(); // Enter the Customer Details
		reservationDetails(sourceName, StartDate, EndDate); // Enter the Reservation Details
		if (sourceName.equalsIgnoreCase("koda")) {
			selectReservationPrepaid(prepaidPartial);
		}
		addVehicleDetails(carColor, carMake, carModel, license, state); // Enter the Add Vehicle Details
		clickCreateReservation();
		boolean isOkBtnDispalyed = isReservationSuccessBtnDisplayed();
		clickReservationSuccessBtn();
		return isOkBtnDispalyed;
	}

	// Third Party Reservation Details

	public boolean AddReservation(String sourceName, String confirmationNumber, String StartDate, String EndDate,
			String PrepaidPartial, String carColor, String carMake, String carModel, String license, String state,
			String vehicleSize) throws InterruptedException {
		enterconfirmationNumber(confirmationNumber);
		clickcreateManually();
		customerDetails(); // Enter the Customer Details
		reservationDetails(sourceName, StartDate, EndDate); // Enter the Reservation Details
		selectReservationPrepaid(PrepaidPartial);
		enterTotalAmount(30);
		enterPrepaidAmount(15);
		validateDueAmount();
		addVehicleDetails(carColor, carMake, carModel, license, state); // Enter the Add Vehicle Details
		if (sourceName.equalsIgnoreCase("CheapAirportParking")) {
			clickOverSizeVehicleCheckbox();
			clickOverSizeVehicleSize(vehicleSize);
		}
		clickCreateReservation();
		boolean isOkBtnDispalyed = isReservationSuccessBtnDisplayed();
		System.out.println("Condition being tested: " + isOkBtnDispalyed);
		clickReservationSuccessBtn();
		return isOkBtnDispalyed;
	}

	public void waitForOverlayToDisappear() {
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".overlay.ng-star-inserted")));
		} catch (TimeoutException e) {
			System.out.println("Overlay did not disappear within timeout.");
		}
	}

	public void clickOkButton() {
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
		longwait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[contains(@class, 'modal-content')]//button[normalize-space()='Ok']"))).click();
	}

	public boolean okBtnisDisplayedupdate() {
		WebElement okButton = longwait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[contains(@class, 'modal-content')]//button[normalize-space()='Ok']")));
		return okButton.isDisplayed();
	}

	public void clickButtonByText(String buttonText) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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

	public void safeClick(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// 1. Wait for overlays to disappear
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(
					By.cssSelector(".overlay, .modal-backdrop, .block-ui-overlay, .loading-spinner")));
		} catch (TimeoutException e) {
			System.out.println("Overlay still visible after timeout.");
		}

		// 2. Scroll element into view and block:Center -> It helps ensure elements are
		// not obscured by sticky headers, footers, or overlays.
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

		// 3. Wait for clickability and try normal click
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Click intercepted. Retrying with JS click.");
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		}
	}

	public void selectPaymentCard() {
		safeClick(selectPaymentMode);
		cardOption.click();
	}
	
	public void selectPaymentCash() {
		safeClick(selectPaymentMode);
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
		selectCardPayment();
		enterCardReferenceNumber(cardInformation);
		payNowBtn.click();
		return new PaymentPage(driver, currentWindowHandle);
	}

	public void clickCollectPaymentButton() {
		collectPayment.click();
	}

	public AddReservationPage goToReceivePaymentCash() {
		clickReceivePayment();
		selectCashPayment();
		clickCollectPaymentButton();
		return new AddReservationPage(driver);
	}

	public static boolean checkinstatus() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement status = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Edit Location']")));
		Assert.assertTrue(status.isDisplayed());
		return status.isDisplayed();
	}

	public boolean checkoutstatus() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement status1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='CheckedOut']")));
		return status1.isDisplayed();
	}

	public PaymentPage Checkin_CardPayment(String cardInformation) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebElement checkin = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Check In / Key In']")));
		checkin.click();

		WebElement parkingslotwindow = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@id='assignParkingSlot']//div[contains(text(),'Reservation No: ')]")));
		parkingslotwindow.click();
		//Thread.sleep(2500);
		ReceivePayment.click();
		//Thread.sleep(2500);
		selectCardPayment();
		String currentWindowHandle = driver.getWindowHandle();
		payNowBtn.click();
		return new PaymentPage(driver, currentWindowHandle);
	}

	public PaymentPage Checkin_CashPayment(String cardInformation) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		Thread.sleep(6000);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebElement checkin = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Check In / Key In']")));
		checkin.click();
		WebElement parkingslotwindow = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@id='assignParkingSlot']//div[contains(text(),'Reservation No: ')]")));
		parkingslotwindow.click();
		ReceivePayment.click();
		selectCashPayment();
		clickCollectPaymentButton();
		Thread.sleep(6000);
		isoKPaymentReceviedButtonDisplayed();
		return new PaymentPage(driver);
	}

	public void checkout() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,650)");
		wait.until(ExpectedConditions.elementToBeClickable(Checkout)).click();
		wait.until(ExpectedConditions.elementToBeClickable(Checkout_click)).click();
		wait.until(ExpectedConditions.elementToBeClickable(ConfirmPayment)).click();
		wait.until(ExpectedConditions.elementToBeClickable(yes)).click();
		wait.until(ExpectedConditions.elementToBeClickable(checkout_ok)).click();
		System.out.println("Check out completed");
		checkinstatus();
	}

	public void okBtnCheckIn() {
		WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Ok']")));
		okButton.click();
	}

	public void checkInKeyIn(String checkInButton) {
		clickActionButtonBtnDisplayed(checkInButton);
		clickcheckInKeyInBtn();
		okBtnCheckIn();
		clickUpdateLocation();

	}

	public void clickcheckInKeyInBtn() {
		WebElement okButton = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Check-In/ Key-In')]")));
		okButton.click();
	}

	public void clickUpdateLocation() {
		WebElement updateButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@id='gridContainer']//button[text()='Update Location']")));
		updateButton.click();
	}

	public void selectCardPayment() {
		safeClick(selectPaymentMode);
		card.click();
	}
	public void selectCashPayment() {
		safeClick(selectPaymentMode);
		cash.click();
	}
}
