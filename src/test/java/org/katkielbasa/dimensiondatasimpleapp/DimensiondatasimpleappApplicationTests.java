package org.katkielbasa.dimensiondatasimpleapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.katkielbasa.dimensiondatasimpleapp.utils.MySQLAppConfig;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringRunner.class)
//@ContextConfiguration(locations = {
//	    "classpath:applicationContext.xml"})
//@ContextConfiguration(classes = MySQLAppConfig.class, loader = AnnotationConfigContextLoader.class)
@SpringBootTest
public class DimensiondatasimpleappApplicationTests {

	@Test
	public void contextLoads() {
	}

}
