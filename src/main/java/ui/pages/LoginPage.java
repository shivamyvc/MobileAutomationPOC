package ui.pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import ui.base.utils.MobileUtility;

public class LoginPage extends MobileUtility {
	
	private static  By ACCOUNT_MENU=  AppiumBy.accessibilityId("account button tappable"); 
	
	public void goToAccount() {
	
		click(ACCOUNT_MENU);
		
		
	}
	
}
