package com.kodacars.qa.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.kodacars.qa.pageobjects.DashboardPage;
import com.kodacars.qa.pageobjects.LoginPage;
import com.kodacars.qa.testbase.BaseClass;
import com.kodacars.qa.uilities.ConfigFileReader;
import com.kodacars.qa.uilities.LoggerLoad;

public class LoginTest extends BaseClass {
	
	//ConfigFileReader configFileReader = ConfigFileReader.getInstance();

	@Test()
	public void ValidLoginCredentials() {

		LoginPage loginPage = new LoginPage(driver);
		DashboardPage dashboardpage = loginPage.login(ConfigFileReader.getUsername(), ConfigFileReader.getPassword());
		Assert.assertTrue(dashboardpage.isAddReservationBtnDisplayed(), "AddReservation Button Is not dispplaed");
		LoggerLoad.info("The user is on the " + driver.getTitle() + " home page and successfully logged in.");
	}

}
