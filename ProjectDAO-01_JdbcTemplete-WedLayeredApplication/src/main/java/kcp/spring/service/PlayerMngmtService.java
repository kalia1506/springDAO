package kcp.spring.service;

import java.util.List;
import java.util.Map;

public interface PlayerMngmtService {
	public List<Map<String, Object>> fatchPlayerByType(String[] playeraType);
}
