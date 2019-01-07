package org.katkielbasa.dimensiondatasimpleapp.service;

import java.util.List;

import org.katkielbasa.dimensiondatasimpleapp.model.Server;

public interface ServerService {

	void persistServer(Server server);

	Server findServerById(int id);

	void updateServer(Server server);

	void deleteServer(Server server);

	List<Server> listAllServers();

	Long countAllServers();

}
