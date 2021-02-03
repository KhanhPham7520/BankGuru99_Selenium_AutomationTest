package bankGuru.stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.PageGeneratorManager;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pageObjects.RegisterPageObject;

public class RegisterPageSteps {

	WebDriver driver;
	String username;
	String password;
	RegisterPageObject registerPage;

	public RegisterPageSteps(WebDriver driver) {
		this.driver = Hooks.openAndQuitBrowser();
		registerPage = PageGeneratorManager.getRegisterPage(driver);
	}

	@When("^Input to Email textbox$")
	public void inputToEmailTextbox() {
		registerPage.inputToEmailTextbox("");
	}

	@When("^Click To Submit button$")
	public void clickToSubmitButton() {
		registerPage.clickToSubmitButton();
	}

	@Then("^Get User and password Infor$")
	public void getUserAndPasswordInfor() {
		username = registerPage.getUserIDText();
		password = register.getPasswordText();
	}

	@When("^Back to Login page$")
	public void backToLoginPage() {
		registerPage.openLoginPage("");
	}

	@When("^Submit valid infor to login form$")
	public void submitValidInforToLoginForm() {
		// Write code here that turns the phrase above into concrete actions
	}
}
