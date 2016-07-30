package test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import bean.Customer;
import mapper.impl.CustomerDaoImpl;

public class TestCutomer {
	CustomerDaoImpl ctd = new CustomerDaoImpl();
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
		fail("Not yet implemented");
	}

	@Test
	public void testFindOne() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdd() {
		Customer customer  = new Customer();
		customer.setCustomerName("曾聪");
		customer.setIdNumber("622201177410153256");
		customer.setPhone("132456789");
		ctd.add(customer);
	}

	@Test
	public void testDel() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

}
