package java_mysql_erp.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java_mysql_erp.dao.impl.DepartmentDaoImpl;
import java_mysql_erp.dto.Department;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DepartmentDaoTest {
	private static DepartmentDao dao = DepartmentDaoImpl.getInstance();
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("테스트 클래스 시작 전 - setUpBeforeClass");
		dao = DepartmentDaoImpl.getInstance();
		System.out.println();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("테스트 클래스 종료 후 - tearDownAfterClass");
		dao = null;
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Test메서드 수행 전 - setUp");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Test메서드 수행 후 - tearDown");
		System.out.println();
	}

	@Test
	public void test01SelectDepartmentByAll() {
		System.out.println("testSelectDepartmentByNo");
		ArrayList<Department> list = dao.selectDepartmentByAll();
		Assert.assertNotEquals(0, list.size());
		list.stream().forEach(System.out::println);
	}

	@Test
	public void test02SelectDepartmentByNo() {
		System.out.println("testSelectDepartmentByNo");
		Department selectDept = dao.selectDepartmentByNo(new Department(2));
		Assert.assertNotNull(selectDept); //@test부터 void가지는 jUnit의 기본형식
		System.out.println(selectDept);  // Assert는 왼쪽 초록색 판별여부
	}

	@Test
	public void test03InsertDepartment() {
		System.out.println("testInsertDepartment");
		Department newDept = new Department(4, "총무", 25);
		int res = dao.insertDepartment(newDept);
		Assert.assertEquals(1, res);
		
		dao.deleteDepartment(newDept); // 추가된거 바로 삭제
	}

	@Test
	public void test04UpdataDepartment() {
		System.out.println("testUpdataDepartment");
		//추가 수정(검증) 변경유무 확인 삭제 순서대로
		Department dept = new Department(4, "총무", 25);
		dao.insertDepartment(dept);
		
		dept.setDeptName("인사");
		dept.setFloor(19);
		int res = dao.updataDepartment(dept);
		Assert.assertEquals(1, res);
		
		Department selDept = dao.selectDepartmentByNo(dept);
		System.out.println(selDept);
		
		dao.deleteDepartment(selDept);
	}

	@Test
	public void test05DeleteDepartment() {
		System.out.println("testDeleteDepartment");
		// 추가 삭제(검증) 삭제검증
		
		Department dept = new Department(4, "총무", 25);
		dao.insertDepartment(dept);
		
		
		int res = dao.deleteDepartment(dept);
		Assert.assertEquals(1, res);
		
		Department selDept = dao.selectDepartmentByNo(dept);
		Assert.assertNull(selDept);
	}

}
