package org.katkielbasa.dimensiondatasimpleapp;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.katkielbasa.dimensiondatasimpleapp.model.Server;
import org.katkielbasa.dimensiondatasimpleapp.service.ServerService;
import org.katkielbasa.dimensiondatasimpleapp.service.ServerServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
public class DeleteServerCommandTest {

	@Mock
	ServerService serverService = mock(ServerServiceImpl.class);;

	@InjectMocks
	DeleteServerCommand dsc;

	@Test
	public void testRun() {
		// given
		Server server = new Server();
		server.setId(1);
		server.setName("ser");
		when(serverService.findServerById(1)).thenReturn(server);
		doNothing().when(serverService).deleteServer(server);

		// when
		dsc.run("", "1");

		// then
		verify(serverService, times(1)).deleteServer(server);
	}
}
