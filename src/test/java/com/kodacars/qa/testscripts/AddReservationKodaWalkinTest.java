package com.kodacars.qa.testscripts;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kodacars.qa.pageobjects.AddReservationPage;
import com.kodacars.qa.pageobjects.DashboardPage;
import com.kodacars.qa.pageobjects.LoginPage;
import com.kodacars.qa.testbase.BaseClass;
import com.kodacars.qa.uilities.ConfigFileReader;
import com.kodacars.qa.uilities.LoggerLoad;

public class AddReservationKodaWalkinTest extends BaseClass {
	DashboardPage dashboardpage;

	@BeforeMethod
	public void login() {
		LoginPage loginPage = new LoginPage(driver);
		dashboardpage = loginPage.login(ConfigFileReader.getUsername(), ConfigFileReader.getPassword());
		LoggerLoad.info("The user is on the " + driver.getTitle() + " home page and successfully logged in.");
	}
//enabled=false,
	@Test(priority = 0, description = " Walk-in Customer and Koda Customer ",
		  dataProvider = "KodaWalkIn", dataProviderClass = com.kodacars.qa.dataprovider.ExcelDataProvider.class)

	public void AddReservationForWalkInKoda(Map<String, String> rowData) throws InterruptedException {

		dashboardpage.clickAddReservation();
		AddReservationPage reservationObj = dashboardpage.clickNoConfirmation();
		Assert.assertTrue(reservationObj.AddReservation(rowData.get("Select Source"),
	                                                	rowData.get("Start Date"),
		                                                        rowData.get("End Date"),
																rowData.get("Reservation Prepaid"),
																rowData.get("Car Color"),
																rowData.get("Make"),
																rowData.get("Model"),
																rowData.get("License Plate"),
																rowData.get("State")));
	}

	@Test(priority = 1, description = " Customer booked by Third Party Provider ",
		  dataProvider = "ThirdpartyManuallyCreateConfirmationNumber", dataProviderClass = com.kodacars.qa.dataprovider.ExcelDataProvider.class)

	public void AddReservationForThirdPartyCreateManually(Map<String, String> rowData) throws InterruptedException {

		dashboardpage.clickAddReservation();
		AddReservationPage reservationObj = dashboardpage.clickYesConfirmation();
		Assert.assertTrue(reservationObj.AddReservation(rowData.get("Select Source"),
																rowData.get("confirmation Number"),
																rowData.get("Start Date"),
		                                                        rowData.get("End Date"),
																rowData.get("Prepaid Or Partial"),
																rowData.get("Car Color"),
																rowData.get("Make"),
																rowData.get("Model"),
																rowData.get("License Plate"),
																rowData.get("State"),
																rowData.get("Oversize Category")));
	}

	
	
	@Test(priority = 2, description = " Search the customer confirmation number booked by third party ", 
		  dataProvider = "SearchThirdpartyConfirmationNumber", dataProviderClass = com.kodacars.qa.dataprovider.ExcelDataProvider.class)
	
	public void AddReservationConfirmationNumberSearch(Map<String, String> rowData) throws InterruptedException {
		dashboardpage.clickAddReservation();
		AddReservationPage reservationObj = dashboardpage.clickYesConfirmation();
		reservationObj.enterconfirmationNumber( rowData.get("confirmation Number"));
		reservationObj.clicksearchBtn();
		Assert.assertTrue(reservationObj.isReceivePaymentMethodDispalyed());
	}
	
	 @Test(priority = 3, description = "Verify the application that user can pay the payment by cards", 
		   dataProviderClass = com.kodacars.qa.dataprovider.ExcelDataProvider.class, dataProvider = "receivePaymentByCard")

	 public void payPaymentByCard(Map<String, String> rowData) {

		AddReservationPage reservationObj = dashboardpage.clickLinkByConfirmationNumber(rowData.get("Confirmation Number"));
		Assert.assertTrue(reservationObj.goToReceivePaymentCard(rowData.get("Card Information"))
				                        .payPaymentByCard(rowData.get("Card Information"),
				                        	              rowData.get("Card Expiry"), 
				                        	              rowData.get("CVC"),
				                        	              rowData.get("Billing Name"), 
				                        	              rowData.get("Zip"), 
				                        	              rowData.get("Email Id"),
				                        	              rowData.get("Checkbox"),
				                        	              rowData.get("Phone Number"))				                        					
				                        				.isoKPaymentReceviedButtonDisplayed());
	}

	@Test(priority=4, description="Verify the application that user can pay the payment by cash",
			dataProviderClass = com.kodacars.qa.dataprovider.ExcelDataProvider.class, dataProvider = "receivePaymentByCash")
	
	public void payPaymentByCash(Map<String, String> rowData) {
		AddReservationPage reservationObj = dashboardpage.clickLinkByConfirmationNumber(rowData.get("Confirmation Number"));
		Assert.assertTrue(reservationObj.goToReceivePaymentCash().isoKPaymentReceviedButtonDisplayed());
	}
	 
	@Test(priority = 5,  description=" Update Reservation ", 
		  dataProvider = "updateReservation", dataProviderClass = com.kodacars.qa.dataprovider.ExcelDataProvider.class)
	
	public void updateReservation(Map<String, String> rowData) throws InterruptedException {
		AddReservationPage reservationObj =dashboardpage.clickLinkByConfirmationNumber(rowData.get("confirmation Number"));
		reservationObj.updateReservationokBtnIsDisplayed(rowData.get("Click Button"));
				
	}

     // checkin with payment.
	@Test(priority = 7,description="Verify Checkin with full payment",
			dataProviderClass= com.kodacars.qa.dataprovider.ExcelDataProvider.class, dataProvider ="checkinByCard" )
   
	public void Check_In(Map<String, String> rowData) throws InterruptedException {
         dashboardpage.clickAddReservation();
         AddReservationPage reservationObj = dashboardpage.clickYesConfirmation();
 		                    reservationObj.enterconfirmationNumber( rowData.get("Confirmation Number"));
 		                    reservationObj.clicksearchBtn();
 		                    reservationObj.Checkin_CardPayment(rowData.get("Card Information"))
 		                                   .CheckinCardPayment(rowData.get("Card Information"),
 		            		                                   rowData.get("Card Expiry"),
 		            		                                   rowData.get("CVC"),
 		                                                       rowData.get("Billing Name"), 
 		                                                       rowData.get("Zip"),
 		                                                       rowData.get("Email Id"),
 		                                                       rowData.get("Checkbox"),
 						                        	           rowData.get("Phone Number"));
 	}
	
	@Test(priority = 8, description="Verify Check out test",
			dataProviderClass= com.kodacars.qa.dataprovider.ExcelDataProvider.class, dataProvider ="checkinByCard" )
    
	public void Check_Out(Map<String, String> rowData) throws InterruptedException {
         
		dashboardpage.clickAddReservation();
		AddReservationPage reservationObj = dashboardpage.clickYesConfirmation();
		                   reservationObj.enterconfirmationNumber(rowData.get("Confirmation Number"));
		                   reservationObj.clicksearchBtn();
		                   reservationObj.checkout();
		
	}
	
	@Test(priority=9, description="Verify the application that user can checkin and make payment by cash",
			dataProviderClass = com.kodacars.qa.dataprovider.ExcelDataProvider.class, dataProvider = "checkinByCash")
	
	public void CheckinByCash(Map<String, String> rowData) throws InterruptedException {
		 dashboardpage.clickAddReservation();
         AddReservationPage reservationObj = dashboardpage.clickYesConfirmation();
 		                    reservationObj.enterconfirmationNumber(rowData.get("Confirmation Number"));
 		                    reservationObj.clicksearchBtn();
 				            reservationObj.Checkin_CashPayment(rowData.get("Card Information")).CheckinCashPayment();
 
	}

	
	
}