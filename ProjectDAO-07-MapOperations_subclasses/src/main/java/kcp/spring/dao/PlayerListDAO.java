package kcp.spring.dao;


import java.util.List;

import kcp.spring.bo.PlayerListBO;

public interface PlayerListDAO {
	public PlayerListBO getPlayerNameBYid(int pid);
	public List<PlayerListBO> getPlayerListByType(String type1,String type2);
	public int hikeSalaryByType(String type2,double addSal);

}
