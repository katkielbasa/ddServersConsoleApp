package org.katkielbasa.dimensiondatasimpleapp.dao;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.persistence.NoResultException;

import org.katkielbasa.dimensiondatasimpleapp.model.Server;

public interface ServerDAO {
	
		  void persistServer(Server server);
		  
		  Server findServerById(int id);
		  
		  void updateServer(Server server) throws SQLIntegrityConstraintViolationException, NoResultException;
		  
		  void deleteServer(Server server);
		  
		  List<Server> listAllServers();
		  
		  Long countAllServers(); 
		  
}
