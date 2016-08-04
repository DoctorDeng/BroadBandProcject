package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import bean.Page;
import bean.dto.BillDto;
import bean.dto.BillSearchDto;
import mapper.BillMapper;
import util.SqlSessionUtil;

public class TestBill {
	private SqlSession sqlSession;
	private BillMapper billMapper;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		sqlSession = SqlSessionUtil.getSqlSession();
		billMapper = sqlSession.getMapper(BillMapper.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		/*System.out.println(billMapper.selectBillDetailDtoByBillId(1).size());*/
		/*System.out.println(billMapper.selectPageBill(new Page(1,5)).size());*/
		Map map = new HashMap<>();
		map.put("customerId",2);
		map.put("month","201607");
		System.out.println(billMapper.selectBillDetailByMonthById(map).get(0).getTotalTime());
	}
	
	@Test
	public void selectBillByCondition() {
		/*BillSearchDto billSearchDto = new BillSearchDto("429005", "", "");
		List<BillDto> billDtos = billMapper.selectBillByCondition(billSearchDto);
		for (BillDto billDto : billDtos) {
			System.out.print("客户账务账号: " + billDto.getCustomerAccount() + "  ");
			System.out.print("客户姓名:" + billDto.getCustomerName());
			System.out.println();
		}*/
		BillSearchDto billSearch = new BillSearchDto("","","","201607");
		List<BillDto> bills = billMapper.selectMonthBillByCondition(billSearch);
		for (BillDto bill:bills) {
			System.out.println(bill.toString());
		}
	}
	@Test
	public void selectMonthBillByPage() {
		Page page = new Page();
		page.setIndex(0);
		page.setSize(5);
		List<BillDto> bills = billMapper.selectMonthBillByPage(page);
		for (BillDto bill:bills) {
			System.out.println(bill.toString());
		}
	}
	
	@Test
	public void getBillNum() {
		System.out.println(billMapper.getBillsNum());
	}
}
