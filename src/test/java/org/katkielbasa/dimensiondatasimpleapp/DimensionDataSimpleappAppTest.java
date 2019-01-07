package org.katkielbasa.dimensiondatasimpleapp;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DimensionDataSimpleappAppTest {
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalErr = System.err;
	private String helpText1 = "Command not known. Type \"HELP\" as an argument to get more options" ;
	private String helpText2 = "Argument is needed. Type \"HELP\" as an argument to get more options";

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(errContent));
	}

	@After
	public void restoreStreams() {
	    System.setOut(originalErr);
	}

	@Test
	public void testMainNoArgs() throws Exception {
		DimensionDataSimpleappApp.main(new String [] {});
	    Assert.assertThat(errContent.toString(), CoreMatchers.containsString(helpText2));
	}
	@Test
	public void testMainWrongCommand() throws Exception {
	    DimensionDataSimpleappApp.main(new String[] {"DUPA"});
	    Assert.assertThat(errContent.toString(), CoreMatchers.containsString(helpText1));
	}

	@Test
	public void contextLoads() {
	}

}
