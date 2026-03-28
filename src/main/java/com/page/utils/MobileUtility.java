package com.page.utils;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.drivers.DriverFactory;
import com.drivers.DriverManager;
import com.utils.ConfigReader;

import io.appium.java_client.AppiumDriver;

public abstract class MobileUtility {

	protected AppiumDriver driver;
	protected ThreadLocal<WebDriverWait> wait = new ThreadLocal<WebDriverWait>();

	public MobileUtility() {

		this.driver = DriverManager.getDriver();
		this.wait.set(new WebDriverWait(driver, Duration.ofSeconds(35)));
	}

	protected void click(By by) {
		wait.get().until(ExpectedConditions.elementToBeClickable(by)).click();
	}

	protected void type(By by, String textString) {
		WebElement el = wait.get().until(ExpectedConditions.visibilityOfElementLocated(by));
		el.clear();
		el.sendKeys(textString);

	}

}
