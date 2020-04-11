package kcp.springJDBC.service;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
	public int getCountEmplyee();
	public String getEmployeeName(int empno);
	public Map<String,Object> getAllData(int empno);
	public List<Map<String,Object>> getStudentLists(String result1,String result2);
	public String fatchData(String name,int rno,String address);
}
