package kcp.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;

import kcp.spring.configuration.AppConfig;
import kcp.spring.service.AuthonticateService;

public class SimpleJdbcCallTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context;
		AuthonticateService service;
		context = new AnnotationConfigApplicationContext(AppConfig.class);
		service=context.getBean("authService",AuthonticateService.class);
		try {
			System.out.println(service.fatchLogin("kalia", "kalia"));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}
}
