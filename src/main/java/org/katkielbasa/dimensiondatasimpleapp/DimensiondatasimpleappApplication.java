package org.katkielbasa.dimensiondatasimpleapp;

import static java.lang.System.exit;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.katkielbasa.dimensiondatasimpleapp.model.Server;
import org.katkielbasa.dimensiondatasimpleapp.service.ServerService;
import org.katkielbasa.dimensiondatasimpleapp.service.ServerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DimensiondatasimpleappApplication implements CommandLineRunner {

	// ConfigurableApplicationContext context = new
	// ClassPathXmlApplicationContext("applicationContext.xml");
	// ServerService serService = (ServerService) context.getBean("serverService");
	@Autowired
	ServerService serService;

	static Logger log = LogManager.getLogger(DimensiondatasimpleappApplication.class);

	
	public static void main(String[] args) throws Exception {
		System.out.println("In main method");

		SpringApplication app = new SpringApplication(DimensiondatasimpleappApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run();
	}
    Console console = System.console();

	@Override
	public void run(String... args) throws ClassNotFoundException, SQLException, IOException {

		log.info("In run method");
		if (args.length > 0) {
			log.info("No arguments passed into console");
			showHelp();
		}
//		Server server = new Server();
//		server.setName("server1");
//		server.setId("12334");
//		serService.persistServer(server);
//	}

		else {
			Console console = System.console();

			if (console == null) {
//				throw new RuntimeException();
				log.error("No console available");
				} else {
				String option = console.readLine();

				if (option.equals("help")) {
					showHelp();
				} else if (option.equals("quit")) {
					exit(0);
				} else if (option.equals("countServers")) {
					Long servNumb = serService.countAllServers();
					console.writer().printf("The number of servers is {} .", servNumb);
				} else if (option.equalsIgnoreCase("addServer")) {
					Server server = new Server();
					askForUserInput("Please provide server id: ");
					server.setId(getUserInput());
					askForUserInput("Please provide server name: ");
					server.setName(getUserInput());
					serService.persistServer(server);

				} else if (option.equalsIgnoreCase("deleteServer")) {
					askForUserInput("Please provide id of server You want to delete: ");
					Server server = serService.findServerById(getUserInput());
					serService.deleteServer(server);

				} else if (option.equalsIgnoreCase("editServer")) {
					askForUserInput("Please provide id of server You want to edit: ");
					Server server = serService.findServerById(getUserInput());
					askForUserInput("Please provide new id for server You want to edit: ");
					server.setId(getUserInput());
					askForUserInput("Please provide new name for server You want to edit: ");
					server.setName(getUserInput());
					serService.updateServer(server);

				} else if (option.equalsIgnoreCase("listServers")) {
					List<Server> servers = new ArrayList<Server>();
					servers = serService.listAllServers();

					for (Server server : servers) {
						console.printf(server.getId(), "||", server.getName());
					}

				}
			}
		}
	}

	private void askForUserInput(String instruction) {
		console.writer().printf(instruction);
		console.flush();
	}

	private String getUserInput() throws IOException {
		BufferedReader reader = new BufferedReader(console.reader());
		return reader.readLine();
	}

	private void showHelp() {
		System.out.println("help to display this message");
		System.out.println("countServers to display the current number of servers present");
		System.out.println("addServer to display the current number of servers present");
		System.out.println(
				"editServer to change the name of a server identified by id (takes 2 additional args - the id and the new name)");
		System.out.println("deleteServer to delete a server (takes one more arg - the id of the server to delete)");
		System.out.println("listServers to display details of all servers servers");
	}
}
