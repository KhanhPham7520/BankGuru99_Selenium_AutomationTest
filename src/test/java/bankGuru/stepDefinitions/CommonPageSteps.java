package bankGuru.stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.PageGeneratorManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pageObjects.CommonPageObject;
import pageObjects.HomePageObject;
import pageObjects.NewCustomerPageObject;
import pageUIs.NewCustomerPageUI;

public class CommonPageSteps {
	
	WebDriver driver;
	HomePageObject homePage;
	CommonPageObject commonPage;
	NewCustomerPageObject newCustomerPage;

	public CommonPageSteps() {
		this.driver = Hooks.openAndQuitBrowser();
		homePage = PageGeneratorManager.getHomePage(driver);
		commonPage = PageGeneratorManager.getCommonPage(driver);
		newCustomerPage = PageGeneratorManager.getNewCustomerPage(driver);
	}
	
	@Given("^Navigate to New Customer page$")
	public void navigate_to_New_Customer_page()  {
	    newCustomerPage = commonPage.navigateToCustomerPage(driver,"New Customer");
	}

	@When("^Input to \"(.*?)\" textbox with value \"(.*?)\"$")
	public void inputToTextboxWithValue(String textboxValue, String inputValue)  {
	    switch (textboxValue) {
		case "Customer Name":
			newCustomerPage.inputToTextbox(driver, NewCustomerPageUI.DYNAMIC_TEXTBOX, inputValue,"name");
			break;

		default:
			break;
		}
	}

	@When("^Click to \"(.*?)\" radio$")
	public void clickToRadio(String maleOption)  {
	    
	}

	@When("^Click to \"(.*?)\" button$")
	public void clickToButton(String arg1)  {
	    
	}

	@Then("^Verify message \"(.*?)\" is displayed$")
	public void verifyMessageIsDisplayed(String arg1)  {
	    
	}

	@Then("^The correct value displayed at \"(.*?)\" with value \"(.*?)\"$")
	public void theCorrectValueDisplayedAtWithValue(String arg1, String arg2)  {
	    
	}
}
