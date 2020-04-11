package kcp.spring.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "kcp.spring.dao")
public class PersistanceConfig {
	@Bean("HKDS")
	public	 DataSource getHKDS() {
		HikariDataSource ds=new HikariDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setJdbcUrl("jdbc:mysql://localhost:3306/spring712");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
}
