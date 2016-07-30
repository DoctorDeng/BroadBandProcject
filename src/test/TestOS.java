package test;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import bean.Os;
import mapper.OsMapper;
import util.SqlSessionUtil;

public class TestOS {
	static SqlSession sqlSession;
	static OsMapper osMapper;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	sqlSession = SqlSessionUtil.getSqlSession();
	osMapper = sqlSession.getMapper(OsMapper.class);
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	/**
	 * 测试Os表的一次查询
	 */
	@Test
	public void selOneOsByOsid(){
	 Os os =osMapper.selOneOsByOsid(1);
	 System.out.println(os);
	}

}
