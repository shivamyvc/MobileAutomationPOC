package com.page.utils;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
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

	protected boolean isElementVisible(By by) {
	    try {
	        // Increase duration; 1s is often too short for mobile transitions
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	        
	        // This method waits for the element to be present AND displayed
	        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	        
	        // If we reach this line, the element is visible
	        return element != null; 
	    } catch (TimeoutException | NoSuchElementException e) {
	        // Return false instead of crashing the test
	        return false;
	    }
	}

	public WebElement scrollTo(By by) {
	    int maxScrolls = 5; // Prevent infinite loops
	    int scrollCount = 0;

	    while (scrollCount < maxScrolls) {
	        if (isElementVisible(by)) {
	            return driver.findElement(by); // Element found and visible, exit method
	        }
	        performScrollDown();
	        scrollCount++;
	    }
	    throw new RuntimeException("Element not found after " + maxScrolls + " scrolls: " + by.toString());
	}

	public void performScrollDown() {
	    Dimension size = driver.manage().window().getSize();
	    int startX = size.getWidth() / 2;
	    int startY = (int) (size.getHeight() * 0.7); // Start at 80% height (bottom)
	    int endY = (int) (size.getHeight() * 0.3);   // End at 20% height (top)

	    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	    Sequence scroll = new Sequence(finger, 1);

	    scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
	    scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	    scroll.addAction(finger.createPointerMove(Duration.ofMillis(800), PointerInput.Origin.viewport(), startX, endY));
	    scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	    driver.perform(Collections.singletonList(scroll));
	}




	}


