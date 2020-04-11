package kcp.spring.service;

import java.util.List;

import kcp.spring.dto.PlayerListDTO;

public interface PlayerService {
	public PlayerListDTO fatchPlayerByID(int pid);
	public List<PlayerListDTO> fatchPlayerByType(String type1,String type2);
	public String fatchHikeSalByType(String type2,double addsal);
}
