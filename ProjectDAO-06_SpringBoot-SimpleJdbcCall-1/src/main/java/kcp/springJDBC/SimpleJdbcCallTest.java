package kcp.springJDBC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.dao.DataAccessException;

import kcp.springJDBC.configuration.AppConfig;
import kcp.springJDBC.service.AuthonticateService;

@SpringBootApplication
public class SimpleJdbcCallTest {


	public static void main(String[] args) {
		ApplicationContext context;
		AuthonticateService service;
		context =SpringApplication.run(SimpleJdbcCallTest.class, args);
		service=context.getBean("authService",AuthonticateService.class);
		try {
			System.out.println(service.fatchLogin("kalia", "kalia"));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}
}
