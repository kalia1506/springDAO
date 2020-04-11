package kcp.springJDBC.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kcp.springJDBC.bo.PlayerListBO;
import kcp.springJDBC.dao.PlayerListDAO;
import kcp.springJDBC.dto.PlayerListDTO;



@Service("playerService")
public class PlayerMgmtServices implements PlayerService {
	@Autowired
	private PlayerListDAO dao;

	@Override
	public PlayerListDTO fatchPlayerByID(int pid) {
		PlayerListBO bo = dao.getPlayerNameBYid(pid);
		PlayerListDTO dto = null;
		dto = new PlayerListDTO();
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}
	@Override
	public List<PlayerListDTO> fatchPlayerByType(String type1, String type2) {
		List<PlayerListDTO> listDTO = new ArrayList<PlayerListDTO>();
		List<PlayerListBO> listBO = dao.getPlayerListByType(type1, type2);
		listBO.forEach(bo -> {
			PlayerListDTO dto = new PlayerListDTO();
			BeanUtils.copyProperties(bo, dto);
			listDTO.add(dto);
		});

		return listDTO;
	}
}
