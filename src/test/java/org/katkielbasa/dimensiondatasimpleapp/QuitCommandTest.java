package org.katkielbasa.dimensiondatasimpleapp;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class QuitCommandTest {

	@Rule
	public final ExpectedSystemExit exit = ExpectedSystemExit.none();


	@Test
	public void testRun() {
		QuitCommand qc = new QuitCommand();
		exit.expectSystemExitWithStatus(0);
		qc.run(null);
	}
}
