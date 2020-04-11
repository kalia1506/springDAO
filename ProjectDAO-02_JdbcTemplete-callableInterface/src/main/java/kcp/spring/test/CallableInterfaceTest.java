package kcp.spring.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import kcp.spring.dto.PlayerInfoDTO;
import kcp.spring.services.PlayerInfoService;

public class CallableInterfaceTest {

	private static String path = "kcp/spring/configuration/applicationContext.xml";

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context;
		PlayerInfoService service;
		PlayerInfoDTO dto;
		List<PlayerInfoDTO> listDTO;
		context = new ClassPathXmlApplicationContext(path);
		service = context.getBean("PlayerInfoService", PlayerInfoService.class);
		try {
			dto = service.fatchPlayerDataByID(102);
			System.out.println(dto);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		System.out.println("*********************************************************************");
		try {
			listDTO = service.fatchPlayerDataBytype("kabaddi".toLowerCase());
			System.out.println(listDTO);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		System.out.println("*********************************************************************");
		try {
			listDTO = service.fatchPlayerDetailsByGrade("b".toUpperCase(),"c".toUpperCase());
			System.out.println(listDTO);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}

}
