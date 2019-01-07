package org.katkielbasa.dimensiondatasimpleapp;

import java.util.HashMap;
import java.util.Map;

public class CommandStore {
    
	private static final Map<String, Class<?>> providers;
	static {
		providers = new HashMap<String, Class<?>>();
		providers.put(Command.ADD.toString(), AddServerCommand.class);
		providers.put(Command.DELETE.toString(), DeleteServerCommand.class);
		providers.put(Command.LIST.toString(), ListServersCommand.class);
		providers.put(Command.HELP.toString(), ShowHelpCommand.class);
		providers.put(Command.IMPORT.toString(), ImportFromXMLCommand.class);
		providers.put(Command.COUNT.toString(), CountServersCommand.class);
		providers.put(Command.QUIT.toString(), QuitCommand.class);
		providers.put(Command.EDIT.toString(), EditServerCommand.class);
	}
	
	public static Class<?> getCommand(String name) {
		return  providers.get(name);
	}
    
}