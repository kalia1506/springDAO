package kcp.spring.dao;

import java.util.List;

import kcp.spring.bo.RailwayTickectBO;

public interface RailwayTicketBookingDAO {
	public int[] insertData(List<RailwayTickectBO> listBO);
}
