package com.drivers;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;

public class DriverFactory {
    public static AppiumDriver createInstance(String platform) throws MalformedURLException {
        AppiumDriver driver = null;
        UiAutomator2Options androidOptions = new UiAutomator2Options();
        XCUITestOptions iosOptions = new XCUITestOptions();
        URL url = new URL("http://127.0.0.1:4723/");

        switch (platform.toLowerCase()) {
            case "android":
                androidOptions.setAutomationName("UiAutomator2")
                             .setDeviceName(ConfigReader.getProperty("android.device"))  //
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