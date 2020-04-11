package kcp.springJDBC.service;

import java.util.List;
import java.util.Map;

import kcp.springJDBC.DAO.EmployeeDAO;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDAO employeeDAO;

	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	public int getCountEmplyee() {
		System.out.println("EmployeeServiceImpl.getCountEmplyee()");
		return employeeDAO.totalEmployeeCount();
	}

	public String getEmployeeName(int empno) {
		System.out.println("EmployeeServiceImpl.getEmployeeName()");
		return employeeDAO.getEmpNameByNo(empno);
	}

	public Map<String, Object> getAllData(int empno) {
		System.out.println("EmployeeServiceImpl.getAllData()");
		return employeeDAO.getStudentData(empno);
	}

	public List<Map<String, Object>> getStudentLists(String result1, String result2) {
		return employeeDAO.getStudentList(result1, result2);
	}

	public String fatchData(String name, int rno, String address) {
		int count=0;
		count=employeeDAO.insertData(name, rno, address);
		if(count==0)
			return"fail";
		else
		return "success";
	}
}
