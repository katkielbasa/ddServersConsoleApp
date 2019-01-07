package org.katkielbasa.dimensiondatasimpleapp;

public class QuitCommand extends ServerCommand {


	@Override
	public void run(String...args) {
		System.exit(0);
	}

}
