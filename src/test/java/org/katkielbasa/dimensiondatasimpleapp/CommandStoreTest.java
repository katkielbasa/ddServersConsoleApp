package org.katkielbasa.dimensiondatasimpleapp;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class CommandStoreTest {

	@Test
	public void testGetCommand()  {
		
		Class<?> cmd1 = CommandStore.getCommand("HELP");
		assertThat(cmd1).isEqualTo(ShowHelpCommand.class);

		Class<?> cmd2 = CommandStore.getCommand("LIST");
		assertThat(cmd2).isEqualTo(ListServersCommand.class);

		Class<?> cmd4 = CommandStore.getCommand("ADD");
		assertThat(cmd4).isEqualTo(AddServerCommand.class);
		
		Class<?> cmd5 = CommandStore.getCommand("COUNT");
		assertThat(cmd5).isEqualTo(CountServersCommand.class);

		Class<?> cmd6 = CommandStore.getCommand("EDIT");
		assertThat(cmd6).isEqualTo(EditServerCommand.class);
		
		Class<?> cmd7 = CommandStore.getCommand("DELETE");
		assertThat(cmd7).isEqualTo(DeleteServerCommand.class);
		
		Class<?> cmd8 = CommandStore.getCommand("IMPORT");
		assertThat(cmd8).isEqualTo(ImportFromXMLCommand.class);
		
		Class<?> cmd9 = CommandStore.getCommand("QUIT");
		assertThat(cmd9).isEqualTo(QuitCommand.class);
	}

	

}
