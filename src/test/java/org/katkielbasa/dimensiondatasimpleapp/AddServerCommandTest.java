package org.katkielbasa.dimensiondatasimpleapp;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.katkielbasa.dimensiondatasimpleapp.model.Server;
import org.katkielbasa.dimensiondatasimpleapp.service.ServerService;
import org.katkielbasa.dimensiondatasimpleapp.service.ServerServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
public class AddServerCommandTest {
	@Mock
	ServerService serverService = mock(ServerServiceImpl.class);;

	@InjectMocks
	AddServerCommand asc;

	@Test
	public void testRun() {
		// given
		Server server = new Server();
		server.setId(1);
		server.setName("server");

		doNothing().when(serverService).persistServer(server);


		// when
		asc.run("", "1", "server");

		// then
		//verify(serverService, times(1)).persistServer(server.getId());
		assertEquals(server.getId(), 1);
		assertEquals(server.getName(),"server");

	}
}
