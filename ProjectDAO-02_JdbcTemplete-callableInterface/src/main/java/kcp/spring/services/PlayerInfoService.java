package kcp.spring.services;

import java.util.List;

import kcp.spring.dto.PlayerInfoDTO;

public interface PlayerInfoService {
	public PlayerInfoDTO fatchPlayerDataByID(int playerID);

	public List<PlayerInfoDTO> fatchPlayerDataBytype(String playerType);
	
	public List<PlayerInfoDTO> fatchPlayerDetailsByGrade(String grade1,String grade2);
}
