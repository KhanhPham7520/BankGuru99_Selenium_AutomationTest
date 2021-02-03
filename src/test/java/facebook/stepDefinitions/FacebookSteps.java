package facebook.stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FacebookSteps {

    WebDriver driver;

    @Before
    public void openFacebookApplication() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void closeApplication() {
        driver.quit();
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





    //@When("^Input to Username and Password$")
//    public void inputToUsernameAndPassword(DataTable table){
//        List<Map<String, String>> customer = table.asMaps(String.class, String.class);

//        driver.findElement(By.id("email")).clear();
//        driver.findElement(By.id("email")).sendKeys(customer.get(0).get("Username"));
//
//        driver.findElement(By.id("pass")).clear();
//		driver.findElement(By.id("pass")).sendKeys(customer.get(0).get("Password"));

//        for(Map<String, String> loginInfo : table.asMaps(String.class, String.class){
//            driver.findElement(By.id("email")).clear();
//            driver.findElement(By.id("email")).sendKeys(loginInfo.get("Username"));
//
//            driver.findElement(By.id("pass")).clear();
//            driver.findElement(By.id("pass")).sendKeys(loginInfo.get("Password"));
//        }
    }



