package de.uni_hannover.hci.cedric_wellhausen.aufgabe1.commands;

import de.uni_hannover.hci.cedric_wellhausen.aufgabe1.items.Item;

public class TakeCommand implements Command {
	
	private final String invokationName = "take";
	private Item[] items;
	
	public TakeCommand(Item[] items) {
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
		
		if(args.length < 1) {
			System.out.println("Not enough arguments!");
			return false;
		}
		
		if(!isNumber(args[0])) {
			System.out.println("Not a Number!");
			return false;
		}
		
		position = Integer.parseInt(args[0]) - 1;
		
		if(this.items[position] == null) {
			System.out.println("There is nothing to take out!");
			return false;
		}
		
		Item item = this.items[position];
		String classname = "----";
		
		try {
			classname = Class.forName(item.getClass().getGenericSuperclass().getTypeName()).getSimpleName();
		} catch(Exception e) {
			return false;
		}
		
		System.out.printf("You have taken the %s \"%s\" with the ISBN-13 \"%s\" out of the inventory. It costs %.2f\n", classname, item.getTitle(), item.getID(), item.getPrice());
		this.items[position] = null;
		
		return true;
		
	}		
	
}