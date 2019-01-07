package org.katkielbasa.dimensiondatasimpleapp;

import static org.junit.Assert.assertEquals;
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
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
public class ImportFromXMLCommandTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final String path = "";
	private final String expectedStatusInfo = 
			"Job Exit Status : exitCode=COMPLETED;exitDescription=";
	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@After
	public void restoreStreams() {
		System.setOut(originalOut);
	}
	@Mock
	ServerService serverService = mock(ServerServiceImpl.class);

	@InjectMocks
	ImportFromXMLCommand ifxc;
	@Mock
	JobLauncher jobLauncher;
	@Mock
	Job job;
	
	@Test
	public void testRun() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		// given mock
		JobExecution execution = new JobExecution(1L) ;
		execution.setExitStatus(new ExitStatus("COMPLETED"));
		when(jobLauncher.run(job,takeParameters(path))).thenReturn(execution);

		// when
		ifxc.run("",path);

		// then
		assertEquals(expectedStatusInfo, outContent.toString());	
		}

	private JobParameters takeParameters(String path) {
		JobParametersBuilder builder = new JobParametersBuilder();
		builder.addString("filePath", path);
		return builder.toJobParameters();
	}
}
