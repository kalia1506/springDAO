package kcp.spring.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("playerDAO")
public class PlayersDAOImpl implements PlayersDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public PlayersDAOImpl() {
		System.out.println("PlayersDAOImpl.PlayersDAOImpl()");
	}

	@Override
	public List<Map<String, Object>> getAllPlayerByType(String playeraType) {
		final String GET_ALL_BY_TYPE = "select * from playerslist where player_type in" + playeraType;
		System.out.println(GET_ALL_BY_TYPE);
		return jdbcTemplate.queryForList(GET_ALL_BY_TYPE);
	}
}
