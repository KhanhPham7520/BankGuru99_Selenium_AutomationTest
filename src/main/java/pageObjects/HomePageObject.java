package pageObjects;

import commons.AbstractPages;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class HomePageObject extends AbstractPages {

    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isWelcomeMessageDisplayed() {
        waitToElementInvisible(driver, HomePageUI.MARQUEE_WELCOME_MANAGER);
        return isElementDisplayed(driver,HomePageUI.MARQUEE_WELCOME_MANAGER);
    }
}
