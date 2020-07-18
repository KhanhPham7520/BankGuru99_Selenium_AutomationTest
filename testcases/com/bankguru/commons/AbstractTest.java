package com.bankguru.commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import com.bankguru.utils.GlobalConstants;

public class AbstractTest {

	private final String rootFolder = System.getProperty("user.dir");
	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public WebDriver getBrowserDriver(String browserName) {
		if (browserName.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();
		}
		if (browserName.equalsIgnoreCase("headless_firefox")) {
			System.setProperty(GlobalConstants.FIREFOX_DRIVER_SYSTEM_KEY, GlobalConstants.FIREFOX_DRIVER_SYSTEM_VALUE);
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			driver = new FirefoxDriver(options);
		}
		if (browserName.equalsIgnoreCase("headless_chrome")) {
			System.setProperty(GlobalConstants.CHROME_DRIVER_SYSTEM_KEY, GlobalConstants.CHROME_DRIVER_SYSTEM_VALUE);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("window-size=1920x1080");
			options.setHeadless(true);
			driver = new ChromeDriver(options);
		}
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty(GlobalConstants.CHROME_DRIVER_SYSTEM_KEY, GlobalConstants.CHROME_DRIVER_SYSTEM_VALUE);
			System.setProperty("webdriver.chrome.args", "--disable-logging");
			System.setProperty("webdriver.chrome.silentOutput", "true");
			driver = new ChromeDriver();

		}
		if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty(GlobalConstants.EDGE_DRIVER_SYSTEM_KEY, GlobalConstants.EDGE_DRIVER_SYSTEM_VALUE);
			driver = new EdgeDriver();
		}
		if (browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
			driver.manage().window().maximize();
		}
		driver.manage().deleteAllCookies();
		driver.get(GlobalConstants.REGISTER_URL);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		return driver;
	}
	
	protected void closeBrowserAndDriver(WebDriver driver) throws Exception {
			String osName = System.getProperty("os.name").toLowerCase();

			String cmd = "";
			if (driver != null) {
				driver.quit();
			}

			if (driver.toString().toLowerCase().contains("chrome")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill chromedriver";
				} else if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				}
			} else if (driver.toString().toLowerCase().contains("internetexplorer")) {
				if (osName.toLowerCase().contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
				}
			} else if (driver.toString().toLowerCase().contains("firefox")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill geckodriver";
				} else if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
				}
			}
			Process process = Runtime.getRuntime().exec(cmd);
			process.waitFor();

	}
		
	}
	


