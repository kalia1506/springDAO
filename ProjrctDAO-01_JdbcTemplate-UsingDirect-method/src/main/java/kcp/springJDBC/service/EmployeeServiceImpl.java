package kcp.springJDBC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kcp.springJDBC.DAO.EmployeeDAO;
@Service("EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDAO employeeDAO;

	/*public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}*/

	public String fatchDesgByNo(int empno) {
		return employeeDAO.getDesignationByNo(empno);
	}

	public double fatchSal(int empno) {
		return employeeDAO.getSal(empno);
	}

	public String hikeEmployeeSal(int empno) {
		double sal = (int) fatchSal(empno);
		String dName = fatchDesgByNo(empno);
		double newsal = 0;
		if ("CLERK".equalsIgnoreCase(dName)) {
			newsal = sal + (sal * 0.2);
		} else if ("SALESMAN".equalsIgnoreCase(dName)) {
			newsal = sal + (sal * 0.15);
		} else if ("MANAGER".equalsIgnoreCase(dName)) {
			newsal = sal + (sal * 0.3);
		} else if ("ANALYST".equalsIgnoreCase(dName)) {
			newsal = sal + (sal * 0.35);
		} else if ("PRESIDENT".equalsIgnoreCase(dName)) {
			newsal = sal + (sal * 0.5);
		}
		int count = employeeDAO.updateEmployeeSal(empno, (int) newsal);
		if (count == 1) {
			return "update successfully" + newsal + "," + fatchSal(empno);
		} else {
			return "not update" + "," + count;
		}

	}

	public String fatchdeleteEmployee(int startNo, int endNo) {
		int count = 0;
		count = employeeDAO.deleteEmploye(startNo, endNo);
		if (count == 1)
			return " no delete employee beteween " + startNo + " to " + endNo;
		else
			return " delete employee beteween " + startNo + " to " + endNo;

	}

}
