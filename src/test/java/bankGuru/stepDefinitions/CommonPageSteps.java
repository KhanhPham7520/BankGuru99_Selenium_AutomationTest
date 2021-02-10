package bankGuru.stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.PageGeneratorManager;
import cucumberOptions.Hooks;
import pageObjects.HomePageObject;

public class CommonPageSteps {
	
	WebDriver driver;
	HomePageObject homePage;

	public CommonPageSteps() {
		this.driver = Hooks.openAndQuitBrowser();
		homePage = PageGeneratorManager.getHomePage(driver);
	}
}
