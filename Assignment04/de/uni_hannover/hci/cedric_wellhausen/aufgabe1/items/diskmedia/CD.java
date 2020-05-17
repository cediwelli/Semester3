package de.uni_hannover.hci.cedric_wellhausen.aufgabe1.items.diskmedia;

public class CD extends DiskMedia {
	
	/*public CD(String title, String id, double price) {
		super(title, id, price);
	}
	
	public CD(String title, String id) {
		super(title, id, 8.99);
	}*/
	
	public CD() {
		super();
		this.setPrice(8.99);
		this.setSuffix(" (CD)");
	}
	
}