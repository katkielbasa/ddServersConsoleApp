package org.katkielbasa.dimensiondatasimpleapp.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.persistence.NoResultException;

import org.katkielbasa.dimensiondatasimpleapp.model.Server;

public interface ServerService {

	void persistServer(Server server);

	Server findServerById(int id);

	void updateServer(Server server)
			throws NoResultException, IllegalStateException, SQLIntegrityConstraintViolationException;

	void deleteServer(Server server);

	List<Server> listAllServers();

	Long countAllServers();

}
