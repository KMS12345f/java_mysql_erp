package java_mysql_erp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java_mysql_erp.dao.DepartmentDao;
import java_mysql_erp.dao.DepartmentDaoTest;
import java_mysql_erp.dto.Department;
import java_mysql_erp.util.JdbcUtil;

public class DepartmentDaoImpl implements DepartmentDao {
	private static final DepartmentDaoImpl instance = new DepartmentDaoImpl();

	private DepartmentDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public static DepartmentDaoImpl getInstance() {
		return instance;
	}

	@Override
	public ArrayList<Department> selectDepartmentByAll() {
		String sql = "select code, name, floor from department";
		ArrayList<Department> list = null;
		try (Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			list = new ArrayList<Department>();
			while (rs.next()) {
				list.add(getDepartment(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Department selectDepartmentByNo(Department department) {
		String sql = "select * from department where code = ?";
		try(
				Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
			){
			pstmt.setInt(1, department.getDeptNo());
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return getDepartment(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private Department getDepartment(ResultSet rs) throws SQLException {
		// deptno, deptname, floor // 반복문 안에서 생성하는건 좋지않다
		int code = rs.getInt("code");
		String name = rs.getString("name");
		int floor = rs.getInt("floor");
		Department newDept = new Department(code, name, floor);
		return newDept;
	}

	@Override
	public int insertDepartment(Department department) {
		String sql = "insert into department values(?, ?, ?);";
		try(Connection con = JdbcUtil.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setInt(1, department.getDeptNo());
			pstmt.setString(2, department.getDeptName());
			pstmt.setInt(3, department.getFloor());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updataDepartment(Department department) {
		String sql = "update department set name = ? where code = ?";
		try(Connection con = JdbcUtil.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql); 
					){
			pstmt.setString(1, department.getDeptName());
			pstmt.setInt(2, department.getDeptNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteDepartment(Department department) {
		String sql = "delete from department where code = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
				pstmt.setInt(1, department.getDeptNo());
				return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
