package com.selenium.bankGuru99.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.selenium.bankGuru99.pages.*;


public class BaseTest {
	  public WebDriver driver;
	    public HomePage homePage;
	 
	    public WebDriver getDriver() {
	        return driver;
	    }
	 
	    @BeforeClass
	    public void classLevelSetup() {
	        driver = new ChromeDriver();
	    }
	 
	    @BeforeMethod
	    public void methodLevelSetup() {
	        homePage = new HomePage(driver);
	    }
	 
	    @AfterClass
	    public void teardown() {
	        driver.quit();
	    }

		public void onFinish(ITestContext iTestContext) {
			// TODO Auto-generated method stub
			
		}

		public void onStart(ITestContext iTestContext) {
			// TODO Auto-generated method stub
			
		}

		public void onTestStart(ITestResult iTestResult) {
			// TODO Auto-generated method stub
			
		}

		public void onTestFailure(ITestResult iTestResult) {
			// TODO Auto-generated method stub
			
		}

		public void onTestSuccess(ITestResult iTestResult) {
			// TODO Auto-generated method stub
			
		}

		public void onTestSkipped(ITestResult iTestResult) {
			// TODO Auto-generated method stub
			
		}

		public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
			// TODO Auto-generated method stub
			
		}
}
