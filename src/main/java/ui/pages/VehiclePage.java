package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import ui.base.utils.MobileUtility;

public class VehiclePage extends MobileUtility {

	private static By VEHICLE_MAKE = AppiumBy.xpath("//android.view.View[contains(@content-desc,'Make')]");

	private static String VEHICLE_MAKE_NAME = "%s";
	private static String VEHICLE_MODEL_NAME = "%s";

	private static By VEHICLE_SAVE_BUTTON = AppiumBy.accessibilityId("Save");

	// Adaptors Locator
	private static String ADAPTOR_MODEL_NAME = "%s";

	public void make(String makeName, String modelName) {
		makeAndModel(makeName, modelName);
	}

	public VehiclePage model(String makeName, String modelName) {
		makeAndModel(makeName, modelName);
		return this;
	}

	public VehiclePage adapter(String adapterText) {
		By locator = AppiumBy.accessibilityId(String.format(ADAPTOR_MODEL_NAME, adapterText));

		// Get height before click
		WebElement elBefore = scrollTo(locator);
		int heightBefore = elBefore.getSize().getHeight();

		elBefore.click();

		// Re-find to get fresh height after click
		WebElement elAfter = driver.findElement(locator);
		int heightAfter = elAfter.getSize().getHeight();

		String status = (heightAfter > heightBefore) ? "Selected" : "Not Selected";

		Assert.assertEquals(status, "Selected",
				String.format("Adaptor %s was not selected (Height didn't increase)", adapterText));

		return this;
	}

	public VehiclePage makeAndModel(String makeName, String modelName) {
		click(VEHICLE_MAKE);
		// 1. Implement logic select car make from list of results
		WebElement vehicleMakeName = scrollTo(AppiumBy.accessibilityId(String.format(VEHICLE_MAKE_NAME, makeName)));
		vehicleMakeName.click();

		// 2. Implement logic to select model from list of results
		WebElement vehicleModelName = scrollTo(AppiumBy.accessibilityId(String.format(VEHICLE_MODEL_NAME, modelName)));
		vehicleModelName.click();

		return this;
	}

	public MapScreenPage saveVehicleDetails() {
		click(VEHICLE_SAVE_BUTTON);
		return new MapScreenPage();
	}

}
