package org.katkielbasa.dimensiondatasimpleapp;

import org.katkielbasa.dimensiondatasimpleapp.model.Server;

public class AddServerCommand extends ServerCommand {


	@Override
	public void run(String...args) {
		Server server = new Server();
		int id = Integer.parseInt(args[1]);
		server.setId(id);
		String name = args[2];
		server.setName(name);
		serService.persistServer(server);
	}

}
