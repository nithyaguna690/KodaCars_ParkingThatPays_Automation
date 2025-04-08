package com.kodacars.qa.pageobjects;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	
	
	
	public AddReservationPage payPaymentByCard(String cardInformation,String cardExpiry ,String cvcNo, String cardName, String zip, String email) {
		

		
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
		return new AddReservationPage(driver);
		
		
		
	}
}
