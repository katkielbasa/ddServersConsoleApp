package org.katkielbasa.dimensiondatasimpleapp;

import java.util.List;

import org.katkielbasa.dimensiondatasimpleapp.model.Server;

public class ListServersCommand extends ServerCommand {
	private StringBuffer listToPrint = new StringBuffer();

	@Override
	public void run(String... args) {
		List<Server> servers = serService.listAllServers();
		listToPrint.append("-----CURRENT SERVERS------\n");
		for (Server server : servers) {
			int record = servers.indexOf(server) + 1;
			listToPrint.append("record: " + record + "  id: " + server.getId() + "; name: " + server.getName() + ";\n");
		}
		System.out.print(listToPrint.toString());
	}



}
