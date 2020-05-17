package de.uni_hannover.hci.cedric_wellhausen.aufgabe1.items;

public interface Addable {
	
	void openAddDialog();
	
	public static void invalidCreation(String reason) {
		System.err.println("Invalid creation of Item. Reason: " + reason);
		System.exit(2);
	}
	
}
	