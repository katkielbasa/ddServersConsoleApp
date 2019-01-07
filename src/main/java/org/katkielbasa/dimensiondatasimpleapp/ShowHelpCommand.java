package org.katkielbasa.dimensiondatasimpleapp;

public class ShowHelpCommand extends ServerCommand {
	private String helpText = 
			"type \"help\" to display this message again\n"
			+ "type \"count\" to display the current number of servers present\n"
			+ "type \"add\" \"<id>\" \"<name>\" to display the current number of servers present\n"
			+ "type \"edit\" \"<idToEdit>\" \"<newName>\" to change the name of a server identified by id\n"
			+ "type \"delete\" \"<id>\" to delete a server\n"
			+ "type \"list\" to display details of all servers servers\n"
			+ "type \"import <pathToServer>\" to upload the servers from XML file\n"
			+ "type \"quit\" to exit\n";

	@Override
	public void run(String...args) {
		showHelp();
	}

	private void showHelp() {
		System.out.print(helpText);

	}

}
