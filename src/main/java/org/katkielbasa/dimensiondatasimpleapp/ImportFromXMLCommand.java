package org.katkielbasa.dimensiondatasimpleapp;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;

public class ImportFromXMLCommand extends ServerCommand {


	@Autowired
	private JobLauncher jobLauncher;
	@Autowired
	private Job job;

	@Override
	public void run(String...args) {
		String path = args[1];
		try {
			JobExecution execution = jobLauncher.run(job, takeParameters(path));
			System.out.print("Job Exit Status : " + execution.getExitStatus());
		} catch (JobExecutionException e) {
			log.error("XML upload failed");
			e.printStackTrace();
		}

	}

	private JobParameters takeParameters(String path) {
		JobParametersBuilder builder = new JobParametersBuilder();
		builder.addString("filePath", path);
		return builder.toJobParameters();
	}

}
