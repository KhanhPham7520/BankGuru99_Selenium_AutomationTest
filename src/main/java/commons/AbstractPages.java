package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;


public abstract class AbstractPages {
    protected Select select;
    JavascriptExecutor jsExcutor;
    long longTimeOut = GlobalConstants.LONG_TIMEOUT;
    long shortTimeOut = GlobalConstants.SHORT_TIMEOUT;
    Actions action;
    WebElement element;
    By byXpath;
    WebDriverWait waitExplicit;
    Date date;
    private Actions actions;
    private WebDriver driver;

    // public boolean isNameSortedDescending(WebDriver driver) {
    // ArrayList<String> arrayList = new ArrayList<>();
    //
    // List<WebElement> elementList = findElementsByXpath(driver,
    // AbstractBankPageUI.PRODUCT_TITLE);
    //
    // for (WebElement element : elementList) {
    // arrayList.add(element.getText());
    // }
    //
    // // copy to new arraylist for sorting in code
    // ArrayList<String> sortedList = new ArrayList<>();
    // for (String child : arrayList) {
    // sortedList.add(child);
    // }
    //
    // // Collections.reverse(arrayList);
    // return sortedList.equals(arrayList);
    //
    // }
    //
    // public boolean isNameSortedAscending(WebDriver driver) {
    // ArrayList<String> arrayList = new ArrayList<>();
    //
    // List<WebElement> elementList = findElementsByXpath(driver,
    // AbstractBankPageUI.PRODUCT_TITLE);
    //
    // for (WebElement element : elementList) {
    // arrayList.add(element.getText());
    // }
    // // copy to new arraylist for sorting in code
    // ArrayList<String> sortedList = new ArrayList<>();
    // for (String child : arrayList) {
    // sortedList.add(child);
    // }
    // Collections.sort(arrayList);
    // return sortedList.equals(arrayList);
    //
    // }
    //
    // public boolean isPriceSortedAscending(WebDriver driver) {
    // ArrayList<Float> arrayList = new ArrayList<Float>();
    //
    // List<WebElement> elementList = findElementsByXpath(driver,
    // AbstractBankPageUI.PRODUCT_TITLE);
    //
    // for (WebElement element : elementList) {
    // arrayList.add(Float.parseFloat(element.getText().replace("$",
    // "").replace(",", "").trim()));
    // }
    //
    // // copy to new arraylist for sorting in code
    // ArrayList<Float> sortedList = new ArrayList<Float>();
    // for (Float child : arrayList) {
    // sortedList.add(child);
    // }
    // Collections.sort(arrayList);
    // return sortedList.equals(arrayList);
    //
    // }
    //
    // public boolean isPriceSortedDescending(WebDriver driver) {
    // ArrayList<Float> arrayList = new ArrayList<Float>();
    //
    // List<WebElement> elementList = findElementsByXpath(driver,
    // AbstractBankPageUI.PRODUCT_TITLE);
    //
    // for (WebElement element : elementList) {
    // arrayList.add(Float.parseFloat(element.getText().replace("$",
    // "").replace(",", "").trim()));
    // }
    // // copy to new arraylist for sorting in code
    // ArrayList<Float> sortedList = new ArrayList<Float>();
    // for (Float child : arrayList) {
    // sortedList.add(child);
    // }
    //
    // // Collections.reverse(arrayList);
    // return sortedList.equals(arrayList);
    //
    // }

    public void sleepInSecond() {
        try {
            Thread.sleep(shortTimeOut * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void openUrl(WebDriver driver, String urlValue) {
        driver.get(urlValue);
        driver.manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getCurrentPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public void back(WebDriver driver) {
        driver.navigate().back();
    }

    public void refreshPage(WebDriver driver) {
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

    public void sendKeyToAlert(WebDriver driver, String value) {
        driver.switchTo().alert().sendKeys(value);
    }

    public List<WebElement> findElementsByXpath(WebDriver driver, String locator) {
        return driver.findElements(byXpathLocator(locator));

    }

    public List<WebElement> findElementsByXpath(WebDriver driver, String locator, String... values) {
        locator = String.format(locator, values);
        return driver.findElements(byXpathLocator(locator));
    }

    public void clickToElement(WebDriver driver, String locator) {
        waitToElementClickable(driver, locator);
        findElementByXpath(driver, locator).click();
    }

    public void clickToElement(WebDriver driver, String locator, String... values) {
    	// element = findElementByXpath(driver, locator, values);
    	// highlightElement(driver, element);
    	findElementByXpath(driver, locator, values).click();
    }
    
    public void clickToLink(WebDriver driver, String locator, String... values) {
        waitToElementClickable(driver, locator, values);
        findElementByXpath(driver, locator, values).click();
    }

    public void sendKeyToElement(WebDriver driver, String locator, String value) {
        waitToElementVisible(driver, locator);
        clearExistedData(driver, locator);
        // element = findElementByXpath(driver, locator);
        // highlightElement(driver, element);
        driver.findElement(byXpathLocator(locator)).sendKeys(value);
    }

    public void sendKeyToElement(WebDriver driver, String locator, String sendKeyValue, String... values) {
        waitToElementVisible(driver, locator, values);
        findElementByXpath(driver, locator, values).clear();
        // element = findElementByXpath(driver, locator, values);
        // highlightElement(driver, element);
        findElementByXpath(driver, locator, values).sendKeys(sendKeyValue);
    }

    public WebElement findElementByXpath(WebDriver driver, String locator) {
        return driver.findElement(byXpathLocator(locator));
    }

    public WebElement findElementByXpath(WebDriver driver, String locator, String... values) {
        locator = String.format(locator, values);
        return driver.findElement(byXpathLocator(locator));
    }

    public int countElementNumber(WebDriver driver, String locator) {
        return findElementsByXpath(driver, locator).size();
    }

    public String getAttributeElement(WebDriver driver, String locator, String attributeName) {
        return findElementByXpath(driver, locator).getAttribute(attributeName);
    }

    public String getAttributeElement(WebDriver driver, String locator, String attributeName, String... values) {
        return findElementByXpath(driver, locator, values).getAttribute(attributeName);
    }

    public boolean isElementDisplayed(WebDriver driver, String locator) {
        try {
            element = findElementByXpath(driver, locator);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementDisplayed(WebDriver driver, String locator, String... values) {
        try {
            element = findElementByXpath(driver, locator, values);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementNoDisplayed(WebDriver driver, String locator, String... values) {
        return !(findElementByXpath(driver, locator, values).isDisplayed());
    }

    public boolean isControlEnabled(WebDriver driver, String locator) {
        return findElementByXpath(driver, locator).isEnabled();
    }

    public boolean isControlEnabled(WebDriver driver, String locator, String... values) {
        return findElementByXpath(driver, locator, values).isEnabled();
    }

    public void doubleClickToElement(WebDriver driver, String locator) {
        action = new Actions(driver);
        element = findElementByXpath(driver, locator);
    }

    public By byXpathLocator(String locator) {
        return byXpath = By.xpath(locator);
    }

    public By byXpathLocator(String locator, String... values) {
        locator = String.format(locator, values);
        return byXpath = By.xpath(locator);
    }

    public void waitToElementVisible(WebDriver driver, String locator) {
        byXpath = byXpathLocator(locator);
        element = findElementByXpath(driver, locator);
        waitExplicit = new WebDriverWait(driver, longTimeOut);
        waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byXpath));
    }

    public void waitToElementPresence(WebDriver driver, String locator) {
        byXpath = byXpathLocator(locator);
        waitExplicit = new WebDriverWait(driver, longTimeOut);
        waitExplicit.until(ExpectedConditions.presenceOfElementLocated(byXpath));
    }

    public void waitToElementPresence(WebDriver driver, String locator, String... values) {
        byXpath = byXpathLocator(locator, values);
        waitExplicit = new WebDriverWait(driver, longTimeOut);
        waitExplicit.until(ExpectedConditions.presenceOfElementLocated(byXpath));
    }

    public void waitToElementVisible(WebDriver driver, String locator, String... values) {
        byXpath = byXpathLocator(locator, values);
        element = findElementByXpath(driver, locator, values);
        waitExplicit = new WebDriverWait(driver, longTimeOut);
        waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byXpath));
    }

    public void waitToElementInvisible(WebDriver driver, String locator) {
        date = new Date();
        byXpath = byXpathLocator(locator);
        waitExplicit = new WebDriverWait(driver, GlobalConstants.SHORT_TIMEOUT);
        overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
        try {
            System.out.println("Start time for wait invisible = " + date.toString());
            waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(byXpathLocator(locator)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("End time for wait invisible = " + new Date().toString());
        overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
    }

    public void waitToElementInvisible(WebDriver driver, String locator, String... values) {
        byXpath = byXpathLocator(locator, values);
        waitExplicit = new WebDriverWait(driver, longTimeOut);
        waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(byXpath));
    }

    public void waitToElementClickable(WebDriver driver, String locator) {
        byXpath = byXpathLocator(locator);
        waitExplicit = new WebDriverWait(driver, longTimeOut);
        waitExplicit.until(ExpectedConditions.elementToBeClickable(byXpath));
    }

    public void waitToElementClickable(WebDriver driver, String locator, String... values) {
        byXpath = byXpathLocator(locator, values);
        waitExplicit = new WebDriverWait(driver, longTimeOut);
        waitExplicit.until(ExpectedConditions.elementToBeClickable(byXpath));
    }

    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove, String... values) {
        jsExcutor = (JavascriptExecutor) driver;
        element = findElementByXpath(driver, locator, values);
        jsExcutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
    }


    public void clickIntoButton(WebDriver driver, String locator, String... values) {
        waitToElementClickable(driver, locator, values);
        findElementByXpath(driver, locator, values).click();
    }

    public void clickIntoDynamicButtonInputType(WebDriver driver, String locator, String... values) {
        waitToElementClickable(driver, locator, values);
        findElementByXpath(driver, locator, values).click();
    }



    public void clickIntoCheckbox(WebDriver driver, String locator) {
        waitToElementClickable(driver, locator);
        findElementByXpath(driver, locator).click();
    }

    public void clickIntoRadioButton(WebDriver driver, String locator) {
        waitToElementClickable(driver, locator);
        findElementByXpath(driver, locator).click();
    }

    public void selectItemInDropdown(WebDriver driver, String locator, String valueItem, String... values) {
        waitToElementClickable(driver, locator);
        select = new Select(element);
        element = findElementByXpath(driver, locator, values);

        clickToElement(driver, locator, values);
        select.selectByVisibleText(valueItem);

    }

    public String getText(WebDriver driver, String locator) {
        waitToElementVisible(driver, locator);
        return findElementByXpath(driver, locator).getText();
    }

    public String getText(WebDriver driver, String locator, String... values) {
        waitToElementVisible(driver, locator, values);
        return findElementByXpath(driver, locator, values).getText();
    }

    public void clearExistedData(WebDriver driver, String locator) {
        findElementByXpath(driver, locator).clear();
    }

    public void selectDropdownByVisibleText(WebDriver driver, String locator, String inputText) {
        waitToElementClickable(driver, locator);
        Select select = new Select(findElementByXpath(driver, locator));

        clickToElement(driver, locator);
        select.selectByVisibleText(inputText);
    }

    public void selectCustomDropdownByVisibleText(WebDriver driver, String locator, String inputText) throws Exception {
        String allItemXpath = null;
        String expectedValueItem = null;
        WebElement parentDropdown = findElementByXpath(driver, locator);
        jsExcutor.executeScript("arguments[0].click();", parentDropdown);

        waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byXpathLocator(allItemXpath)));
        List<WebElement> allItems = findElementsByXpath(driver, locator);
        System.out.println("All items : " + allItems);
        for (WebElement childElement : allItems) {
            if (childElement.getText().equalsIgnoreCase(expectedValueItem)) {
                if (childElement.isDisplayed()) {
                    System.out.println("Click by Selenium = " + childElement);
                    childElement.click();
                } else {
                    jsExcutor.executeScript("arguments[0].scrollIntoView(true)", childElement);
                    System.out.println("Click by JS = " + childElement.getText());
                    jsExcutor.executeScript("arguments[0].click()", childElement);
                }
                Thread.sleep(1000);
                break;
            }
        }

    }

    public void hoverToElement(WebDriver driver, String locator) {
        WebElement hoverElement = findElementByXpath(driver, locator);
        actions = new Actions(driver);
        actions.moveToElement(hoverElement).perform();
    }

    public void hoverToElement(WebDriver driver, String locator, String value) {
        WebElement hoverElement = findElementByXpath(driver, locator, value);
        actions = new Actions(driver);
        actions.moveToElement(hoverElement).perform();
    }

    public void selectItemInCustomDropdownList(String parentXpath, String childXpath, String expectedItem) {

        // click vào thẻ cha để nó xổ ra các item
        // driver.findElement(By.xpath(parentXpath)).click();
        findElementByXpath(driver, parentXpath).click();
        sleepInSecond();
        // lấy hết tất cả item gán vào 1 cái List
        // List<WebElement> allItems = driver.findElements(By.xpath(childXpath));
        List<WebElement> allItems = driver.findElements(byXpathLocator(childXpath));
        System.out.println("Number items = " + allItems.size());

        // Wait cho tất cả item load lên thành công
        waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childXpath)));

        // Dùng vòng lặp để duyệt qua các item
        for (int i = 0; i < allItems.size(); i++) {
            // Get text của item ra
            String itemText = allItems.get(i).getText();
            // Kiểm tra item có bằng item mình cần chọn ko
            if (itemText.equals(expectedItem)) {
                // Nếu như thỏa mãn thì click vào item đó
                allItems.get(i).click();
                // Thoát khỏi vòng lặp
                break;
            }

        }
    }

    public void overrideGlobalTimeout(WebDriver driver, long timeOut) {
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
    }

    public boolean isControlUndisplayed(WebDriver driver, String locator) {
        date = new Date();
        System.out.println("Start time " + date.toString());
        overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
        List<WebElement> elements = driver.findElements(By.xpath(locator));

        if (elements.size() == 0) {
            System.out.println("Element not in DOM");
            System.out.println("End time = " + new Date().toString());
            overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
            return true;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            System.out.println("Element in DOM but not visible / displayed");
            System.out.println("End time = " + new Date().toString());
            overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
            return true;
        } else {
            System.out.println("Element in DOM and visible");
            overrideGlobalTimeout(driver, longTimeOut);
            return false;
        }
    }

    public void pressEnter(WebDriver driver) {
        action = new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();
    }

    public void highlightElement(WebDriver driver, WebElement element) {
        jsExcutor = (JavascriptExecutor) driver;
        String originalStyle = element.getAttribute("style");
        jsExcutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 3px solid red; border-style: dashed;");
        jsExcutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);

    }

    public void inputToTextbox(WebDriver driver, String locator, String enterValue) {
    	waitToElementVisible(driver, locator);
    	sendKeyToElement(driver, locator, enterValue);
    }
    
    public void inputToTextbox(WebDriver driver, String locator, String enterValue, String...values) {
        waitToElementVisible(driver, locator,values);
        sendKeyToElement(driver, locator, enterValue,values);
    }

    public void switchToPage(WebDriver driver, String urlValue) {
        driver.get(urlValue);
    }

    public void switchToPopUpModal(WebDriver driver) {
        driver.switchTo().activeElement();
    }
}
