package kcp.spring.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "kcp.spring.dao")
public class PersistanceConfig {
	@Bean("HKDSs")
	public	 DataSource getHKDS() {
		HikariDataSource ds=new HikariDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setJdbcUrl("jdbc:mysql://localhost:3306/spring712");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
	@Bean("templete")
	public SimpleJdbcCall getSJdbcCall() {
		return new SimpleJdbcCall(getHKDS());
	}
	
	

}
