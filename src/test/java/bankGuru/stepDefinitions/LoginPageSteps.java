package bankGuru.stepDefinitions;

import commons.PageGeneratorManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;
import pageUIs.LoginPageUI;

public class LoginPageSteps {

	String loginPageUrl;
	WebDriver driver;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	HomePageObject homePage;



	public LoginPageSteps() {
		driver = Hooks.openAndQuitBrowser();
		loginPage = PageGeneratorManager.getLoginPage(driver);
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Given("^Get login page url$")
	public void getLoginPageUrl()  {
		loginPage.getLoginPageUrl();
	}

	@Given("^Open Register page$")
	public void open_Register_page()  {
		registerPage = loginPage.clickIntoLink(driver, LoginPageUI.REGISTER_HERE_LINK);
	}



	@When("^Submit valid infor to login form$")
	public void submit_valid_infor_to_login_form()  {
		loginPage.inputToTextbox(driver,LoginPageUI.USERID_TEXTBOX, RegisterPageSteps.username);
		loginPage.inputToTextbox(driver,LoginPageUI.PASSWORD_TEXTBOX, RegisterPageSteps.password);
		loginPage.clickIntoButton(driver, LoginPageUI.LOGIN_BUTTON);
	}



}
