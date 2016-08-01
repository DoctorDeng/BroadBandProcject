package service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.synth.SynthSpinnerUI;

import org.apache.ibatis.session.SqlSession;

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
	 * 通过分页，获取指定页的账单信息
	 * @return  包含账单信息的PageDto
	 */
	public PageDto<BillFormBean> getBillFormByPage(String currentPageStr, int pageSize) {
		
		init();
		int recordNum = billMapper.getBillNum();
		
		PageDto<BillFormBean> pageDto = new PageDto<>();
		pageDto.init(recordNum, pageSize, currentPageStr);
		
		List<BillDto> billDtos = billMapper.selectPageBill(new Page((pageDto.getCurrentPage()-1)*pageSize,pageSize)); 
		
		List<BillFormBean> billForms = BillUtil.billDtoToBillFormBean(billDtos);
		
		pageDto.setDataList(billForms);
		close();
		return pageDto;
	}
	/**
	 * 获取客户Os账号登陆表单信息
	 * @param osId   账号Id
	 * @return
	 */
	public List<OsLoginFormBean>   getOsLoginForm(int osId) {
		try {
			sqlSession = SqlSessionUtil.getSqlSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		OsLoginMapper osLoginMapper = sqlSession.getMapper(OsLoginMapper.class);
		
		List<OsLoginDto> osLoginDtos = osLoginMapper.selectOsLoginDtoByOsId(osId);
		List<OsLoginFormBean> loginList = OsLoginUtil.osLoginDtoToFormBean(osLoginDtos);
		
		close();
		return loginList;
	}
	/**
	 * 获取客户详单信息
	 * @param billId  账单Id
	 * @return  返回详单表单Bean的集合
	 */
	public List<BillDetailFormBean> getBillDetailForm(int billId) {
		init();
		
		List<BillDetailDto> billDetailDtos = billMapper.selectBillDetailDtoByBillId(billId);
		
		List<BillDetailFormBean> list = BillUtil.billDetailDtoToFormBean(billDetailDtos);
		
		close();
		return list;
	}
	/**
	 * 通过客户身份证号、账务账号、客户姓名来查找客户的
	 * @param idNumber       客户身份证号
	 * @param loginAccount   客户账务账号
	 * @param customerName   客户姓名
	 * @return               账单表单Bean（包含用户账单信息）集合
	 */
	public PageDto<BillFormBean> getBillFormByCondition(String idNumber, String customerAccount, String customerName) {
		init();
		
		BillSearchDto billSearchDto = new BillSearchDto(idNumber, customerAccount, customerName);
		
		List<BillDto> billDtos = billMapper.selectBillByCondition(billSearchDto);
		
		List<BillFormBean> billForms = BillUtil.billDtoToBillFormBean(billDtos);
		
		close();
		PageDto<BillFormBean> pageDto = new PageDto<>();
		pageDto.setDataList(billForms);
		
		return pageDto;
	}
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
		
		List<BillDetailFormBean> forms = bill.getBillDetailForm(1);
		for (BillDetailFormBean temp:forms) {
			System.out.println(temp.toString());
		}
	}
}
