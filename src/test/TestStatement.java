package test;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import bean.Page;
import mapper.StatementMapper;
import util.SqlSessionUtil;

public class TestStatement {
	private SqlSession sqlSession;
	private StatementMapper statementMapper;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		sqlSession = SqlSessionUtil.getSqlSession();
		statementMapper = sqlSession.getMapper(StatementMapper.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Page page = new Page(0,5);
		System.out.println(statementMapper.selectStatementByPagging(page).size());
	}

}
