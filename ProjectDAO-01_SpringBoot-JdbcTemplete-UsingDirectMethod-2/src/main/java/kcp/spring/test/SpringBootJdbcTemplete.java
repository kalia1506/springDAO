package kcp.spring.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import kcp.springJDBC.configuration.AppConfig;
import kcp.springJDBC.service.EmployeeService;

@SpringBootApplication
@Import(AppConfig.class)
public class SpringBootJdbcTemplete {

	public static void main(String[] args) {
		ApplicationContext context;
		EmployeeService service;
		context=SpringApplication.run(SpringBootJdbcTemplete.class, args);
		service=context.getBean("EmployeeService",EmployeeService.class);
		System.out.println(service.fatchDesgByNo(7788));
		System.out.println(service.fatchSal(7788));
		System.out.println(service.hikeEmployeeSal(7788));
		((ConfigurableApplicationContext) context).close();
	}

}
