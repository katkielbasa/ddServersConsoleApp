package org.katkielbasa.dimensiondatasimpleapp.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.persistence.NoResultException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.katkielbasa.dimensiondatasimpleapp.dao.ServerDAO;
import org.katkielbasa.dimensiondatasimpleapp.model.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("serverService")
public class ServerServiceImpl implements ServerService{

	@Autowired
	private ServerDAO serverDAO;
	
	static Logger log = LogManager.getLogger(ServerServiceImpl.class);

	
	@Override
	@Transactional
	public void persistServer(Server server)  {
		serverDAO.persistServer(server);	
	}

	@Override
	@Transactional
	public void updateServer(Server server) throws SQLIntegrityConstraintViolationException, NoResultException {
		serverDAO.updateServer(server);
	}
	
	@Override
	@Transactional
	public Server findServerById(int id) {
		return serverDAO.findServerById(id);
	}

	@Override
	@Transactional
	public void deleteServer(Server server) {
		serverDAO.deleteServer(server);	
	}

	@Override
	@Transactional
	public List<Server> listAllServers() {
		List<Server> servers = serverDAO.listAllServers();
				return servers;
	}

	@Override
	@Transactional
	public Long countAllServers() {
		return serverDAO.countAllServers();
	}

}
