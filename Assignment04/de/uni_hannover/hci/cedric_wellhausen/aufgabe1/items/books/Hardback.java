package de.uni_hannover.hci.cedric_wellhausen.aufgabe1.items.books;

public class Hardback extends Book {

	/*public Hardback(String title, String id, double price) {
		super(title + hardbackSuffix, id, price);
	}
	
	public Hardback(String title, String id) {
		super(title + hardbackSuffix, id, 12.99);
	}*/
	
	public Hardback() {
		super();
		this.setPrice(12.99);
		this.setSuffix(" (Hardback Edition)");
	}
	
}