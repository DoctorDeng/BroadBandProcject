package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.impl.OsLoginDaoImpl;

public class Oslogintest {

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
	public final void testFindAll() {
		//fail("Not yet implemented");
		OsLoginDaoImpl n =new OsLoginDaoImpl();
		System.out.println(n.findAll().get(2));
	}

	@Test
	public final void testFindOne() {
		//fail("Not yet implemented");
		OsLoginDaoImpl m =new OsLoginDaoImpl();
		System.out.println(m.findOne(1).getLoginInTime());
	}

	@Test
	public final void testFindAlls() {
		OsLoginDaoImpl s =new OsLoginDaoImpl();
		System.out.println(s.findAlls(2).get(0).getLoginIp());
	}

}
