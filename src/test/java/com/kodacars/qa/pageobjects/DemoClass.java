package com.kodacars.qa.pageobjects;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoClass {

	
//	public void selectPaymentMode(String paymentMode) throws InterruptedException {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//
//		// Ensure the modal is visible
//		WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("receivePayment")));
//
//		// Ensure the overlay disappears before interaction
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("overlay")));
//
//		// Click the dropdown to open the payment mode options
//		WebElement dropdown = modal.findElement(By.className("p-dropdown-trigger"));
//		wait.until(ExpectedConditions.elementToBeClickable(dropdown));
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdown);
//		Thread.sleep(1000);
//		WebElement dropdownList = wait
//				.until(ExpectedConditions.presenceOfElementLocated(By.className("p-dropdown-items")));
//		List<WebElement> paymentOptions = dropdownList
//				.findElements(By.xpath("//li[@role='option' and contains(@class, 'p-dropdown-item')]"));
//
//		boolean found = false;
//		for (WebElement option : paymentOptions) {
//			if (option.getText().trim().equalsIgnoreCase(paymentMode)) {
//				wait.until(ExpectedConditions.elementToBeClickable(option));
//				option.click();
//				found = true;
//				break;
//			}
//		}
//
//		if (!found) {
//			throw new NoSuchElementException("Payment mode '" + paymentMode + "' not found in the dropdown.");
//		}
//	}
	
	//****************************************************
	
//	public void enterCardReferenceNumber(String cardRefNumber) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement cardRefInput = wait
//				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@formcontrolname='CRN']")));
//		cardRefInput.clear();
//		cardRefInput.sendKeys(cardRefNumber);
//	}
	
	//****************************************************
//	public void clickPayNowButton() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//		// Wait until *any* Pay Now button is present
//		wait.until(
//				ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[contains(text(), 'Pay Now')]")));
//
//		List<WebElement> payNowButtons = driver.findElements(By.xpath("//button[contains(text(), 'Pay Now')]"));
//
//		for (WebElement button : payNowButtons) {
//			try {
//				if (button.isDisplayed() && button.isEnabled()) {
//					// Try standard click
//					try {
//						button.click();
//					} catch (Exception e) {
//						// Fallback to JS click if normal click fails
//						((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
//					}
//					System.out.println("Clicked Pay Now button.");
//					return;
//				}
//			} catch (StaleElementReferenceException e) {
//				// Retry with next button if stale
//				continue;
//			}
//		}
//
//		throw new RuntimeException("No visible and enabled 'Pay Now' button found.");
//	}
	
	//****************************************************
	
//	public void enterEmail1() {
//
//		// Check if iframe exists
//		List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
//		System.out.println("Iframe count: " + iframes.size());
//
//		if (iframes.size() > 0) {
//			driver.switchTo().frame(0); // or switch using name/id if known
//		}
//
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement enterEmail = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email']")));
//		enterEmail.sendKeys("abc123@gmail.com");
//	}

	//****************************************************
	
//	public void clickcollectPayment() {
//		utilsObj.visibilityOfExtraWaitTime(collectPayment);
//		collectPayment.click();
//	}
	
//	public void clickPayNowButton() {
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
////	WebElement modalFooter = wait.until(
////			ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.modal-footer.ng-star-inserted")));
//	 List<WebElement> payNowButtons = driver.findElements(
//		        By.xpath("//button[contains(text(), 'Pay Now')]"));
//	WebElement payNowButton = wait
//			.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Pay Now')]")));
//	payNowButton.click();
//}
	//**************Pay Now 
	
//	public void clickCardButton() {
//
//		// First switch to parent iframe
//		driver.switchTo().frame("parentIframeId"); // or use WebElement or other locators
//		// Then switch to the target iframe
//		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='Secure card payment input frame']")));
//
////		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
////		WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("iframe[title='Secure card payment input frame']")));
////		driver.switchTo().frame(iframe);
//
//		// Now wait for the button
//		WebElement cardButton = wait
//				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[aria-label='Pay with card']")));
//		cardButton.click();
//
//	}
//
//	public void clickCardButton1() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//
//		// Optional: Wait for loader to disappear
//		try {
//			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loading-overlay")));
//		} catch (TimeoutException e) {
//			System.out.println("Loader not found or already gone.");
//		}
//
//		// Optional debug
//		List<WebElement> btns = driver.findElements(By.cssSelector("button[aria-label='Pay with card']"));
//		System.out.println("Card button count: " + btns.size());
//
//		WebElement cardButton = wait
//				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[aria-label='Pay with card']")));
//
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cardButton);
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", cardButton);
//	}

//	@FindBy(xpath = "//div[@class='swal2-actions']//button[contains(@class, 'swal2-confirm')]")
//	@CacheLookup
//	private WebElement paymentReceivedSuccessfully;
//	
//	public void clickpaymentReceivedSuccessfully() {
//		utilsObj.visibilityOfExtraWaitTime(paymentReceivedSuccessfully);
//		paymentReceivedSuccessfully.click();
//	}
//
//	public boolean ispaymentReceivedSuccessfullyBtnDisplayed(String paymentMethod, String cardReferenceNo)
//			throws InterruptedException {
//	//	clickReceivePayment();
//		//selectPaymentMode(paymentMethod);
//		if (paymentMethod.equalsIgnoreCase("Card")) {
//			//enterCardReferenceNumber(cardReferenceNo);
//			//clickPayNowButton();
//			Thread.sleep(7000);
//
////			enterEmail1();
////			clickCardButton();
//		}
//		 else {
//			paymentMethod.equalsIgnoreCase("Cash");
//			System.out.println("Cash");
//		}
//		
//		//clickcollectPayment();
//
//		boolean isOkBtnDispalyed = paymentReceivedSuccessfully.isDisplayed();
//		clickpaymentReceivedSuccessfully();
//		return isOkBtnDispalyed;
//	}
//	public void clickReceivePayment() {
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
//
//	// Ensure the page has fully loaded
//	wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
//			.equals("complete"));
//
//	try {
//		WebElement receivePaymentButton = wait.until(ExpectedConditions
//				.presenceOfElementLocated(By.xpath("//button[contains(text(),'Receive Payment')]")));
//
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", receivePaymentButton);
//		wait.until(ExpectedConditions.elementToBeClickable(receivePaymentButton));
//		try {
//			receivePaymentButton.click();
//		} catch (ElementClickInterceptedException e) {
//			((JavascriptExecutor) driver).executeScript("arguments[0].click();", receivePaymentButton);
//		}
//
//	} catch (TimeoutException e) {
//		System.out.println("Timeout: 'Receive Payment' button not found.");
//	}
//}
	
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$4
	// the third party confirmation Number Cash/Card Payment Method
//		@Test(priority = 3, dataProvider = "receivePayment", dataProviderClass = com.kodacars.qa.dataprovider.ExcelDataProvider.class)
//		
//		public void receiveCashOrCardPayment(Map<String, String> rowData) throws InterruptedException {
//			
//			
//			AddReservationPage reservationObj =dashboardpage.clickLinkByConfirmationNumber(rowData.get("confirmation Number"));
//			Assert.assertTrue(reservationObj.ispaymentReceivedSuccessfullyBtnDisplayed(rowData.get("PaymentMode"),
//														        	 rowData.get("Card Reference No")));
//			
//		}
	
	// Reservation Link
//	@FindBy(xpath = "//div[@class='text-center mt-4']//button[text()='Receive Payment']")
//	@CacheLookup
//	private WebElement clickReceivePayment;
//
//	@FindBy(xpath = "//span[contains(@class, 'p-dropdown-label') and text()='Select Payment Mode']")
//	@CacheLookup
//	private WebElement selectPaymentMode;
//
//	@FindBy(xpath = "//li[@role='option']//span[text()='Cash']")
//	@CacheLookup
//	private WebElement selectCash;
//
//	@FindBy(xpath = "//button[@id='closeModal' and text()='Collect Payment']")
//	@CacheLookup
//	private WebElement collectPayment;
	
	//******************************************888
//	public String getTextConfirmationNumber(String expectedConfirmationNumber) {
//	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//
//	// Wait until the input field is visible
//	WebElement confirmationInput = wait.until(
//			ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@formcontrolname='confirmationNo']")));
//
//	WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(60));
//	WebElement confirmationElement = waits
//			.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmationNumber")));
//
//	new WebDriverWait(driver, Duration.ofSeconds(30)).until(webDriver -> ((JavascriptExecutor) webDriver)
//			.executeScript("return document.readyState").equals("complete"));
//
//	// Get the confirmation number from the input field
//	String actualConfirmationNumber = confirmationInput.getDomAttribute("value");
//	return actualConfirmationNumber;
//}
	
//	public void selectLocationDropdownOption(String locationName) {
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//
//	    // Step 1: Gracefully handle modal-backdrop if present
//	    try {
//	        List<WebElement> overlays = driver.findElements(By.className("modal-backdrop"));
//	        if (!overlays.isEmpty()) {
//	            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("modal-backdrop")));
//	            System.out.println("Modal overlay disappeared.");
//	        }
//	    } catch (TimeoutException e) {
//	        System.out.println("Modal overlay did not disappear in time. Proceeding with caution.");
//	    }
//
//	    // Step 2: Locate and click the dropdown input
//	    By locationInputLocator = By.xpath("//ng-select[@formcontrolname='location' and @bindlabel='name']//input");
//	    WebElement locationInput = wait.until(ExpectedConditions.elementToBeClickable(locationInputLocator));
//
//	    scrollIntoView(locationInput);
//	    clickElement(locationInput);
//
//	    // Step 3: Select desired location option
//	    By locationOptionLocator = By.xpath("//ng-select[@formcontrolname='location']//span[contains(text(),'" + locationName + "')]");
//	    WebElement locationOption = wait.until(ExpectedConditions.visibilityOfElementLocated(locationOptionLocator));
//
//	    scrollIntoView(locationOption);
//	    clickElement(locationOption);
//
//	    System.out.println("Selected location: " + locationName);
//
//	    
//	}
//	// === Helper methods inside main method ===
//    public void scrollIntoView(WebElement element) {
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
//        System.out.println("Scrolled into view: " + element);
//    }
//
//    public void clickElement(WebElement element) {
//        try {
//            element.click();
//            System.out.println("Clicked element: " + element);
//        } catch (ElementClickInterceptedException e) {
//            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
//            System.out.println("Fallback JS click used for element: " + element);
//        }
//    }
}
