package bankGuru.stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.PageGeneratorManager;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pageObjects.HomePageObject;

public class CommonPageSteps {
	
	WebDriver driver;
	HomePageObject homePage;

	public CommonPageSteps() {
		this.driver = Hooks.openAndQuitBrowser();
		homePage = PageGeneratorManager.getHomePage(driver);
	}
	
	@Given("^Open \"(.*?)\" page$")
	public void openPage(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^Input to \"(.*?)\" textbox with value \"(.*?)\"$")
	public void inputToTextboxWithValue(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^Click to \"(.*?)\" radio$")
	public void clickToRadio(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^Click to \"(.*?)\" button$")
	public void clickToButton(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Verify message \"(.*?)\" is displayed$")
	public void verifyMessageIsDisplayed(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^The correct value displayed at \"(.*?)\" with value \"(.*?)\"$")
	public void theCorrectValueDisplayedAtWithValue(String rowName, String expectedValue) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
