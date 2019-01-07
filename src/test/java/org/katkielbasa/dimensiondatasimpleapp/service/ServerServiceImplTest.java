package org.katkielbasa.dimensiondatasimpleapp.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.katkielbasa.dimensiondatasimpleapp.dao.ServerDAO;
import org.katkielbasa.dimensiondatasimpleapp.dao.ServerDAOImpl;
import org.katkielbasa.dimensiondatasimpleapp.model.Server;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ServerServiceImplTest {

	@Mock
	ServerDAO serverDAO = mock(ServerDAOImpl.class);;

	@InjectMocks
	ServerServiceImpl serverServiceImpl;

	@Test
	public void shouldFindServerById() {
		Server server = new Server();
		server.setId(3);
		server.setName("serverxxx");
		when(serverDAO.findServerById(3)).thenReturn(server);
		
		Server foundServer = serverServiceImpl.findServerById(3);

		assertThat(foundServer.getName()).isEqualTo("serverxxx");
	}

	@Test
	public void shouldAddServer() {
		// given
		Server server = new Server();
		server.setId(3);
		server.setName("ser");

		// when

		serverServiceImpl.persistServer(server);

		// then
		assertThat(server.getName()).isEqualTo("ser");
		assertThat(server.getId()).isEqualTo(3);
	}

	@Test
	public void shouldListServers() {
		// given
		Server server1 = new Server();
		server1.setId(1);
		server1.setName("ser1");

		Server server2 = new Server();
		server2.setId(2);
		server2.setName("ser2");
		List<Server> servers = new ArrayList<>();
		servers.add(server1);
		servers.add(server2);
		// mock
		when(serverDAO.listAllServers()).thenReturn(servers);

		// when
		List<Server> servs = serverServiceImpl.listAllServers();
		// then
		assertThat(servs).isEqualTo(servers);
	}

	@Test
	public void shouldCountServers() {
		// given mock
		when(serverDAO.countAllServers()).thenReturn(2L);

		// when
		Long count = serverServiceImpl.countAllServers();

		// then
		assertThat(count).isEqualTo(2);
	}

	@Test
	public void shouldDeleteServer() {
		// given
		Server server = new Server();
		server.setId(1);
		server.setName("ser");
		doNothing().when(serverDAO).deleteServer(server);

		// when
		serverServiceImpl.deleteServer(server);
		// then

		verify(serverDAO, times(1)).deleteServer(server);
	}

	@Test
	public void shouldUpdateServer()  {
		// given
		Server server = new Server();
		server.setId(1);
		server.setName("ser");
		Server server2 = new Server();
		server2.setId(1);
		server2.setName("ser2");
		when(serverDAO.findServerById(1)).thenReturn(server2);
		// when
		serverServiceImpl.updateServer(server2);
		// then
		assertThat(server2.getName()).isEqualTo("ser2");
		assertThat(serverServiceImpl.findServerById(1).getName()).isEqualTo("ser2");

	}
}
