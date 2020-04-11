package kcp.springJDBC.service;

public interface EmployeeService {
	public String fatchDesgByNo(int empno);

	public double fatchSal(int empno);

	public String hikeEmployeeSal(int empno);
	
	public String fatchdeleteEmployee(int startNo, int endNo);
}
