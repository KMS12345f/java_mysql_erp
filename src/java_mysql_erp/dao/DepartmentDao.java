package java_mysql_erp.dao;

import java.util.ArrayList;

import java_mysql_erp.dto.Department;

public interface DepartmentDao {
	ArrayList<Department> selectDepartmentByAll();
	Department selectDepartmentByNo(Department department);
	
	int insertDepartment(Department department);
	int updataDepartment(Department department);
	int deleteDepartment(Department department);
}
