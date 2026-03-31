package com.drivers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import com.utils.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {

    public static AppiumDriver createInstance(String platform) {
        URL url = getAppiumServerUrl();

        try {
            switch (platform.toLowerCase()) {
                case "android":
                    return new AndroidDriver(url, getAndroidOptions());
                case "ios":
                    return new IOSDriver(url, getIosOptions());
                case "browserstack":
                    // return new AndroidDriver(remoteUrl, getBrowserStackOptions());
                    throw new UnsupportedOperationException("BrowserStack logic not implemented yet.");
                default:
                    throw new IllegalArgumentException("Unsupported platform: " + platform);
            }
        } catch (Exception e) {
            // Fix: Changed % to %s and added the cause (e) for better debugging
            throw new RuntimeException(String.format("Failed to create driver instance for %s", platform), e);
        }
    }

    private static UiAutomator2Options getAndroidOptions() {
        return new UiAutomator2Options()
                .setAutomationName("UiAutomator2")
                .setDeviceName(ConfigReader.getProperty("android.device"))
                .setPlatformVersion(ConfigReader.getProperty("android.platform.version"))
                .setApp(ConfigReader.getProperty("android.app.path"))
                .setAppActivity(ConfigReader.getProperty("android.app.main.activity"))
                .setAppWaitActivity("*")
                .setAutoGrantPermissions(true)
                .setNoReset(true)
                .setNewCommandTimeout(Duration.ofSeconds(1500))
                .setGpsEnabled(true);
    }

    private static XCUITestOptions getIosOptions() {
        return new XCUITestOptions()
                .setAutomationName("XCUITest")
                .setDeviceName(ConfigReader.getProperty("ios.device"))
                .setApp(ConfigReader.getProperty("ios.app.path"))
                .setNoReset(true);
    }


	private static URL getAppiumServerUrl() {
        try {
            // Good idea to move this URL to config file too!
            return new URL(ConfigReader.getProperty("appium.server.url"));
        } catch (MalformedURLException e) {
            throw new RuntimeException("Appium Server URL is invalid", e);
        }
    }
}
