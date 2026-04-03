package ui.pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import ui.base.utils.MobileUtility;

public class MapScreenPage extends MobileUtility{
	private static  By ACCOUNT_MENU=  AppiumBy.accessibilityId("account button tappable"); 
	private static By MAP_SEARCH_BUTTON= AppiumBy.accessibilityId("On map button - search");
	
	public AccountPage goToAccount() {
		click(ACCOUNT_MENU);
		return new AccountPage();
	}
	
	public SearchPage goToSearch(String searchString) {
		click(MAP_SEARCH_BUTTON);
		return new SearchPage();
	}
	
	public void goToStation(String stationText) {
		//Implement horizontal scrolling common for Android and iSO both
		//Select the station name return the object of Station class
	}
	
	

}
