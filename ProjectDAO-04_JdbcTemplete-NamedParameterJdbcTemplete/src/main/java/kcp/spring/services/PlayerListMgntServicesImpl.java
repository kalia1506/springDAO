package kcp.spring.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kcp.spring.bo.PlayerListBO;
import kcp.spring.dao.PlayerListDAO;
import kcp.spring.dto.PlayerListDTO;

@Service("playerService")
public class PlayerListMgntServicesImpl implements PlayerListMgntServices {

	@Autowired
	private PlayerListDAO dao;

	public PlayerListDTO fatchPlayerDetails(String playerName) {
		PlayerListBO bo = dao.getPlayerDetailsByName(playerName);
		PlayerListDTO dto = null;
		dto = new PlayerListDTO();
		BeanUtils.copyProperties(bo, dto);

		return dto;
	}

}
