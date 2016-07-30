package test;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import mapper.BillMapper;
import mapper.OsLoginMapper;
import util.SqlSessionUtil;

public class TestBill {
	private SqlSession sqlSession;
	private OsLoginMapper osLoginMapper;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		sqlSession = SqlSessionUtil.getSqlSession();
		osLoginMapper = sqlSession.getMapper(OsLoginMapper.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		System.out.println(osLoginMapper.selOneOsLoginByOsLoginId(1).size());
	}

}
