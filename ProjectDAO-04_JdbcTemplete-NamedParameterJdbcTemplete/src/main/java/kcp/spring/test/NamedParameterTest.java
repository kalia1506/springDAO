package kcp.spring.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import kcp.spring.dto.PlayerListDTO;
import kcp.spring.services.PlayerListMgntServices;


public class NamedParameterTest {
	private static String path = "kcp/spring/configuration/applicationContext.xml";
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context;
		PlayerListMgntServices service = null;
		PlayerListDTO dto = null;
		context = new ClassPathXmlApplicationContext(path);
		service=context.getBean("playerService",PlayerListMgntServices.class);
		try {
			dto=service.fatchPlayerDetails("virat kohil");
			System.out.println(dto);
		} catch (DataAccessException e) {
			// TODO: handle exception
		}
	}

}
