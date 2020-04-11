package kcp.springJDBC.DAO;

import java.util.List;
import java.util.Map;

public interface EmployeeDAO {
			public int totalEmployeeCount();
			public String getEmpNameByNo(int empno);
			public Map<String,Object> getStudentData(int empno);
			public List<Map<String,Object>> getStudentList(String result1,String result2);
			public int insertData(String name,int rno,String address);
			
}
