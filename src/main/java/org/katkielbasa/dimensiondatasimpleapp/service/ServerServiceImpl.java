package org.katkielbasa.dimensiondatasimpleapp.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.katkielbasa.dimensiondatasimpleapp.dao.ServerDAO;
import org.katkielbasa.dimensiondatasimpleapp.dao.ServerDAOImpl;
import org.katkielbasa.dimensiondatasimpleapp.model.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("serverService")
public class ServerServiceImpl implements ServerService{

	@Autowired
	private ServerDAO serverDAO;
	
	static Logger log = LogManager.getLogger(ServerServiceImpl.class);

	
	@Override
	@Transactional
	public void persistServer(Server server) {
		serverDAO.persistServer(server);
		
	}

	@Override
	@Transactional
	public void updateServer(Server server) {
		serverDAO.updateServer(server);
	}
	
	@Override
	@Transactional
	public Server findServerById(String id) {
		return serverDAO.findServerById(id);
	}

	@Override
	@Transactional
	public void deleteServer(Server server) {
		serverDAO.deleteServer(server);	
	}

	@Override
	public List<Server> listAllServers() {
		List<Server> servers = serverDAO.listAllServers();
//				servers.forEach((server) -> {
//					System.out.println(server.getId() + "||" +server.getName());
//					}	
				return servers;
	}

	@Override
	public Long countAllServers() {
		return serverDAO.countAllServers();
	}

}
