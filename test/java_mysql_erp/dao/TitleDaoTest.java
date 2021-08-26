package java_mysql_erp.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java_mysql_erp.dao.impl.TitleDaoImpl;
import java_mysql_erp.dto.Title;

public class TitleDaoTest {
	private TitleDao dao;

	@Before
	public void setUp() throws Exception {
		dao = TitleDaoImpl.getInstance();
	}

	@After
	public void tearDown() throws Exception {
		dao = null;
	}

	@Test
	public void testSelectTitleByAll() {
		System.out.println("testSelectTitleByAll()");
		ArrayList<Title> list = dao.selectTitleByAll();
		Assert.assertNotEquals(0, list.size());
//		list.stream().forEach(System.out::println);
		list.stream().forEach(s -> System.out.println(s));
	}

	@Test
	public void testSelectTitleByCode() {
		System.out.println("testSelectTitleByCode()");
		Title selectTitle = dao.selectTitleByCode(new Title(5));
		Assert.assertNotNull(selectTitle);
		System.out.println(selectTitle);
	}

	@Test
	public void testInsertTitle() {
		System.out.println("testInsertTitle()");
		Title newTitle = new Title(6, "인턴");
		int res = dao.insertTitle(newTitle);
		Assert.assertEquals(1, res);
	}

	@Test
	public void testUpdateTitle() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteTitle() {
		fail("Not yet implemented");
	}

}
