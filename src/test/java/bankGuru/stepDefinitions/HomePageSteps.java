package bankGuru.stepDefinitions;

import org.openqa.selenium.WebDriver;

import cucumberOptions.Hooks;

public class HomePageSteps {

	WebDriver driver;

	public HomePageSteps(WebDriver driver) {
		this.driver = Hooks.openAndQuitBrowser();
	}

}
