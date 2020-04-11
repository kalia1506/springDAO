package kcp.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kcp.spring.bo.PlayerListBO;
import kcp.spring.dao.PlayerListDAO;
import kcp.spring.dto.PlayerListDTO;

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

	@Override
	public String fatchHikeSalByType(String type2, double addSal) {
		int count = dao.hikeSalaryByType( type2, addSal);
		if (count == 1) {
			return "update successfully";
		} else {
			return "update not successfully";
		}
	}

}
