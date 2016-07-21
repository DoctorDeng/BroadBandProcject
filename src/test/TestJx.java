package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import bean.AdminInfor;
import dao.impl.AdminDaoImpl;
import dao.impl.AdminInforDaoImpl;
import dao.impl.CustomerDaoImpl;
import jdk.nashorn.internal.ir.annotations.Ignore;

public class TestJx {
	CustomerDaoImpl customerDao = new CustomerDaoImpl();
    AdminInforDaoImpl admininforDao = new AdminInforDaoImpl();
    AdminDaoImpl adminDao = new AdminDaoImpl();
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

	@Ignore
	public void testFindAll() {
		 System.out.println(admininforDao.findAll().size());
	}
	@Ignore
	public void testfindAdminInforByadminId() {
		  System.out.println(admininforDao.findAdminInforByadminId(1).getEmail());   
	}
	@Ignore
	public void testfindAdminInforByInforId() {
		System.out.println(admininforDao.findAdminInforByInforId(8).getEmail()); 
	}
	@Ignore
	public void testdelAdminInfor() {
		System.out.println(admininforDao.delAdminInfor(1));
	}
	@Ignore
	public void testaddAdminInfor() {
	AdminInfor admininfor = new AdminInfor();
	admininfor.setAdminId(1);
	admininfor.setIdNumber("542123199612270023");
	admininfor.setEmail("1541@qq.com");
	admininfor.setPhone("13277412390");
	System.out.println(admininforDao.addAdminInfor(admininfor));
	}
	@Ignore
	public void testupdateAdminInfor() {
		AdminInfor adminInfor = new AdminInfor();
		adminInfor.setAdminId(1);
		adminInfor.setAdminName("徐川川 ");
		adminInfor.setPhone("13255523625");
		adminInfor.setEmail("1412@qq.com");
		System.out.println(admininforDao.updateAdminInfor(adminInfor));
	}
}
