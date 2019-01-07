package org.katkielbasa.dimensiondatasimpleapp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.katkielbasa.dimensiondatasimpleapp.service.ServerService;
import org.katkielbasa.dimensiondatasimpleapp.service.ServerServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CountServersCommandTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final String expectedCount = 
			"The number of servers is 2.";
	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@After
	public void restoreStreams() {
		System.setOut(originalOut);
	}
	@Mock
	ServerService serverService = mock(ServerServiceImpl.class);;

	@InjectMocks
	CountServersCommand csc;

	@Test
	public void testRun() {
		// given mock
		when(serverService.countAllServers()).thenReturn(2L);

		// when
		csc.run(null);;

		// then
		assertEquals(expectedCount, outContent.toString());
	}
	
}
