package ui.pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;

public class SearchPage extends MapScreenPage {
	
	protected static By ANDROID_SEARCH_BOX= AppiumBy.className("android.widget.EditText");
	
	protected static String SERACH_RESULT= "//android.widget.ImageView[contains(@content-desc,'%s')]";
	
	public void select(String searchString) {
		
		type(ANDROID_SEARCH_BOX, searchString);
		
		click(AppiumBy.xpath(String.format(SERACH_RESULT,searchString)));
	}
	
	

}
