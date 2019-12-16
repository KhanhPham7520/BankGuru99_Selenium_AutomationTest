package com.selenium.bankGuru99;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class LoadTest {
	private WebDriver driver;
	private static final String CHROME_DRIVER_URL_LOCAL = "C:\\Users\\KhanhPPN-Web\\Desktop\\chromedriver.exe";
	private static final String URL_SEARCH_TEXT = "http://demo.guru99.com/V4/";

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_URL_LOCAL);
		driver = new ChromeDriver();
	}

	@Test
	public void verifySearchButton() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL_SEARCH_TEXT);
		String search_text = "Guru99 Bank Home Page";
		driver.findElement(By.linkText("Demo Site"));
		// String text = search_button.getAttribute("value");
		Assert.assertEquals(driver.getTitle(), search_text);
	}

	@AfterClass
	public void afterClass() {
		// driver.quit();

	}

}
