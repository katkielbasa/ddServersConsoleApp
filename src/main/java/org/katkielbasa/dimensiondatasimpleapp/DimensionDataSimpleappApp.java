package org.katkielbasa.dimensiondatasimpleapp;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DimensionDataSimpleappApp {

	static Logger log = LogManager.getLogger(DimensionDataSimpleappApp.class);

	public static void main(String[] args) throws Exception {
		Set<String> commandNames = Stream.of(Command.values()).map(Command::name).collect(Collectors.toSet());
		if (args.length > 0) {
			if (commandNames.contains(args[0].toUpperCase())) {
				Class<?> cmdClass = CommandStore.getCommand(args[0].toUpperCase());
				SpringApplication app = new SpringApplication(cmdClass);
				app.setBannerMode(Banner.Mode.OFF);
				app.run(args);
			} else {
				log.error("Command not known. Type \"HELP\" as an argument to get more options");
			}
		} else {
			log.error("Argument is needed. Type \"HELP\" as an argument to get more options");
		}
	}

}
