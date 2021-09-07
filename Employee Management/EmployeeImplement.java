package Employee;

import java.sql.Connection;
import java.util.List;

import Employee.Employee;

public interface EmployeeImplement {
	
	public static final String jdbcurl="jdbc:mysql://localhost:3306/employee";
	public static final String driverclass="com.mysql.cj.jdbc.Driver";
	public static final String username="Devi";
	public static final String password="Dhanam";
	
	Connection getConnection();
	void insertEmployee(Employee e);
	Employee selectEmployee(int id);
	List<Employee> selectAllEmployee();
	boolean deleteEmployee(int id);
	boolean updateEmployee(Employee e);

}