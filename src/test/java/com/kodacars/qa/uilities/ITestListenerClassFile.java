package com.kodacars.qa.uilities;

import java.io.File;
import java.util.Objects;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.kodacars.qa.testbase.BaseClass;

import io.qameta.allure.Attachment;

public class ITestListenerClassFile extends BaseClass implements ITestListener {

	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	// for allure report
	@Attachment
	public byte[] saveFailureScreenshot(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	@Attachment(value = "{0}", type = "text/plain")
	public static String saveTextLog(String message) {
		return message;
	}

	@Override
	public void onTestStart(ITestResult result) {
		LoggerLoad.info(getTestMethodName(result) + " Test is starting.");
		Reporter.log(getTestMethodName(result) + " Test is starting.");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		LoggerLoad.info(getTestMethodName(result) + " Test is succeed.");
		Reporter.log(getTestMethodName(result) + " Test is succeed.");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		LoggerLoad.info(getTestMethodName(result) + " Test is failed.");
		Reporter.log("onTestFailure" + result.getName());
		// Get driver from BaseTest and assign to local webdriver variable.
		Object testClass = result.getInstance();
		WebDriver driver = ((BaseClass) testClass).driver;

		// add screenshot to target folder
//		System.out.println(" result.getName " + result.getName());
//		String screenshot = getScreenshot(result.getName(), driver);

		// allure screenshot
		if (driver instanceof WebDriver) {
			saveFailureScreenshot(driver);
		}
		saveTextLog(getTestMethodName(result) + "failed screenshot taken");

		//final byte[] screenshot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		ChainTestListener.log(result.getName() + " testcase failed "); // logs for failed test cases
	//	ChainTestListener.embed(screenshot, "image/png"); // to attach screenshot for failed test cases
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		LoggerLoad.info(getTestMethodName(result) + " Test is skipped.");
		Reporter.log(getTestMethodName(result) + " Test is skipped.");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		LoggerLoad.info("Test failed but it is in defined success ratio " + getTestMethodName(result));
		Reporter.log("Test failed but it is in defined success ratio " + getTestMethodName(result));
	}

	@Override
	public void onStart(ITestContext context) {
		LoggerLoad.info(" onStart method " + context.getName());
		// Reporter log is used to the see the logs in Emailable Report
		Reporter.log("onStart method " + context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		LoggerLoad.info("onFinish method " + context.getName());
		Reporter.log("onFinish method " + context.getName());
	}


	public String getScreenshot(String testName, WebDriver driver) {
	    if (driver == null) {
	        System.out.println("WebDriver is null. Cannot take a screenshot.");
	        return null;
	    }
	    TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	    File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
	    String screenshotPath = "target/Screenshots/" + testName + ".png";
	    try {
	        FileUtils.copyFile(screenshot, new File(screenshotPath));
	    } catch (Exception e) {
	        System.out.println("Failed to save screenshot");
	        e.printStackTrace();
	    }
	    return screenshotPath;
	}

}
