package test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import bean.viewBean.BussinessViewBean;
import dao.impl.BussinessViewBeanDaoImpl;

public class TestBussinessView {
	BussinessViewBeanDaoImpl bvbd = new BussinessViewBeanDaoImpl();
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
		BussinessViewBean biv = new BussinessViewBean();
		biv.setAdminId(Integer.parseInt("1"));
		biv.setCustomerName("木木");
		biv.setIdNumber("123466789");
		biv.setOsAccount("1");
		biv.setServerId("194.245.0.14");
		biv.setStatus("暂停");
		biv.setTariffId(Integer.parseInt("2"));
		bvbd.findAll();
	}

}
