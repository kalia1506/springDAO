package kcp.springJDBC.service;

import java.util.List;

import kcp.springJDBC.dto.PlayerListDTO;

public interface PlayerService {
	public PlayerListDTO fatchPlayerByID(int pid);
	public List<PlayerListDTO> fatchPlayerByType(String type1,String type2);
	
}
