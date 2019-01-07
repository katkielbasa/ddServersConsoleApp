package org.katkielbasa.dimensiondatasimpleapp;

public class CountServersCommand extends ServerCommand {



	@Override
	public void run(String...args) {
		Long servNumb = serService.countAllServers();
		System.out.print("The number of servers is "+ servNumb + ".");
	}

}
