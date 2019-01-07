package org.katkielbasa.dimensiondatasimpleapp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
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
import org.katkielbasa.dimensiondatasimpleapp.dao.IdNotRecognisedException;
import org.katkielbasa.dimensiondatasimpleapp.model.Server;
import org.katkielbasa.dimensiondatasimpleapp.service.ServerService;
import org.katkielbasa.dimensiondatasimpleapp.service.ServerServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class EditServerCommandTest {
	//private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	//private final PrintStream originalerr = System.err;
	//private final String expectedErrMsg = "NO record with the id 2 found";

	@Mock
	ServerService serverService = mock(ServerServiceImpl.class);;

	@InjectMocks
	EditServerCommand esc;

	//@Before
	//public void setUpStreams() {
	//	System.setOut(new PrintStream(errContent));
	//}

	//@After
	//public void restoreStreams() {
	//	System.setOut(originalerr);
	//}

	@Test
	public void testRun() throws IdNotRecognisedException {
		// given
		Server server = new Server();
		server.setId(1);
		server.setName("ser");
		when(serverService.findServerById(1)).thenReturn(server);
	//	Throwable throwableType = new IdNotRecognisedException();
//		when(serverService.findServerById(2)).thenThrow(throwableType);

		// when
		//serverService.updateServer(server);

		// when
		esc.run("", "1", "newName");

		// then
		assertEquals(server.getId(), 1);
		assertEquals(server.getName(), "newName");


		// when
		//esc.run("", "2", "newName");

		// then
		//assertEquals(expectedErrMsg, errContent.toString());
	}
}
