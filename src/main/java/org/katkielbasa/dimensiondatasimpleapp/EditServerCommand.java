package org.katkielbasa.dimensiondatasimpleapp;

import org.katkielbasa.dimensiondatasimpleapp.model.Server;

public class EditServerCommand extends ServerCommand {



	@Override
	public void run(String...args) {
		int id = Integer.parseInt(args[1]); 
		Server server = null;
		server = serService.findServerById(id);
		server.setName(args[2]);
		serService.updateServer(server);
	
	}

}
