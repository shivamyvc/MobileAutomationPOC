package ui.pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;

public class AccountPage extends MapScreenPage{
	
	protected static  String PROFILE_BUTTON= "//android.widget.ScrollView[contains(@content-desc,'%s')]";
	
	protected static By VEHICLE_BUTTON= AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc,'Vehicle')]");
	
	protected static By PAYMENT_BUTTON= AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc,'Payment method')]");
	
	public void profile(String profileText) {
		click(AppiumBy.xpath(String.format(profileText,PROFILE_BUTTON)));
		
		//Return Profile Object

	}
	
	public VehiclePage vehicle() {
		click(VEHICLE_BUTTON);
		return new VehiclePage();
	}
	
	public void payment() {
		// Action to click on Payment
		click(PAYMENT_BUTTON);
		System.out.println("Payment Method Completed");
		// Payment Module flow
	}
	
}
