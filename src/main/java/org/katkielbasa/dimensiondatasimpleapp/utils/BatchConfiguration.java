package org.katkielbasa.dimensiondatasimpleapp.utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.katkielbasa.dimensiondatasimpleapp.model.Server;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.xstream.XStreamMarshaller;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	private static final String QUERY_INSERT_SERVER = "insert into server(id,name) values(?, ?)";

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	public DataSource dataSource;

	@Bean
	@StepScope
	public StaxEventItemReader<Server> reader(@Value("#{jobParameters['filePath']}") String filePath) {
		StaxEventItemReader<Server> reader = new StaxEventItemReader<Server>();
		reader.setResource(new FileSystemResource(filePath));
		reader.setFragmentRootElementName("server");

		Map<String, String> aliases = new HashMap<String, String>();
		aliases.put("server", "org.katkielbasa.dimensiondatasimpleapp.model.Server");

		XStreamMarshaller xStreamMarshaller = new XStreamMarshaller();
		xStreamMarshaller.setAliases(aliases);

		reader.setUnmarshaller(xStreamMarshaller);

		return reader;
	}

	@Bean
	public JdbcBatchItemWriter<Server> writer() {
		JdbcBatchItemWriter<Server> writer = new JdbcBatchItemWriter<Server>();
		writer.setDataSource(dataSource);
		writer.setSql(QUERY_INSERT_SERVER);
		writer.setItemPreparedStatementSetter(new ServerItemPreparedStmSetter());

		return writer;
	}

	private class ServerItemPreparedStmSetter implements ItemPreparedStatementSetter<Server> {

		@Override
		public void setValues(Server server, PreparedStatement ps) throws SQLException {
			ps.setInt(1, server.getId());
			ps.setString(2, server.getName());
		}

	}

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1").
				<Server, Server>chunk(10).
				reader(reader(null)).
				writer(writer()).build();
	}
	@Bean
	public Job importServerJob() {
		return jobBuilderFactory.get("importServerJob").
				incrementer(new RunIdIncrementer()).
				flow(step1()).end().build();

	}
}