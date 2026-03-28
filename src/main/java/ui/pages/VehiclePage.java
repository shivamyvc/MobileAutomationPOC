package ui.pages;

import com.page.utils.MobileUtility;

public class VehiclePage extends MobileUtility{
	
	public void make(String makeName, String modelName) {
		makeAndModel(makeName, modelName);
	}
	
	
	public VehiclePage model(String makeName, String modelName) {
		makeAndModel(makeName, modelName);
		return this;
	}
	
	public VehiclePage adapter(String adapterText) {
		// Adaptor selections
		System.out.println(String.format("Adapter %s is selected", adapterText));
		
		// save Vehicle details
		return this;
	}
	
	public VehiclePage makeAndModel(String makeName, String modelName) {
		//1. Implement logic select car make from list of results
		//2. Implement logic to select model from list of results
		return this;
	}
	


}
