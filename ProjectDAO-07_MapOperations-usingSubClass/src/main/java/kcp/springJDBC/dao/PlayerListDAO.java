package kcp.springJDBC.dao;

import java.util.List;

import kcp.springJDBC.bo.PlayerListBO;

public interface PlayerListDAO {
	public PlayerListBO getPlayerNameBYid(int pid);
	public List<PlayerListBO> getPlayerListByType(String type1,String type2);
	}
