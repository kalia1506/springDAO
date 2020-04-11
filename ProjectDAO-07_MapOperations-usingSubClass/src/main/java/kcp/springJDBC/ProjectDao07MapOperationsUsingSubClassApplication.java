package kcp.springJDBC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataAccessException;

import kcp.springJDBC.service.PlayerService;

@SpringBootApplication
public class ProjectDao07MapOperationsUsingSubClassApplication {

	public static void main(String[] args) {
		ApplicationContext context;
		PlayerService service;
		context = SpringApplication.run(ProjectDao07MapOperationsUsingSubClassApplication.class, args);
		try {
			service = context.getBean("playerService", PlayerService.class);
			System.out.println(service.fatchPlayerByID(101));
			System.out.println();
			System.out.println(service.fatchPlayerByType("cricket", "Basketball"));
	
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

	}

}
