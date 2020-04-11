package kcp.spring.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kcp.spring.bo.RailwayTickectBO;

@Repository("TicketDAO")
public class RailwayTicketBookingDAOImpl implements RailwayTicketBookingDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final String INSERT_DATA = "insert into railwayticket values(?,?,?,?,?,?,?)";

	public int[] insertData(final List<RailwayTickectBO> listBO) {
		return jdbcTemplate.batchUpdate(INSERT_DATA, new BatchPreparedStatementSetter() {

			public void setValues(PreparedStatement ps, int i) throws SQLException {
				System.out.println(
						"RailwayTicketBookingDAOImpl.insertData(...).new BatchPreparedStatementSetter() {...}.setValues()");
				ps.setInt(1, GeneratePNR.getPNRno());
				ps.setString(2, listBO.get(i).getPassengerName());
				ps.setInt(3,listBO.get(i).getAge());
				ps.setString(4, listBO.get(i).getSourcePlace());
				ps.setString(5, listBO.get(i).getDestinationPlace());
				ps.setDouble(6, listBO.get(i).getDistance());
				ps.setDouble(7, listBO.get(i).getTicketPrice());

			}

			public int getBatchSize() {
				return listBO.size();
			}
		});
	}

}
