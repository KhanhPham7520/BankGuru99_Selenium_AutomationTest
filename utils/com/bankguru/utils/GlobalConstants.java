package com.bankguru.utils;

public class GlobalConstants {
	
	public static final String REGISTER_URL = "http://demo.guru99.com/";
	
	public static final String LOGIN_URL = "http://demo.guru99.com/v4/";
	
	
	public static final String rootFolderPath = System.getProperty("user.dir");

	// Firefox driver path
	public static final String FIREFOX_DRIVER_SYSTEM_KEY = "webdriver.gecko.driver";
	public static final String FIREFOX_DRIVER_SYSTEM_VALUE = rootFolderPath + "/browserDrivers/geckodriver";

	// Chrome driver path
	public static final String CHROME_DRIVER_SYSTEM_KEY = "webdriver.chrome.driver";
	public static final String CHROME_DRIVER_SYSTEM_VALUE = rootFolderPath + "/browserDrivers/chromedriver";
	// Edge driver path
	public static final String EDGE_DRIVER_SYSTEM_KEY = "webdriver.edge.driver";
	public static final String EDGE_DRIVER_SYSTEM_VALUE = rootFolderPath + "/browserDrivers/msedgedriver";

	// Common message in Search Product Page
	public static final long SHORT_TIMEOUT = 10;
	public static final long LONG_TIMEOUT = 20;

	
}
