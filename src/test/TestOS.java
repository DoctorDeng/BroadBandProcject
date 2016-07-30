package test;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import bean.Bussiness;
import bean.Os;
import mapper.BussinessMapper;
import mapper.OsMapper;
import util.SqlSessionUtil;

public class TestOS {
	private SqlSession sqlSessiona;
	private SqlSession sqlSessionb;
	private OsMapper osMapper;
	private BussinessMapper bussinessMapper;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	
	}

	@Before
	public void setUp() throws Exception {
	sqlSessiona = SqlSessionUtil.getSqlSession();
	sqlSessionb = SqlSessionUtil.getSqlSession();
	osMapper = sqlSessiona.getMapper(OsMapper.class);
	bussinessMapper = sqlSessiona.getMapper(BussinessMapper.class);
	}

	@After
	public void tearDown() throws Exception {
	sqlSessiona.commit();
	sqlSessionb.commit();
	sqlSessiona.close();
	sqlSessionb.close();
	}
	/**
	 * 测试Os表的一次查询
	 */
	@Test
	public void selOneOsByOsid(){
	 Os os =osMapper.selOneOsByOsid(1);
	 System.out.println(os);
	}
	
	/**
	 * 测试Os表的删除功能
	 */
	@Test
	public void delOneOsByOsId(){
		 Bussiness bussiness = bussinessMapper.selectBussinessById(1);
		 System.out.println(bussiness.getOsId());
		 bussinessMapper.deleteBussiness(1);
		 System.out.println("1111");
		 osMapper.delOneOsByOsId(bussiness.getOsId());
		 System.out.println("2222");
	}
	/**
	 * 测试业务表的添加功能
	 */
	@Test
	public void test(){
		
	}
}
