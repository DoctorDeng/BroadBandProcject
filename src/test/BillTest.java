package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.impl.BillDaoImpl;
import jdk.nashorn.internal.ir.annotations.Ignore;

public class BillTest {
	BillDaoImpl bdI = new BillDaoImpl();
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
	public void testFindBillForm() {
		System.out.println(bdI.findBillForm().size());
	}
	/*@Test
	public void testFindBillDetailForm() {
		System.out.println(bdI.findBillDetailForm(1));
	}*/
	
}
