package de.uni_hannover.hci.cedric_wellhausen.aufgabe1.items.diskmedia;

import de.uni_hannover.hci.cedric_wellhausen.aufgabe1.items.Addable;
import de.uni_hannover.hci.cedric_wellhausen.aufgabe1.items.Item;
import java.util.Scanner;

public class DiskMedia extends Item {
	
	/*public DiskMedia(String title, String id, double price) {
		super();
		
		this.setTitle(title);
		this.setID(id);
		this.setPrice(price);
	}*/
	
	public DiskMedia() {
		super();
	}
	
	private boolean isASIN(String s) {
		if(s.length() != 10) return false;
		
		for(char c : s.toCharArray()) {
			if( (c < '0' && c > '9') || (c < 'A' && c > 'Z') || (c < 'a' && c > 'z') ) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public void setID(String asin) {
		if(this.isASIN(asin)) {
			this.id = asin;
		}
		else {
			Addable.invalidCreation(asin + " is not an ASIN.");
		}
	}
	
	@Override
	public void openAddDialog() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.printf("Please enter the title: ");
		this.setTitle(scanner.nextLine());
		
		System.out.printf("Please enter the ASIN code: ");
		this.setID(scanner.nextLine());
		
		System.out.printf("Please enter the price (d for default): ");
		String price = scanner.nextLine();
		
		if(!price.equalsIgnoreCase("d")) {
			this.setPrice(Double.parseDouble(price));
		}
	}
	
}