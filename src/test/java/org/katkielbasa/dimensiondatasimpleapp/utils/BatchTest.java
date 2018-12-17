//package org.katkielbasa.dimensiondatasimpleapp.utils;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.batch.core.JobParameters;
//import org.springframework.batch.core.JobParametersBuilder;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = { DataSourceConfigTest.class, BatchConfiguration.class})
//public class BatchTest {
//
//	@Autowired
//	private JobLauncher jobLauncher;
//
//	@Autowired
//	private Job job;
//
//	static String PATH_PARAM = "resources/ServersTest.xml";
//	@Test
//	public void startBatch() throws Exception {
//		jobLauncher.run((org.springframework.batch.core.Job) job, testParam());
//		
//	}
//	
//	private JobParameters testParam(){
//		JobParametersBuilder jobBuilder= new JobParametersBuilder();
//        jobBuilder.addString("filePath", PATH_PARAM);
//		return  jobBuilder.toJobParameters();
//	}
//
//}