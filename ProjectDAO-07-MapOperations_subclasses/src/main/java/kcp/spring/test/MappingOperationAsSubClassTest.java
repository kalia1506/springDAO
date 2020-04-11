package kcp.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;

import kcp.spring.configuration.AppConfig;
import kcp.spring.service.PlayerService;

public class MappingOperationAsSubClassTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context;
		PlayerService service;
		context=new AnnotationConfigApplicationContext(AppConfig.class);
		service=context.getBean("playerService",PlayerService.class);
		try {
			System.out.println(service.fatchPlayerByID(101));
			System.out.println();
			System.out.println(service.fatchPlayerByType("cricket", "Basketball"));
			System.out.println();
			//System.out.println(service.fatchHikeSalByType("Basketball", 1));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

	}

}
