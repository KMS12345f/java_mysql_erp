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

import java_mysql_erp.dao.impl.TitleDaoImpl;
import java_mysql_erp.dto.Title;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TitleDaoTest {
	private TitleDao dao;

	@Before
	public void setUp() throws Exception {
		dao = TitleDaoImpl.getInstance();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println();
		dao = null;
	}

	@Test
	public void test01SelectTitleByAll() {
		System.out.println("testSelectTitleByAll()");
		ArrayList<Title> list = dao.selectTitleByAll();
		Assert.assertNotEquals(0, list.size());
//		list.stream().forEach(System.out::println);
		list.stream().forEach(s -> System.out.println(s));
	}

	@Test
	public void test02SelectTitleByCode() {
		System.out.println("testSelectTitleByCode()");
		Title selectTitle = dao.selectTitleByCode(new Title(5));
		Assert.assertNotNull(selectTitle);
		System.out.println(selectTitle);
	}

	@Test
	public void test03InsertTitle() {
		System.out.println("testInsertTitle()");
		Title newTitle = new Title(6, "인턴");
		int res = dao.insertTitle(newTitle);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test04UpdateTitle() {
		System.out.println("testUpdateTitle()");
		// 검색 후 수정
		Title selectedTitle = dao.selectTitleByCode(new Title(6));
		selectedTitle.setName("계약직");

		int res = dao.updateTitle(selectedTitle);
		Assert.assertEquals(1, res);
		
		test01SelectTitleByAll();
	}

	@Test
	public void test05DeleteTitle() {
		System.out.println("testDeleteTitle()");
		int res = dao.deleteTitle(new Title(6));
		Assert.assertEquals(1, res);
		test01SelectTitleByAll();
	}

}
