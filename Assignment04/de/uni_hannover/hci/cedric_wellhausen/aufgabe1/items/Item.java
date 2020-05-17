package de.uni_hannover.hci.cedric_wellhausen.aufgabe1.items;


public class Item implements Addable {
	
	protected String suffix = "";
	
	protected String title;
	protected String id;
	protected double price;
	
	
	/*public Item(String title, String id, double price) {
		this.title = title;
		this.id = id;
		this.price = price;
	}*/
	
	protected Item() {
		
	}
	

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return this.title + this.suffix;
	}

	public void setID(String id) {
		this.id = id;
	}
	
	public String getID() {
		return this.id;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	protected void setSuffix(String s) {
		this.suffix = s;
	}
	
	@Override
	public String toString() {
		return this.getTitle() + " [" + this.getID() + "], " + this.getPrice() + "EUR";
	}
	
	@Override
	public void openAddDialog() {}
	
}