package pageObjects;

import commons.AbstractPages;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends AbstractPages {
    WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public RegisterPageObject clickIntoLink(WebDriver driver, String locator) {
        clickToElement(driver,locator);
        return new RegisterPageObject(driver);
    }

    public void getLoginPageUrl() {
        waitToElementVisible(driver, GlobalConstants.LOGIN_BANKGURU_URL);
    openUrl(driver, GlobalConstants.LOGIN_BANKGURU_URL);
    }
}
