package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.impl.OsLoginDaoImpl;

public class OSTest {
    OsLoginDaoImpl osdi = new OsLoginDaoImpl();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindAll() {
		System.out.println(osdi.findAll().size());
	}

	@Test
	public void testFindOne() {
		System.out.println(osdi.findOne(1).getLoginInTime());
	}

	@Test
	public void testfindLoginForm() {
		System.out.println(osdi.findLoginFormById(1));
	}

	@Test
	public void testfindAlls() {
		System.out.println(osdi.findAlls(1));
	}

}
