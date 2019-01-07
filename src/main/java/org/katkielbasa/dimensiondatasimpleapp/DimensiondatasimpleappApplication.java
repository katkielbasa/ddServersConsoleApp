//package org.katkielbasa.dimensiondatasimpleapp;
//
//import static java.lang.System.exit;
//
//import java.io.BufferedReader;
//import java.io.Console;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.katkielbasa.dimensiondatasimpleapp.model.Server;
//import org.katkielbasa.dimensiondatasimpleapp.service.ServerService;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.JobExecution;
//import org.springframework.batch.core.JobExecutionException;
//import org.springframework.batch.core.JobParameters;
//import org.springframework.batch.core.JobParametersBuilder;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.Banner;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
////old fashion command line runner with prompt for arguments
//@SpringBootApplication
//public class DimensiondatasimpleappApplication implements CommandLineRunner {
//
//	@Autowired
//	private ServerService serService;
//	@Autowired
//	private JobLauncher jobLauncher;
//	@Autowired
//	private Job job;
//
//	private Console console = System.console();
//
//	static Logger log = LogManager.getLogger(DimensiondatasimpleappApplication.class);
//
//	public static void main(String[] args) throws Exception {
//
//		SpringApplication app = new SpringApplication(DimensiondatasimpleappApplication.class);
//		app.setBannerMode(Banner.Mode.OFF);
//			app.run();
//	}
//
//	@Override
//	public void run(String... args) throws ClassNotFoundException, SQLException, IOException {
//
//		showHelp();
//
//		if (console == null) {
//			log.error("No console available");
//		} else {
//			String option = console.readLine();
//			if (option.equals("help")) {
//				showHelp();
//			} else if (option.equals("quit")) {
//				exit(0);
//			} else if (option.equals("countServers")) {
//				Long servNumb = serService.countAllServers();
//				console.writer().printf("The number of servers is "+ servNumb + ". ");
//			} else if (option.equalsIgnoreCase("addServer")) {
//				Server server = new Server();
//				askForUserInput("Please provide server id: ");
//				int id = Integer.parseInt(getUserInput());
//				server.setId(id);
//				askForUserInput("Please provide server name: ");
//				server.setName(getUserInput());
//				List<Server> servers = serService.listAllServers();
//				for (Server serv : servers) {
//					if (server.getId() == (serv.getId())) {
//						askForUserInput(
//								"Server with ID: " + server.getId() + " already exist. Do You want override? (Yes/No)");
//						if (getUserInput() == "Yes") {
//							serService.persistServer(server);
//							exit(0);
//
//						} else {
//							console.printf("No record added");
//							exit(0);
//						}
//					}
//				}
//				serService.persistServer(server);
//			} else if (option.equalsIgnoreCase("deleteServer")) {
//				askForUserInput("Please provide id of server You want to delete: ");
//				int id = Integer.parseInt(getUserInput());
//				Server server = serService.findServerById(id);
//				serService.deleteServer(server);
//			} else if (option.equalsIgnoreCase("editServer")) {
//				askForUserInput("Please provide id of server You want to edit: ");
//				int id = Integer.parseInt(getUserInput());
//				Server server = serService.findServerById(id);
//				askForUserInput("Please provide new name for server You want to edit: ");
//				server.setName(getUserInput());
//				try {
//					serService.updateServer(server);
//				} catch (Exception e) {
//					log.error("NO record with the id {} found" + server.getId());
//				}
//
//			} else if (option.equalsIgnoreCase("findById")) {
//				askForUserInput("Please provide ID of server: ");
//				int id = Integer.parseInt(getUserInput());
//				Server server = serService.findServerById(id);
//				console.printf(String.valueOf(server.getId()), "||", server.getName());
//			} else if (option.equalsIgnoreCase("listServers")) {
//				List<Server> servers = serService.listAllServers();
//				console.printf("-----CURRENT SERVERS------\n");
//				for (Server server : servers) {
//					int record = servers.indexOf(server) + 1;
//					console.printf(
//							"record: " + record + "  id: " + server.getId() + "; name: " + server.getName() + "; \n ");
//				}
//			} else if (option.equalsIgnoreCase("importFromXml")) {
//				askForUserInput("Please provide path to xml file with server: ");
//				String path = getUserInput();
//				try {
//	            JobExecution execution = jobLauncher.run(job, takeParameters(path));
//	            log.info("Job Exit Status : "+ execution.getStatus());
//	 
//	        } catch (JobExecutionException e) {
//	        	log.error("XML upload failed");
//	            e.printStackTrace();
//	        }
//	    }
//			else {
//				console.printf("Command not recognised.");
//				log.error("Command not recognised.");
//			}
//		}
//
//	}
//
//	private void askForUserInput(String instruction) {
//		console.writer().printf(instruction);
//		console.flush();
//	}
//
//	private JobParameters takeParameters(String path) {
//		JobParametersBuilder builder = new JobParametersBuilder();
//		builder.addString("filePath", path);
//		return builder.toJobParameters();
//	}
//
//	private String getUserInput() throws IOException {
//		BufferedReader reader = new BufferedReader(console.reader());
//		return reader.readLine();
//	}
//
//	private void showHelp() {
//		System.out.println("type 'help' to display this message again");
//		System.out.println("type 'countServers' to display the current number of servers present");
//		System.out.println("type 'addServer' to display the current number of servers present");
//		System.out.println(
//				"type 'editServer' to change the name of a server identified by id (prompt will ask You to provide - the id and the new name)");
//		System.out.println("type 'deleteServer' to delete a server (prompt will ask You to provide the id of the server to delete)");
//		System.out.println("type 'listServers' to display details of all servers servers");
//		System.out.println("type 'importFromXml' to upload the servers from XML file (prompt will ask You to provide the path to the file to upload)");
//		System.out.println("type 'quit' to exit");
//
//	}
//}
