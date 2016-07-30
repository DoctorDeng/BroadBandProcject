package test;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import mapper.AdminMapper;
import util.SqlSessionUtil;

public class TestAdmin {
	private SqlSession sqlSession;
	private AdminMapper adminMapper;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		sqlSession = SqlSessionUtil.getSqlSession();
		adminMapper = sqlSession.getMapper(AdminMapper.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSelectAdminById() {
		System.out.println(adminMapper.selectAdminById(5).getPowers().size());
	}
	@Test
	public void testSelectAllAdmin() {
		System.out.println(adminMapper.selectAllAdmin().size());
	}

}
