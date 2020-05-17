package de.uni_hannover.hci.cedric_wellhausen.aufgabe1.items.diskmedia;

public class DVD extends DiskMedia {
	
	/*public DVD(String title, String id, double price) {
		super(title + dvdSuffix, id, price);
	}
	
	public DVD(String title, String id) {
		super(title + dvdSuffix, id, 9.99);
	}*/
	
	public DVD() {
		super();
		this.setPrice(9.99);
		this.setSuffix(" (DVD)");
	}
	
}