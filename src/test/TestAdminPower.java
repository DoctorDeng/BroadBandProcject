package test;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import bean.AdminPower;
import mapper.AdminPowerMapper;
import util.SqlSessionUtil;

public class TestAdminPower {
	private SqlSession sqlSession;
	private AdminPowerMapper adminPowerMapper;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		sqlSession = SqlSessionUtil.getSqlSession();
		adminPowerMapper = sqlSession.getMapper(AdminPowerMapper.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDeleteAdminPower() {
		System.out.println(adminPowerMapper.deleteAdminPower(3));
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testInsertAdminPower() {
		AdminPower adminPower = new AdminPower(3,1);
		AdminPower adminPower1 = new AdminPower(3,3);
		List<AdminPower> adminPowers = new ArrayList<>();
		adminPowers.add(adminPower);
		adminPowers.add(adminPower1);
		
		System.out.println(adminPowerMapper.insertAdminPower(adminPowers));
		sqlSession.commit();
		sqlSession.close();
	}
	

}
