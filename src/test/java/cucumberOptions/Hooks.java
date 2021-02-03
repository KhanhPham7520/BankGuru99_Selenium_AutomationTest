package cucumberOptions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.Assert;
import org.testng.Reporter;

import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
	private static WebDriver driver;

	public synchronized static WebDriver openAndQuitBrowser() {

		String browser = System.getProperty("BROWSER");

		if (driver == null) {
			try {
				if (browser == null) {
					browser = System.getenv("BROWSER");
					if (browser == null) {
						browser = "firefox";
					}
				}

				switch (browser) {
				case "chrome":
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					break;
				case "hchrome":
					WebDriverManager.chromedriver().setup();
					ChromeOptions chromeOptions = new ChromeOptions();
					chromeOptions.addArguments("headless");
					chromeOptions.addArguments("window-size=1920x1080");
					driver = new ChromeDriver(chromeOptions);
					break;
				case "firefox":
					WebDriverManager.firefoxdriver().setup();
					System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
					System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
					driver = new FirefoxDriver();
				case "safari":
					// WebDriverManager.s
					break;
				default:
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					break;
				}
			} catch (UnreachableBrowserException e) {
				System.out.println(e.getMessage());
			} catch (WebDriverException e) {
				e.printStackTrace();

			} finally {
				// Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
			}
		}
		driver.get(GlobalConstants.BANKGURU_URL);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;

	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false) {
				// log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				// log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			// VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(),
			// e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			// log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			// log.info(" -------------------------- FAILED -------------------------- ");
			// VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(),
			// e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(String actual, String expected) {
		return checkEquals(actual, expected);
	}

	protected void closeBrowserAndDriver(WebDriver driver) {
		try {
			// get ra tên của OS và convert qua chữ thường
			String osName = System.getProperty("os.name").toLowerCase();
			// log.info("OS name = " + osName);

			// Khai báo 1 biến command line để thực thi
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

			// log.info("---------- QUIT BROWSER SUCCESS ----------");
		} catch (Exception e) {
			// log.info(e.getMessage());
		}
	}

	protected Object formatDate(String dateValue) {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		try {
			Date date = simpleDateFormat.parse(dateValue);
			dateValue = simpleDateFormat.format(date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dateValue;
	}

	protected String getCurrentDay() {
		DateTime nowUTC = new DateTime(DateTimeZone.UTC);
		int day = nowUTC.getDayOfMonth();
		if (day < 10) {
			String dayValue = "0" + day;
			return dayValue;
		}
		return day + "";
	}

	protected String getCurrentMonth() {
		DateTime now = new DateTime(DateTimeZone.UTC);
		int month = now.getMonthOfYear();
		if (month < 10) {
			String monthValue = "0" + month;
			return monthValue;
		}
		return month + "";
	}

	protected String getCurrentYear() {
		DateTime now = new DateTime(DateTimeZone.UTC);
		return now.getYear() + "";
	}

	protected String getBankGuruToday() {
		return getCurrentYear() + "-" + getCurrentMonth() + "-" + getCurrentDay();
	}
}
