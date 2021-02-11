package bankGuru.stepDefinitions;

import commons.GlobalConstants;
import commons.PageGeneratorManager;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import org.openqa.selenium.WebDriver;

import Data_Faker.DataHelper;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;
import pageUIs.RegisterPageUI;

public class RegisterPageSteps {

	WebDriver driver;
	public static String username;
	public static String password;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	DataHelper dataFaker;
	String email;

//Constructor
	public RegisterPageSteps() {
		driver = Hooks.openAndQuitBrowser();
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		email = DataHelper.getData().getEmail();
	}

	@When("^Input to Email textbox$")
	public void input_to_Email_textbox() {
		registerPage.inputToTextbox(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
	}

	@When("^Click To Submit button$")
	public void click_To_Submit_button() {
		registerPage.clickIntoButton(driver, RegisterPageUI.SUBMIT_BUTTON);
	}

	@Then("^Get User and password Infor$")
	public void get_User_and_password_Infor() {
		username = registerPage.getText(driver, RegisterPageUI.USER_ID);
		password = registerPage.getText(driver, RegisterPageUI.PASSWORD);
	}

	@When("^Back to Login page$")
	public void back_to_Login_page() {
		loginPage = registerPage.navigateToLoginPage(driver, GlobalConstants.LOGIN_BANKGURU_URL);
	}

}
