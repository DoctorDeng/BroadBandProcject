package service;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import bean.Bill;
import bean.Page;
import bean.dto.BillDetailDto;
import bean.dto.BillDto;
import bean.dto.BillSearchDto;
import bean.dto.OsLoginDto;
import bean.dto.PageDto;
import bean.vo.BillDetailFormBean;
import bean.vo.BillFormBean;
import bean.vo.OsLoginFormBean;
import mapper.BillMapper;
import mapper.OsLoginMapper;
import util.BillUtil;
import util.OsLoginUtil;
import util.SqlSessionUtil;

public class BillService {
	private SqlSession sqlSession;
	private BillMapper billMapper;
	
	public BillService() {
	}
	/**
	 * 获取指定页的月份账单信息
	 * @param currentPageStr  当前页页码的字符串表示形式
	 * @param pageSize        页面数据条数 
	 * @return PageDto<BillFormBean>
	 */
	public PageDto<BillFormBean> getMonthBillFormByPage(String currentPageStr, int pageSize) {
		init();
		int recordNum = billMapper.getBillsNum();
		
		PageDto<BillFormBean> pageDto = new PageDto<>();
		pageDto.init(recordNum, pageSize, currentPageStr);
		
		List<BillDto> billDtos = billMapper.selectMonthBillByPage(new Page((pageDto.getCurrentPage()-1)*pageSize,pageSize)); 
		
		List<BillFormBean> billForms = BillUtil.monthBillDtoToBillFormBean(billDtos);
		
		pageDto.setDataList(billForms);
		close();
		return pageDto;
	}
	/**
	 * 通过条件查询月份账单信息
	 * @param idNumber         客户身份证号
	 * @param customerAccount  客户账务账号
	 * @param customerName     客户姓名
	 * @param month            月份
	 * @return PageDto<BillFormBean>
	 */
	public PageDto<BillFormBean> getMonthBillFormByCondition(String idNumber, String customerAccount, String customerName,String month) {
		init();
		
		BillSearchDto billSearchDto = new BillSearchDto(idNumber, customerAccount, customerName,month);
		
		List<BillDto> billDtos = billMapper.selectMonthBillByCondition(billSearchDto);
		
		List<BillFormBean> billForms = BillUtil.monthBillDtoToBillFormBean(billDtos);
		
		close();
		PageDto<BillFormBean> pageDto = new PageDto<>();
		pageDto.setDataList(billForms);
		
		return pageDto;
	}
	/**
	 * 查找指定OS账号的指定月份的登录信息
	 * @param osId    os账号Id
	 * @param months  月份
	 * @return        List<OsLoginFormBean>
	 */
	public List<OsLoginFormBean>   getOsLoginFormByMonth(int osId,String months) {
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		OsLoginMapper osLoginMapper = sqlSession.getMapper(OsLoginMapper.class);
		Map map = new HashMap();
		map.put("osId",osId);
		map.put("months",months);
		
		List<OsLoginDto> osLoginDtos = osLoginMapper.selectOsLoginByMonthById(map);
		List<OsLoginFormBean> loginList = OsLoginUtil.osLoginDtoToFormBean(osLoginDtos);
		
		close();
		return loginList;
	} 
	/**
	 * 获取指定客户指定月份的各账号的详单信息
	 * @param customerId   客户ID
	 * @param months       月份
	 * @return  List<BillDetailFormBean>
	 */
	public List<BillDetailFormBean> getMonthBillDetailForm(int customerId,String months) {
		init();
		Map map = new HashMap();
		map.put("customerId", customerId);
		map.put("months", months);
		
		List<BillDetailDto> billDetailDtos = billMapper.selectBillDetailByMonthById(map);
		
		for (BillDetailDto billDetails : billDetailDtos) {
			billDetails.setMonths(months);
		}
		
		List<BillDetailFormBean> list = BillUtil.billDetailDtoToFormBean(billDetailDtos);
		
		close();
		return list;
	}
	/**
	 * 通过后台OsLogin数据更新账单表的资费数据
	 * @return
	 */
	public boolean updateAllBill() {
		init();
		List<BillDto> bills = billMapper.selectAllMonthBill();
		int resultNum = 0;
		for (int i=0; i<bills.size(); i++) {
			BillDto bill = bills.get(i);
			List<BillDetailFormBean> billDetails = getMonthBillDetailForm(bill.getCustomerId(),bill.getMonths());
			double cost = 0.00;
			
			for (BillDetailFormBean billDetail: billDetails) {
				cost += Double.parseDouble(billDetail.getCost()); 
			}
			System.out.println(cost);
			Map map = new HashMap();
			map.put("customerId",bill.getCustomerId());
			map.put("months", bill.getMonths());
			map.put("cost", cost);
			
			try {
				SqlSession sqlSession = SqlSessionUtil.getSqlSession();
				BillMapper billMapper = sqlSession.getMapper(BillMapper.class);
				int result = billMapper.updateBill(map);
				if (result >0) {
					sqlSession.commit();
					resultNum += 1;
				} else {
					sqlSession.rollback();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(resultNum);
		return true;
	}
	
/*	public void test(){
		init();
		Map map = new HashMap();
		map.put("customerId",1);
		map.put("months", 201603);
		map.put("cost", 30);
		System.out.println(billMapper.updateBill(map));;
		close();
	}*/
	
	/**
	 * 初始化SqlSession和mapper
	 */
	public void init(){
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
			billMapper = sqlSession.getMapper(BillMapper.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//提交关闭SqlSession
	public void close(){
		sqlSession.commit();
		sqlSession.close();
	}
	
	public static void main(String[] args) {
		BillService bill = new BillService();
		/*System.out.println(bill.getBillFormByCondition("", "", "").size());*/
		/*List<BillFormBean> bills = bill.getBillFormByCondition("", "", "邓华杰").getDataList();
		
		for (BillFormBean temp: bills) {
			System.out.println(temp.toString());
		}*/
	/*	List<OsLoginFormBean> forms = bill.getOsLoginForm(1);
		for (OsLoginFormBean temp:forms) {
			System.out.println(temp.toString());
		}*/
		
	/*	List<BillDetailFormBean> forms = bill.getMonthBillDetailForm(1,"201603");
		for (BillDetailFormBean temp:forms) {
			System.out.println(temp.toString());
		}*/
		/*PageDto<BillFormBean> page = bill.getMonthBillFormByPage("1",5);
		for (BillFormBean temp: page.getDataList()) {
			System.out.println(temp.toString());
		}*/
	/*	BillSearchDto billSearch = new BillSearchDto("","","","201607");
		PageDto<BillFormBean> page = bill.getMonthBillFormByCondition("", "", "杨", "201607");
		for (BillFormBean temp: page.getDataList()) {
			System.out.println(temp.toString());
		}*/
		/*List<OsLoginFormBean> osLogins = bill.getOsLoginFormByMonth(1, "201606");
		for (OsLoginFormBean osLogin:osLogins) {
			System.out.println(osLogin.toString());
		}*/
		bill.updateAllBill();
	/*	bill.test();*/
	}
}
