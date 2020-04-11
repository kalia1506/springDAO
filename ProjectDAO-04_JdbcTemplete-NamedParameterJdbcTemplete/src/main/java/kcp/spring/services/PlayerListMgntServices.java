package kcp.spring.services;

import kcp.spring.dto.PlayerListDTO;

public interface PlayerListMgntServices {
	public PlayerListDTO fatchPlayerDetails(String playerName);
}
