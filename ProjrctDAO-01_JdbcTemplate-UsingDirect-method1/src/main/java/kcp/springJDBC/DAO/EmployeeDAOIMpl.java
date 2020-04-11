package kcp.springJDBC.DAO;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDAOIMpl implements EmployeeDAO {
	public static final String COUNT_EMPLOYEE = "select count(*) from studenttable";
	private JdbcTemplate jdbcTemplate;
	private static final String INSERT_DATA = "insert into studenttable(name,rollno,address)values(?,?,?)";
	private static final String Get_more_data = "select * from studenttable where result in(?,?)";
	private static final String GET_one_DATA = "select * from studenttable where rollno=?";
	private static final String GET_ONE_EMPLOYEE_NAME = "select name from studenttable where rollno=?";

	public EmployeeDAOIMpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int totalEmployeeCount() {
		System.out.println("EmployeeDAOIMpl.totalEmployeeCount()");
		return jdbcTemplate.queryForObject(COUNT_EMPLOYEE, Integer.class);
	}

	public String getEmpNameByNo(int empno) {
		System.out.println("EmployeeDAOIMpl.getEmpNameByNo()");
		return jdbcTemplate.queryForObject(GET_ONE_EMPLOYEE_NAME, String.class, empno);
	}

	public Map<String, Object> getStudentData(int empno) {
		System.out.println("EmployeeDAOIMpl.getStudentData()");
		return jdbcTemplate.queryForMap(GET_one_DATA, empno);
	}

	public List<Map<String, Object>> getStudentList(String result1, String result2) {
		System.out.println("EmployeeDAOIMpl.getStudentList()");
		return jdbcTemplate.queryForList(Get_more_data, result1, result2);
	}

	public int insertData(String name, int rno, String address) {
		System.out.println("EmployeeDAOIMpl.insertData()");
		return jdbcTemplate.update(INSERT_DATA, name, rno, address);

	}

}
