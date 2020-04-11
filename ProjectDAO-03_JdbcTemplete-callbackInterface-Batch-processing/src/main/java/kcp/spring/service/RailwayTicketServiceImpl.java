package kcp.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kcp.spring.bo.RailwayTickectBO;
import kcp.spring.dao.RailwayTicketBookingDAO;
import kcp.spring.dto.RailwayTickectDTO;

@Service("railwayService")
public class RailwayTicketServiceImpl implements RailwayTicketService {
	@Autowired
	private RailwayTicketBookingDAO dao;

	public String fatchRailwayBookingInfo(List<RailwayTickectDTO> listDTO) {
		List<RailwayTickectBO> listBO = new ArrayList<RailwayTickectBO>();
		RailwayTickectBO bo = null;
		System.out.println("RailwayTicketServiceImpl.fatchRailwayBookingInfo()");
		for (RailwayTickectDTO dto : listDTO) {
			bo = new RailwayTickectBO();
			bo.setPassengerName(dto.getPassengerName());
			bo.setAge(dto.getAge());
			bo.setSourcePlace(dto.getSourcePlace());
			bo.setDestinationPlace(dto.getDestinationPlace());
			bo.setDistance(Integer.parseInt(dto.getDistance()));
			double ticketPrice = Integer.parseInt(dto.getDistance()) * 0.5;
			bo.setTicketPrice(ticketPrice);
			listBO.add(bo);
		}
		int[] result = dao.insertData(listBO);
		if (result != null) {
			return "successfully get the ticket";
		} else {
			return "not get the ticket";
		}

	}

}
