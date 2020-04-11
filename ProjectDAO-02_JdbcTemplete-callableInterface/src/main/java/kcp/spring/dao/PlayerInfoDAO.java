package kcp.spring.dao;

import java.util.List;

import kcp.spring.bo.PlayerInfoBO;

public interface PlayerInfoDAO {
	public PlayerInfoBO getPlayerDetailsByID(int playerID);
	public List<PlayerInfoBO> getPlayerListByPlayer_Type(String playerType);
	public List<PlayerInfoBO> getPlayerListByGrade(String grade1,String grade2);
}
