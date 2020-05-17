package de.uni_hannover.hci.cedric_wellhausen.aufgabe1;

import de.uni_hannover.hci.cedric_wellhausen.aufgabe1.commands.CommandExecutor;
import de.uni_hannover.hci.cedric_wellhausen.aufgabe1.commands.AddCommand;
import de.uni_hannover.hci.cedric_wellhausen.aufgabe1.commands.ListCommand;
import de.uni_hannover.hci.cedric_wellhausen.aufgabe1.commands.TakeCommand;

import de.uni_hannover.hci.cedric_wellhausen.aufgabe1.items.Item;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		Item[] items = new Item[5];
	
		CommandExecutor commandExecutor = new CommandExecutor();
		commandExecutor.registerCommand(new AddCommand(items));
		commandExecutor.registerCommand(new ListCommand(items));
		commandExecutor.registerCommand(new TakeCommand(items));
		
		while(true) {
			
			System.out.printf("Please enter your command: ");
			
			String input = scanner.nextLine();
			String[] splittedInput = input.split(" ");
			
			if(!commandExecutor.invoke(splittedInput))
				System.out.println("Unkown command!");
		}
		
		
		
	}
}