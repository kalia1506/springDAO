package kcp.springJDBC.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository("dao")
public class EmployeeDAOIMpl implements EmployeeDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final String delete_employee="delete from emp where sal>=? and sal<=?";
	private static final String update_sal = "update emp set sal=? where empno=?";
	private static final String GET_SAL = "select sal from emp where empno=?";
	private static final String GET_DESG = "select job from emp where empno=?";

	/*public EmployeeDAOIMpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}*/

	public String getDesignationByNo(int empno) {
		return jdbcTemplate.queryForObject(GET_DESG, String.class, empno);
	}

	public double getSal(int empno) {
		return jdbcTemplate.queryForObject(GET_SAL, Integer.class, empno);
	}

	public int updateEmployeeSal(int empno, int newsal) {
		return jdbcTemplate.update(update_sal,newsal,empno);
	}

	public int deleteEmploye(int startNo, int endNo) {
		return jdbcTemplate.update(delete_employee,startNo,endNo);
	}

}
