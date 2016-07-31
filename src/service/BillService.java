package service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.synth.SynthSpinnerUI;

import org.apache.ibatis.session.SqlSession;

import bean.Page;
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
		List<BillDetailFormBean> list = new ArrayList<>();
		List<Map<String, Object>> listMap = billDao.findBillDetailForm(billId);
				
		for (int i=0; i<listMap.size(); i++) {
			Map<String,Object> map = listMap.get(i);
			
			int billDetailId 	= Integer.parseInt(map.get("billDetailId").toString());
			int osId         	= Integer.parseInt(map.get("osId").toString());
			String osAccount    = map.get("osAccount").toString();
			String serverIp     = map.get("serverIp").toString();
			String loginAccount = map.get("loginAccount").toString();
			String tariffName   = map.get("tariffName").toString();
			/**
			 * 总时常长：秒
			 */
			int totalTime = 0;
			String timeStr     = map.get("totalTime").toString();
			if (!"".equals(timeStr)) {
				totalTime = Integer.parseInt(timeStr);
			}
			/**
			 * 获取总的时长 时/分/秒
			 */
			int h = totalTime/3600;
			int m = (totalTime%3600)/60;
			int s = (totalTime%3600)%60;
			String timeLong    = h + "时" + m + "分" + s +"秒";
			
			String tariffType = map.get("tariffType").toString();
			double tariff     = 0;
			int    timeTariff = 0;
			int    timeLongs  = 0;
			double cost       = 0;
			
			String tariffStr     = map.get("tariff").toString();
			String timeTariffStr = map.get("timeTariff").toString();
			String timeLongsStr  = map.get("timeLong").toString();
			
			if (!"".equals(tariffStr)) {
				tariff     = Double.parseDouble(tariffStr);
			}
			if (!"".equals(timeTariffStr)) {
				timeTariff = Integer.parseInt(timeTariffStr);
			}
			if (!"".equals(timeLongsStr)) {
				timeLongs  = Integer.parseInt(timeLongsStr);
			}
			
			if ("1".equals(tariffType)) {
				cost = tariff;
			} else if ("2".equals(tariffType)) {
				/**
				 * 当总时长小于套餐时长
				 */
				if (totalTime/3600 < timeLongs) {
					cost = tariff;
				}
				//当总时长大于套餐时长
				else {
					cost = tariff + (totalTime/3600 - timeLongs)*timeTariff;
				}
			} else if ("3".equals(tariffType)){
				cost = (totalTime/3600)*timeTariff;
			}
			
			BillDetailFormBean billDetailForm = new BillDetailFormBean(billDetailId,osAccount,serverIp,loginAccount,timeLong,cost,tariffName,osId);
			list.add(billDetailForm);
		}
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
		List<OsLoginFormBean> forms = bill.getOsLoginForm(1);
		for (OsLoginFormBean temp:forms) {
			System.out.println(temp.toString());
		}
		/*List<BillDetailFormBean> list = bill.getBillDetailForm(2);
		for (BillDetailFormBean billForm : list) {
			System.out.println("总时长:" + billForm.getTimeLong());
			System.out.println("资费:" + billForm.getCost());
		}*/
		/*System.out.println(bill.getBillDetailForm(1).size());*/
		/*System.out.println(bill.getOsLoginForm(1).size());*/
		/*System.out.println(bill.getBill().size());*/
		/*List<BillFormBean> billForm = bill.getBill();
		for (BillFormBean billFormBean : billForm) {
			System.out.println("总时长: " + billFormBean.getTimeLong());
		}*/
		
	}
}
