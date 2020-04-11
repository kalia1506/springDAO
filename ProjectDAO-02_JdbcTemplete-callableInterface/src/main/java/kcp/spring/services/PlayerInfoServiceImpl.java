package kcp.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kcp.spring.bo.PlayerInfoBO;
import kcp.spring.dao.PlayerInfoDAO;
import kcp.spring.dto.PlayerInfoDTO;

@Service("PlayerInfoService")
public class PlayerInfoServiceImpl implements PlayerInfoService {
	@Autowired
	private PlayerInfoDAO dao;

	public PlayerInfoDTO fatchPlayerDataByID(int playerID) {
		PlayerInfoDTO dto = new PlayerInfoDTO();
		PlayerInfoBO bo = null;
		bo = dao.getPlayerDetailsByID(playerID);
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}

	@Override
	public List<PlayerInfoDTO> fatchPlayerDataBytype(String playerType) {
		List<PlayerInfoBO> listBO = dao.getPlayerListByPlayer_Type(playerType);
		List<PlayerInfoDTO> listDTO = new ArrayList<PlayerInfoDTO>();
		/*for (PlayerInfoBO bo : listBO) {
			PlayerInfoDTO dto = new PlayerInfoDTO();
			BeanUtils.copyProperties(bo, dto);
			listDTO.add(dto);
		}*/

		listBO.forEach(bo -> {
			PlayerInfoDTO dto = new PlayerInfoDTO();
			BeanUtils.copyProperties(bo, dto);
			listDTO.add(dto);
		});
		// System.out.println(listDTO);
		return listDTO;
	}

	@Override
	public List<PlayerInfoDTO> fatchPlayerDetailsByGrade(String grade1, String grade2) {
		List<PlayerInfoBO> listBO = dao.getPlayerListByGrade(grade1, grade2);
		List<PlayerInfoDTO> listDTO = new ArrayList<PlayerInfoDTO>();
		listBO.forEach(bo->{
			PlayerInfoDTO dto = new PlayerInfoDTO();
			BeanUtils.copyProperties(bo, dto);
			listDTO.add(dto);
		});
		return listDTO;
	}

}
