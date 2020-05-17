package de.uni_hannover.hci.cedric_wellhausen.aufgabe1.items.books;

import de.uni_hannover.hci.cedric_wellhausen.aufgabe1.items.Addable;
import de.uni_hannover.hci.cedric_wellhausen.aufgabe1.items.Item;
import java.util.Scanner;

public class Book extends Item {
	
	protected String suffix = " (NULL Edition)";
	
	public Book(String title, String id, double price) {
		super();
		
		this.setTitle(title);
		this.setID(id);
		this.setPrice(price);
	}
	
	public Book() {
		super();
	}
	
	protected boolean isISBN(String s) {
		
		int len = 0;
		
		for(int k = 0; k < s.length(); k++) {
			char c = s.charAt(k);
			
			if((c >= '0' && c <= '9')) {
				len++;
				continue;
			}
			if(c == '-') continue;
			
			return false;
		}
		
		return len == 13 || len == 10;
	}
	
	@Override
	public void setID(String isbn) {
		if(this.isISBN(isbn)) {
			this.id = isbn;
		}
		else {
			Addable.invalidCreation(isbn + " is not an ISBN.");
		}
	}
	
	@Override
	public void openAddDialog() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.printf("Please enter the title: ");
		this.setTitle(scanner.nextLine());
		
		System.out.printf("Please enter the ISBN-13 code: ");
		this.setID(scanner.nextLine());
		
		System.out.printf("Please enter the price (d for default): ");
		String price = scanner.nextLine();
		
		if(!price.equalsIgnoreCase("d")) {
			this.setPrice(Double.parseDouble(price));
		}
	}
	
}