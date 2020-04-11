package kcp.springJDBC.DAO;

public interface EmployeeDAO {
	public String getDesignationByNo(int empno);

	public double getSal(int empno);

	public int updateEmployeeSal(int empno, int newsal);

	public int deleteEmploye(int startNo, int endNo);
}
