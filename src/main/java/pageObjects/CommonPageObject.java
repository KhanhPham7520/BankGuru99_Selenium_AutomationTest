package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.NewCustomerPageUI;

public class CommonPageObject extends AbstractPages {

	WebDriver driver;

	public CommonPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public NewCustomerPageObject navigateToCustomerPage(WebDriver driver, String pageUrl) {
		waitToElementClickable(driver, NewCustomerPageUI.DYNAMIC_LEFT_MENU_LINK, pageUrl);
		clickToLink(driver, NewCustomerPageUI.DYNAMIC_LEFT_MENU_LINK, pageUrl);
		return new NewCustomerPageObject(driver);

	}

}
