package com.bankguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.commons.AbstractTest;


public class BankGuru_Register extends AbstractTest {
	
	private WebDriver driver;

	@Parameters({"browser"})
	@BeforeTest
	public void beforeClass(@Optional("chrome") String browserName) {
		driver = getBrowserDriver(browserName);
		
	}
	
	@Test
	public void TC_01_Register_New_User() {
		
	}

	@AfterTest(alwaysRun = true)
	public void afterClass() throws Exception {
		closeBrowserAndDriver(driver);
	}

}
