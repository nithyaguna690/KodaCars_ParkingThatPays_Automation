package com.kodacars.qa.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	WebDriverWait wait;
	WebDriverWait longwait;
	public LoginPage(WebDriver driver) {
		if (driver == null) {
			throw new IllegalArgumentException("Driver instance cannot be null");
		}
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.longwait = new WebDriverWait(driver, Duration.ofSeconds(30));
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@formcontrolname='userName']")
	@CacheLookup
	private WebElement username;

	@FindBy(xpath = "//input [@formcontrolname='password']")
	@CacheLookup
	private WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	@CacheLookup
	private WebElement signin;

	public String getActualTitle() {
		return driver.getTitle();
	}
	
	public DashboardPage login(String userName,String passWord) {
		username.sendKeys(userName);
		password.sendKeys(passWord);
		signin.click();
		return new DashboardPage(driver);
	}

	

}
