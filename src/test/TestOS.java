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
import bean.Tariff;
import bean.dto.OsAddDto;
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
		 bussinessMapper.deleteBussiness(1);
		 osMapper.delOneOsByOsId(bussiness.getOsId());
	}
	/**
	 * 测试业务表的添加功能
	 */
	@Test
	public void addOsInfo(){
		String idNumber = "622201199410153014";
		Customer customer = customerMapper.selectCustomerByIdNumber(idNumber);
		OsAddDto osAddDto = new OsAddDto();
		osAddDto.setCustomerId(customer.getCustomerId());
		osAddDto.setTariffId(1);
		osAddDto.setOsAccount("yya");
		osAddDto.setOsPassword("woshizhu");
		osAddDto.setServerIp("184.123.123.123");
		osAddDto.setStatus("1");
		osMapper.addOsInfo(osAddDto);
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
	/**
	 * 通过业务账号通过业务Id来修改Os表里面的资费类型
	 */
	@Test
	public void upOneOsByBussinessId(){
		Bussiness bussiness = bussinessMapper.selectBussinessById(1);
		Os os = new Os();
		os.setOsId(bussiness.getOsId());
		os.setTariffId(2);
		osMapper.upOneOsByBussinessId(os);
	}
	/**
	 * 通过条件查询
	 */
	@Test
	public void selChooseInfo(){
		OsDto osD = new OsDto();
		osD.setIdNumber("429005199608082512");
		List<OsDto> listDto = osMapper.selChooseInfo(osD);
		for(OsDto osDto:listDto){
		System.out.println(osDto);
		}
	}
}
