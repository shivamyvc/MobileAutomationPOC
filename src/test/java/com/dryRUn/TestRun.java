package com.dryRUn;

import org.testng.annotations.Test;

import com.test.utils.BaseTest;

import ui.pages.LoginPage;
import ui.pages.MapScreenPage;

public class TestRun extends BaseTest{

	@Test(description = "Select Location")
	public void testRun1() {
		MapScreenPage MapHome= new MapScreenPage();
		 MapHome.goToSearch("New York").select("New York");
	}
	
	
	@Test(description = "Add Vehicle & adaptor details")
	public void testRun2() {
		MapScreenPage MapHome= new MapScreenPage();
		MapHome.goToAccount().vehicle().makeAndModel("Tesla","Model 3").adapter("CCS").adapter("J-1772");
	}
	
	
	@Test(description = "Add payment method details")
	public void testRun3() {
		MapScreenPage MapHome= new MapScreenPage();
		MapHome.goToAccount().payment();
	}
	

}
