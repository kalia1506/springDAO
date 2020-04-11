package kcp.springJDBC.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

@Configuration
public class PersistanceConfig {
	@Autowired
	private DataSource ds;

	@Bean("templete")
	public SimpleJdbcCall getSimpleJdbcCall() {
		return new SimpleJdbcCall(ds);
	}
}
