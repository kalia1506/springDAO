package kcp.spring.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import kcp.spring.dto.RailwayTickectDTO;
import kcp.spring.service.RailwayTicketService;

public class BatchProcessingTest {
	private static String path = "kcp/spring/configuration/applicationContext.xml";

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context;
		RailwayTicketService service = null;
		List<RailwayTickectDTO> listDTO = null;
		RailwayTickectDTO dto = null;
		context = new ClassPathXmlApplicationContext(path);
		service = context.getBean("railwayService", RailwayTicketService.class);

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Source point:: ");
		String sourcePlace = sc.next();
		System.out.println("Enter Destination point:: ");
		String distanationPlace = sc.next();
		System.out.println("Enter Distance :: ");
		int distance = sc.nextInt();
		System.out.println("Enter how many  the group:: ");
		int group = sc.nextInt();
		listDTO = new ArrayList<RailwayTickectDTO>();
		for (int i = 1; i <= group; i++) {
			System.out.println("Enter the Passanger name::");
			String passangerName = sc.next();
			System.out.println("Enter the passanger age:: ");
			int age = sc.nextInt();

			dto = new RailwayTickectDTO();
			dto.setPassengerName(passangerName);
			dto.setAge(age);
			dto.setSourcePlace(sourcePlace);
			dto.setDestinationPlace(distanationPlace);
			dto.setDistance(String.valueOf(distance));
			listDTO.add(dto);
		}
		System.out.println(listDTO);
		try {
		String result=service.fatchRailwayBookingInfo(listDTO);
			System.out.println(result);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}
}
