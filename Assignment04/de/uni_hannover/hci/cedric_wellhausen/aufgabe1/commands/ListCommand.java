package de.uni_hannover.hci.cedric_wellhausen.aufgabe1.commands;

import de.uni_hannover.hci.cedric_wellhausen.aufgabe1.items.Item;

public class ListCommand implements Command {
	
	private final String invokationName = "list";
	
	private Item[] items;
	
	public ListCommand(Item[] items) {
		this.items = items;
	}
	
	@Override
	public String getInvokationName() {
		return this.invokationName;
	}
	
	@Override
	public boolean execute(String[] args) {
		System.out.println("");
		for(int i = 0; i < this.items.length; i++) {
			System.out.printf("%d: %s\n", i+1, this.items[i]);
		}
		System.out.println("");
		
		return true;
	}
	
}