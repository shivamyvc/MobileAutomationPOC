package com.dryRUn;

import org.testng.annotations.Test;

import com.test.utils.BaseTest;

import ui.pages.LoginPage;
import ui.pages.MapScreenPage;

public class TestRun extends BaseTest{

	@Test(description = "Select Location",enabled = false)
	public void testRun1() {
		MapScreenPage MapHome= new MapScreenPage();
		 MapHome.goToSearch("New York").select("New York");
	}
	
	
	@Test(description = "Add Vehicle & adaptor details",enabled = false)
	public void testRun2() {
		MapScreenPage MapHome= new MapScreenPage();
		MapHome.goToAccount().vehicle().makeAndModel("Tesla","Model 3").adapter("CCS").adapter("J-1772");
	}
	
	
	@Test(description = "Add payment method details",enabled = false)
	public void testRun3() {
		MapScreenPage MapHome= new MapScreenPage();
		MapHome.goToAccount().payment();
	}
	
	
	@Test(description = "Scroll and select vehichle details")
	public void testRun4() {
		MapScreenPage MapHome= new MapScreenPage();
		MapHome.goToAccount().vehicle().makeAndModel("Volkswagen", "ID.4").adapter("CHAdeMO").saveVehicleDetails();
	}
	

}
