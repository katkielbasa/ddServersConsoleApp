package org.katkielbasa.dimensiondatasimpleapp;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.katkielbasa.dimensiondatasimpleapp.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public abstract class ServerCommand implements CommandLineRunner {
	@Autowired
	protected ServerService serService;

	static Logger log = LogManager.getLogger(ServerCommand.class);
	
    
    public abstract void run(String... args);
    		
}
