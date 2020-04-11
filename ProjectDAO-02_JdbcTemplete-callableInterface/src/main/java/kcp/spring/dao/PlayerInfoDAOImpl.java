package kcp.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kcp.spring.bo.PlayerInfoBO;

//@Repository("PlayerInfoDAO")
public class PlayerInfoDAOImpl implements PlayerInfoDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final String GET_PLAYERLIST_BY_GRADE = "select * from playerslist where grade in(?,?)";
	private static final String GET_PLAYERLIST_BY_PLAYERTYPE = "select * from playerslist where player_type=?";
	private static final String GET_PLAYER_INFOBY_ID = " select * from playerslist where pid=?";

	public PlayerInfoBO getPlayerDetailsByID(int playerID) {
		return jdbcTemplate.queryForObject(GET_PLAYER_INFOBY_ID, new PlayerInfoRowMapper(), playerID);
	}

	private class PlayerInfoRowMapper implements RowMapper<PlayerInfoBO> {
		public PlayerInfoBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			PlayerInfoBO bo = null;
			bo = new PlayerInfoBO();
			bo.setPid(rs.getInt(1));
			bo.setName(rs.getString(2));
			bo.setPlayer_type(rs.getString(3));
			bo.setCountry(rs.getString(4));
			bo.setSalary(rs.getInt(5));
			bo.setGrade(rs.getString(6));
			return bo;
		}// rowMap

	}// inner class

	@Override
	public List<PlayerInfoBO> getPlayerListByPlayer_Type(String playerType) {

		return jdbcTemplate.query(GET_PLAYERLIST_BY_PLAYERTYPE, new PlayerListRowMapper(), playerType);
	}

	private class PlayerListRowMapper implements ResultSetExtractor<List<PlayerInfoBO>> {

		@Override
		public List<PlayerInfoBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
			System.out.println("PlayerInfoDAOImpl.PlayerListRowMapper.extractData()");
			PlayerInfoBO bo = null;
			List<PlayerInfoBO> listBO = new ArrayList<PlayerInfoBO>();
			while (rs.next()) {

				bo = new PlayerInfoBO();
				bo.setPid(rs.getInt(1));
				bo.setName(rs.getString(2));
				bo.setPlayer_type(rs.getString(3));
				bo.setCountry(rs.getString(4));
				bo.setSalary(rs.getInt(5));
				bo.setGrade(rs.getString(6));
				listBO.add(bo);
			}
			return listBO;
		}

	}

	@Override
	public List<PlayerInfoBO> getPlayerListByGrade(String grade1, String grade2) {
		List<PlayerInfoBO> listBO =new ArrayList<PlayerInfoBO>();
		 jdbcTemplate.query(GET_PLAYERLIST_BY_GRADE, new PlayerRowCallbackHandler(listBO) , grade1, grade2);
		return listBO;
	}

	private class PlayerRowCallbackHandler implements RowCallbackHandler {
		private List<PlayerInfoBO> lbo;

		public PlayerRowCallbackHandler(List<PlayerInfoBO> lbo) {

			this.lbo = lbo;
		}

		@Override
		public void processRow(ResultSet rs) throws SQLException {
			System.out.println("PlayerInfoDAOImpl.PlayerRowCallbackHandler.processRow()");
			PlayerInfoBO bo = null;
			bo = new PlayerInfoBO();
			bo.setPid(rs.getInt(1));
			bo.setName(rs.getString(2));
			bo.setPlayer_type(rs.getString(3));
			bo.setCountry(rs.getString(4));
			bo.setSalary(rs.getInt(5));
			bo.setGrade(rs.getString(6));
			lbo.add(bo);
		}

	}
}
