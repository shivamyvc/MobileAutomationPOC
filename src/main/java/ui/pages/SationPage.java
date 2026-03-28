package ui.pages;

public class SationPage extends MapScreenPage {

	public SationPage connector(String connectorText) {
		// Implement Connector Selection logic
		System.out.println(String.format("Connector % is selected", connectorText));
		return this;
	}

	public SationPage scanQR() {
		// implement logic for scanning QR Code
		System.out.println("QR Code Scanned ");
		return this;
	}

	public void swipeAndCharge() {
		// Logic to swipe
		System.out.println("Charging started");
	}

}
