package test;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import bean.Tariff;
import mapper.TariffMapper;
import util.SqlSessionUtil;

public class TestTariff {
	SqlSession sqlsession;
	TariffMapper tariffMapper;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		sqlsession =  SqlSessionUtil.getSqlSession();
		tariffMapper = sqlsession.getMapper(TariffMapper.class);
	}

	@After
	public void tearDown() throws Exception {
		sqlsession.commit();
		sqlsession.close();
	}

	/**
	 * 查询所有信息
	 */
	@Test
	public final void testFindAll() {
		List<Tariff>ta = tariffMapper.findAll();
		for(Tariff t:ta){
			System.out.println(t);
		}
	}
	
	/**
	 *查询一条信息 
	 */
	@Test
	public final void testFindOne() {
		System.out.println(tariffMapper.findOne(1));
	}
	
	/**
	 * 添加一条信息
	 */
	@Test
	public final void testAdd() {
		Tariff tf = new Tariff("包时211",5.5,13,31,"2","我是包时211");
		System.out.println(tariffMapper.add(tf));
	}
	/**
	 * 删除一条信息
	 */
	@Test
	public final void testDel() {
		System.out.println(tariffMapper.del(56));
	}
	/**
	 * 修改一条信息
	 */
	@Test
	public final void testUpdate() {
		Tariff tff = new Tariff(60,"包时110",11.3,22,33,"1","我是包时110");
		System.out.println(tariffMapper.update(tff));
	}
	/**
	 * 修改状态信息
	 */
	@Test
	public final void testUpdateStatus(){
		System.out.println(tariffMapper.updateStatus(57));
	}
	

}
