package org.katkielbasa.dimensiondatasimpleapp.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.persistence.NoResultException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.katkielbasa.dimensiondatasimpleapp.DimensiondatasimpleappApplicationTests;
import org.katkielbasa.dimensiondatasimpleapp.dao.ServerDAO;
import org.katkielbasa.dimensiondatasimpleapp.model.Server;
import org.katkielbasa.dimensiondatasimpleapp.utils.DataSourceConfigTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = {
		  DimensiondatasimpleappApplicationTests.class, 
		  DataSourceConfigTest.class})
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class ServerTestService {
 
    @TestConfiguration
    static class ServerServiceImplTestContextConfiguration {
  
        @Bean
        public ServerService serverService() {
            return new ServerServiceImpl();
        }
    }
 
    @Autowired
    private ServerService serverService;
    
    @MockBean
    private ServerDAO serverRepository;
 
  
    @Test
    @Transactional
    public void testServerFunctions()
    {
    	//setting Up
    	 Server ser1 = new Server();
         ser1.setId(1);
         ser1.setName("ser1");
         
         Server ser2 = new Server();
         ser2.setId(2);
         ser2.setName("ser2");
         
         Server ser3 = new Server();
         ser3.setId(3);
         ser3.setName("ser3");
         
         Server ser4 = new Server();
         ser4.setId(1);
         ser4.setName("ser4"); 
       //add
        serverService.persistServer(ser1);
        serverService.persistServer(ser2);
        serverService.persistServer(ser3);

         //listAll
        List<Server> servers = serverService.listAllServers();
        Assert.assertEquals(ser1.getName(), servers.get(0).getName());
        Assert.assertEquals(ser2.getName(), servers.get(1).getName());
        Assert.assertEquals(ser3.getName(), servers.get(2).getName());
        //override and count
        Long count = serverService.countAllServers();
        Assert.assertEquals(count, servers.size(),0);
        
        serverService.persistServer(ser4);
      
        Long count2 = serverService.countAllServers();
        Assert.assertNotEquals(ser1.getName(), servers.get(0).getName());
        Assert.assertNotEquals(ser4.getName(), servers.get(2).getName());
        Assert.assertEquals(count, count2, 0);
        
        Assert.assertEquals(serverService.findServerById(1).getName(), ser4.getName());
        //edit
        try {
			serverService.updateServer(ser1);
		} catch (SQLIntegrityConstraintViolationException|NoResultException e) {
			e.printStackTrace();
		}

        Assert.fail("Passing existing ID when update will make it fail ");
        
        //delete
        serverService.deleteServer(ser2);
        Long count3 = serverService.countAllServers();
        Assert.assertEquals(count3, count2, 1);
        List<Server> servers2 = serverService.listAllServers();
        Assert.assertNotEquals(ser2.getName(), servers2.get(1).getName());

    }
     
  
}

