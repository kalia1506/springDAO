package kcp.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kcp.spring.bo.PlayerListBO;

@Repository("playerDAO")
public class PlayerListDAOImpl implements PlayerListDAO {
	@Autowired
	private NamedParameterJdbcTemplate npjt;
	private static final String GET_PLAYERDETAILS_BYNAME = "select * from playerslist where name=:playerName";

	public PlayerListBO getPlayerDetailsByName(String playerName) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("playerName", playerName);
		BeanPropertyRowMapper<PlayerListBO> bean = new BeanPropertyRowMapper(PlayerListBO.class);
		RowMapperResultSetExtractor<PlayerListBO> rset =  new RowMapperResultSetExtractor(bean);

		return npjt.queryForObject(GET_PLAYERDETAILS_BYNAME, paramMap,  rset);
	}
}
