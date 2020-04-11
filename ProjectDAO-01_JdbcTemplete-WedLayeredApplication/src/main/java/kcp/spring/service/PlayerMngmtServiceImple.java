package kcp.spring.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kcp.spring.dao.PlayersDAO;

@Service("playerService")
public class PlayerMngmtServiceImple implements PlayerMngmtService {
	@Autowired
	private PlayersDAO dao;

	public PlayerMngmtServiceImple() {
		System.out.println("PlayerMngmtServiceImple.PlayerMngmtServiceImple()");
	}

	@Override
	public List<Map<String, Object>> fatchPlayerByType(String[] playeraType) {
		StringBuffer sb = new StringBuffer("(");
		for (int i = 0; i < playeraType.length; i++) {
			if (i == playeraType.length - 1) {
				sb.append("'" + playeraType[i] + "'");
			} else {
				sb.append("'" + playeraType[i] + "',");
			}
		}
		sb.append(")");
		System.out.println(sb.toString());
		return dao.getAllPlayerByType(sb.toString());
	}

}
