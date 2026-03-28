package com.drivers;

import java.net.MalformedURLException;


import java.net.URL;
import java.time.Duration;

import com.utils.ConfigReader;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

public class DriverFactory {
    public static AppiumDriver createInstance(String platform) {
        AppiumDriver driver = null;
        UiAutomator2Options androidOptions = new UiAutomator2Options();
        XCUITestOptions iosOptions = new XCUITestOptions();
        URL url;
		try {
			url = new URL("http://127.0.0.1:4723/");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Appium Server URL is inavlid");
		}

        switch (platform.toLowerCase()) {
            case "android":
                androidOptions.setAutomationName("UiAutomator2")
                             .setDeviceName(ConfigReader.getProperty("android.device"))
                             .setPlatformVersion(ConfigReader.getProperty("android.platform.version"))
                             .setAutoGrantPermissions(true)
                             .setNoReset(true)
                             .setNewCommandTimeout(Duration.ofSeconds(1500))
                             .setAppWaitActivity("*") 
                             .setAppActivity(ConfigReader.getProperty("android.app.main.activity"))
                             .gpsEnabled()
                             .setApp(ConfigReader.getProperty("android.app.path"));
              
                driver = new AndroidDriver(url, androidOptions);
                break;
            case "ios":
                iosOptions.setAutomationName("XCUITest")
                          .setDeviceName(ConfigReader.getProperty("ios.device"))
                          .setApp(ConfigReader.getProperty("ios.app.path"));
                driver = new IOSDriver(url, iosOptions);
                break;
            case "browserstack":
                // Logic for BrowserStack/LambdaTest using remote URL and Caps
                break;
        }
        return driver;
    }
}