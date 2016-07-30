package test;

import static org.junit.Assert.fail;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import mapper.PowerMapper;
import util.SqlSessionUtil;

public class TestPower {
	private SqlSession sqlSession;
	private PowerMapper powerMapper;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		sqlSession = SqlSessionUtil.getSqlSession();
		powerMapper = sqlSession.getMapper(PowerMapper.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		/*System.out.println(powerMapper.selectPowerByAdminId(1).size());*/
		System.out.println(powerMapper.selectAllPower().size());
	}

}
