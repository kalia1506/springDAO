package kcp.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.stereotype.Repository;

import kcp.spring.bo.PlayerListBO;
import kcp.spring.jdbcQuerys.JdbcQuerys;

@Repository("playerDAO")
public class PlayerListDAOImpl implements PlayerListDAO {
	private PlayerListSelecter selecter;
	private PlayerlistselecterByType selecter1;
	private PlayerListHikeSalByType selecter2;
	@Autowired
	private DataSource ds;

	public PlayerListDAOImpl(DataSource ds) {
		selecter = new PlayerListSelecter(ds, JdbcQuerys.playerNamebyId);
		selecter1 = new PlayerlistselecterByType(ds, JdbcQuerys.PlayerListByType);
		selecter2 = new PlayerListHikeSalByType(ds, JdbcQuerys.PlayerListhikeSalByType);
		this.ds = ds;
	}

	@Override
	public PlayerListBO getPlayerNameBYid(int pid) {
		return selecter.findObject(pid);
	}

	@Override
	public List<PlayerListBO> getPlayerListByType(String type1, String type2) {
		return selecter1.execute(type1, type2);
	}

	@Override
	public int hikeSalaryByType(String type2, double addSal) {
		return selecter2.update(addSal, type2);
	}

//inner classes
	public class PlayerListSelecter extends MappingSqlQuery<PlayerListBO> {

		public PlayerListSelecter(DataSource ds, String playernamebyid) {
			super(ds, playernamebyid);
			super.declareParameter(new SqlParameter(Types.INTEGER));
			super.compile();
		}

		@Override
		public PlayerListBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			PlayerListBO bo = null;
			bo = new PlayerListBO();
			bo.setPid(Integer.parseInt(rs.getString(1)));
			bo.setPlayerName(rs.getString(2));
			bo.setPlayer_type(rs.getString(3));
			bo.setCountry(rs.getString(4));
			bo.setSalary(Integer.parseInt(rs.getString(5)));
			bo.setGrade(rs.getString(6));
			return bo;
		}
	}

	public class PlayerlistselecterByType extends MappingSqlQuery<PlayerListBO> {

		public PlayerlistselecterByType(DataSource ds, String playerlistbytype) {
			super(ds, playerlistbytype);
			super.declareParameter(new SqlParameter(Types.VARCHAR));
			super.declareParameter(new SqlParameter(Types.VARCHAR));
			super.compile();
		}

		@Override
		protected PlayerListBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			PlayerListBO bo = null;
			bo = new PlayerListBO();
			// bo.setPid(rs.getInt(1));
			bo.setPid(Integer.parseInt(rs.getString(1)));
			bo.setPlayerName(rs.getString(2));
			bo.setPlayer_type(rs.getString(3));
			bo.setCountry(rs.getString(4));
			bo.setSalary(Integer.parseInt(rs.getString(5)));
			bo.setGrade(rs.getString(6));
			return bo;
		}

	}

	private class PlayerListHikeSalByType extends SqlUpdate {

		public PlayerListHikeSalByType(DataSource ds, String playerlisthikesalbytype) {
			super(ds, playerlisthikesalbytype);
			System.out.println(playerlisthikesalbytype);
			super.declareParameter(new SqlParameter(Types.VARCHAR));
			super.declareParameter(new SqlParameter(Types.VARCHAR));
			super.declareParameter(new SqlParameter(Types.DOUBLE));
			super.compile();
		}

	}

}
