package de.uni_hannover.hci.cedric_wellhausen.aufgabe1.commands;

import de.uni_hannover.hci.cedric_wellhausen.aufgabe1.items.Item;
import de.uni_hannover.hci.cedric_wellhausen.aufgabe1.items.Addable;

import de.uni_hannover.hci.cedric_wellhausen.aufgabe1.items.books.Paperback;
import de.uni_hannover.hci.cedric_wellhausen.aufgabe1.items.books.Hardback;

import de.uni_hannover.hci.cedric_wellhausen.aufgabe1.items.diskmedia.CD;
import de.uni_hannover.hci.cedric_wellhausen.aufgabe1.items.diskmedia.DVD;
import de.uni_hannover.hci.cedric_wellhausen.aufgabe1.items.diskmedia.BlueRay;

public class AddCommand implements Command {
	
	private enum SupportedItem {
		PAPERBACK(Paperback.class),
		HARDBACK(Hardback.class),
		CD(CD.class),
		DVD(DVD.class),
		BLUERAY(BlueRay.class);
		
		private Class<?> associatedClass;
		
		SupportedItem(Class<?> c) {
			this.associatedClass = c;
		}
		
		public Item getNewInstance() throws Exception {
			return (Item) this.associatedClass.newInstance();
		}
	}
	
	private final String invokationName = "add";
	private Item[] items;
	
	
	public AddCommand(Item[] items) {
		this.items = items;
	}

	private boolean isNumber(String s) {
		for(char c : s.toCharArray()) {
			if(c < '0' || c > '9') return false; 
		}
		
		return true;
	}

	@Override
	public String getInvokationName() {
		return this.invokationName;
	}
	
	
	@Override
	public boolean execute(String[] args) {
		int position;
		Item item = null;
		
		if(args.length < 2) {
			 System.out.println("Not enough arguments!\n");
			 return false;
		}
		
		if(!isNumber(args[0])) {
			System.out.println("Not a Number!\n");
			return false;
		}
		
		position = Integer.parseInt(args[0]) - 1;
		
		if(this.items[position] != null) {
			System.out.println("Inventory slot already taken!\n");
			return false;
		}
		
		for(SupportedItem si : SupportedItem.values()) {
			if(si.name().equalsIgnoreCase(args[1])) {
				try {
					item = si.getNewInstance();
					item.openAddDialog();
				} catch(Exception e) {
					return false;
				}
			}
		}
		
		for(Item i : this.items) {
			if(i != null && i.getID().equals(item.getID())) {
				Addable.invalidCreation("ID duplicate.");
				return false;
			}
		}
		
		this.items[position] = item;
		
		System.out.println("");
		return true;
	}
	
}
	