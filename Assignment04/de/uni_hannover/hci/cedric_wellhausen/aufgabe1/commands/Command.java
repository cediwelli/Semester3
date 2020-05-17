package de.uni_hannover.hci.cedric_wellhausen.aufgabe1.commands;

public interface Command {
	
	String getInvokationName();
	boolean execute(String[] args);
	
}
	