package org.katkielbasa.dimensiondatasimpleapp;

import org.katkielbasa.dimensiondatasimpleapp.model.Server;

public class DeleteServerCommand extends ServerCommand {



	@Override
	public void run(String...args) {
		int id = Integer.parseInt(args[1]);
		Server server = serService.findServerById(id);
		serService.deleteServer(server);
	}

}
