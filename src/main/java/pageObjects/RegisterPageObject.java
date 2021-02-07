package pageObjects;

import commons.AbstractPages;
import org.openqa.selenium.WebDriver;

public class RegisterPageObject extends AbstractPages {

    WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPageObject navigateToLoginPage(WebDriver driver, String pageUrl){
        driver.navigate().to(pageUrl);
        return new LoginPageObject(driver);
    }


}
