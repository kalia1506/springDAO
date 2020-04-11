package kcp.springJDBC.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "kcp.springJDBC.DAO")
public class PresisatnceConfig {
	@Bean("HKDs")
	public DataSource getHKDs() {
		HikariDataSource hkds = null;
		hkds = new HikariDataSource();
		hkds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		hkds.setJdbcUrl("jdbc:mysql://localhost:3306/employee");
		hkds.setUsername("root");
		hkds.setPassword("root");
		return hkds;
	}

	@Bean("Templte")
	public JdbcTemplate getTemplate() {
		return new JdbcTemplate(getHKDs());

	}
}
