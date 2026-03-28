package ui.pages;

import org.openqa.selenium.By;

import com.page.utils.MobileUtility;

import io.appium.java_client.AppiumBy;

public class LoginPage extends MobileUtility {
	
	private static  By ACCOUNT_MENU=  AppiumBy.accessibilityId("account button tappable"); 
	
	public void goToAccount() {
	
		click(ACCOUNT_MENU);
		
		
	}
	
}
