package com.drivers;

import java.util.HashMap;
import java.util.Map;

import io.appium.java_client.AppiumDriver;

public class DriverManager {
	private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

	public static AppiumDriver getDriver() {
		return driver.get();
	}

	public static AppiumDriver createDriver(String platfromName) {
		setDriver(DriverFactory.createInstance(platfromName));
		return driver.get();
	}

	public static void setDriver(AppiumDriver driverInstance) {
		driver.set(driverInstance);
	}

	public static void quitDriver() {
		if (getDriver() != null) {
			Map<String, Object> params = new HashMap<>();
			params.put("appId", "com.chargepass.presto");//Android Specific
			driver.get().executeScript("mobile: terminateApp",params);
			getDriver().quit();
			driver.remove();
		}
	}
}
