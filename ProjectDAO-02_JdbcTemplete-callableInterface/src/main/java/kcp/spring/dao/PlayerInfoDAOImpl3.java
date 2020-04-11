package kcp.spring.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import kcp.spring.bo.PlayerInfoBO;

//@Repository("PlayerInfoDAO")
public class PlayerInfoDAOImpl3 implements PlayerInfoDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final String GET_PLAYER_INFOBY_ID = " select * from playerslist where pid=?";
	private static final String GET_PLAYERLIST_BY_PLAYERTYPE = "select * from playerslist where player_type=?";
	public PlayerInfoBO getPlayerDetailsByID(int playerID) {

		return jdbcTemplate.queryForObject(GET_PLAYER_INFOBY_ID,
											new BeanPropertyRowMapper<PlayerInfoBO>(PlayerInfoBO.class) ,
											playerID);
	}

	@Override
	public List<PlayerInfoBO> getPlayerListByPlayer_Type(String playerType) {

		
	return (List<PlayerInfoBO>) jdbcTemplate.query(GET_PLAYERLIST_BY_PLAYERTYPE,
			new RowMapperResultSetExtractor(new BeanPropertyRowMapper<PlayerInfoBO>(PlayerInfoBO.class)),playerType);
	}

	@Override
	public List<PlayerInfoBO> getPlayerListByGrade(String grade1, String grade2) {
		// TODO Auto-generated method stub
		return null;
	}
}
