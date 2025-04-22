package com.kodacars.qa.pageobjects;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

	WebDriver driver;
	WebDriverWait wait;
	WebDriverWait longwait;

	public DashboardPage(WebDriver driver) {

		if (driver == null) {
			throw new IllegalArgumentException("Driver instance cannot be null");
		}
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.longwait = new WebDriverWait(driver, Duration.ofSeconds(30));
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()=' Add Reservation ']")
	@CacheLookup
	private WebElement addReservation;

	@FindBy(xpath = "//button[text()='No']")
	@CacheLookup
	private WebElement clickNoConfirmation;

	@FindBy(xpath = "//button[text()='Yes']")
	@CacheLookup
	private WebElement clickYesConfirmation;

	public boolean isAddReservationBtnDisplayed() {
		return addReservation.isDisplayed();
	}

	public AddReservationPage clickNoConfirmation() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".overlay.ng-star-inserted")));
		WebElement noButton = longwait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='No']")));
		noButton.click();
		return new AddReservationPage(driver);
	}

	public AddReservationPage clickYesConfirmation() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".overlay.ng-star-inserted")));
		WebElement yesButton = longwait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Yes']")));
		yesButton.click();
		return new AddReservationPage(driver);
	}

	public void clickAddReservation() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		// Ensure modal or overlay disappears before clicking
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("modal-backdrop")));

		WebElement addReservationButton = driver.findElement(By.xpath("//button[text()=' Add Reservation ']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addReservationButton);

		wait.until(ExpectedConditions.elementToBeClickable(addReservationButton));

		// Click using JavaScript if normal click fails
		try {
			addReservationButton.click();
		} catch (ElementClickInterceptedException e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", addReservationButton);
		}
	}

	public AddReservationPage clickLinkByConfirmationNumber(String confirmationNumber) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		By nextPageBtn = By.cssSelector("div[ref='btNext']");
		By confirmationCellXpath = By
				.xpath("//span[contains(@class,'ag-cell-value') and text()='" + confirmationNumber + "']");

		int maxPages = Integer
				.parseInt(wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[ref='lbTotal']")))
						.getText().trim());

		for (int i = 1; i <= maxPages; i++) {
			System.out.println("Searching for confirmation number on page " + i + " of " + maxPages);

			List<WebElement> matchingCells = driver.findElements(confirmationCellXpath);
			if (!matchingCells.isEmpty()) {
				matchingCells.get(0).click();
				return new AddReservationPage(driver);
			}

			if (i < maxPages) {
				safeClick(nextPageBtn);
				waitForAGGridToLoad(); // Wait for AG Grid to refresh
			}
		}

		throw new NoSuchElementException("Confirmation number '" + confirmationNumber + "' not found on any page.");
	}

	public void safeClick(By locator) {
		waitForOverlaysToDisappear();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		try {
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		} catch (ElementClickInterceptedException e) {
			System.out.println("Click intercepted. Retrying with JS click on locator: " + locator);
			WebElement element = driver.findElement(locator);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		}
	}

	public void waitForOverlaysToDisappear() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		try {
			wait.until(driver -> {
				List<WebElement> overlays = driver.findElements(By.cssSelector(
						".overlay, .modal-backdrop, .block-ui-overlay, .loading, .spinner, .progress, .ag-overlay-loading-center"));
				for (WebElement overlay : overlays) {
					if (overlay.isDisplayed()) {
						System.out.println("Overlays or spinners may still be visible even after 30 secs.");
						return false; // Still visible
					}
				}
				return true; // All overlays gone
			});
		} catch (TimeoutException e) {
			System.out.println("Overlays or spinners may still be visible after timeout.");
		}
	}

	public void waitForAGGridToLoad() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			// Check for the invisibility of the AG Grid loading spinner
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ag-overlay-loading-center")));
		} catch (TimeoutException e) {
			System.out.println("AG Grid did not finish loading within timeout.");
		}
	}
}