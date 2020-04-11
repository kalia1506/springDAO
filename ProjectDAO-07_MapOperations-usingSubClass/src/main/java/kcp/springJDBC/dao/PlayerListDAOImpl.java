package kcp.springJDBC.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.stereotype.Repository;

import kcp.springJDBC.Queries.JdbcQuerys;
import kcp.springJDBC.bo.PlayerListBO;



@Repository("playerDAO")
public class PlayerListDAOImpl implements PlayerListDAO {
	private PlayerListSelecter selecter;
	private PlayerlistselecterByType selecter1;
	@Autowired
	private DataSource ds;

	public PlayerListDAOImpl(DataSource ds) {
		selecter = new PlayerListSelecter(ds,JdbcQuerys.playerNamebyId);
		selecter1 = new PlayerlistselecterByType(ds, JdbcQuerys.PlayerListByType);
		this.ds = ds;
	}

	@Override
	public PlayerListBO getPlayerNameBYid(int pid) {
			PlayerListBO name=selecter.findObject(pid);
		return name;
	}
	@Override
	public List<PlayerListBO> getPlayerListByType(String type1, String type2) {
		return selecter1.execute(type1, type2);
	}

	public class PlayerListSelecter extends MappingSqlQuery<PlayerListBO> {

		public PlayerListSelecter(DataSource ds, String playernamebyid) {
			super(ds,playernamebyid);
			super.declareParameter(new SqlParameter(Types.INTEGER));
			super.compile();
		}

		@Override
		protected PlayerListBO mapRow(ResultSet rs, int rowNum) throws SQLException {
				PlayerListBO bo=null;
				bo=new PlayerListBO();
				bo.setPid(Integer.parseInt(rs.getString(1)));
				bo.setPlayerName(rs.getString(2));
				bo.setPlayer_type(rs.getString(3));
				bo.setCountry(rs.getString(4));
				bo.setSalary(Integer.parseInt(rs.getString(5)));
				bo.setGrade(rs.getString(3));
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
			bo.setPid(Integer.parseInt(rs.getString(1)));
			bo.setPlayerName(rs.getString(2));
			bo.setPlayer_type(rs.getString(3));
			bo.setCountry(rs.getString(4));
			bo.setSalary(Integer.parseInt(rs.getString(5)));
			bo.setGrade(rs.getString(6));
			return bo;
		}

	}
}
