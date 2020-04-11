package kcp.spring.service;

import java.util.List;

import kcp.spring.dto.RailwayTickectDTO;

public interface RailwayTicketService {
	public String fatchRailwayBookingInfo(List<RailwayTickectDTO> listDTO);
}
