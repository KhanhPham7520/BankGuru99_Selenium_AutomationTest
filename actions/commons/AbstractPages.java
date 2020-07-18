package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bankguru.utils.GlobalConstants;

public abstract class AbstractPages {

	WebDriver driver;
	private WebDriverWait waitExplicit;
	By byXpath;
	Select select;
	WebElement element;
	Actions action;

	public WebElement findElementByXpath(WebDriver driver, String locator) {
		return driver.findElement(byXpathLocator(locator));
	}

	public List<WebElement> findElementsByXpath(WebDriver driver, String locator) {
		return driver.findElements(byXpathLocator(locator));
	}

	public void openUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	public String getTitle(WebDriver driver, String url) {
		return driver.getTitle();
	}

	public String getCurrentUrl(WebDriver driver, String url) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver, String url) {
		return driver.getPageSource();
	}

	public void back(WebDriver driver) {
		driver.navigate().back();
	}

	public void forward(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public void sendkeyToAlert(WebDriver driver, String sendKeyValue) {
		driver.switchTo().alert().sendKeys(sendKeyValue);
	}

	public By byXpathLocator(String locator, String... values) {
		locator = String.format(locator, values);
		return byXpath = By.xpath(locator);
	}

	public By byXpathLocator(String locator) {
		locator = String.format(locator);
		return byXpath = By.xpath(locator);
	}

	public void waitAlertToPresence(WebDriver driver, String locator) {
		byXpath = byXpathLocator(locator);
		waitExplicit = new WebDriverWait(driver, GlobalConstants.SHORT_TIMEOUT);
		waitExplicit.until(ExpectedConditions.alertIsPresent());
	}

	public WebElement findElement(WebDriver driver, String locator) {
		return driver.findElement(byXpathLocator(locator));
	}

	public List<WebElement> findElements(WebDriver driver, String locator) {
		return driver.findElements(byXpathLocator(locator));
	}

	public void sendkeyToTextbox(WebDriver driver, String locator, String sendkeyValue) {
		driver.findElement(byXpathLocator(locator)).sendKeys(sendkeyValue);
	}

	public void sendkeyToTextarea(WebDriver driver, String locator, String sendkeyValue) {
		findElementByXpath(driver, locator).sendKeys(sendkeyValue);
	}

	public void selectItemInDropdown(WebDriver driver, String locator, String dropdownValue) {
		select = new Select(findElementByXpath(driver, locator));
		select.selectByVisibleText(dropdownValue);
	}

	public String getSelectedItemInDropdown(WebDriver driver, String locator) {
		select = new Select(findElementByXpath(driver, locator));
		element = select.getFirstSelectedOption();
		return element.getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String locator) {
		select = new Select(findElementByXpath(driver, locator));
		return select.isMultiple();
	}

	public void getAttributeValue(WebDriver driver, String locator) {
		findElementByXpath(driver, locator).getAttribute("value");
	}

	public String getText(WebDriver driver, String locator) {
		return findElementByXpath(driver, locator).getText();
	}

	public int countElementNumber(WebDriver driver, String locator) {
		return findElementsByXpath(driver, locator).size();
	}

	public void checkTheCheckbox(WebDriver driver, String locator) {
		if (findElementByXpath(driver, locator).isSelected() != true) {
			findElementByXpath(driver, locator).click();
		}

	}

	public void uncheckTheCheckbox(WebDriver driver, String locator) {
		if (findElementByXpath(driver, locator).isSelected() == true) {
			findElementByXpath(driver, locator).click();
		}
	}

	public boolean isDisplayed(WebDriver driver, String locator) {
		return findElementByXpath(driver, locator).isDisplayed();
	}

	public boolean isSelected(WebDriver driver, String locator) {
		return findElementByXpath(driver, locator).isSelected();
	}

	public boolean isEnabled(WebDriver driver, String locator) {
		return findElementByXpath(driver, locator).isEnabled();
	}

	public void switchToFrame(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWindow = driver.getTitle();
			if (currentWindow.equals(title)) {
				break;
			}
		}
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		element = findElementByXpath(driver, locator);
		action.doubleClick(element).perform();
	}

	public void hoverTo(WebDriver driver, String locator) {
		action = new Actions(driver);
		element = findElementByXpath(driver, locator);
		action.moveToElement(element).build().perform();
	}
	
	public void rightClickTo(WebDriver driver, String locator) {
		action = new Actions(driver);
		element = findElementByXpath(driver, locator);
		action.contextClick(element).perform();
	}
	
	public void dragAndDropTo(WebDriver driver, String departureLocator, String destinationLocator) {
		action = new Actions(driver);
		WebElement departureElement = findElementByXpath(driver, departureLocator);
		WebElement destinationElement = findElementByXpath(driver, destinationLocator);
		action = new Actions(driver);
		action.dragAndDrop(departureElement, destinationElement).build().perform();
	}

}
