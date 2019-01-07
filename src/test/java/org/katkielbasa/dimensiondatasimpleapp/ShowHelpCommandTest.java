package org.katkielbasa.dimensiondatasimpleapp;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ShowHelpCommandTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private String helpText = 
			"type \"help\" to display this message again\n"
			+ "type \"count\" to display the current number of servers present\n"
			+ "type \"add\" \"<id>\" \"<name>\" to display the current number of servers present\n"
			+ "type \"edit\" \"<idToEdit>\" \"<newName>\" to change the name of a server identified by id\n"
			+ "type \"delete\" \"<id>\" to delete a server\n"
			+ "type \"list\" to display details of all servers servers\n"
			+ "type \"import <pathToServer>\" to upload the servers from XML file\n"
			+ "type \"quit\" to exit\n";

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}

	@After
	public void restoreStreams() {
	    System.setOut(originalOut);
	}
	
	@Test
	public void testRun() {
		ShowHelpCommand sc = new ShowHelpCommand();
		sc.run(null);
	    assertEquals(helpText, outContent.toString());
	}


}
