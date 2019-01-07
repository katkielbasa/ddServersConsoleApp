package org.katkielbasa.dimensiondatasimpleapp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.katkielbasa.dimensiondatasimpleapp.model.Server;
import org.katkielbasa.dimensiondatasimpleapp.service.ServerServiceImpl;
import org.katkielbasa.dimensiondatasimpleapp.service.ServerService;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ListServersCommandTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final String expectedList = 
			"servers\r\n" + 
			"-----CURRENT SERVERS------\n" + 
			"record: 1  id: 1; name: ser1;\n" + 
			"record: 2  id: 2; name: ser2;\n";

	@Mock
	ServerService serverService = mock(ServerServiceImpl.class);;

	@InjectMocks
	ListServersCommand lsc;

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@After
	public void restoreStreams() {
		System.setOut(originalOut);
	}

	@Test
	public void testRun() {
		//given
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
		when(serverService.listAllServers()).thenReturn(servers);
		System.out.println("servers");

		// when
		lsc.run(null);
		
		// then
	   
		assertEquals(expectedList, outContent.toString());

	}
}
