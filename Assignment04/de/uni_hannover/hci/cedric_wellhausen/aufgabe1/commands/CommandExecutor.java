package de.uni_hannover.hci.cedric_wellhausen.aufgabe1.commands;

import java.util.ArrayList;
import java.util.Arrays;

public class CommandExecutor {
	
	private ArrayList<Command> commands;
	
	public CommandExecutor() {
		this.unregisterAll();
	}
	
	public void registerCommand(Command command) {
		this.commands.add(command);
	}
	
	public void unregisterAll() {
		this.commands = new ArrayList<Command>();
	}
	
	public boolean invoke(String[] commandWithArgs) {
		
		if(commandWithArgs.length < 1) return false;
		
		for(Command c : this.commands) {
			if(c.getInvokationName().equals(commandWithArgs[0])) {
				c.execute(Arrays.copyOfRange(commandWithArgs, 1, commandWithArgs.length));
				return true;
			}
		}
		
		return false;
	}
	
}
	