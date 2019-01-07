package org.katkielbasa.dimensiondatasimpleapp.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.katkielbasa.dimensiondatasimpleapp.model.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("serverDAO")
public class ServerDAOImpl implements ServerDAO {

	static Logger log = LogManager.getLogger(ServerDAOImpl.class);
	
    private SessionFactory sessionFactory;

    @Autowired 
    public ServerDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
	@Override
	public void persistServer(Server server) {
        sessionFactory.getCurrentSession().saveOrUpdate(server);
		log.info("Server created with id: {} and name: {} ", server.getId(), server.getName()); 
    }   

	@Override
	public Server findServerById(int id){
		log.info("Looking for server with id: " + id); 
        TypedQuery<Server> query;
        query = sessionFactory.getCurrentSession().getNamedQuery("findServerById");  
        query.setParameter("id", id);
        Server server = query.getSingleResult();
        log.info("Returned server with id:{} and name{}", server.getId(), server.getName()); 
        return server;
	}
	
	@Override
	public void updateServer(Server server){
		sessionFactory.getCurrentSession().update(server);
		log.info("server with new a name: {} and id: {} updated: ", server.getName(),server.getId()); 

	}
	@Override
	public void deleteServer(Server server) {
		sessionFactory.getCurrentSession().delete(server);
		log.info("server with a name: {} and id: {} deleted: ", server.getName(),server.getId()); 
	}

	@Override
	public List<Server> listAllServers() {
		List<Server> resultList = (List<Server>)sessionFactory.getCurrentSession().getNamedQuery("findAllServers").getResultList();
		List<Server> servers= resultList;
		return servers;
	}

	@Override
	public Long countAllServers() {
		Long numberOfServers = (Long) sessionFactory.getCurrentSession().getNamedQuery("countAllServers").uniqueResult();
		return  numberOfServers;
	}



}