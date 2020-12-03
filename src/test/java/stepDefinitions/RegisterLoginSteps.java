package stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.PageGeneratorManager;
import cucumberOptions.Hooks;
import pageObjects.LoginPageObject;

public class RegisterLoginSteps {
	
	WebDriver driver;
	LoginPageObject loginPage;
	static String loginPageUrl;

	public RegisterLoginSteps() {
		driver = Hooks.openAndQuitBrowser();
		loginPage = PageGeneratorManager.getLoginPage(driver);
	}
	
	
	
	
}
