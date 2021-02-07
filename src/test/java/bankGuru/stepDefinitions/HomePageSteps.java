package bankGuru.stepDefinitions;

import commons.PageGeneratorManager;
import cucumber.api.java.en.Then;
import cucumberOptions.Hooks;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePageObject;

public class HomePageSteps {

	WebDriver driver;
	HomePageObject homePage;

	public HomePageSteps(WebDriver driver) {
		this.driver = Hooks.openAndQuitBrowser();
		homePage = PageGeneratorManager.getHomePage(driver);
	}


	@Then("^Home page displayed$")
	public void home_page_displayed()  {
		Assert.assertTrue(homePage.isWelcomeMessageDisplayed());
	}
}
