package kcp.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import kcp.spring.service.AuthonticateService;

public class SimpleJdbcCallTest {
	private static String path = "kcp/spring/configuration/applicationContext.xml";

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context;
		AuthonticateService service;
		context = new ClassPathXmlApplicationContext(path);
		service=context.getBean("authService",AuthonticateService.class);
		try {
			System.out.println(service.fatchLogin("kalia", "kalia"));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}
}
