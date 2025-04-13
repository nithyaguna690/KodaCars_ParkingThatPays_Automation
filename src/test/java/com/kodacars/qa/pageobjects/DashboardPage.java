package com.kodacars.qa.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.kodacars.qa.uilities.CommonUtils;

public class DashboardPage {

	WebDriver driver;
	WebDriverWait wait;
	WebDriverWait longwait;
	CommonUtils utilsObj = CommonUtils.getInstance(driver);

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
		utilsObj.visibilityOfMoreWaitTime(clickNoConfirmation);
		clickNoConfirmation.click();
		return new AddReservationPage(driver);

	}

	public AddReservationPage clickYesConfirmation() {
		utilsObj.visibilityOfMoreWaitTime(clickYesConfirmation);
		clickYesConfirmation.click();
		return new AddReservationPage(driver);
	}

	public void clickAddReservation() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Ensure modal or overlay disappears before clicking
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("modal-backdrop")));

		// Scroll to the button (if needed)
		WebElement addReservationButton = driver.findElement(By.xpath("//button[text()=' Add Reservation ']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addReservationButton);

		// Wait until clickable
		wait.until(ExpectedConditions.elementToBeClickable(addReservationButton));

		// Click using JavaScript if normal click fails
		try {
			addReservationButton.click();
		} catch (ElementClickInterceptedException e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", addReservationButton);
		}
	}

	public AddReservationPage clickLinkByConfirmationNumber(String confirmationNumber) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement confirmCell = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//span[contains(@class,'ag-cell-value') and text()='" + confirmationNumber + "']")));
		confirmCell.click();
		return new AddReservationPage(driver);
	}

}