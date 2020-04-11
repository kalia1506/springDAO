package kcp.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import kcp.spring.dto.PersonalInfoDTO;
import kcp.spring.service.PersonalInfoService;

public class SimpleJdbcInsertTest {

	private static final String path = "kcp/spring/configuration/applicationContext.xml";

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context;
		PersonalInfoService service = null;
		PersonalInfoDTO dto;
		context = new ClassPathXmlApplicationContext(path);
		service = context.getBean("Service", PersonalInfoService.class);
		dto = new PersonalInfoDTO();
		dto.setPid(1311);
		dto.setPname("kalu");
		dto.setAddress("bhm");
		dto.setCompany("tcs");
		dto.setDeptNo(12);
		dto.setSalary(98765);
		dto.setDesg("manager");
		try {
			System.out.println(service.FatchData(dto));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

	}

}
