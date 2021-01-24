package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import cucumber.api.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class FacebookSteps {

    WebDriver driver;

    @Given("^Open Facebook application$")
    public void openFacebookApplication() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

//	@When("^Input to Username textbox$")
//	public void inputToUsernameTextbox() throws Throwable {
//		driver.findElement(By.id("email")).clear();
//		driver.findElement(By.id("email")).sendKeys("automationtesting@gmail.com");
//	}
//
//	@When("^Input to Password textbox$")
//	public void inputToPasswordTextbox() throws Throwable {
//		driver.findElement(By.id("pass")).clear();
//		driver.findElement(By.id("pass")).sendKeys("automationtesting@gmail.com");
//
//	}

    @When("^Input to Username textbox with \"(.*?)\"$")
    public void inputToUsernameTextboxWith(String username) throws Throwable {
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(username);
    }

    @When("^Input to Password textbox with \"(.*?)\"$")
    public void inputToPasswordTextboxWith(String password) throws Throwable {
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys(password);
    }

    @When("^Click To Submit button$")
    public void click_To_Submit_button() throws Throwable {
        driver.findElement(By.name("login")).click();
    }

    @Then("^Close application$")
    public void closeApplication() throws Throwable {
        driver.quit();
    }


}
