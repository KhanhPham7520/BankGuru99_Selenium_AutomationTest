package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.CommonPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;

public class PageGeneratorManager {

    public static LoginPageObject getLoginPage(WebDriver driver) {
        return new LoginPageObject(driver);
    }

    public static RegisterPageObject getRegisterPage(WebDriver driver) {
        return new RegisterPageObject(driver);
    }

    public static HomePageObject getHomePage(WebDriver driver) {
    	return new HomePageObject(driver);
    }
    
    public static CommonPageObject getCommonPage(WebDriver driver) {
    	return new CommonPageObject(driver);
    }
    
    public static NewCustomerPageObject getNewCustomerPage(WebDriver driver) {
        return new NewCustomerPageObject(driver);
    }
}
