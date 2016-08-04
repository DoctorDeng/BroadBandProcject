package test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import mapper.OsLoginMapper;
import util.SqlSessionUtil;

public class TestOsLogin {
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
	public void selOneOsLoginByOsLoginId() {
		/*System.out.println(osLoginMapper.selOneOsLoginByOsLoginId(4));*/
		Map map = new HashMap<>();
		map.put("osId","2");
		map.put("month", "201606");
		System.out.println(osLoginMapper.selectOsLoginByMonthById(map).size());
	}

}
