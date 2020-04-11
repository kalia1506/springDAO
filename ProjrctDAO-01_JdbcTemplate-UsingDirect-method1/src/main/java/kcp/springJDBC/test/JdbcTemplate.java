package kcp.springJDBC.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import kcp.springJDBC.service.EmployeeService;

public class JdbcTemplate {

	private static String path="kcp/springJDBC/configuration/applicationContext.xml";

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context;
		EmployeeService service;
		context=new ClassPathXmlApplicationContext(path);
		service=context.getBean("EmployeeService",EmployeeService.class);
		try {
			System.out.println("Total student::"+service.getCountEmplyee());
		}catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("*********************************************");
		try {
			System.out.println("student Name::"+service.getEmployeeName(76));
		}catch (DataAccessException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		System.out.println("*********************************************");
		try {
			System.out.println("one data "+service.getAllData(76));
		}catch (DataAccessException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		System.out.println("*********************************************");
		try {
			System.out.println("all data "+service.getStudentLists("fail", "pass"));
		}catch (DataAccessException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		System.out.println("*********************************************");
		try {
			System.out.println(service.fatchData("kalu charan panda", 61239, "berhampur"));
		}catch (DataAccessException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
