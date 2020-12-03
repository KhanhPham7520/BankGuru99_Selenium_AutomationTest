package cucumberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.PendingException;
import cucumber.api.SnippetType;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", 
glue = {"stepDefinitions" },
monochrome = true, snippets = SnippetType.UNDERSCORE, 
plugin = { "pretty", "html:target/site/cucumber-report-default", "json:target/site/cucumber.json" }, 
tags = { "@Register_Login" })
public class CucumberTestRunner {

	@Given("^I want to navigate to url \"(.*?)\"$")
	public void i_want_to_navigate_to_url(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I input Email ID with value \"(.*?)\"$")
	public void i_input_Email_ID_with_value(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I click Submit button$")
	public void i_click_Submit_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^I get User ID with value \"(.*?)\"$")
	public void i_get_User_ID_with_value(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^I get Password with value \"(.*?)\"$")
	public void i_get_Password_with_value(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I want to navigate to url \"(.*?)\" to login$")
	public void i_want_to_navigate_to_url_to_login(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I input UserID with value \"(.*?)\"$")
	public void i_input_UserID_with_value(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I input Password with value \"(.*?)\"$")
	public void i_input_Password_with_value(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I click Login button$")
	public void i_click_Login_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^I verified marquee displayed with text \"(.*?)\"$")
	public void i_verified_marquee_displayed_with_text(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^I verified Manager ID displayed with value \"(.*?)\"$")
	public void i_verified_Manager_ID_displayed_with_value(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}



}
