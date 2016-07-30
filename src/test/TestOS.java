package test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import bean.Bussiness;
import bean.Customer;
import bean.Os;
import bean.dto.OsDto;
import mapper.BussinessMapper;
import mapper.CustomerMapper;
import mapper.OsMapper;
import util.SqlSessionUtil;

public class TestOS {
	private SqlSession sqlSession;
	private OsMapper osMapper;
	private BussinessMapper bussinessMapper;
	private CustomerMapper customerMapper;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	
	}

	@Before
	public void setUp() throws Exception {
	sqlSession = SqlSessionUtil.getSqlSession();
	osMapper = sqlSession.getMapper(OsMapper.class);
	bussinessMapper = sqlSession.getMapper(BussinessMapper.class);
	customerMapper = sqlSession.getMapper(CustomerMapper.class);
	}

	@After
	public void tearDown() throws Exception {
	sqlSession.commit();
	sqlSession.close();
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
		String idNumber = "6222011996410153015";
		Customer customer = customerMapper.selectCustomerByIdNumber(idNumber);
		
	}
	/**
	 * 测试业务表的界面显示信息功能
	 */
	@Test
	public void selServiceShow(){
		List<OsDto> listDto = osMapper.selServiceShow();
		for(OsDto osDto:listDto){
		System.out.println(osDto);
		}
	}
}
