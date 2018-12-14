package org.katkielbasa.dimensiondatasimpleapp.dao;

import java.util.List;

import org.katkielbasa.dimensiondatasimpleapp.model.Server;

public interface ServerDAO {
	
		  void persistServer(Server server);
		  
		  Server findServerById(String id);
		  
		  void updateServer(Server server);
		  
		  void deleteServer(Server server);
		  
		  List<Server> listAllServers();
		  
		  Long countAllServers(); 
		  
}
