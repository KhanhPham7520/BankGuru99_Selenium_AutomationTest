package bankGuru.stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.PageGeneratorManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pageObjects.LoginPageObject;

public class LoginPageSteps {

	WebDriver driver;
	String loginPageUrl;
	LoginPageObject loginPage;

	public LoginPageSteps(WebDriver driver) {
		this.driver = Hooks.openAndQuitBrowser();
		loginPage = PageGeneratorManager.getLoginPage(driver);
	}

	@Given("^Open Register page$")
	public void openRegisterPage() {

	}

	@When("^Submit valid infor to login form$")
	public void submitValidInforToLoginForm() {
		// Write code here that turns the phrase above into concrete actions
	}
}
