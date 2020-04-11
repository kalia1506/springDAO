package kcp.spring.dao;


import kcp.spring.bo.PlayerListBO;

public interface PlayerListDAO {
	public PlayerListBO getPlayerDetailsByName(String playerName);
}
