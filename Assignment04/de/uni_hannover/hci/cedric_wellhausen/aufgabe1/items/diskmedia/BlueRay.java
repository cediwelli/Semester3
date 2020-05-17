package de.uni_hannover.hci.cedric_wellhausen.aufgabe1.items.diskmedia;

public class BlueRay extends DiskMedia {
	
	/*public BlueRay(String title, String id, double price) {
		super(title + blueraySuffix, id, price);
	}
	
	public BlueRay(String title, String id) {
		super(title + blueraySuffix, id, 12.99);
	}*/
	
	public BlueRay() {
		super();
		this.setPrice(12.99);
		this.setSuffix(" (BD)");
	}
	
}