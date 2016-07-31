package service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bean.vo.BillDetailFormBean;
import bean.vo.BillFormBean;
import bean.vo.OsLoginFormBean;
import mapper.impl.BillDaoImpl;
import mapper.impl.OsLoginDaoImpl;

public class BillService {
	private 
	
	private OsLoginDaoImpl  osLoginDao;
	private BillDaoImpl   billDao;
	
	public BillService() {
		osLoginDao = new OsLoginDaoImpl();
		billDao = new BillDaoImpl();
	}
	/**
	 * 获取账单表格显示所需要的信息，涉及到多表查询
	 */
	public List<BillFormBean> getBill(){
		List<BillFormBean> billFormList  = new ArrayList<>();
		List<Map<String,Object>> listMap = billDao.findBillForm();
		
		for (int i=0; i<listMap.size(); i++) {
			Map<String,Object> map = listMap.get(i);
			
			int billId 			= Integer.parseInt(map.get("billId").toString());
			String customerName = map.get("customerName").toString();
			String idNumber     = map.get("idNumber").toString();
			String loginAccount = map.get("loginAccount").toString();
			String totalTime    = map.get("totalTime").toString();
			String payWay       = map.get("payWay").toString();
			String payStatus    = map.get("payStatus").toString();
			
			int times = 0;
			if (!"".equals(totalTime)) {
				times = Integer.parseInt(totalTime);
			}
			
			/**
			 * 获取总的时长 时/分/秒
			 */
			int h = times/3600;
			int m = (times%3600)/60;
			int s = (times%3600)%60;
			String timeLong    = h + "时" + m + "分" + s +"秒";
			
			
			BillFormBean billForm = new BillFormBean(billId, customerName, idNumber, loginAccount, timeLong, payWay, payStatus);
			billFormList.add(billForm);
		}
		return billFormList;
	}
	/**
	 * 通过分页，获取指定页的账单信息
	 * @return  表单Bean信息集合
	 */
	public List<BillFormBean> getBillFormByPage(int index, int pageSize) {
		List<BillFormBean> billFormList  = new ArrayList<>();
		List<Map<String,Object>> listMap =billDao.findBillFormPage(index, pageSize);
		
		for (int i=0; i<listMap.size(); i++) {
			Map<String,Object> map = listMap.get(i);
			
			int billId 			= Integer.parseInt(map.get("billId").toString());
			String customerName = map.get("customerName").toString();
			String idNumber     = map.get("idNumber").toString();
			String loginAccount = map.get("loginAccount").toString();
			String totalTime    = map.get("totalTime").toString();
			String payWay       = map.get("payWay").toString();
			String payStatus    = map.get("payStatus").toString();
			
			int times = 0;
			if (!"".equals(totalTime)) {
				times = Integer.parseInt(totalTime);
			}
			
			/**
			 * 获取总的时长 时/分/秒
			 */
			int h = times/3600;
			int m = (times%3600)/60;
			int s = (times%3600)%60;
			String timeLong    = h + "时" + m + "分" + s +"秒";
			
			BillFormBean billForm = new BillFormBean(billId, customerName, idNumber, loginAccount, timeLong, payWay, payStatus);
			billFormList.add(billForm);
		}
		return billFormList;
	}
	/**
	 * 获取客户Os账号登陆表单信息
	 * @param osId   账号Id
	 * @return
	 */
	public List<OsLoginFormBean>   getOsLoginForm(int osId) {
		List<Map<String,Object>> list = osLoginDao.findLoginFormById(osId);
		List<OsLoginFormBean> loginList = new ArrayList<>();
		
		for (int i=0; i<list.size(); i++) {
			Map<String,Object> map = list.get(i);
			OsLoginFormBean osLogin = new OsLoginFormBean();
			
			double cost       = 0;
			double tariff     = Double.parseDouble(map.get("tariff").toString());
			int timeTariff    = Integer.parseInt(map.get("timeTariff").toString());
			int timeLong      = Integer.parseInt(map.get("timeLong").toString());
			String tariffType = map.get("tariffType").toString();
			int time   = Integer.parseInt(map.get("timeLogin").toString());
			/*
			 * 资费类型为套餐时
			 */
		    if ("2".equals(tariffType)) {
		    	//当总时长大于套餐时长
				if (time/3600 > timeLong) {
					cost = tariff + (time/3600 - timeLong)*timeTariff;
				}
			}
		    /**
		     * 资费类型为按时 时
		     */
		    else if ("3".equals(tariffType)){
				cost = (time/3600)*timeTariff;
			}
			
		    String loginIp      = map.get("loginIp").toString();
		    String loginInTime  = map.get("loginInTime").toString();
		    String loginOutTime = map.get("loginOutTime").toString();
		    String tariffName   = map.get("tariffName").toString();
		    
		    osLogin.setLoginIp(loginIp);
		    osLogin.setLoginInTime(loginInTime);
		    osLogin.setLoginOutTime(loginOutTime);
		    osLogin.setTimeLong(time);
		    osLogin.setCost(String.valueOf(cost));
		    osLogin.setTariffName(tariffName);
		    loginList.add(osLogin);
		}
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
	 * 获取客户账单信息长度
	 * @return    账单信息长度
	 */
	public int getBillFormSize() {
		return billDao.getBillFormSize();
	}
	/**
	 * 通过客户身份证号、账务账号、客户姓名来查找客户的
	 * @param idNumber       客户身份证号
	 * @param loginAccount   客户账务账号
	 * @param customerName   客户姓名
	 * @return               账单表单Bean（包含用户账单信息）集合
	 */
	public List<BillFormBean> getBillFormByCondition(String idNumber, String loginAccount, String customerName) {
		String idNumberTemp 	= "%";
		String loginAccountTemp = "%";
		String customerNameTemp = "%";
		
		if (null != idNumber && !"".equals(idNumber)) {
			idNumberTemp = idNumber.trim();
		}
		if (null != loginAccount && !"".equals(loginAccount)) {
			loginAccountTemp = loginAccount.trim();
		}
		if (null != customerName && !"".equals(customerName)) {
			customerNameTemp = customerName.trim();
		}
		
		String sqlCondition = " WHERE cu.idNumber like '%" +idNumberTemp+ "%' AND "
				+ " cu.customerName like '%" +customerNameTemp+ "%' AND "
				+ " loginAccount like '%" +loginAccountTemp+ "%'";
		
		return toBillFormBean(billDao.findBillFormBycondition(sqlCondition));
	}
	/**
	 * 将含有客户账单信息的List<Map<String,Object>>转化为用于前台显示的List<BillFormBean>
	 * @param billFormList
	 * @return
	 */
	public List<BillFormBean> toBillFormBean(List<Map<String,Object>> billForms) {
		List<BillFormBean> billFormList  = new ArrayList<>();
		
		for (int i=0; i<billForms.size(); i++) {
			Map<String,Object> map = billForms.get(i);
			
			int billId 			= Integer.parseInt(map.get("billId").toString());
			String customerName = map.get("customerName").toString();
			String idNumber     = map.get("idNumber").toString();
			String loginAccount = map.get("loginAccount").toString();
			String totalTime    = map.get("totalTime").toString();
			String payWay       = map.get("payWay").toString();
			String payStatus    = map.get("payStatus").toString();
			
			int times = 0;
			if (!"".equals(totalTime)) {
				times = Integer.parseInt(totalTime);
			}
			
			/**
			 * 获取总的时长 时/分/秒
			 */
			int h = times/3600;
			int m = (times%3600)/60;
			int s = (times%3600)%60;
			String timeLong    = h + "时" + m + "分" + s +"秒";
			
			
			BillFormBean billForm = new BillFormBean(billId, customerName, idNumber, loginAccount, timeLong, payWay, payStatus);
			billFormList.add(billForm);
		}
		return billFormList;
	}
	
	public static void main(String[] args) {
		BillService bill = new BillService();
		System.out.println(bill.getBillFormByCondition("", "", "").size());
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
