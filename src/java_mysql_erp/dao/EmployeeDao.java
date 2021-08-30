package java_mysql_erp.dao;

import java.util.ArrayList;

import java_mysql_erp.dto.Employee;

public interface EmployeeDao {
	ArrayList<Employee> selectEmployeeAll();
	Employee selectEmployeeByNo(Employee emp);
	
	int insertEmployee(Employee emp);
	int updateEmployee(Employee emp);
	int deleteEmployee(Employee emp);
}
