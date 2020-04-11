package kcp.spring.dao;

import java.util.List;
import java.util.Map;

public interface PlayersDAO {
	public List<Map<String, Object>> getAllPlayerByType(String playeraType);
}
