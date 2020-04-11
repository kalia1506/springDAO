package kcp.springJDBC.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import kcp.springJDBC.service.EmployeeService;

public class JdbcTemplate {
	private static String path = "kcp/springJDBC/configuration/applicationContext.xml";

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context;
		EmployeeService service;
		context = new ClassPathXmlApplicationContext(path);
		service = context.getBean("EmployeeService", EmployeeService.class);
		try {
			System.out.println("employee designation::" + service.fatchDesgByNo(7788));
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("*********************************************");
		try {
			System.out.println("employee sal::" + service.fatchSal(7788));
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("*********************************************");

		try {
			System.out.println("employee sal::" + service.hikeEmployeeSal(7788));
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("*********************************************");

		try {
			System.out.println(" delete employee ::" + service.fatchdeleteEmployee(2, 5));
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("*********************************************");

	}

}
